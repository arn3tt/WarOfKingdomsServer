package com.warofkingdoms.server.networking.entities;

public class StartGameRequest {

	// Must have no-argument constructor
	public StartGameRequest() {

	}

	private int roomId;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

}
