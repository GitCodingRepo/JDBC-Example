import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlCon {

	public static void main(String[] args) {

		System.out.println("hi");

		try {
			// 1. Register driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			String URL = "jdbc:mysql://localhost:3306/SADADB";
			String user = "root";
			String pass = "sadauser";

			System.out.println("before connection");
			// 2. Creating connection
			Connection con = DriverManager.getConnection(URL, user, pass);

			System.out.println("Connection successful");
			// 3. Creating statement
			Statement stmt = con.createStatement();

			System.out.println("before excute");
			// 4. Query execution
			ResultSet rs = stmt.executeQuery("select * from SADA");
			
			System.out.println("here");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				
				System.out.println("\n");
			}
			
			// 5. Closing connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver class not found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
