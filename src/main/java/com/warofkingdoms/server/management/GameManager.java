package com.warofkingdoms.server.management;

import java.util.ArrayList;
import java.util.List;

import com.warofkingdoms.server.entities.Map;
import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.MapTemplate;

public class GameManager {

	private Map map;
	private List<Player> players;

	// private Round currentRound;

	public GameManager(MapTemplate mapId) {
		this.map = MapCreator.createNewMap(mapId);
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		player.addConqueredUnit(map.getNextFreeCastle());

		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public boolean isFull() {
		if (players != null && map != null) {
			return players.size() == map.getNumPlayers();
		}
		return false;
	}

	public Map getCurrentMap() {
		return map;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
