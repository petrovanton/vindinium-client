package com.brianstempin.vinidiumclient.gamestates;

import java.util.ArrayList;
import java.util.HashMap;

import com.brianstempin.vindiniumclient.dto.GameState;
import com.brianstempin.vinidiumclient.algorithms.Runnable;
import com.brianstempin.vinidiumclient.algorithms.TilePathFinder;
import com.brianstempin.vinidiumclient.utils.Mine;
import com.brianstempin.vinidiumclient.utils.Tavern;
import com.brianstempin.vinidiumclient.utils.Tile;
import com.google.gson.internal.Pair;

public class CompleteGameState {
	private Runnable algorithm;
	private GameState gameState;
	private HashMap<Pair<Integer, Integer>, Tile> tiles;
	private ArrayList<Mine> mines;
	private ArrayList<Tavern> taverns;

	public CompleteGameState(GameState gameState) {
		this.gameState = gameState;
//		this.algorithm = new Dijkstra();
		this.algorithm = new TilePathFinder();
		this.tiles = new HashMap<Pair<Integer, Integer>, Tile>();
		this.mines = new ArrayList<Mine>();
		this.taverns = new ArrayList<Tavern>();

		parseBoard();
	}
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public HashMap<Pair<Integer, Integer>, Tile> getTiles() {
		return tiles;
	}

	public ArrayList<Mine> getMines() {
		return mines;
	}

	public ArrayList<Tavern> getTaverns() {
		return taverns;
	}

	public void runAlgorithm() {
		algorithm.run(this);
	}

	private void parseBoard() {
		int x = 0;
		int y = 0;
		int size = gameState.getGame().getBoard().getSize();
		char tileType;

		String board = gameState.getGame().getBoard().getTiles();
		
		for(int i = 0; i < board.length(); i=+2){
			tileType = board.charAt(i);
			
			if(!"#".equals(tileType)){
				tiles.put(new Pair<Integer, Integer>(x, y), new Tile(x, y));

				if("$".equals(tileType)){
					mines.add(new Mine(x, y));
				}
				else if("[".equals(tileType)){
					taverns.add(new Tavern(x, y));
				}
				else if("@".equals(tileType)){
					
				}
			}
			
			if((i % size) == 0){
				x = 0;
				y++;
			}
		}
		
		for(Tile tile : tiles.values()){
			Pair<Integer, Integer> leftTilePos  = new Pair<Integer, Integer>(tile.getX()-1, tile.getY());
			Pair<Integer, Integer> rightTilePos = new Pair<Integer, Integer>(tile.getX()+1, tile.getY());
			Pair<Integer, Integer> upperTilePos = new Pair<Integer, Integer>(tile.getX(), tile.getY()-1);
			Pair<Integer, Integer> lowerTilePos = new Pair<Integer, Integer>(tile.getX(), tile.getY()+1);

			if(tiles.containsKey(upperTilePos)){
				tile.addAdjacentTile(tiles.get(upperTilePos));
			}
			
			if(tiles.containsKey(lowerTilePos)){
				tile.addAdjacentTile(tiles.get(lowerTilePos));
			}
			
			if(tiles.containsKey(leftTilePos)){
				tile.addAdjacentTile(tiles.get(leftTilePos));
			}
			
			if(tiles.containsKey(rightTilePos)){
				tile.addAdjacentTile(tiles.get(rightTilePos));
			}
		}
	}
	
}
