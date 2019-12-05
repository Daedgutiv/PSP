package Ejercicio;

public class Main {
	
	private final static int c = 20;

	public static void main(String[] args) {
		
		ClassA a = new ClassA();
		ClassB[] b = new ClassB[c];
				
		for (int i = 0;i<c;i++) {
			b[i] = new ClassB(a);
		}
		
		Thread[] hilos = new Thread[c];
		
		for (int i =0;i<c;i++) {
			hilos[i]= new Thread(b[i]);
			hilos[i].start();
		}
		for (int i =0;i<c;i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
