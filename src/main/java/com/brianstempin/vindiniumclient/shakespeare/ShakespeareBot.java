package com.brianstempin.vindiniumclient.shakespeare;

import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.decisioners.Decisioner;
import com.brianstempin.vindiniumclient.dto.GameState;

public class ShakespeareBot implements Movable {
	private Decisioner decisioner;
	
	public ShakespeareBot() {
		this.decisioner = null;
	}

	public Decisioner getDecisioner() {
		return decisioner;
	}

	public void setDecisioner(Decisioner decisioner) {
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
