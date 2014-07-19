package com.warofkingdoms.server.entities;

import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;
import com.warofkingdoms.server.management.GameManager;

public class Room {

	private int id;
	private String name;
	private boolean isPrivate;
	private String password;
	private TemplateMap mapId;

	private GameManager game;

	// Must have no-argument constructor
	public Room() {

	}

	public Room(int id, boolean isPrivate, String password, TemplateMap mapId) {
		this.id = id;
		this.isPrivate = isPrivate;
		this.password = password;
		this.mapId = mapId;
		this.game = new GameManager(mapId);
	}

	public boolean isFull() {
		return game.isFull();
	}

	public void addPlayer(Player player, String roomPassword) throws WrongRoomPasswordException {
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

	public TemplateMap getMapId() {
		return mapId;
	}

	public void setMapId(TemplateMap mapId) {
		this.mapId = mapId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
