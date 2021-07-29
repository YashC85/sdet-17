package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {
	@Test
	 public void getExecuteUpdate() throws SQLException
	 {
	  Connection con=null;
	  try{
	  //Step 1:Register the database
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //Step 2:establish connection with database
	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	  
	  //Step 3 issue create statement
	  Statement stat = con.createStatement();
	  
	  //step 4: Execute any query
	   int result = stat.executeUpdate("insert into customer values(3,'John','Adam','USA');");
	  if(result==1)
	  {
	   System.out.println("project is created successfully");
	  }
	  else
	  {
	   System.out.println("query failed");
	  }
	  }
	  catch(Exception e)
	  {
	   
	  }
	  finally{
	   
	  
	  //Step : close database connection
	  con.close();
	  }
	 }

}
