package com.warofkingdoms.server.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private static final int STARTING_RESOURCES = 10;

	private int id;
	private String name;
	private int resources;

	private List<Troop> troops;
	private List<Unit> conqueredUnits;

	// Must have no-argument constructor
	public Player() {
		resources = STARTING_RESOURCES;
		conqueredUnits = new ArrayList<Unit>();
		troops = new ArrayList<Troop>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int addTroop(Troop troop) {
		int troopId = troops.size();
		troops.add(troop);
		return troopId;
	}
	
	public Troop getTroop(int id) {
		return troops.get(id);
	}

	public void addConqueredUnit(Unit unit) {
		conqueredUnits.add(unit);
	}

	public void removeConqueredUnit(Unit unit) {
		conqueredUnits.remove(unit);
	}

	public void addResources(int toBeAdded) {
		resources += toBeAdded;
	}

	public int getResources() {
		return resources;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", resources="
				+ resources + ", troops=" + troops + ", conqueredUnits="
				+ conqueredUnits + "]";
	}
}
