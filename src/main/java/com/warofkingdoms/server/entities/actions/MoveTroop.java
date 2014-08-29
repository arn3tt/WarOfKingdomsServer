package com.warofkingdoms.server.entities.actions;

import com.warofkingdoms.server.entities.Troop;
import com.warofkingdoms.server.entities.Unit;

public class MoveTroop extends Action {

	private Unit goal;
	
	public MoveTroop() {
		
	}
	
	public MoveTroop(Troop troop, Unit goal) {
		setTroop(troop);
		setGoal(goal);
	}

	public Unit getGoal() {
		return goal;
	}

	public void setGoal(Unit goal) {
		this.goal = goal;
	}
}
