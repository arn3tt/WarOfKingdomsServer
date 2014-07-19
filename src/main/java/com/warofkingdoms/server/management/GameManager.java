package com.warofkingdoms.server.management;

import java.util.List;

import com.warofkingdoms.server.entities.Map;
import com.warofkingdoms.server.entities.Player;
import com.warofkingdoms.server.entities.TemplateMap;

public class GameManager {

	private Map map;
	private List<Player> players;
//	private Round currentRound;

	public GameManager(TemplateMap mapId) {
		this.map = MapCreator.createNewMap(mapId);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public boolean isFull() {
		return players.size() == map.getNumPlayers();
	}
}
