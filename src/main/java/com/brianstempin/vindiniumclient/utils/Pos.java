package com.brianstempin.vindiniumclient.utils;

public class Pos {
	private int x;
	private int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return x*10 + y;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        
        Pos position = (Pos) o;
        		
        if (x != position.x) return false;
        if (y != position.y) return false;
        
		return false;
	}
}
