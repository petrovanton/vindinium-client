package com.brianstempin.vindiniumclient.utils;

import java.util.ArrayList;

public class Tile {
	private int weight;
	private Pos pos;
	private Tile pi;
	private TileType type;
	private boolean visited;
	private ArrayList<Tile> adjacentTiles;

	public Tile(int x, int y, TileType type) {
		this.pi = null;
		this.pos = new Pos(x, y);
		this.weight = 0;
		this.type = type;
		this.visited = false;
		this.adjacentTiles = new ArrayList<Tile>();
	}

	public Pos getPosition (){
		return pos;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Tile getPi() {
		return pi;
	}

	public void setPi(Tile pi) {
		this.pi = pi;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited() {
		this.visited = true;
	}
	
	public void setNotVisited() {
		this.visited = false;
	}
	
	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public ArrayList<Tile> getAdjacentTiles() {
		return adjacentTiles;
	}

	public void addAdjacentTile(Tile tile) {
		this.adjacentTiles.add(tile);
	}
	
	
}
