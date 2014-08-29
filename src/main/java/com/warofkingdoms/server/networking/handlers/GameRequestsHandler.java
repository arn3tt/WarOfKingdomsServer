package com.warofkingdoms.server.networking.handlers;

import java.util.List;
import java.util.logging.Logger;

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
import com.warofkingdoms.server.entities.actions.Action;
import com.warofkingdoms.server.entities.actions.MoveTroop;
import com.warofkingdoms.server.exceptions.RoomNotFoundException;
import com.warofkingdoms.server.management.GameManager;
import com.warofkingdoms.server.management.RoomManager;
import com.warofkingdoms.server.networking.entities.ApplyActionsRequest;
import com.warofkingdoms.server.networking.entities.ApplyActionsResponse;
import com.warofkingdoms.server.networking.entities.JoinPrivateRoomRequest;
import com.warofkingdoms.server.networking.entities.StartGameRequest;
import com.warofkingdoms.server.networking.entities.StartGameResponse;

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

	private final static Logger LOGGER = Logger
			.getLogger(GameRequestsHandler.class.getName());

	@POST
	@Path("/startGame")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// TODO Improve error status
	public StartGameResponse startGame(StartGameRequest request) {
		try {
			Room room = RoomManager.getInstance().getById(request.getRoomId());

			if (!room.containsPlayer(request.getPlayerId())) {
				LOGGER.severe(String.format("Player %d is not in room %d",
						request.getPlayerId(), request.getRoomId()));
				return null;
			}

			room.getRequestBlocker().blockUntilRequestIsProcessed(this);

			GameManager game = room.getGameManager();

			List<Unit> updatedUnits = game.getCurrentMap().getUnits();
			List<Player> allPlayers = game.getPlayers();
			return new StartGameResponse(allPlayers, updatedUnits);
		} catch (RoomNotFoundException e) {
			LOGGER.warning(e.toString());
			return null;
		}
	}

	/*
	 * TESTS
	 * 
	 * LINK: http://localhost:8080/WarOfKingdomsServer/rest/games/applyActions
	 * 
	 * JSON-REQUEST: {"roomId" : 1234, "playerId": 12345,
	 * "actions":[{"type":"moveTroop", "troop":null, "goal":null}]}
	 */
	/**
	 * POST method that receives round actions
	 * 
	 * @param request
	 * @return
	 */
	// TODO Improve error status
	@POST
	@Path("/applyActions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ApplyActionsResponse applyActions(ApplyActionsRequest request) {

		int roomId = request.getRoomId();
		int playerId = request.getPlayerId();
		List<Action> actions = request.getActions();

		// TODO process data from all player (with semaphore) and generate
		// proper response
		return null;
	}

	// Testing

	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JoinPrivateRoomRequest test(JoinPrivateRoomRequest request) {
		Unit position = request.getPlayer().getTroop(0).getPosition();

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