package JChat.JServidor;

import java.util.ArrayList;
import java.util.List;

public class ListaDeClientes {

	private static List<ClienteConectado> conectados;

	public void initList() {
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

	}

	public static int getPositionById(Long id) {
		int aux = -1;
		for (int i = 0; i < conectados.size(); i++) {
			if (conectados.get(i).getId() == id) {
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
		return aux;
	}

}
