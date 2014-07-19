package com.warofkingdoms.server.entities;

public class Tower extends Unit {

	public Tower() {

	}

	public Tower(int resourcesGainedPerRound, String name) {
		setResourcesGainedPerRound(resourcesGainedPerRound);
		setName(name);
	}

	@Override
	public Tower clone() {
		Tower t = new Tower();
		t.setResourcesGainedPerRound(getResourcesGainedPerRound());
		t.setName(getName());
		return t;
	}
}
