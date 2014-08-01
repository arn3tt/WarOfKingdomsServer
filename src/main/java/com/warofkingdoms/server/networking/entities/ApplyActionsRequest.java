package com.warofkingdoms.server.networking.entities;

import java.util.List;

import com.warofkingdoms.server.entities.actions.Action;


public class ApplyActionsRequest {

	private int roomId;
	private int playerId;
	private List<Action> actions;

	// Must have no-argument constructor
	public ApplyActionsRequest() {

	}

	public ApplyActionsRequest(int roomId, int id, List<Action> actions) {
		super();
		this.roomId = roomId;
		this.playerId = id;
		this.actions = actions;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int id) {
		this.playerId = id;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
