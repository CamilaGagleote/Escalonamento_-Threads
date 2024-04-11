package view;

import java.util.concurrent.Semaphore;

import controller.FCFS;
import controller.SJF;

public class Principal {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		for(int threadId = 0; threadId<20; threadId ++) {
			Thread thread = new FCFS(threadId, semaforo);
			thread.start();
		}
		
		for(int threadId = 0; threadId<20; threadId ++) {
			Thread thread2 = new SJF(threadId);
			thread2.start();
		}
	}
}