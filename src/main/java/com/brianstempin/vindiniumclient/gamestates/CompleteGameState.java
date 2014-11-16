package com.brianstempin.vindiniumclient.gamestates;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brianstempin.vindiniumclient.dto.GameState;
import com.brianstempin.vindiniumclient.utils.Mine;
import com.brianstempin.vindiniumclient.utils.Tavern;
import com.brianstempin.vindiniumclient.utils.Tile;
import com.brianstempin.vindiniumclient.utils.TileType;

public class CompleteGameState {
	private GameState gameState;
//	private HashMap<Pair<Integer, Integer>, Tile> tiles;
	private ArrayList<ArrayList<Tile>> abstractBoard;
	private ArrayList<Mine> mines;
	private ArrayList<Tavern> taverns;
	private static final Logger logger = LogManager.getLogger(CompleteGameState.class);

	public CompleteGameState(GameState gameState) {
		this.gameState = gameState;
//		this.tiles = new HashMap<Pair<Integer, Integer>, Tile>();
		this.mines = new ArrayList<Mine>();
		this.taverns = new ArrayList<Tavern>();
		this.abstractBoard = new ArrayList<ArrayList<Tile>>();
		
		for (int i = 0; i < gameState.getGame().getBoard().getSize(); i++) {
			abstractBoard.add(new ArrayList<Tile>());
		}

		parseBoard();
	}
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

//	public HashMap<Pair<Integer, Integer>, Tile> getTiles() {
//		return tiles;
//	}

	public ArrayList<Mine> getMines() {
		return mines;
	}

	public ArrayList<Tavern> getTaverns() {
		return taverns;
	}

	private void parseBoard() {
		int x = 0;
		int y = 0;
		int size = gameState.getGame().getBoard().getSize();
		char tileType;
		
		System.out.println("Size: " + size);
		System.out.println("Parsing board..");

		String board = gameState.getGame().getBoard().getTiles();
		
		for(int i = 0; i < board.length(); i+=2){
			tileType = board.charAt(i);

//			System.out.print("board.length: " + board.length() + " ; i: " + i);
			System.out.print("[" + x + ";" + y +"]");
			
			if("#".equals(String.valueOf(tileType))){
//				tiles.put(new Pair<Integer, Integer>(x, y), new Tile(x, y));
				abstractBoard.get(x).add(new Tile(x, y, TileType.BLOCKER));
			}
			else if("$".equals(String.valueOf(tileType))){
				mines.add(new Mine(x, y));
				abstractBoard.get(x).add(new Tile(x, y, TileType.MINE));
			}
			else if("[".equals(String.valueOf(tileType))){
				taverns.add(new Tavern(x, y));
				abstractBoard.get(x).add(new Tile(x, y, TileType.TAVERN));
			}
			else if("@".equals(String.valueOf(tileType))){
				abstractBoard.get(x).add(new Tile(x, y, TileType.HERO));
			}
			else {
//				System.out.print("[" + x + ";" + y +"]");
				abstractBoard.get(x).add(new Tile(x, y, TileType.PATHABLE));
			}
			
			y++;
			
			if(y >= size){
				y = 0;
				x++;
			}
		}
		
		System.out.println("Parsed. Representing the board..");
		
		for (ArrayList<Tile> arrayList : abstractBoard) {
			System.out.println();
			for (Tile tile : arrayList) {
				if(TileType.BLOCKER.equals(tile.getType())){
					System.out.print("#");
				}
				else if (TileType.PATHABLE.equals(tile.getType())) {
					System.out.print(" ");
				}
				else if (TileType.MINE.equals(tile.getType())) {
					System.out.print("$");
				}
				else if (TileType.TAVERN.equals(tile.getType())) {
					System.out.print("T");
				}
				else {
					System.out.print("@");
				}
			}
		}
		
		System.out.println();
		System.out.println("Done.");
		System.out.println();
		
		for (int row = 0; row < abstractBoard.size(); row++) {
			ArrayList<Tile> tilesRow = abstractBoard.get(row);
			for (int col = 0; col < tilesRow.size(); col++) {
				Tile tile = tilesRow.get(col);
				x = tile.getPosition().getX();
				y = tile.getPosition().getY();
				
				if (!tile.getType().equals(TileType.BLOCKER) && (x-1) >= 0 && !abstractBoard.get(row-1).get(col).getType().equals(TileType.BLOCKER)){
					tile.addAdjacentTile(abstractBoard.get(row-1).get(col));
					logger.info("Adding tile [" + (x-1) + ";" + y + "] to the tile [" + x + ";" + y + "]");
				}
				if (!tile.getType().equals(TileType.BLOCKER) && (x+1) < size && !abstractBoard.get(row+1).get(col).getType().equals(TileType.BLOCKER)){
					tile.addAdjacentTile(abstractBoard.get(row+1).get(col));
					logger.info("Adding tile [" + (x+1) + ";" + y + "] to the tile [" + x + ";" + y + "]");
				}
				if (!tile.getType().equals(TileType.BLOCKER) && (y-1) >= 0 && !abstractBoard.get(row).get(col-1).getType().equals(TileType.BLOCKER)){
					tile.addAdjacentTile(abstractBoard.get(row).get(col-1));
					logger.info("Adding tile [" + x + ";" + (y-1) + "] to the tile [" + x + ";" + y + "]");
				}
				if (!tile.getType().equals(TileType.BLOCKER) && (y+1) < size && !abstractBoard.get(row).get(col+1).getType().equals(TileType.BLOCKER)){
					tile.addAdjacentTile(abstractBoard.get(row).get(col+1));
					logger.info("Adding tile [" + x + ";" + (y+1) + "] to the tile [" + x + ";" + y + "]");
				}
			}
		}
		
//		for(Tile tile : tiles.values()){
//			Pair<Integer, Integer> leftTilePos  = new Pair<Integer, Integer>(tile.getX()-1, tile.getY());
//			Pair<Integer, Integer> rightTilePos = new Pair<Integer, Integer>(tile.getX()+1, tile.getY());
//			Pair<Integer, Integer> upperTilePos = new Pair<Integer, Integer>(tile.getX(), tile.getY()-1);
//			Pair<Integer, Integer> lowerTilePos = new Pair<Integer, Integer>(tile.getX(), tile.getY()+1);
//
//			if(tiles.containsKey(upperTilePos)){
//				tile.addAdjacentTile(tiles.get(upperTilePos));
//			}
//			
//			if(tiles.containsKey(lowerTilePos)){
//				tile.addAdjacentTile(tiles.get(lowerTilePos));
//			}
//			
//			if(tiles.containsKey(leftTilePos)){
//				tile.addAdjacentTile(tiles.get(leftTilePos));
//			}
//			
//			if(tiles.containsKey(rightTilePos)){
//				tile.addAdjacentTile(tiles.get(rightTilePos));
//			}
//		}
	}
	
}
