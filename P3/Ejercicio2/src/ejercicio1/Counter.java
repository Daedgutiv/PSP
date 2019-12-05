package ejercicio1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	// Con AtomicInteger se actualiza atómicamente lo que hace que el contador no
	// falle al intentar acceder varios hilos a la vez
	
	private AtomicInteger contador;

	public Counter() {
		this.contador = new AtomicInteger(0);
	}

	public void increment() {
		this.contador.getAndIncrement();
	}

	public int getContador() {
		return contador.get();
	}

}
