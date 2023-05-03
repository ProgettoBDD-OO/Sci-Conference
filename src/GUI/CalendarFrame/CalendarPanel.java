package GUI.CalendarFrame;

import javax.swing.*;

import DAO.ConferenzaDAO;
import DTO.Conferenza;
import GUI.ConferenzaFrame.ConferenzaFrame;
import GUI.MainFrame.MainFrame;
import linker.Controller;
import linker.ControllerLink;
import linker.DBConnection;
import myTools.myTemplates;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.channels.CancelledKeyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class CalendarPanel extends JPanel {
	
	private myTemplates c = new myTemplates();
	
	private ControllerLink controllerLink;
	
	private int Month;
	private int Year;
	
	private ArrayList<CalendarCell> arrayCells;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	
	public CalendarPanel(int month, int year, ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setBackground(c.white);
		setLayout(new GridLayout(7, 7, 0, 0));
		
		Month = month;
		Year = year;
		
		arrayCells = new ArrayList<CalendarCell>();		
		
		CalendarCell LunedìCell = new CalendarCell();
		LunedìCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LunedìCell.setText("Lun");
		LunedìCell.asTitle();
		add(LunedìCell);
		
		CalendarCell MartedìCell = new CalendarCell();
		MartedìCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MartedìCell.setText("Mar");
		MartedìCell.asTitle();
		add(MartedìCell);
		
		CalendarCell MercoledìCell = new CalendarCell();
		MercoledìCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MercoledìCell.setText("Mer");
		MercoledìCell.asTitle();
		add(MercoledìCell);
		
		CalendarCell GiovedìCell = new CalendarCell();
		GiovedìCell.addMouseListener(new MouseAdapter() {
			
		});
		GiovedìCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GiovedìCell.setText("Gio");
		GiovedìCell.asTitle();
		add(GiovedìCell);
		
		CalendarCell VenerdìCell = new CalendarCell();
		VenerdìCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VenerdìCell.setText("Ven");
		VenerdìCell.asTitle();
		add(VenerdìCell);
		
		CalendarCell SabatoCell = new CalendarCell();
		SabatoCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SabatoCell.setText("Sab");
		SabatoCell.asTitle();
		add(SabatoCell);
		
		CalendarCell DomenicaCell = new CalendarCell();
		DomenicaCell.setForeground(c.scBlue);
		DomenicaCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DomenicaCell.setText("Dom");
		DomenicaCell.asTitle();
		add(DomenicaCell );
		
		for (int i = 0; i < 42; i++) {
			
			arrayCells.add(new CalendarCell());
			add(arrayCells.get(i));
		}
		
		setDate(arrayCells);
	}
	
	private void setDate(ArrayList<CalendarCell> arrCells) {
		
		Calendar Calendario = Calendar.getInstance();
		Calendario.set(Year, Month - 1, 1);
		
		int StartDay = Calendario.get(Calendar.DAY_OF_WEEK) - 2;
		
		Calendario.add(Calendar.DATE, - StartDay);
		
		ConferenzaDAO conferenzaDAO = new ConferenzaDAO();
		
		for (CalendarCell c : arrCells) {
			
			c.setText(Calendario.get(Calendar.DATE) + "");
			c.setData(Calendario.getTime());
			c.currentMonth(Calendario.get(Calendar.MONTH) == Month - 1);
			addConferenzaToCell(c, c.getForeground(), conferenzaDAO);

			Calendario.add(Calendar.DATE, 1);			
		}
	}
	
	private void addConferenzaToCell(CalendarCell cell, Color color, ConferenzaDAO confDAO) {
		
		Conferenza conf = confDAO.getConferenzaByDate(dateFormat.format(cell.getData()));
		
		if (conf.getNome() != null) {
			
			cell.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));				
			cell.append("\n" + conf.getNome());
			cell.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					controllerLink.goToConferenza(conf.getId());
				}
				@Override
				public void mouseEntered(MouseEvent e) { cell.setForeground(c.scBlue); }
				@Override
				public void mouseExited(MouseEvent e) { cell.setForeground(color); }
			});
		}
	}
}