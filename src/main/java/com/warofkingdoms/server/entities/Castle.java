package com.warofkingdoms.server.entities;

public class Castle extends Unit {

	private int level;

	// Must have no-argument constructor
	public Castle() {

	}

	public Castle(int resourcesGainedPerRound, int level, String name) {
		setName(name);
		setResourcesGainedPerRound(resourcesGainedPerRound);
		setLevel(level);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public Castle clone() {
		Castle c = new Castle();
		c.setResourcesGainedPerRound(getResourcesGainedPerRound());
		c.setName(getName());
		c.setLevel(level);
		return c;
	}

}
