package Ejercicio;

public class ClassA {
	
	public synchronized void EnterAndWait() {
		System.out.println("El hilo " + Thread.currentThread().getName() + " me est� ejecutando");
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("El hilo " + Thread.currentThread().getName() + " est� acabando");
	}

}
