package GUI.CalendarFrame;

import linker.Controller;
import myTools.myTemplates;

import java.util.ArrayList;
import java.util.Calendar;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.*;


public class CalendarPanel extends JPanel {
	
	private Controller controller;

	private myTemplates t = new myTemplates();
	private Calendar DataPannello;
	
	private ArrayList<CalendarCell> arrayCells;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	
	public CalendarPanel(int month, int year, Controller c) {
		
		controller = c;
		
		setBackground(t.white);
		setLayout(new GridLayout(7, 7, 0, 0));
		
		DataPannello = Calendar.getInstance();
		DataPannello.set(year, month - 1, 1);
		
		arrayCells = new ArrayList<CalendarCell>();		
		
		CalendarCell LunedìCell = new CalendarCell();
		LunedìCell.setText("Lun");
		add(LunedìCell);
		
		CalendarCell MartedìCell = new CalendarCell();
		MartedìCell.setText("Mar");
		add(MartedìCell);
		
		CalendarCell MercoledìCell = new CalendarCell();
		MercoledìCell.setText("Mer");
		add(MercoledìCell);
		
		CalendarCell GiovedìCell = new CalendarCell();
		GiovedìCell.setText("Gio");
		add(GiovedìCell);
		
		CalendarCell VenerdìCell = new CalendarCell();
		VenerdìCell.setText("Ven");
		add(VenerdìCell);
		
		CalendarCell SabatoCell = new CalendarCell();
		SabatoCell.setText("Sab");
		add(SabatoCell);
		
		CalendarCell DomenicaCell = new CalendarCell();
		DomenicaCell.setText("Dom");
		add(DomenicaCell );
		
		for (int i = 0; i < 42; i++) {
			
			arrayCells.add(new CalendarCell());
			add(arrayCells.get(i));
		}
		
		controller.setDate(arrayCells, DataPannello);
	}
}