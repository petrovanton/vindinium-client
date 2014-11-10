package com.brianstempin.vinidiumclient.decisioners;

import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.dto.GameState;
import com.brianstempin.vinidiumclient.algorithms.Runnable;
import com.brianstempin.vinidiumclient.gamestates.CompleteGameState;

public class Decisioner {
	private Runnable algorithm;
	private CompleteGameState completeGameState;
	
	public Decisioner(Runnable algorithm, CompleteGameState gameState) {
		this.algorithm = algorithm;
		this.completeGameState = gameState;
	}
	
	public BotMove takeDecision() {
		return null;
	}
	
	public void updateState(GameState gameState) {
		completeGameState.setGameState(gameState);
	}
}
