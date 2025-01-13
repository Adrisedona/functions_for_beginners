package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSqLite implements AutoCloseable {

	Connection connection;

	public ConnectionSqLite(String databasePath, String databaseFileName) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection(String.format("jdbc:sqlite:/%s/%s", databasePath, databaseFileName));
	}

	public ConnectionSqLite(String databaseFullFileName) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection(String.format("jdbc:sqlite:/%s", databaseFullFileName));
	}

	@Override
	public void close() throws SQLException {
		this.connection.close();
	}
}
