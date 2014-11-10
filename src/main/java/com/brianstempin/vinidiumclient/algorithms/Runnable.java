package com.brianstempin.vinidiumclient.algorithms;

import com.brianstempin.vinidiumclient.gamestates.SimpleGameState;

public interface Runnable {
	public void run(SimpleGameState gameState);
	public void init(SimpleGameState gameState);
}
