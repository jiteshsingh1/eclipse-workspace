package employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class employeedetails {

	public static void main(String[] args) {
			
		String url = "jdbc:mysql://localhost:3306/employees";
		String Uname = "root";
		String Password ="User@684";
		String query ="select max(maxu) , dept_no from max_salary_table group by dept_no;";
		TreeMap<Integer,String> map = new TreeMap<>();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,Uname,Password);
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(query);
			
			while (rst.next()) {
				for (int i = 1; i <=2 ; i++) {
					map.put(rst.getInt(1), rst.getString(2));
				}
				
			}
			ResultSet rst1 ;
			for(Map.Entry<Integer,String> m:map.entrySet()) {
				rst1 = stmt.executeQuery("select emp_no from salaries where salary ="+m.getKey());
				rst1.next();
				System.out.println("emp_no = "+ " "+ rst1.getInt(1));
				
				System.out.println("max_salary = " + m.getKey() +"  " +"\ndepartment = " + m.getValue());
				System.out.println("----------------");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
