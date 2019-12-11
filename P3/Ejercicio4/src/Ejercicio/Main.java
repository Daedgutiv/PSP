package Ejercicio;

public class Main {

	private final static int HILOS = 20;
	public final static int Contador = 10;

	public static void main(String[] args) {

		ClassA a = new ClassA(Contador);
		ClassB[] b = new ClassB[HILOS];

		for (int i = 0; i < HILOS; i++) {
			b[i] = new ClassB(a);
		}
		for (int i = 0; i < HILOS; i++) {
			if (i == HILOS - 1) {
				b[i].setNext(b[0]);
			} else {
				b[i].setNext(b[i + 1]);
			}
		}

		Thread[] hilos = new Thread[HILOS];
		for (int i = 0; i < HILOS; i++) {
			hilos[i] = new Thread(b[i]);
			hilos[i].start();
		}
		
		hilos[0].interrupt();
		

	}

}
