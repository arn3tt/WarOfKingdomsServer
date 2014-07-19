package com.warofkingdoms.server.entities;

import java.util.List;

public class Game {

	private Map map;
	private List<Player> players;
//	private Round currentRound;

	// Must have no-argument constructor
	public Game() {

	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public boolean isFull() {
		return players.size() == map.getNumPlayers();
	}
}
