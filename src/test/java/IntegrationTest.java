import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.warofkingdoms.server.entities.MapTemplate;
import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.management.RoomManager;
import com.warofkingdoms.server.networking.entities.JoinPublicRoomRequest;
import com.warofkingdoms.server.networking.entities.StartGameRequest;
import com.warofkingdoms.server.networking.entities.StartGameResponse;
import com.warofkingdoms.server.networking.handlers.GameRequestsHandler;
import com.warofkingdoms.server.networking.handlers.RoomRequestsHandler;

public class IntegrationTest {

	@Before
	public void resetServer() {
		RoomManager.getInstance().reset();
	}

	private int joinRandomPublicRoom(String playerName, int playerId) {
		RoomRequestsHandler roomsHandler = new RoomRequestsHandler();

		JoinPublicRoomRequest request = new JoinPublicRoomRequest();
		request.setMapId(MapTemplate.GAME_OF_THRONES.id);

		Player player = new Player();
		player.setName(playerName);
		player.setId(playerId);
		request.setPlayer(player);
		
		int joinPublicRoomResponse = roomsHandler.joinPublicRoom(request);
		return joinPublicRoomResponse;
	}

	@Test
	public void testDefaultBehaviorJoinPublicRoom() {
		String name = "Hodor";
		int id = "01:23:45:67:89:ab".hashCode();
		assertTrue(joinRandomPublicRoom(name, id) != -1);
	}

	@Test
	public void testDefaultBehaviorStartGame() {
		String playerName1 = "Hodor";
		int playerId1 = "01:23:45:67:89:ab".hashCode();
		int joinedRoomId1 = joinRandomPublicRoom(playerName1, playerId1);
		assertTrue(joinedRoomId1 != -1);

		String playerName2 = "Khaleesi";
		int playerId2 = "01:23:45:67:89:ac".hashCode();
		int joinedRoomId2 = joinRandomPublicRoom(playerName2, playerId2);
		assertTrue(joinedRoomId2 != -1);

		GameRequestsHandler gamesHandler = new GameRequestsHandler();

		StartGameRequest request = new StartGameRequest();
		request.setRoomId(joinedRoomId1);
		request.setPlayerId(playerId1);

		runThreadToStartGame(gamesHandler, request);

		request.setPlayerId(playerId2);
		runThreadToStartGame(gamesHandler, request);
	}

	private void runThreadToStartGame(final GameRequestsHandler gamesHandler,
			final StartGameRequest request) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				StartGameResponse response = gamesHandler.startGame(request);
				System.out.println("players " + response.getPlayers());
				System.out.println("units " + response.getUnits());
			}
		};
		new Thread(runnable).start();
	}

}
