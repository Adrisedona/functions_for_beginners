package util;

import java.awt.Rectangle;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import javax.swing.*;

import java.time.format.DateTimeFormatter;
import java.time.*;

public final class Util {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Esta es una libreria de funciones, no se debe instanciar un objeto de esta
	 * clase
	 */
	private Util() {
	}

	/**
	 * Solicita una cadena al usuario con una longitud entre min y max
	 * 
	 * @param min longitud minima de la cadena (<code>0</code> si null)
	 * @param max longitud maxima de la cadena ({@link Integer#MAX_VALUE} si null)
	 * @param txt texto a mostrar al usuario para que introduzca la cadena deseado
	 * @return cadena introducida por el usuario
	 */
	public static String pedirDatosCadena(Integer min, Integer max, String txt) {
		String cadena = "";
		if (max == null) {
			max = Integer.MAX_VALUE;
		}
		if (min == null || min < 0) {
			min = 0;
		}
		do {
			System.out.println(txt);
			cadena = sc.nextLine();
			if (cadena.length() > max || cadena.length() < min) {
				System.out.printf("La longitud de la cadena debe de ser entre %d y %d, intentelo de nuevo\n", min, max);
			}
		} while (cadena.length() > max || cadena.length() < min);
		return cadena.trim();
	}

	/**
	 * Solicita al usuario un numero entero entre dos valores (ambos incluidos)
	 * 
	 * @param min valor minimo del numero ({@link Integer#MIN_VALUE} si null)
	 * @param max valor maximo del numero ({@link Integer#MAX_VALUE} si null)
	 * @param txt texto para informar al usuario el uso del numero que va a
	 *            introducir
	 * @return numero introducido por el usuario entre los valores
	 */
	public static int pedirDatosInt(Integer min, Integer max, String txt) {
		int numint = 0;
		boolean valid;
		if (min == null) {
			min = Integer.MIN_VALUE;
		}
		if (max == null) {
			max = Integer.MAX_VALUE;
		}
		do {
			try {
				System.out.println(txt);
				numint = Integer.parseInt(sc.nextLine());
				valid = !(numint < min || numint > max);
				if (!valid) {
					System.out.printf("El número debe ser entre %d y %d\n", min, max);
				}
			} catch (NumberFormatException e) {
				System.out.println("No se ha introducido un numero, intentelo de nuevo");
				valid = false;
			}
		} while (!valid);

		return numint;

	}

	/**
	 * Solicita al usuario un numero decimal entre dos valores (ambos incluidos)
	 * 
	 * @param min valor minimo del numero (-{@link Double#MAX_VALUE} si null)
	 * @param max valor maximo del numero ({@link Double#MAX_VALUE} si null)
	 * @param txt texto para informar al usuario el uso del numero que va a
	 *            introducir
	 * @return numero introducido por el usuario entre los valores
	 */
	public static double pedirDatosDouble(Double min, Double max, String txt) {
		double numdouble = 0;
		boolean valid;
		if (min == null) {
			min = -Double.MAX_VALUE;
		}
		if (max == null) {
			max = Double.MAX_VALUE;
		}
		do {
			try {
				System.out.println(txt);
				numdouble = Double.parseDouble(sc.nextLine());
				valid = !(numdouble < min || numdouble > max);
				if (!valid) {
					System.out.printf("El número debe ser entre %.4e y %.4e\n", min, max);
				}
			} catch (NumberFormatException e) {
				valid = false;
				System.out.println("No se ha introducido un numero, intentelo de nuevo");
			}
		} while (!valid);
		return numdouble;

	}

	/**
	 * Limpia la pantalla mostrando muchas lineas en blanco
	 * 
	 */
	public static void screenClear() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	/**
	 * Genera {@code true} o {@code false} aleatoriamente
	 * 
	 * @return {@code true} o {@code false}
	 */
	public static boolean RandomBoolean() {
		return (int) (Math.random() * 2) == 1;
	}

	/**
	 * Calcula el factorial de un numero (metodo tradicional, sin funciones gamma y
	 * pi)
	 * 
	 * @param num numero para el que se calcula el factorial
	 * @return factorial calculado
	 */
	public static double factorial(int num) {
		if (num < 0) {
			throw new IllegalArgumentException();
		}
		if (num > 1) {
			return (double) (num * factorial(num - 1));
		} else {
			return 1;
		}
	}

	/**
	 * Muestra la tabla ASCII extendida
	 */
	public static void mostrarTablaASCII() {
		for (int i = 0; i < 256; i++) {
			System.out.printf("| %3d | %3c |\n", i, (char) i);

		}
	}

