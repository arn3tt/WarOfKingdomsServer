package com.warofkingdoms.server.networking.entities;

import com.warofkingdoms.server.entities.Player;

public class JoinPublicRoomRequest {

	private Player player;
	private int mapId;

	// Must have no-argument constructor
	public JoinPublicRoomRequest() {

	}

	public JoinPublicRoomRequest(Player player, int mapId) {
		this.player = player;
		this.mapId = mapId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
}