package JChat.JCliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ServerSender implements Runnable{
	
	private DataOutputStream out;
	private boolean active;
	private BufferedReader keyboard;
	
	public ServerSender(DataOutputStream out) {
		this.out = out;
		active = true;
	}
	
	public void run() {
		
		do {
			String mensaje="";
			Scanner scanner = new Scanner(System.in);
//			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
				mensaje = scanner.nextLine();
			
			if(mensaje.equalsIgnoreCase("#salir")) {
				try {
					out.writeUTF(mensaje);
					Cliente.shutdown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			try {
				out.writeUTF(mensaje);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} while (active);
		
	}
	
	public void stop() {
		active = false;
	}

}
