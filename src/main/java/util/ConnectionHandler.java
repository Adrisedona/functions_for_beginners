package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
	
	protected Connection conexion;

	public void abrirConexion(String bd, String servidor, String usuario,
			String password) {
		try {
			String url = String.format("jdbc:mysql://%s:3306/%s?useServerPrepStmts=true", servidor, bd);
			// Establecemos la conexión con la BD
			this.conexion = DriverManager.getConnection(url, usuario, password);
			if (this.conexion != null) {
				System.out.println("Conectado a " + bd + " en " + servidor);
			} else {
				System.out.println("No conectado a " + bd + " en " + servidor);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getLocalizedMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("Código error: " + e.getErrorCode());
		}
	}

	public void cerrarConexion() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
		}
	}
}
