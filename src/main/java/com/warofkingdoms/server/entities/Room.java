package com.warofkingdoms.server.entities;

import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;
import com.warofkingdoms.server.management.GameManager;
import com.warofkingdoms.server.networking.handlers.RequestBlocker;

public class Room {

	private int id;
	private String name;
	private boolean isPrivate;
	private Player owner;
	private String password;
	private MapTemplate mapTemplate;

	private RequestBlocker requestBlocker;
	private GameManager game;

	// Must have no-argument constructor
	public Room() {

	}

	public Room(int id, String name, boolean isPrivate, Player owner, String password,
			MapTemplate mapTemplate) {
		this.id = id;
		this.name = name;
		this.isPrivate = isPrivate;
		this.owner = owner;
		this.password = password;
		this.mapTemplate = mapTemplate;

		this.requestBlocker = new RequestBlocker(mapTemplate.maxNumberOfPlayers);
		this.game = new GameManager(mapTemplate);
	}

	public boolean isFull() {
		return game.isFull();
	}

	public void addPlayer(Player player, String roomPassword)
			throws WrongRoomPasswordException {
		if (roomPassword.equals(this.password)) {
			game.addPlayer(player);
		} else {
			throw new WrongRoomPasswordException();
		}
	}

	public void addPlayer(Player player) {
		game.addPlayer(player);
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GameManager getGameManager() {
		return game;
	}

	public void setGameGameManager(GameManager game) {
		this.game = game;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MapTemplate getMapTemplate() {
		return mapTemplate;
	}

	public void setMapTemplate(MapTemplate mapId) {
		this.mapTemplate = mapId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RequestBlocker getRequestBlocker() {
		return requestBlocker;
	}

	public void setRequestBlocker(RequestBlocker requestBlocker) {
		this.requestBlocker = requestBlocker;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public boolean containsPlayer(int playerId) {
		for (Player player : game.getPlayers()) {
			if (player.getId() == playerId) {
				return true;
			}
		}
		return false;
	}

}
