package com.warofkingdoms.server.management;

import java.util.ArrayList;
import java.util.List;

import com.warofkingdoms.server.entities.Room;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;

public class RoomMananger {

	private static RoomMananger instance;

	private List<Room> rooms = new ArrayList<Room>();

	private RoomMananger() {
	}

	public synchronized static RoomMananger getInstance() {
		if (instance == null) {
			instance = new RoomMananger();
		}
		return instance;
	}

	public synchronized int createRoom(boolean isPrivate) {
		Room aRoom = new Room();
		aRoom.setId(rooms.size());
		aRoom.setPrivate(isPrivate);

		return aRoom.getId();
	}

	public List<Room> getPrivateRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room getById(int roomId) throws RoomNotFoundException {
		if (roomId >= 0 && roomId < rooms.size()) {
			return rooms.get(roomId);
		}
		throw new RoomNotFoundException(roomId);
	}
}
