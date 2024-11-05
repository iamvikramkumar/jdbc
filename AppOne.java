package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppOne {

	private static final String INSERT_QUERY = "insert into student values(1001,'arun','CSE')";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1.load the jdbc driver and obtain connection

		Class.forName("com.mysql.cj.jdbc.Driver"); // load the jdbc driver

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "root");

		// 2.create a simple jdbc statement
		Statement statement = connection.createStatement();

		// 3. write a sql query and give to statement
		int i = statement.executeUpdate(INSERT_QUERY); // executes the query in db

		if (i > 0) {
			System.out.println("Student data inserted in DB");
		} else {
			System.out.println("Student data not inserted in DB");
		}

		// close the connection
		statement.close();
		connection.close();

	}
}