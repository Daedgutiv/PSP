package JChat.JServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

public class ClienteConectado implements Runnable {

	private String nickName;
	private Long id;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private Long idChat;

	public ClienteConectado(Socket socket) {
		this.socket = socket;
		this.id = new Date().getTime();
	}

	public void run() {

		try {
			// recibir nickname al ejecutar el cliente
			in = new DataInputStream(socket.getInputStream());
			nickName = in.readUTF();
			System.out.println("Conexión establecida con la IP: " + socket.getRemoteSocketAddress() + " y el nickname: "
					+ nickName);
			ListaDeClientes.addCliente(this);

		} catch (Exception e) {
			// TODO: handle exception
		}
		do {

			String mensaje = "";

			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				try {
					mensaje = in.readUTF();
				} catch (SocketException e) {
					try {
						socket.close();
					} catch (IOException ex) {
						e.printStackTrace();
					}
					System.out.println("El usuario con ip: " + socket.getRemoteSocketAddress() + " y nick: " + nickName
							+ " Se ha desconectado.");
					ListaDeClientes.deleteCLienteById(id);
					break;
				}

				if (mensaje.charAt(0) == '>') {
					enviarRespuesta(mensaje);
				} else {
					if (idChat == null) {
						procesarComando(mensaje);
					} else {
						if (mensaje.charAt(0) == '#') {
							procesarComando(mensaje);
						} else {
							boolean enviado = ListaDeClientes.enviarMensaje(idChat, mensaje);
							if (enviado == false) {
								enviarRespuesta("Error, el mensaje no se ha podido enviar.");
							}
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} while (ListaDeClientes.getPositionById(id) != -1);

	}

	public void enviarRespuesta(String respuesta) {

		try {
			out.writeUTF(respuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void procesarComando(String cmd) {

		String[] strings = cmd.split(" ");

		switch (strings[0]) {
		case "#ayuda":
			if (strings.length != 1) {
				enviarRespuesta("El comando \"" + cmd
						+ "\" no existe, para más información consulte los comandos escribiendo \"#ayuda\"");
			} else {
				enviarRespuesta(
						"#listar: lista todos los usuarios conectados.\n#charlar <usuario>: comienza la comunicación con el usuario <usuario>\n#salir: se desconecta del chat");
			}
			break;
		case "#listar":
			enviarRespuesta("En este momento están conectados " + ListaDeClientes.getNumConectados() + " usuarios:\n"
					+ ListaDeClientes.getNombres());
			break;
		case "#salir":
			enviarRespuesta("Desconectado con éxito");
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("El usuario con ip: " + socket.getRemoteSocketAddress() + " y nick: " + nickName
					+ " Se ha desconectado.");
			ListaDeClientes.deleteCLienteById(id);
			break;
		case "#charlar":
			if (strings[1] != null) {
				if (ListaDeClientes.getIdByNickName(strings[1]) != -1) {
					enviarRespuesta("Ahora está conectado con " + strings[1] + ". Escribe para hablarle");
					this.idChat = ListaDeClientes.getIdByNickName(strings[1]);
				} else {
					enviarRespuesta("El usuario " + strings[1] + " no está conectado");
				}
			} else {
				enviarRespuesta("El comando " + cmd
						+ " no existe , para más información consulte los comandos escribiendo \"#ayuda\"");
			}

			break;
		default:
			enviarRespuesta("El comando " + cmd
					+ " no existe , para más información consulte los comandos escribiendo \"#ayuda\"");
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
