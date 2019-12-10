package Ejercicio;

public class ClassB implements Runnable {

	private ClassA a;
	private boolean aux;
	private ClassB next;

	public ClassB(ClassA a) {
		this.a = a;
		this.aux = true;
	}

	@Override
	public void run() {

		while (aux) {
			
			
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
				
				}
			}
			if (!a.isfinished()) {
				this.a.EnterAndWait();
			} else if (a.isfinished()) {
				aux = false;
			}

			synchronized (next) {
				next.notify();
			}
		}

	}

	public void setNext(ClassB next) {
		this.next = next;
	}
}
