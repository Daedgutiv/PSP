package JChat.JCliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;

public class ServerSender implements Runnable{
	
	private DataOutputStream out;
	private boolean active;
	private BufferedReader keyboard;
	
	public ServerSender(DataOutputStream out) {
		this.out = out;
	}
	
	public void run() {
		
	}
	
	public void stop() {
		
	}

}
