package com.brianstempin.vindiniumclient.decisioners;

import java.util.ArrayDeque;

import com.brianstempin.vindiniumclient.algorithms.Runnable;
import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.dto.GameState;
import com.brianstempin.vindiniumclient.gamestates.CompleteGameState;
import com.brianstempin.vindiniumclient.utils.Mine;
import com.brianstempin.vindiniumclient.utils.Tile;

public class Decisioner {
	private Runnable algorithm;
	private final CompleteGameState completeGameState;
	
	public Decisioner(Runnable algorithm, GameState gameState) {
		this.algorithm = algorithm;
		this.completeGameState = new CompleteGameState(gameState);
	}
	
	public BotMove takeDecision() {
		ArrayDeque<Tile> path = null;
		
		for (Mine mine : completeGameState.getMines()) {
			path = algorithm.run(completeGameState.getMyHero().getTile(), mine.getTile());
		}
		
		return null;
	}
	
	public void updateState(GameState gameState) {
		completeGameState.setGameState(gameState);
	}
}
