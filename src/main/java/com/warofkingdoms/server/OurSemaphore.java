package com.warofkingdoms.server;

import java.util.concurrent.Semaphore;

public class OurSemaphore {

	private static OurSemaphore instance;

	private Semaphore a;
	
	private OurSemaphore() {
		a = new Semaphore(0);
	}

	public synchronized static OurSemaphore getInstance() {
		if (instance == null) {
			instance = new OurSemaphore();
		}
		return instance;
	}

	public Semaphore getSemaphore() {
		return a;
	}
}
