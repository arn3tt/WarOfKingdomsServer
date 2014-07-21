package com.warofkingdoms.server.entities;

import java.util.List;

public class Map {

	private MapTemplate template;
	private int numPlayers;
	private List<Unit> units;

	// Must have no-argument constructor
	public Map() {

	}

	public Map(MapTemplate template, int numPlayers, List<Unit> units) {
		this.template = template;
		this.numPlayers = numPlayers;
		this.units = units;
	}

	public MapTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MapTemplate template) {
		this.template = template;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public List<Unit> getUnits() {
		return units;
	}
}
