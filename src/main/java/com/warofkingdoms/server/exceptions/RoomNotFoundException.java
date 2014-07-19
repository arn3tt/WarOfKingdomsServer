package com.warofkingdoms.server.exceptions;

public class RoomNotFoundException extends Exception {

	private static final long serialVersionUID = 2403553124065809280L;

	private int roomId;

	public RoomNotFoundException(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String getMessage() {
		return String.format("The room %d does not exist.", roomId);
	}

}
