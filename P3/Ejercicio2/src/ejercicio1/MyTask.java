package ejercicio1;

public class MyTask extends Thread {
	
	private static final int time = 1000;
	private Counter c;
	
	public MyTask(Counter c) {
		this.c=c;
	}
	
	
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep((long)(Math.random() * 1000));
				c.increment();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
