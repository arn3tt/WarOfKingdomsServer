package com.warofkingdoms.server.entities;

public enum MapTemplate {

	// New maps should be added here
	GAME_OF_THRONES(0, 2);

	public final int id;
	public final int maxNumberOfPlayers;

	MapTemplate(int id, int maxNumberOfPlayers) {
		this.id = id;
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}
}
