package com.warofkingdoms.server.entities.actions;

import com.warofkingdoms.server.entities.Troop;

public class CreateTroop extends Action {

	public CreateTroop() {
		
	}
	
	public CreateTroop(Troop troop) {
		setTroop(troop);
	}
	
}
