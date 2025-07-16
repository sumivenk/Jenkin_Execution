package DDT;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class FetchingDataFromDatabase {
	public static void main(String[] args) throws Throwable {
		
		//Register/Load Mysql database
		Driver driverRep = new Driver();
		DriverManager.registerDriver(driverRep);
		
		//get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata", "root", "Sumitha@77");
		
		//create sql statement
		Statement statement = conn.createStatement();
		String qury = "select *from employee";
		
		//execute statement qury
		ResultSet result = statement.executeQuery(qury);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+ result.getString(2)+"\t"+ result.getString(3));
		}
		
		//close connect
		conn.close();	
		

	}

}





