package com.ilim.ome;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Simple app to create java.lang.OutOfMemoryError
 *
 */
public class App {

	public static void main(String[] args) {

		System.out.println("Run its gonna blow!");
		tooManyThreads();
	}

	private static void tooManyThreads() {

		final AtomicInteger i = new AtomicInteger(0);
		while (true) {

			new Thread(new Runnable() {
				public void run() {
					try {
						System.out.println(" thread" + i.incrementAndGet());
						Thread.sleep(10000000);
					} catch (InterruptedException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}).start();
		}

	}
}
