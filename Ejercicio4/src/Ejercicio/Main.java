package Ejercicio;

public class Main {

	private final static int c = 20;

	public static void main(String[] args) {

		ClassA a = new ClassA();
		ClassB[] b = new ClassB[c];

		for (int i = 0; i < c; i++) {
			b[i] = new ClassB(a);
		}
		for (int i = 0; i < c; i++) {
			if (i == c - 1) {
				b[i].setNext(b[0]);
			} else {
				b[i].setNext(b[i + 1]);
			}
		}

		Thread[] hilos = new Thread[c];

		for (int i = 0; i < c; i++) {
			hilos[i] = new Thread(b[i]);
			hilos[i].start();
		}
		
	}

}
