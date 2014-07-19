package com.warofkingdoms.server.entities;

public class Map {

	private int id;
	private String name;
	private int numPlayers;

	// Must have no-argument constructor
	public Map() {

	}

	public Map(int id, String name, int numPlayers) {
		this.id = id;
		this.name = name;
		this.numPlayers = numPlayers;
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

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

}
