package com.warofkingdoms.server.management;

import java.util.ArrayList;
import java.util.List;

import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.Room;
import com.warofkingdoms.server.entities.TemplateMap;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;
import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;

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
	
	public synchronized void addRoom(String roomName, String roomPassword, TemplateMap mapId) {
		Room room = new Room(rooms.size(), true, roomPassword, mapId);
		rooms.add(room);
	}

	public synchronized void addPlayerIntoPublicRoom(Player player, TemplateMap mapId) {
		
		Room room = getNextAvailablePublicRoom(mapId);
		room.addPlayer(player);
	}
	
	public synchronized void addPlayerIntoPrivateRoom(
			Player player, 
			int roomId, 
			String roomPassword) 
					throws RoomNotFoundException, WrongRoomPasswordException {
		
		Room room = getById(roomId);
		room.addPlayer(player, roomPassword);
	}
	
	public Room getNextAvailablePublicRoom(TemplateMap mapId) {
		
		for (Room aRoom : rooms) {
			
			if (!aRoom.isPrivate() 
					&& !aRoom.isFull()
					&& aRoom.getMapId() == mapId) {
				return aRoom;
			}
		}
		
		// there is no public room available
		return createPublicRoom(mapId);
	}

	private synchronized Room createPublicRoom(TemplateMap mapId) {
		
		Room newRoom = new Room(rooms.size(), false, "", mapId);
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
		return rooms;
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

}
