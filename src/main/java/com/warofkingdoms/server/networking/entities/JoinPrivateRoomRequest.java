package com.warofkingdoms.server.networking.entities;

import com.warofkingdoms.server.entities.Player;

public class JoinPrivateRoomRequest {

	private Player player;
	private int roomId;
	private String roomPassword;
	private int mapId;

	// Must have no-argument constructor
	public JoinPrivateRoomRequest() {

	}

	public JoinPrivateRoomRequest(Player player, int roomId, int mapId) {
		this.player = player;
		this.roomId = roomId;
		this.mapId = mapId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomPassword() {
		return roomPassword;
	}

	public void setRoomPassword(String roomPassword) {
		this.roomPassword = roomPassword;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

}