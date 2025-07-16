package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDatabase {
	public static void main(String[] args) throws Throwable {
		
		//load/register mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata", "root", "Sumitha@77");
		
		//create sql statement
		Statement statement = conn.createStatement();
		String query = "insert into employee(RegNo,FirstName,LastName)values('2','Janani','L'),('3','Dilip','Kumar')";
		
		 int result = statement.executeUpdate(query);
		
		if(result != 1)
		{
			System.out.println("Data is created");
		}
		else
		{
			System.out.println("Data is not created");
		}
		
		conn.close();
		
		
		
	}

}
