package tests;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Clase para probar codigo antes de añadirlo a algun otro archivo de la
 * libreria
 */

class Temp {
	public static void main(String[] args) throws InterruptedException {
		// String cadena = "Esto va a ir lento";
		// for (int i = 0; i < cadena.length(); i++) {
		// System.err.print(cadena.charAt(i));
		// Thread.sleep(200);
		// }
		// new PruebaTimer().setVisible(true);
		int i = 0;

		File file = new File(System.getProperty("user.home") + "\\prueba.txt");
		try (PrintWriter printer = new PrintWriter(new FileWriter(file, true))) {
			while (i < args.length) {
				printer.printf("%s%n", args[i++]);
			}
		} catch (IOException e) {
			System.err.println("Folio no encontrado");
		}

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (IOException | IllegalArgumentException e) {
			System.err.println(e.getClass() == IOException.class ? "Folio no encontrado" : e.getMessage());
		}

		char[] buffer = new char[3];
		@SuppressWarnings("unused")
		int nCaracteres;
		try (FileReader fr = new FileReader(file)) {
			while ((nCaracteres = fr.read(buffer)) > -1) {
				System.out.println(buffer);
			}
		} catch (IOException e) {
			System.out.println("error");
		}

		/**
		 * Linea de prueba
		 * Linea de prueba
		 * Linea de prueba
		 * Linea de prueba
		 * linea1
		 * linea2
		 * linea3
		 * linea4
		 * linea1
		 * linea2
		 * linea3
		 * linea4
		 */
	}

}
