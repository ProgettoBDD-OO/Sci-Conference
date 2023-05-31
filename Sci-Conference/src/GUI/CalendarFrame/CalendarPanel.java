package GUI.CalendarFrame;

import linker.Controller;
import myTools.myTemplates;

import java.util.Calendar;
import java.util.ArrayList;

import java.awt.GridLayout;

import javax.swing.JPanel;


public class CalendarPanel extends JPanel {

	private Controller controller;

	private myTemplates t;
	private Calendar DataPannello;

	private ArrayList<CalendarCell> arrayCells;

	public CalendarPanel(int month, int year, Controller c) {

		controller = c;

		t = new myTemplates();
		setBackground(t.white);
		setLayout(new GridLayout(7, 7, 0, 0));

		DataPannello = Calendar.getInstance();
		DataPannello.set(year, month, 1);

		arrayCells = new ArrayList<>();

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

		controller.setDate(arrayCells, DataPannello, month);
	}
}