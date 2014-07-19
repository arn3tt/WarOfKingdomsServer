package com.warofkingdoms.server.entities;

import com.warofkingdoms.server.exceptions.WrongRoomPasswordException;

public class Room {

	private int id;
	private Game game;
	private boolean isPrivate;
	private String password;

	// Must have no-argument constructor
	public Room() {

	}
	
	public Room(int id, Game game, boolean isPrivate, String password) {
		super();
		this.id = id;
		this.game = game;
		this.isPrivate = isPrivate;
		this.password = password;
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

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
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

}
