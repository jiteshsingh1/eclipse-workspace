package employees;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Avgsalary {

	public static void main(String[] args) {
			
		String url = "jdbc:mysql://localhost:3306/employees";
		String Uname = "root";
		String Password ="User@684";
		String query ="select total_avg,title from title_table ; ";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,Uname,Password);
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(query);
			
			while (rst.next()) {
				
					System.out.println("avg_salary = " + rst.getDouble(1) + "\ntitle = " + rst.getString(2));
					System.out.println("-------------");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
