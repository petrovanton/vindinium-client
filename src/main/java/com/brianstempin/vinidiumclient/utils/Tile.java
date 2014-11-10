package com.brianstempin.vinidiumclient.utils;

import java.util.ArrayList;

public class Tile {
	private int x;
	private int y;
	private int weight;
	private Tile pi;
	private boolean visited;
	private boolean pathable;
	private ArrayList<Tile> adjacentTiles;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.pi = null;
		this.weight = 0;
		this.visited = false;
		this.adjacentTiles = new ArrayList<Tile>();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	public ArrayList<Tile> getAdjacentTiles() {
		return adjacentTiles;
	}

	public void addAdjacentTile(Tile tile) {
		this.adjacentTiles.add(tile);
	}
	
	
}
