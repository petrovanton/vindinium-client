package com.brianstempin.vindiniumclient.algorithms;

import java.util.ArrayDeque;

import com.brianstempin.vindiniumclient.utils.Tile;

public interface Runnable {
	public ArrayDeque<Tile> run(Tile start, Tile end);
}
