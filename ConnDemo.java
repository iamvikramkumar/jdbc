package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver");

Connection connection = 
DriverManager.getConnection("jdbc:postgresql://localhost:5432/company_db", "postgres",
		"elephant");

		Statement st = connection.createStatement();

		int updateStatus = st.executeUpdate("insert into employees values(1001,'arun',45000.25)");

		if (updateStatus > 0) {
			System.out.println("row inserted successfully");
		} else {
			System.out.println("row not inserted");
		}

		connection.close();

	}
}