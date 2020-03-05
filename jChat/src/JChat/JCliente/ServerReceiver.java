package JChat.JCliente;

import java.io.DataInputStream;

public class ServerReceiver implements Runnable {
	
	private DataInputStream in;
	private boolean active;
	
	public ServerReceiver(DataInputStream in) {
		this.in=in;
	}
	
	public void run() {
		
	}
	
	public void stop() {
		
	}

}
