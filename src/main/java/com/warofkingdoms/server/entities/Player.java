package com.warofkingdoms.server.entities;

import java.util.List;

public class Player {

	private int id;
	private String name;

	private List<Troop> troops;
	private List<Unit> conqueredUnits;

	// Must have no-argument constructor
	public Player() {

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

	public List<Troop> getTroops() {
		return troops;
	}

	public void setTroops(List<Troop> troops) {
		this.troops = troops;
	}
	
	public List<Unit> getConqueredUnits() {
		return conqueredUnits;
	}
	
	public void setConqueredUnits(List<Unit> conqueredUnits) {
		this.conqueredUnits = conqueredUnits;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", troops=" + troops
				+ "]";
	}

}
