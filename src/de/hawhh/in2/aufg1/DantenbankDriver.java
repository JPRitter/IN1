package de.hawhh.in2.aufg1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class DantenbankDriver implements Driver
{

	@Override
	public boolean acceptsURL(String arg0) throws SQLException
	{
		if(arg0.equals("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14"))
			return true;
		
		return false;
	}

	@Override
	public Connection connect(String arg0, Properties arg1) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean jdbcCompliant()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}