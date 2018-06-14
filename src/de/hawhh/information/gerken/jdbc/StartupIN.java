package de.hawhh.information.gerken.jdbc;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.*;

public class StartupIN extends Application
{

	LoginUI _ui;

	public static void main(String[] args)
	{
		launch();

	}

	@Override
	public void start(Stage arg0) throws Exception
	{
		_ui = new LoginUI();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String user = _ui.getUser();
		String pw = _ui.getPasswort();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14",
				user, pw);
		stmt = con.createStatement();
		rs = stmt.executeQuery("Select Stud_Name from Student"); 
		ResultSetMetaData rsetmd = rs.getMetaData();
		System.out.println(rsetmd.getColumnName(1));
		while (rs.next())
		{ 
			System.out.println(rs.getString(1)); 
		}
		con.close(); 
	}
}
