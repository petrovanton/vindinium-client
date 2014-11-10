package com.brianstempin.vinidiumclient.algorithms;

import com.brianstempin.vinidiumclient.gamestates.CompleteGameState;

public interface Runnable {
	public void run(CompleteGameState gameState);
	public void init(CompleteGameState gameState);
}
