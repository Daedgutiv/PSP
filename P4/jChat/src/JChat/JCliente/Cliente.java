package JChat.JCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	
	private final int numPuerto=10;
	private static String dirDestino;
	private static ServerReceiver sr;
	private static ServerSender ss;
	private static Socket socket;
	
	public static void main(String[] args) {
		
		if (args.length!=2) {
			System.out.println("Uso: java Cliente <dirección del servidor> <nickName>");
		} else {
			Cliente cliente = new Cliente(args[1]);
		}
		
		dirDestino= args[0];

	}

	public Cliente(String nick) {
		
		try {
			socket = new Socket(dirDestino, numPuerto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataOutputStream out = null;
		try { 
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(nick);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		try {
			ss = new ServerSender(new DataOutputStream(out));
			sr = new ServerReceiver(new DataInputStream(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread hilo = new Thread(sr);
		hilo.start();
		run();
		
		
	}
	
	public void run() {
		Thread hilo = new Thread(ss);
		hilo.start();
		
	}
	
	public static void shutdown() throws IOException {
		System.out.println("Cerrando conexión...");
		ss.stop();
		sr.stop();
	}

}
