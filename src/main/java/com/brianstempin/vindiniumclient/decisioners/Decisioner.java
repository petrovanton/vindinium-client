package com.brianstempin.vindiniumclient.decisioners;

import com.brianstempin.vindiniumclient.algorithms.Runnable;
import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.dto.GameState;
import com.brianstempin.vindiniumclient.gamestates.CompleteGameState;

public class Decisioner {
	private Runnable algorithm;
	private final CompleteGameState completeGameState;
	
	public Decisioner(Runnable algorithm, GameState gameState) {
		this.algorithm = algorithm;
		this.completeGameState = new CompleteGameState(gameState);
	}
	
	public BotMove takeDecision() {
		return null;
	}
	
	public void updateState(GameState gameState) {
		completeGameState.setGameState(gameState);
	}
}
