package JChat.JServidor;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ListaDeClientes {

	private static List<ClienteConectado> conectados;

	public static void initList() {
		conectados = new ArrayList<ClienteConectado>();
	}

	public static void addCliente(ClienteConectado c) {
		conectados.add(c);
	}

	public static int getNumConectados() {
		return conectados.size();
	}

	public static void deleteCLienteById(Long id) {
		for (int i = 0; i < conectados.size(); i++) {
			if (conectados.get(i).getId() == id) {
				conectados.remove(i);
			}
		}
	}

	public static String getNombres() {
		String aux = "";
		for (int i = 0; i < conectados.size(); i++) {
			aux = aux + conectados.get(i).getNickName() + "\n";
		}
		return aux;
	}

	public static boolean enviarMensaje(Long id, String mensaje) {
		
		try {
			ClienteConectado cliTemp = conectados.get(getPositionById(id));
			String aux = ">"+ cliTemp.getNickName() + ": " + mensaje;
			cliTemp.enviarRespuesta(aux);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public static int getPositionById(Long id) {
		int aux = -1;
		for (int i = 0; i < conectados.size(); i++) {
			if (Long.compare(id, conectados.get(i).getId())==0) {
				aux = i;
			}
		}
		return aux;
	}
	
	public static Long getIdByNickName(String nickName) {
		long aux = -1;
		for (int i = 0; i < conectados.size(); i++) {
			if (conectados.get(i).getNickName().equalsIgnoreCase(nickName)) {
				aux = conectados.get(i).getId();
			}
		}
		System.out.println("Id encontrado = " + aux);
		return aux;
	}

}
