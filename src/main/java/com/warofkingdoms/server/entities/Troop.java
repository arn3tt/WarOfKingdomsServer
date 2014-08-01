package com.warofkingdoms.server.entities;

public class Troop {

	private Unit position;
	private int level;
	private boolean isAlive;

	// Must have no-argument constructor
	public Troop() {

	}

	public Troop(Unit position, int level) {
		this.position = position;
		this.level = level;
	}

	public Unit getPosition() {
		return position;
	}

	public void setPosition(Unit position) {
		this.position = position;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isAlive() {
		return isAlive;
	}
}
