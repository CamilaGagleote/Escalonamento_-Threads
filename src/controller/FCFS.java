package controller;

import java.util.concurrent.Semaphore;

public class FCFS extends Thread{

	int threadId;
	int tempo;
	Semaphore semaforo;
	
	public FCFS(int threadId, Semaphore semaforo) {
		this.threadId = threadId;
		this.semaforo = semaforo;
	}
	
	public void run() {
		escalonamento();
	}
	
	private void escalonamento() {
		tempo = (int)(((Math.random())*117) + 4);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A Thread #" + threadId + " demorou " + tempo + ".s para iniciar" );
		try {
			semaforo.acquire();
			saida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
		
		
	private void saida() {
		System.out.println("A Thread #" + threadId + " saiu" );
	}

}
