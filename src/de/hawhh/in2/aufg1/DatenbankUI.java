package de.hawhh.in2.aufg1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DatenbankUI
{
	private Stage _primaryStage;
	private Scene _scene;
	private Pane _pane;
	private String _ausgewaehlteTabelle;
	private Label _label;
	private Connection _connection;
	@SuppressWarnings("rawtypes")
	public TableView _tw;
	public ChoiceBox<String> _dropDown;
	
	@SuppressWarnings("rawtypes")
	public DatenbankUI(String ueberschrift, Connection c)
	{
		_label = new Label(ueberschrift);
		_tw = new TableView();
		_connection = c;
		_tw.setEditable(true);
		_pane = new VBox();
		_dropDown = new ChoiceBox<String>();
		_pane.getChildren().addAll(_label, _tw);
		 Scene scene = new Scene(_pane, 500, 500);
		_primaryStage = new Stage();
		_primaryStage.setScene(scene);
		
		
	}
//	private void erstelleDropDownUndMacheSichtbar() throws SQLException
//	{
//		//Einfügen von Tabellennamen in Choice-Box
//		String query = "SELECT * FROM user_tables";
//		Statement stmt = _connection.createStatement( ) ;
//	    ResultSet rset = stmt.executeQuery(query);
//
//	    while (rset.next()) 
//	    {
//	    	_dropDown.getItems().add(rset.getString(1));
//	    }
//	    
//	   
////	    _tabellenLabel.setFont(Font.font("COMIC SANS MS", FontWeight.BOLD, 16));
////	    _pane.add(_tabellenLabel, 0, 3);
//	    
//		
//		_dropDown.setMinSize(250, 20);
//		_pane.getChildren().add(_dropDown);
//		
//		// Listener DropDownBox
//		_dropDown.valueProperty().addListener(actionEvent -> {
//			_ausgewaehlteTabelle = _dropDown.getValue();
//			try
//			{
////				erstelleTabelleUndBefuelle(_ausgewaehlteTabelle);
//			} 
//			catch (SQLException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//	}
	public void zeigeFenster()
	{
		_primaryStage.showAndWait();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void aendereTable(String[] ueberschriften)
	{
		LinkedList<TableColumn> allColumns = new LinkedList<TableColumn>();
		TableColumn[] tc = new TableColumn[ueberschriften.length];
		for(int i = 0; i < ueberschriften.length; ++i)
		{
			tc[i] = new TableColumn(ueberschriften[i]);
			allColumns.add(tc[i]);
		}
		
		_tw.getColumns().addAll(allColumns);
		
	}
	
}
