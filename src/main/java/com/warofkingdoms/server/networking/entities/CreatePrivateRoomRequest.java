package com.warofkingdoms.server.networking.entities;

import com.warofkingdoms.server.entities.Player;

public class CreatePrivateRoomRequest {

	private Player owner;
	private String roomName;
	private String roomPassword;
	private int mapId;
	
	// Must have no-argument constructor
	public CreatePrivateRoomRequest() {

	}
	
	public CreatePrivateRoomRequest(
			Player owner,
			String roomName, 
			String roomPassword, 
			int mapId) {
		
		this.owner = owner;
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

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	
}
