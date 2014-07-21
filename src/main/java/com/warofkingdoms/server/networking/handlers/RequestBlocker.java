package com.warofkingdoms.server.networking.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class RequestBlocker {

	private final static Logger LOGGER = Logger.getLogger(RequestBlocker.class
			.getName());

	private int maxNumberOfRequests;
	private List<Object> requestsToBeWakedUp;
	private Semaphore blocker;

	public RequestBlocker(int maxNumberOfRequests) {
		this.setNumberOfRequestsToCount(maxNumberOfRequests);
		this.requestsToBeWakedUp = new ArrayList<Object>();
		this.blocker = new Semaphore(0);
	}

	public int getNumberOfRequestsToCount() {
		return maxNumberOfRequests;
	}

	public void setNumberOfRequestsToCount(int numberOfRequestsToCount) {
		this.maxNumberOfRequests = numberOfRequestsToCount;
	}

	/**
	 * Blocks the calling thread. If the number of blocked threads reach
	 * <tt>maxNumberOfRequests</tt>, all blocked threads are unblocked.
	 * 
	 * @param toBeWakedUp
	 *            the thread to be blocked
	 */
	public void blockUntilRequestIsProcessed(Object toBeWakedUp) {
		requestsToBeWakedUp.add(toBeWakedUp);

		if (requestsToBeWakedUp.size() == maxNumberOfRequests) {
			// Release all blocked threads
			blocker.release(maxNumberOfRequests - 1);
		} else {
			try {
				blocker.acquire();
			} catch (InterruptedException e) {
				LOGGER.severe(e.toString());
			}
		}
	}
}
