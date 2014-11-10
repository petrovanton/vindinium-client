package com.brianstempin.vinidiumclient.algorithms;

import com.brianstempin.vinidiumclient.gamestates.CompleteGameState;

public class TilePathFinder implements Runnable {

	@Override
	public void run(CompleteGameState gameState) {
		int xStart = gameState.getGameState().getHero().getPos().getX();
		int yStart = gameState.getGameState().getHero().getPos().getY();

		
		
		
		init(gameState);
	}

	public void init(CompleteGameState gameState) {
		
	}
}
