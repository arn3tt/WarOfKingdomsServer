package com.warofkingdoms.server.entities.actions;

import com.warofkingdoms.server.entities.Troop;

public class UpgradeTroop extends Action {

	public UpgradeTroop() {
		
	}
	
	public UpgradeTroop(Troop troop) {
		setTroop(troop);
	}
}
