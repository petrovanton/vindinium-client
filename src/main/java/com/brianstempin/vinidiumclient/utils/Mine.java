package com.brianstempin.vinidiumclient.utils;

public class Mine extends GameObject {
	private boolean ownerMe;
	
	public Mine(int x, int y) {
		super(x, y);
		this.ownerMe = false;
	}

	public boolean isOwnerMe() {
		return ownerMe;
	}

	public void setOwnerMe(boolean ownerMe) {
		this.ownerMe = ownerMe;
	}
	
}
