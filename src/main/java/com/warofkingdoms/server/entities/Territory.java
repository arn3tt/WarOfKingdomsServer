package com.warofkingdoms.server.entities;

public class Territory extends Unit {

	public Territory() {

	}

	public Territory(int resourcesGainedPerRound, String name) {
		setResourcesGainedPerRound(resourcesGainedPerRound);
		setName(name);
	}

	@Override
	public Territory clone() {
		Territory t = new Territory();
		t.setResourcesGainedPerRound(getResourcesGainedPerRound());
		t.setName(getName());
		return t;
	}
}
