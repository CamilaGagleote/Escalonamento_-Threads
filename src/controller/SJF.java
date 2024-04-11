package controller;

import java.util.concurrent.Semaphore;

public class SJF extends Thread {

	private int ThreadId;
	int vet[] = new int[20];
	public SJF(int ThreadId) {
		this.ThreadId = ThreadId;

	}

	public void run() {
		escalonamento();
		mostrar();
	}

	public void escalonamento() {
		int cta = 0;
		int tempo = 0;
		while (cta < 1) {
			 tempo = (int) ((Math.random() * 117) + 4);
			System.out.println("A ThreadId #" + ThreadId + " demorou " + tempo + "s para chegar.");
			cta++;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		saida(tempo);
	}

	private void saida(int tempo) {
		int aux = 0;

		for (int i = 0; i < 20; i++) {
			vet[i] = tempo;
			
		}

		for (int i = 0; i < 20; i++) {
			for (int j = i + 1; j < 20; j++) {
				if (vet[j] < vet[i]) {
					aux = vet[j];
					vet[j] = vet[i];
					vet[i] = aux;
				}
			}
		}

	}

	private void mostrar() {
	
	for(int i = 0; i < 1; i++) {
		System.out.println( "#" + ThreadId + " saiu com o tempo de: "+vet[i] + "s");
	}
	}
}