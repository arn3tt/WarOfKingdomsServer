package com.warofkingdoms.server.entities;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private MapTemplate template;
	private int numPlayers;
	private List<Unit> units;
	private List<Castle> startingUnits;

	private int nextFreeCastleIndex = 0;

	// Must have no-argument constructor
	public Map() {
		setStartingUnits();
	}

	public Map(MapTemplate template, int numPlayers, List<Unit> units) {
		this.template = template;
		this.numPlayers = numPlayers;
		this.units = units;

		setStartingUnits();
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

	private void setStartingUnits() {
		startingUnits = new ArrayList<Castle>();
		for (Unit unit : units) {
			if (unit instanceof Castle) {
				startingUnits.add((Castle) unit);
			}
		}
	}

	public Castle getNextFreeCastle() {
		Castle nextFreeCastle = startingUnits.get(nextFreeCastleIndex);
		nextFreeCastleIndex++;
		return nextFreeCastle;
	}
}
