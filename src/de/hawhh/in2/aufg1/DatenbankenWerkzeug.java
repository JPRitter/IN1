package de.hawhh.in2.aufg1;

import java.sql.*;

import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.util.Pair;

import java.io.*;

public class DatenbankenWerkzeug
{
	private String _user;
	private String _pw;

	private void connect()
	{
		// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// class.forName(new oracle.)
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Login");
		dialog.setHeaderText("Look, a Custom Login Dialog");
		try
		{

			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14", _user, _pw);

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
