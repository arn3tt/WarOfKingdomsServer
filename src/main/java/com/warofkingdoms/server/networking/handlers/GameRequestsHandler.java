package com.warofkingdoms.server.networking.handlers;

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
import com.warofkingdoms.server.management.GameManager;
import com.warofkingdoms.server.management.RoomMananger;
import com.warofkingdoms.server.networking.entities.JoinRoomRequest;
import com.warofkingdoms.server.networking.entities.StartGameRequest;

/**
 * Tutorial followed:
 * http://examples.javacodegeeks.com/enterprise-java/rest/jersey
 * /jersey-hello-world-example/
 * 
 * @author Arnett
 *
 */
@Path("/games")
public class GameRequestsHandler {

	@POST
	@Path("/startGame")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean startGame(StartGameRequest request) {
		try {
			Room room = RoomMananger.getInstance().getById(request.getRoomId());
			GameManager game = room.getGameManager();
			return true;
		} catch (RoomNotFoundException e) {
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
		Student st = new Student(name, "Dias", 22, 1);
		return st;
	}
}