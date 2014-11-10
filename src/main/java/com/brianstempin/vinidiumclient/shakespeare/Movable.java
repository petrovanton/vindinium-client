package com.brianstempin.vinidiumclient.shakespeare;

import com.brianstempin.vindiniumclient.bot.BotMove;

/**
 * @author Anton
 *
 */
public interface Movable {
	/**
     * Method that plays each move
     *
     * @return the decided move
     */
    public BotMove move();

    /**
     * Called before the game is started
     */
    public void setup();

    /**
     * Called after the game
     */
    public void shutdown();
}
