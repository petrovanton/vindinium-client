package com.brianstempin.vindiniumclient.utils;

public class Mine extends GameObject {
	private boolean ownerMe;
	
	public Mine(int x, int y, Tile tile) {
		super(x, y, tile);
		this.ownerMe = false;
	}

	public boolean isOwnerMe() {
		return ownerMe;
	}

	public void setOwnerMe(boolean ownerMe) {
		this.ownerMe = ownerMe;
	}
	
}
