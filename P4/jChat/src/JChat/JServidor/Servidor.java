package JChat.JServidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public Servidor() {
		
		try {
			ServerSocket ss = new ServerSocket(ConstantesServidor.puerto);
			ListaDeClientes.initList();
			System.out.println("Iniciando...");
			while(true) {
				Socket s = ss.accept();
				ClienteConectado usuario = new ClienteConectado(s);
				Thread hilo = new Thread(usuario);
				hilo.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		new Servidor();

	}

}
