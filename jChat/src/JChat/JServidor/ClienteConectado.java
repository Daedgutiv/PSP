package JChat.JServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClienteConectado implements Runnable {
	
	private String nickName;
	private Long id;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private Long idChat;
	
	public ClienteConectado(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		
	}
	
	public void enviarRespuesta(String respuesta) {
		
	}
	
	public void procesarComando(String cmd) {
		
		String[] strings = cmd.split(" ");
		
		switch (strings[0]) {
		case "#ayuda":
			if (strings.length!=1) {
				System.out.println("El comando \"" + cmd + "\" no existe, para más información consulte los comandos escribiendo \"#ayuda\"");
			} else {
				System.out.println("#listar: lista todos los usuarios conectados.\n#charlar <usuario>: comienza la comunicación con el usuario <usuario>\n#salir: se desconecta del chat");
			}
			break;
		case "#listar":
			System.out.println("En este momento están conectados " + ListaDeClientes.getNumConectados() + " usuarios:\n" + ListaDeClientes.getNombres());
			break;
		case "#salir":
			
			break;
		case "#charlar":
			if (ListaDeClientes.getIdByNickName(strings[1])!=-1) {
				System.out.println("Ahora está conectado con " + strings[1] + ". Escribe para hablarle");
			} else {
				System.out.println("El usuario " + strings[1] + " no existe o no está conectado");
			}
			break;
		default:
			System.out.println("El comando " + cmd + " no existe , para más información consulte los comandos escribiendo \"#ayuda\"");
			break;
		}
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
