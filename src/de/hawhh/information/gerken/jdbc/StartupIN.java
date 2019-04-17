package de.hawhh.information.gerken.jdbc;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		InsertStatic(con, "delete from CUSTOMER");
		
		InsertStatic(con, "insert into CUSTOMER Values(1234,'Bob','Baker','12.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(1235,'Jack','Faker','10.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(1233,'Faisla','Danils','13.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(1236,'Phibs','Aguiar','14.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(1237,'Ver','Berger','19.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(1238,'Bear','Lager','17.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(1239,'Jopnny','Bier','16.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(123445,'Jay','Beer','15.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(123455,'Steph','Tilus','14.04.2001')");
		InsertStatic(con, "insert into CUSTOMER Values(12313,'Tim','Tark','11.04.2001')");
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from CUSTOMER");
		ResultSetMetaData rsetmd = rs.getMetaData();
		int numberOfCollums = rsetmd.getColumnCount();

		
		for (int i = 1; i <= numberOfCollums; i++)
		{
			System.out.println(rsetmd.getColumnName(i) + " ");
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

	}
	
	public static void InsertStatic(Connection c, String sql) throws SQLException
	{
		try
		{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println("Fehler");
		}
	}
}
