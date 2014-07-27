package com.warofkingdoms.server.networking.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.warofkingdoms.server.entities.MapTemplate;
import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.Room;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;
import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;
import com.warofkingdoms.server.management.RoomManager;
import com.warofkingdoms.server.networking.entities.CreatePrivateRoomRequest;
import com.warofkingdoms.server.networking.entities.JoinPrivateRoomRequest;
import com.warofkingdoms.server.networking.entities.JoinPublicRoomRequest;

/**
 * Tutorial followed:
 * http://examples.javacodegeeks.com/enterprise-java/rest/jersey
 * /jersey-hello-world-example/
 * 
 * @author Arnett
 *
 */
@Path("/rooms")
public class RoomRequestsHandler {

	/*
	 * TESTS
	 * 
	 * LINK:
	 * http://localhost:8080/WarOfKingdomsServer/rest/rooms/getPrivateRooms
	 * 
	 * JSON-REQUEST: no JSON needed for this request
	 */

	/**
	 * This method returns a Map<RoomID, RoomName>
	 * 
	 * It does not return a list of room for restriction data purposes
	 */
	@POST
	@Path("/getPrivateRooms")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<Integer, String> getPrivateRooms() {

		Map<Integer, String> roomIdName = new HashMap<Integer, String>();
		List<Room> rooms = RoomManager.getInstance().getPrivateRooms();

		for (Room aRoom : rooms) {
			roomIdName.put(aRoom.getId(), aRoom.getName());
		}

		return roomIdName;
	}

	/*
	 * TESTS
	 * 
	 * LINK:
	 * http://localhost:8080/WarOfKingdomsServer/rest/rooms/createPrivateRoom
	 * 
	 * JSON-REQUEST: {"roomName" : "RoomTest", "roomPassword":"123",
	 * "mapId":"0","owner":null}
	 */

	/**
	 * Creates a private room
	 * 
	 * @param CreatePrivateRoomRequest
	 *            : owner, roomName, roomPassword, mapId
	 * 
	 * @return true if successful, false otherwise
	 */
	@POST
	@Path("/createPrivateRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean createPrivateRoom(CreatePrivateRoomRequest request) {

		Player roomOwner = request.getOwner();
		String roomName = request.getRoomName();
		String roomPassword = request.getRoomPassword();
		MapTemplate mapId = getTemplateMap(request.getMapId());

		if (mapId == null) {
			return false;
		}

		RoomManager.getInstance().addRoom(roomOwner, roomName, roomPassword,
				mapId);
		return true;
	}

	// TODO - deal with repeated connection from the same player

	/*
	 * TESTS
	 * 
	 * LINK: http://localhost:8080/WarOfKingdomsServer/rest/rooms/joinPublicRoom
	 * 
	 * JSON-REQUEST: {"player":{"id":489572983, "name":"Luan", "troops":null,
	 * "conqueredUnits":null}, "mapId":"0"}
	 */

	/**
	 * Adds the player given into the next available public room
	 * 
	 * @param JoinPublicRoomRequest
	 *            : Player, mapId
	 * 
	 * @return true if successful, false otherwise
	 */
	@POST
	@Path("/joinPublicRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int joinPublicRoom(JoinPublicRoomRequest request) {

		Player player = request.getPlayer();
		MapTemplate mapId = getTemplateMap(request.getMapId());

		if (mapId == null) {
			return -1;
		}

		Room joinedRoom = RoomManager.getInstance().addPlayerIntoPublicRoom(player, mapId);
		return joinedRoom.getId();

		// numPlayersConnected++;
		// if (numPlayersConnected % 2 == 0) {
		// OurSemaphore.getInstance().getSemaphore().release(1);
		// } else {
		// try {
		// OurSemaphore.getInstance().getSemaphore().acquire();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// return Response.status(200).entity("> "+ roomId + " " +
		// player.toString()).build();
	}

	private MapTemplate getTemplateMap(int mapId) {

		if (mapId == MapTemplate.GAME_OF_THRONES.id) {
			return MapTemplate.GAME_OF_THRONES;
		}
		return null;
	}

	/*
	 * TESTS
	 * 
	 * LINK:
	 * http://localhost:8080/WarOfKingdomsServer/rest/rooms/joinPrivateRoom
	 * 
	 * JSON-REQUEST: {"roomId":0, "roomPassword":"123", "player":{"id":23425636,
	 * "name":"Another", "troops":null, "conqueredUnits":null}}
	 */

	/**
	 * Adds the player given into the given private room
	 * 
	 * @param JoinPublicRoomRequest
	 *            : Player, roomId, roomPassword
	 * 
	 * @return true if successful, false otherwise
	 */
	@POST
	@Path("/joinPrivateRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean joinPrivateRoom(JoinPrivateRoomRequest request) {

		int roomId = request.getRoomId();
		Player player = request.getPlayer();
		String roomPassword = request.getRoomPassword();

		try {
			RoomManager.getInstance().addPlayerIntoPrivateRoom(player, roomId,
					roomPassword);
			return true;
		} catch (RoomNotFoundException e) {
			// TODO Improve error status
			return false;
		} catch (WrongRoomPasswordException e) {
			// TODO Improve error status
			return false;
		}
	}

}