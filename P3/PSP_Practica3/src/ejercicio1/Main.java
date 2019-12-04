package ejercicio1;

public class Main {

	public static void main(String[] args) {
		int a = 1000;
		Counter c = new Counter();
		MyTask[] hilos = new MyTask[a];
		
		for (int i = 0; i<a;i++) {
			hilos[i] = new MyTask(c);
			hilos[i].start();
		}
		
		System.out.println(c.getContador());
	}

}
