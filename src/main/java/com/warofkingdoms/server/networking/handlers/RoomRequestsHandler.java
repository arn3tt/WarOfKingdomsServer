package com.warofkingdoms.server.networking.handlers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.warofkingdoms.server.entities.Castle;
import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.Room;
import com.warofkingdoms.server.entities.Student;
import com.warofkingdoms.server.entities.Territory;
import com.warofkingdoms.server.entities.Tower;
import com.warofkingdoms.server.entities.Unit;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;
import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;
import com.warofkingdoms.server.management.RoomMananger;
import com.warofkingdoms.server.networking.entities.JoinRoomRequest;

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
	@Path("/joinPublicRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean joinPublicRoom(JoinRoomRequest request) {
		// TODO Not implemented yet
		return false;

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

	@POST
	@Path("/joinPrivateRoom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean joinPrivateRoom(JoinRoomRequest request) {
		int roomId = request.getRoomId();
		Player player = request.getPlayer();
		String roomPassword = request.getRoomPassword();

		try {
			Room room = RoomMananger.getInstance().getById(roomId);
			room.addPlayer(player, roomPassword);
			return true;
		} catch (RoomNotFoundException e) {
			// TODO Improve error status
			return false;
		} catch (WrongRoomPasswordException e) {
			// TODO Improve error status
			return false;
		}
	}

	// Testing

	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JoinRoomRequest test(JoinRoomRequest request) {
		Unit position = request.getPlayer().getTroops().get(0).getPosition();

		if (position instanceof Castle) {
			request.setRoomId(-1);
		} else if (position instanceof Territory) {
			request.setRoomId(-2);
		} else if (position instanceof Tower) {
			request.setRoomId(-3);
		} else {
			request.setRoomId(-300);
		}

		return null;
	}

	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student aloha(@PathParam("name") String name) {
		Student st = new Student(name, "Diazasdsd", 22, 1);
		return st;
	}
}