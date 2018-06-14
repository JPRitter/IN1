package de.hawhh.information.gerken.jdbc;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.*;

public class StartupIN extends Application
{

	LoginUI _ui;
	DatenbankUI _uiDat;

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
		_ui.login();
		String user = _ui.getUser();
		String pw = _ui.getPasswort();

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

			con = DriverManager.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14", user, pw);

		}
		catch (Exception e)
		{

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from WIMI_Gesamt");
		ResultSetMetaData rsetmd = rs.getMetaData();
		int numberOfCollums = rsetmd.getColumnCount();
		String[] ueber = new String[numberOfCollums];
		for (int i = 1; i <= numberOfCollums; i++)
		{
			System.out.println(rsetmd.getColumnName(i) + " ");
			ueber[i] = rsetmd.getColumnName(i);
		}
		while (rs.next())
		{
			System.out.println();
			for (int i = 1; i <= numberOfCollums; i++)
			{
				System.out.println(rs.getString(i) + " ");
			}
		}
		con.close();
		_uiDat = new DatenbankUI("Bla");
		
		_uiDat.aendereTable(ueber);
		_uiDat.zeigeFenster();
	}
}
