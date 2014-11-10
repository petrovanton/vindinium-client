package com.brianstempin.vinidiumclient.shakespeare;

import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.dto.GameState;
import com.brianstempin.vinidiumclient.decisioners.Decisioner;

public class ShakspeareBot implements Movable {
	private Decisioner decisioner;
	
	public ShakspeareBot(Decisioner decisioner) {
		this.decisioner = decisioner;
	}

	@Override
	public BotMove move() {
		return decisioner.takeDecision();
	}
	
	public void updateState(GameState gameState) {
		decisioner.updateState(gameState);
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
	}

}
