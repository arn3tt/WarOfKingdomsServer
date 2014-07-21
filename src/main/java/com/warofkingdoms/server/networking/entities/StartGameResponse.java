package com.warofkingdoms.server.networking.entities;

import java.util.List;

import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.Unit;

public class StartGameResponse {

	// Must have no-argument constructor
	public StartGameResponse() {

	}

	public StartGameResponse(List<Player> players, List<Unit> units) {
		this.players = players;
		this.units = units;
	}

	private List<Player> players;
	private List<Unit> units;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

}
