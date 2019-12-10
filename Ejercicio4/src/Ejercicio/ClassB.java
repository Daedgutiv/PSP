package Ejercicio;

public class ClassB implements Runnable {

	private ClassA a;
	private boolean aux = true;
	private ClassB next;

	public ClassB(ClassA a) {
		this.a = a;
	}

	@Override
	public void run() {
		if (!Thread.currentThread().getName().equalsIgnoreCase("Thread-0")) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		this.a.EnterAndWait();

		synchronized(next) {
			next.notify();
		}
	
	}

	public void setNext(ClassB next) {
		this.next = next;
	}
}
