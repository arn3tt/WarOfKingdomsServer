package com.warofkingdoms.server.networking.entities;

public class StartGameRequest {

	private int roomId;
	private int playerId;

	// Must have no-argument constructor
	public StartGameRequest() {

	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

}
