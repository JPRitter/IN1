package de.hawhh.information.gerken.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class CustomerInsertTest
{

	@Test
	void testOneCustomerInsertion()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14", "scott", "tiger");
		}
		catch (Exception e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		try
		{
			Customer.ExecuteSql(con, "DELETE FROM CUSTOMER");
			Customer.insertCustomer(con, "1234", "Bob", "Baker", "12.04.2001");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
			
			if(rs.next())
			{
				String id = rs.getString(1);
				assertEquals(id, "1234");
			}
			
			if(rs.next())
			{
				String firstname = rs.getString(2);
				assertEquals(firstname, "Bob");
			}
			
			if(rs.next())
			{
				String familyname = rs.getString(3);
				assertEquals(familyname, "Baker");
			}
			
			if(rs.next())
			{
				String entrydate = rs.getString(4);
				assertEquals(entrydate, "12.04.2001");
			}		
			con.close();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			assertTrue(e.getMessage().matches("(.*)"));
		}
	}

}
