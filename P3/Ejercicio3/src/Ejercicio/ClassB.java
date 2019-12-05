package Ejercicio;

public class ClassB implements Runnable{
	
	private ClassA a;

	public ClassB(ClassA a) {
		this.a=a;
	}
	
	@Override
	public void run() {
		
		this.a.EnterAndWait();
		
	}
	
}
