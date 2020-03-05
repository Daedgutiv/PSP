package JChat.JCliente;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
	
	private int numPuerto;
	private String dirDestino;
	private ServerReceiver sr;
	private ServerSender ss;
	private Socket socket;
	
	public static void main(String[] args) {
		
		if (args.length!=2) {
			System.out.println("Uso: java Cliente <dirección del servidor> <nickName>");
		} else {
			Cliente cliente = new Cliente(args[1]);
		}

	}

	public Cliente(String nick) {
		
		
		
	}
	
	private void run() {
		
	}
	
	private void shutdown() throws IOException {
		System.out.println("Cerrando conexión...");
		this.socket.close();
	}

}
