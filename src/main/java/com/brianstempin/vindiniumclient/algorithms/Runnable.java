package com.brianstempin.vindiniumclient.algorithms;

import com.brianstempin.vindiniumclient.gamestates.CompleteGameState;

public interface Runnable {
	public void run(CompleteGameState gameState);
	public void init(CompleteGameState gameState);
}
