package ejercicio1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

	// Con AtomicInteger se actualiza atómicamente lo que hace que el contador no
	// falle al intentar acceder varios hilos a la vez

	private int contador;

	public Counter() {
		this.contador = 0;
	}

	// Con el synchronized cuenta bien otra vez ya que no pueden intentar escribir
	// varios hilos a la vez
	public synchronized void increment() {
		this.contador++;
	}

	public int getContador() {
		return contador;
	}

}
