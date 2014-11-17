package com.brianstempin.vindiniumclient.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.brianstempin.vindiniumclient.utils.Tile;
import com.brianstempin.vindiniumclient.utils.TileType;

public class TilePathFinder implements Runnable {

	@Override
	public ArrayDeque<Tile> run(Tile start, Tile end) {
		Tile currentTile = start;
		ArrayList<Tile> visited = new ArrayList<Tile>();
		ArrayDeque<Tile> path = new ArrayDeque<Tile>();
		ArrayDeque<Tile> queue = new ArrayDeque<Tile>();
		
		currentTile.setPi(null);
		currentTile.setWeight(0);
		
		while (currentTile != null && !end.equals(currentTile)) {
			for (Tile tile : currentTile.getAdjacentTiles()) {
				if (!tile.isVisited()) {
					if (tile.getType().equals(TileType.HERO)) {
//						continue;
					}
					
					tile.setPi(currentTile);
					tile.setWeight(currentTile.getWeight()+1);
					tile.setVisited();
					queue.add(tile);
					visited.add(tile);
				}
			}
			
			currentTile = queue.pollFirst();
		}
		
		while (currentTile != null) {
			currentTile = currentTile.getPi();
			path.addFirst(currentTile);
		}
		
		for (Tile tile : visited) {
			tile.setNotVisited();
		}
		
		return path;
	}
}
