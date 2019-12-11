package Ejercicio;

import java.util.HashSet;
import java.util.Set;

public class ClassA {

	private int counter;
	private Set<Long> threadIds = new HashSet<Long>() ;
	
	public int getCounter() {
		return counter;
	}

	public ClassA(int counter) {
		this.counter = counter;
		System.out.println(this.counter);
	}

	public boolean isfinished() {

		if (this.counter == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized void disminuir() {
		counter--;
	}
	
	public Set<Long> getIds() {
		return this.threadIds;
	}

	public synchronized void EnterAndWait() {
		System.out.println("El hilo " + Thread.currentThread().getName() + " me está ejecutando");
		
		this.threadIds.add(Thread.currentThread().getId());
		
			disminuir();	
			
			System.out.println(this.getIds().toString());

		System.out.println("El hilo " + Thread.currentThread().getName() + " está acabando " + counter);
	}

}
