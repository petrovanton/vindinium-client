package com.brianstempin.vinidiumclient.shakespeare;

import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.dto.GameState;

public class ShakspeareBot implements Movable {

	@Override
	public BotMove move(GameState gameState) {
		int randomNumber = (int) (Math.random() * 4);

		switch (randomNumber) {
		case 1:
			return BotMove.NORTH;
		case 2:
			return BotMove.SOUTH;
		case 3:
			return BotMove.EAST;
		case 4:
			return BotMove.WEST;
		default:
			return BotMove.STAY;
		}
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
