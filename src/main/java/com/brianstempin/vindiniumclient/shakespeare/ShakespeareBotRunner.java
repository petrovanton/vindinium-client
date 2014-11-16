package com.brianstempin.vindiniumclient.shakespeare;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brianstempin.vindiniumclient.algorithms.TilePathFinder;
import com.brianstempin.vindiniumclient.decisioners.Decisioner;
import com.brianstempin.vindiniumclient.dto.ApiKey;
import com.brianstempin.vindiniumclient.dto.GameState;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

public class ShakespeareBotRunner implements Callable<GameState> {
	private static final HttpTransport HTTP_TRANSPORT = new ApacheHttpTransport();
    private static final JsonFactory JSON_FACTORY = new GsonFactory();
    private static final HttpRequestFactory REQUEST_FACTORY =
            HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest request) {
                    request.setParser(new JsonObjectParser(JSON_FACTORY));
                }
            });
    private static final Logger logger = LogManager.getLogger(ShakespeareBotRunner.class);

    private final ApiKey apiKey;
    private final GenericUrl gameUrl;
    private final ShakespeareBot bot;

    public ShakespeareBotRunner(ApiKey apiKey, GenericUrl gameUrl, ShakespeareBot bot) {
        this.apiKey = apiKey;
        this.gameUrl = gameUrl;
        this.bot = bot;
    }
        
	@Override
	public GameState call() throws Exception {
		HttpContent content;
		HttpRequest request;
        HttpResponse response;
        GameState gameState = null;

        try {
            // Initial request
            logger.info("Sending initial request...");
            content = new UrlEncodedContent(apiKey);
            request = REQUEST_FACTORY.buildPostRequest(gameUrl, content);
            request.setReadTimeout(0); // Wait forever to be assigned to a game
            response = request.execute();
            gameState = response.parseAs(GameState.class);
            logger.info("Game URL: {}", gameState.getViewUrl());
            
            System.out.println("--------------------------------");
            System.out.println("Game URL: ");
            System.out.println(gameState.getViewUrl());
            System.out.println("--------------------------------");

            bot.setDecisioner(new Decisioner(new TilePathFinder(), gameState));
            
            // Game loop
            while (!gameState.getGame().isFinished() && !gameState.getHero().isCrashed()) {
//                logger.info("Taking turn " + gameState.getGame().getTurn());
//                BotMove direction = bot.move(gameState);
//                
//                Move move = new Move(apiKey.getKey(), direction.toString());
//                
//                HttpContent turn = new UrlEncodedContent(move);
//                HttpRequest turnRequest = REQUEST_FACTORY.buildPostRequest(new GenericUrl(gameState.getPlayUrl()), turn);
//                HttpResponse turnResponse = turnRequest.execute();
//
//                gameState = turnResponse.parseAs(GameState.class);
            }

        } catch (Exception e) {
            logger.error("Error during game play", e);
        }

        logger.info("Game over");
        return gameState;
	}

}
