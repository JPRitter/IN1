package de.hawhh.information.gerken.jdbc;

import java.util.LinkedList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatenbankUI
{
	private Stage _primaryStage;
	private Scene _scene;
	private Pane _pane;
	private Label _label;
	private TableView _tw;
	
	public DatenbankUI(String ueberschrift)
	{
		_label = new Label(ueberschrift);
		_tw = new TableView();
		_tw.setEditable(true);
		_pane = new VBox();
		_pane.getChildren().addAll(_label, _tw);
		 Scene scene = new Scene(_pane, 500, 500);
		_primaryStage = new Stage();
		_primaryStage.setScene(scene);
		
		
	}
	
	public void zeigeFenster()
	{
		_primaryStage.show();
	}
	
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
