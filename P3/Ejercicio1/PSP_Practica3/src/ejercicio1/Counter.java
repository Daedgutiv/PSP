package ejercicio1;

public class Counter {

	private int contador;

	public Counter() {
		this.contador = 0;
	}

	// El synchronized hace que los hilos antes de entrar al bloque sincronizado
	// pregunten si alg�n otro hilo que este usando ese bloque sincronizado, en cuyo
	// caso esperar� para ejecutarlo.
	
	public synchronized void increment() {
		this.contador++;
	}

	public int getContador() {
		return contador;
	}

}
