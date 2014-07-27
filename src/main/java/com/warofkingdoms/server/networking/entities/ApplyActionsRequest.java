package com.warofkingdoms.server.networking.entities;

import java.util.List;

import com.warofkingdoms.server.entities.Action;

public class ApplyActionsRequest {

	private int roomId;
	private int id;
	private List<Action> actions;

	// Must have no-argument constructor
	public ApplyActionsRequest() {

	}

	public ApplyActionsRequest(int roomId, int id, List<Action> actions) {
		super();
		this.roomId = roomId;
		this.id = id;
		this.actions = actions;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
