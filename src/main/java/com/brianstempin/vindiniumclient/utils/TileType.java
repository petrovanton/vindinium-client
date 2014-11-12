package com.brianstempin.vindiniumclient.utils;

public enum TileType {
	PATHABLE(0), BLOCKER(1), TAVERN(2), MINE(3), HERO(4);
	
	private final int type;
	
	TileType(int type){
		this.type = type;
	}
	
	public String toString() {
		return String.valueOf(type);
	}
}
