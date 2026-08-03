package Intermediate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBase {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://yourserver.database.windows.net:1433;"
					+ "database = Adventureworks;"
					+ "user=yourusername@yourserver;"
					+ "password =< password>;"
					+ "encrypt=true;"
					+ "trusrServerCertificate=false;"
					+ "loginTimeout=30;";
		
		try (Connection connection = DriverManager.getConnection(connectionUrl)){
			System.out.println("Connected to the database successfully.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
