package com.warofkingdoms.server.networking.handlers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.Room;
import com.warofkingdoms.server.entities.TemplateMap;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;
import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;
import com.warofkingdoms.server.management.RoomMananger;
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

	private static int numPlayersConnected = 0;

	@POST
	@Path("/getPrivateRooms")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> getPrivateRooms() {
		return RoomMananger.getInstance().getPrivateRooms();
	}
	
	@POST
	@Path("/createPrivateRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean createPrivateRoom(CreatePrivateRoomRequest request) {
		
		String roomName = request.getRoomName();
		String roomPassword = request.getRoomPassword();
		TemplateMap mapId = getTemplateMap(request.getMapId());
		
		RoomMananger.getInstance().addRoom(roomName, roomPassword, mapId);
		return true;
	}

	@POST
	@Path("/joinPublicRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean joinPublicRoom(JoinPublicRoomRequest request) {
		
		Player player = request.getPlayer();
		TemplateMap mapId = getTemplateMap(request.getMapId());
		
		RoomMananger.getInstance().addPlayerIntoPublicRoom(player, mapId);
		return true;

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

	private TemplateMap getTemplateMap(int mapId) {
		
		if (mapId == TemplateMap.GAME_OF_THRONES.id) {
			return TemplateMap.GAME_OF_THRONES;
		}
		return TemplateMap.GAME_OF_THRONES;
	}

	@POST
	@Path("/joinPrivateRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean joinPrivateRoom(JoinPrivateRoomRequest request) {
		
		int roomId = request.getRoomId();
		Player player = request.getPlayer();
		String roomPassword = request.getRoomPassword();

		try {
			RoomMananger.getInstance().addPlayerIntoPrivateRoom(player, roomId, roomPassword);
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