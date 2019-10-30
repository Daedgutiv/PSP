package Ejercicio9;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Main {

	private static final String Ruta = "helloBatch.bat";

	public static void batch(String nombre) {
		Process processBuilder;
		try {
			processBuilder = new ProcessBuilder(new File(Ruta).getAbsolutePath(), nombre).start();
			BufferedReader br = new BufferedReader(new InputStreamReader(processBuilder.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {

		batch(JOptionPane.showInputDialog(null, "Introduzca su nombre para hacer el echo:"));

	}
}
