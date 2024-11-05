//program to update data in the db table using jdbc API
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTwo {
	private static final String url = "jdbc:postgresql://localhost:5432/company_db";
	private static final String user = "postgres";
	private static final String password = "elephant";
	private static final String UPDATE_QUERY = "update employ set salary=salary+2000 where id=1001";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1.load the jdbc driver and obtain connection

		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection(url, user, password);

		// 2. create a simple jdbc statement

		Statement st = con.createStatement();

		// 3. write sql query

		// 4. give sql query to statement
		int i = st.executeUpdate(UPDATE_QUERY);

		if (i > 0) {
			System.out.println("employee data updated");
		} else {
			System.out.println("employee data not updated!");
		}

		// 5.close the connection
		st.close();
		con.close();

	}

}
