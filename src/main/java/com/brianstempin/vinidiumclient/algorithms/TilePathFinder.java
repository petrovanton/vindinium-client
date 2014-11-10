package com.brianstempin.vinidiumclient.algorithms;

import com.brianstempin.vinidiumclient.gamestates.SimpleGameState;

public class TilePathFinder extends Algorithm implements Runnable {

	@Override
	public void run(SimpleGameState gameState) {
		int xStart = gameState.getGameState().getHero().getPos().getX();
		int yStart = gameState.getGameState().getHero().getPos().getY();

		
		
		
		init(gameState);
	}

	public void init(SimpleGameState gameState) {
		
	}
}
