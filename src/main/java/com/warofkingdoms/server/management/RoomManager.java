package com.warofkingdoms.server.management;

import java.util.ArrayList;
import java.util.List;

import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.Room;
import com.warofkingdoms.server.entities.MapTemplate;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;
import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;

public class RoomManager {

	private static RoomManager instance;

	private List<Room> rooms = new ArrayList<Room>();

	private RoomManager() {
	}

	public synchronized static RoomManager getInstance() {
		if (instance == null) {
			instance = new RoomManager();
		}
		return instance;
	}

	public synchronized void addRoom(Player roomOwner, String roomName, String roomPassword,
			MapTemplate mapId) {

		Room room = new Room(rooms.size(), roomName, true, roomOwner, roomPassword, mapId);
		rooms.add(room);
	}

	public synchronized void addPlayerIntoPublicRoom(Player player,
			MapTemplate mapId) {

		Room room = getNextAvailablePublicRoom(mapId);
		room.addPlayer(player);
	}

	public synchronized void addPlayerIntoPrivateRoom(Player player,
			int roomId, String roomPassword) throws RoomNotFoundException,
			WrongRoomPasswordException {
		
		Room room = getById(roomId);
		room.addPlayer(player, roomPassword);
	}

	public Room getNextAvailablePublicRoom(MapTemplate mapId) {
		for (Room aRoom : rooms) {
			if (!aRoom.isPrivate() && !aRoom.isFull()
					&& aRoom.getMapTemplate() == mapId) {
				return aRoom;
			}
		}
		// There is no public room available
		return createPublicRoom(mapId);
	}

	private synchronized Room createPublicRoom(MapTemplate mapId) {
		String roomName = "Public Room "+rooms.size();
		Room newRoom = new Room(rooms.size(), roomName, false, null, "", mapId);
		rooms.add(newRoom);
		return newRoom;
	}

	public Room getById(int roomId) throws RoomNotFoundException {
		if (roomId >= 0 && roomId < rooms.size()) {
			return rooms.get(roomId);
		}
		throw new RoomNotFoundException(roomId);
	}

	public List<Room> getPrivateRooms() {

		List<Room> privateRooms = new ArrayList<Room>();
		for (Room aRoom : rooms) {
			if (aRoom.isPrivate()) {
				privateRooms.add(aRoom);
			}
		}
		return privateRooms;
	}

	public List<Room> getPublicRooms() {
		List<Room> publicRooms = new ArrayList<Room>();
		for (Room aRoom : rooms) {
			if (!aRoom.isPrivate()) {
				publicRooms.add(aRoom);
			}
		}
		return publicRooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	// TODO DELETE

	private Room testRoom = new Room(0, "Test Room", false, null, "",
			MapTemplate.GAME_OF_THRONES);

	public Room getTestRoom() throws RoomNotFoundException {
		return testRoom;
	}
}
