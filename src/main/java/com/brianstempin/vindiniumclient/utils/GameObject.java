package com.brianstempin.vindiniumclient.utils;

public abstract class GameObject {
	private int x;
	private int y;
	private Tile tile;
	
	public GameObject(int x, int y, Tile tile) {
		this.x = x;
		this.y = y;
		this.tile = tile;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Tile getTile() {
		return tile;
	}
}
