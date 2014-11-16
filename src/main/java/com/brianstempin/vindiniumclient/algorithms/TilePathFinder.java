package com.brianstempin.vindiniumclient.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.brianstempin.vindiniumclient.utils.Tile;

public class TilePathFinder implements Runnable {

	@Override
	public void run(Tile start) {
		Tile currentTile = start;
		ArrayList<Tile> visited = new ArrayList<Tile>();
		ArrayDeque<Tile> queue = new ArrayDeque<Tile>();
		
		while (currentTile != null && !start.equals(currentTile)) {
			for (Tile tile : currentTile.getAdjacentTiles()) {
				if (!tile.isVisited()) {
					queue.add(tile);
					tile.setWeight(tile.getWeight()+1);
					tile.setVisited();
					visited.add(tile);
				}
			}
			
			currentTile = queue.pollFirst();
		}
		
		for (Tile tile : visited) {
			tile.setNotVisited();
		}
	}
}
