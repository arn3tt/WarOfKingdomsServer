package com.warofkingdoms.server.networking.entities;

public class CreatePrivateRoomRequest {

	private String roomName;
	private String roomPassword;
	private int mapId;
	
	// Must have no-argument constructor
	public CreatePrivateRoomRequest() {

	}
	
	public CreatePrivateRoomRequest(
			String roomName, 
			String roomPassword, 
			int mapId) {
		
		this.roomName = roomName;
		this.roomPassword = roomPassword;
		this.mapId = mapId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