	/**
	 * Solicita un caracter al usuario y lo compara los caracteres parametro
	 * 
	 * @param a   caracter a comparar
	 * @param b   caracter a comparar
	 * @param txt cadena de texto a mostrar al usuario para informarle de lo que
	 *            debe introducir
	 * @return {@code true} si el caracter introducido es igual al primer parametro,
	 *         {@code false} si es igual al segundo
	 */
	public static boolean pickChar(char a, char b, String txt) {
		char picked = ' ';
		String input;
		boolean valid;
		do {
			System.out.println(txt);
			input = sc.nextLine();
			valid = input.length() == 1;
			if (!valid) {
				System.out.println("Debes introducir un unico caracter, intentelo de nuevo");
			} else {
				picked = input.charAt(0);
				valid = picked == a || picked == b;
				if (!valid) {
					System.out.printf("El caracter debe ser %c o %c, intentelo de nuevo", a, b);
				}
			}
		} while (!valid);
		return picked == a;

	}

	/**
	 * Solicita al usuario un numero entero entre dos valores (ambos incluidos)
	 * 
	 * @param min valor minimo del numero (al introducir null como valor, se
	 *            vuelve el menor valor que acepta el tipo de dato int)
	 * @param max valor minimo del numero (al introducir null como valor, se
	 *            vuelve el mayor valor que acepta el tipo de dato int)
	 * @param txt texto para informar al usuario el uso del numero que va a
	 *            introducir
	 * @return numero introducido por el usuario entre los valores
	 */
	public static int pedirDatosIntJOptionPane(Integer min, Integer max, String txt) {
		int numint = 0;
		boolean valid;
		if (min == null) {
			min = Integer.MIN_VALUE;
		}
		if (max == null) {
			max = Integer.MAX_VALUE;
		}
		do {
			try {
				numint = Integer.parseInt(
						JOptionPane.showInputDialog(null, txt, "Introduccion de numero", JOptionPane.PLAIN_MESSAGE));
				valid = !(numint < min || numint > max);
				if (!valid) {
					JOptionPane.showMessageDialog(null, String.format("El número debe ser entre %d y %d\n", min, max),
							"Error en la introduccion de numero", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "No se ha introducido un numero",
						"Error en la introduccion de numero",
						JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		} while (!valid);

		return numint;

	}

	/**
	 * Solicita al usuario un numero decimal entre dos valores (ambos incluidos)
	 * 
	 * @param min valor minimo del numero (al introducir null como valor, se
	 *            vuelve
	 *            el menor valor que acepta el tipo de dato double)
	 * @param max valor minimo del numero (al introducir null como valor, se
	 *            vuelve
	 *            el mayor valor que acepta el tipo de dato double)
	 * @param txt texto para informar al usuario el uso del numero que va a
	 *            introducir
	 * @return numero introducido por el usuario entre los valores
	 */
	public static double pedirDatosDoubleJOptionPane(Double min, Double max, String txt) {
		double numdouble = 0;
		boolean valid;
		if (min == null) {
			min = -Double.MAX_VALUE;
		}
		if (max == null) {
			max = Double.MAX_VALUE;
		}
		do {
			try {
				numdouble = Double.parseDouble(
						JOptionPane.showInputDialog(null, txt, "Introduccion de numero", JOptionPane.PLAIN_MESSAGE));
				valid = !(numdouble < min || numdouble > max);
				if (!valid) {
					JOptionPane.showMessageDialog(null, String.format("El número debe ser entre %e y %e\n", min, max),
							"Error en la introduccion de numero", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "No se ha introducido un numero",
						"Error en la introduccion de numero",
						JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		} while (!valid);
		return numdouble;

	}

	/**
	 * Parsea desde un String un numero entero entre dos valores (ambos incluidos)
	 * 
	 * @param min           valor minimo del numero (al introducir null como valor,
	 *                      se
	 *                      vuelve
	 *                      el menor valor que acepta el tipo de dato int)
	 * @param max           valor minimo del numero (al introducir null como valor,
	 *                      se
	 *                      vuelve
	 *                      el mayor valor que acepta el tipo de dato int)
	 * @param numberToParse cadena de la que obtener el numero
	 * @throws IllegalArgumentException si el cadena es nula, no contiene un
	 *                                  valor numerico o no esta entre el minimo y
	 *                                  el maximo
	 * @return numero introducido por el usuario entre los valores
	 */
	public static int parseInt(Integer min, Integer max, String numberToParse) {
		if (numberToParse == null) {
			throw new IllegalArgumentException("No se ha introducido un numero");
		}
		int numint;
		if (min == null) {
			min = Integer.MIN_VALUE;
		}
		if (max == null) {
			max = Integer.MAX_VALUE;
		}
		try {
			numint = Integer.parseInt(numberToParse);
			if (numint < min || numint > max) {
				throw new IllegalArgumentException("No está dentro del rango permitido");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("No se ha introducido un numero");
		}
		return numint;

	}

	/**
	 * Parsea desde un String un numero decimal entre dos valores (ambos incluidos)
	 * 
	 * @param min           valor minimo del numero (al introducir null como valor,
	 *                      se
	 *                      vuelve
	 *                      el menor valor que acepta el tipo de dato double)
	 * @param max           valor minimo del numero (al introducir null como valor,
	 *                      se
	 *                      vuelve
	 *                      el mayor valor que acepta el tipo de dato double)
	 * @param numberToParse cadena de la que obtener el numero
	 * @throws IllegalArgumentException si el cadena es nula, no contiene un
	 *                                  valor numerico o no esta entre el minimo y
	 *                                  el maximo
	 * @return numero introducido por el usuario entre los valores
	 */
	public static double parseDouble(Double min, Double max, String numberToParse) {
		if (numberToParse == null) {
			throw new IllegalArgumentException("No se ha introducido un numero");
		}
		double numdouble;
		if (min == null) {
			min = -Double.MAX_VALUE;
		}
		if (max == null) {
			max = Double.MAX_VALUE;
		}
		try {
			numdouble = Double.parseDouble(numberToParse);
			if (numdouble < min || numdouble > max) {
				throw new IllegalArgumentException("No está dentro del rango permitido");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("No se ha introducido un número");
		}
		return numdouble;

	}

	/**
	 * Devuelve la cadena parametro al reves
	 * 
	 * @param string cadena con la que trabajar
	 * @return cadena generada
	 */
	public static String reverseString(String string) {
		String retu = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			retu += string.charAt(i);
		}
		return retu;
	}

	public static boolean intersects(JLabel testA, JLabel testB) {
		Rectangle rectB = testB.getBounds();
		Rectangle result = SwingUtilities.computeIntersection(testA.getX(), testA.getY(), testA.getWidth(),
				testA.getHeight(), rectB);
		return (result.getWidth() > 0 && result.getHeight() > 0);
	}

	/**
	 * Genera un numero entero aleatorio entre <code>min</code> y <code>max</code>
	 * (ambos incuidos)
	 * 
	 * @param min valor minimo del rango
	 * @param max valor maximo del rango
	 * @return numero generado
	 */
	public static int random(int min, int max) {
		return ((int) (Math.random() * (max - min + 1) + min));
	}

	/**
	 * Genera un numero decimal aleatorio entre <code>min</code> y <code>max</code>
	 * (ambos incuidos)
	 * 
	 * @param min valor minimo del rango
	 * @param max valor maximo del rango
	 * @return numero generado
	 */
	public static double random(double min, double max) {
		return (Math.random() * (max - min) + min);
	}

	/**
	 * 
	 * @param unixTime
	 * @return
	 */
	public static String unixTimeToString(long unixTime) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT+1")).format(formatter);
	}


	public static String generateTable(ResultSet resu) throws SQLException {
		ResultSetMetaData metaData = resu.getMetaData();
		String table = "";
		String separator = "";
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			table += String.format("| %-20s |", metaData.getColumnName(i));
			for (int j = 0; j < 22; j++) {
				separator += "-";
			}
		}
		table += "\n" + separator + "\n";
		while (resu.next()) {
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				switch (metaData.getColumnType(i)) {
					case Types.INTEGER:
						table += String.format("| %-20d |", resu.getInt(i));
						break;
					case Types.BOOLEAN:
						table += String.format("| %-20b |", resu.getBoolean(i));
						break;
					case Types.CHAR:
					case Types.VARCHAR:
						table += String.format("| %-20s |", resu.getString(i));
						break;
					case Types.DATE:
						table += String.format("| %-20s |", unixTimeToString(resu.getDate(i).getTime()));
						break;
					case Types.TIMESTAMP:
						table += String.format("| %-20s |", unixTimeToString(resu.getTimestamp(i).getTime()));
						break;
					default:
						throw new UnsupportedOperationException(String.format("%s not supported", metaData.getColumnTypeName(i)));
				}
			}
		}
		return table.replaceAll("||", "|");
	}

}
