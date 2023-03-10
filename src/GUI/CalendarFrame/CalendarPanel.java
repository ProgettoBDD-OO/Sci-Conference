package GUI.CalendarFrame;

import javax.swing.*;

import Logica.Connessione;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class CalendarPanel extends JPanel {
	
	private int Month;
	private int Year;
	private Calendar DataConferenza = Calendar.getInstance();
	private Calendar DataCella = Calendar.getInstance();
	
	public CalendarPanel(int Month, int Year) {
		
		Connessione database = new Connessione();
		database.connetti();
		
		setBackground(new Color(255, 255, 255));
		setLayout(new GridLayout(7, 7, 0, 0));
		
		this.Month = Month;
		this.Year = Year;
		
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
		DomenicaCell.setForeground(new Color(0, 0, 200));
		DomenicaCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DomenicaCell.setText("Dom");
		DomenicaCell.asTitle();
		add(DomenicaCell );
		
		CalendarCell Cell1_0 = new CalendarCell();
		add(Cell1_0);
		
		CalendarCell Cell1_1 = new CalendarCell();
		add(Cell1_1);
		
		CalendarCell Cell1_2 = new CalendarCell();
		add(Cell1_2);
		
		CalendarCell Cell1_3 = new CalendarCell();
		add(Cell1_3);
		
		CalendarCell Cell1_4 = new CalendarCell();
		add(Cell1_4);
		
		CalendarCell Cell1_5 = new CalendarCell();
		add(Cell1_5);
		
		CalendarCell Cell1_6 = new CalendarCell();
		add(Cell1_6);
		
		CalendarCell Cell2_0 = new CalendarCell();
		add(Cell2_0);
		
		CalendarCell Cell2_1 = new CalendarCell();
		add(Cell2_1);
		
		CalendarCell Cell2_2 = new CalendarCell();
		add(Cell2_2);
		
		CalendarCell Cell2_3 = new CalendarCell();
		add(Cell2_3);
		
		CalendarCell Cell2_4 = new CalendarCell();
		add(Cell2_4);
		
		CalendarCell Cell2_5 = new CalendarCell();
		add(Cell2_5);
		
		CalendarCell Cell2_6 = new CalendarCell();
		add(Cell2_6);
		
		CalendarCell Cell3_0 = new CalendarCell();
		add(Cell3_0);
		
		CalendarCell Cell3_1 = new CalendarCell();
		Cell3_1.setBackground(new Color(255, 255, 255));
		add(Cell3_1);
		
		CalendarCell Cell3_2 = new CalendarCell();
		add(Cell3_2);
		
		CalendarCell Cell3_3 = new CalendarCell();
		add(Cell3_3);
		
		CalendarCell Cell3_4 = new CalendarCell();
		add(Cell3_4);
		
		CalendarCell Cell3_5 = new CalendarCell();
		add(Cell3_5);
		
		CalendarCell Cell3_6 = new CalendarCell();
		add(Cell3_6);
		
		CalendarCell Cell4_0 = new CalendarCell();
		add(Cell4_0);
		
		CalendarCell Cell4_1 = new CalendarCell();
		add(Cell4_1);
		
		CalendarCell Cell4_2 = new CalendarCell();
		add(Cell4_2);
		
		CalendarCell Cell4_3 = new CalendarCell();
		add(Cell4_3);
		
		CalendarCell Cell4_4 = new CalendarCell();
		add(Cell4_4);
		
		CalendarCell Cell4_5 = new CalendarCell();
		add(Cell4_5);
		
		CalendarCell Cell4_6 = new CalendarCell();
		add(Cell4_6);
		
		CalendarCell Cell5_0 = new CalendarCell();
		add(Cell5_0);
		
		CalendarCell Cell5_1 = new CalendarCell();
		add(Cell5_1);
		
		CalendarCell Cell5_2 = new CalendarCell();
		add(Cell5_2);
		
		CalendarCell Cell5_3 = new CalendarCell();
		add(Cell5_3);
		
		CalendarCell Cell5_4 = new CalendarCell();
		add(Cell5_4);
		
		CalendarCell Cell5_5 = new CalendarCell();
		add(Cell5_5);
		
		CalendarCell Cell5_6 = new CalendarCell();
		add(Cell5_6);
		
		CalendarCell Cell6_0 = new CalendarCell();
		add(Cell6_0);
		
		CalendarCell Cell6_1 = new CalendarCell();
		add(Cell6_1);
		
		CalendarCell Cell6_2 = new CalendarCell();
		add(Cell6_2);
		
		CalendarCell Cell6_3 = new CalendarCell();
		add(Cell6_3);
		
		CalendarCell Cell6_4 = new CalendarCell();
		add(Cell6_4);
		
		CalendarCell Cell6_5 = new CalendarCell();
		add(Cell6_5);
		
		CalendarCell Cell6_6 = new CalendarCell();
		add(Cell6_6);
		
		setDate(database.getConnection());
	}
	
	private void setDate(Connection con) {
		
    String select = "SELECT primasecondospazio(nome), doposecondospazio(nome), datainizio FROM conferenza_scientifica;";
		
		Calendar Calendario = Calendar.getInstance();
		Calendario.set(Calendar.YEAR, Year);
		Calendario.set(Calendar.MONTH, Month - 1);
		Calendario.set(Calendar.DATE, 1);
		int StartDay = Calendario.get(Calendar.DAY_OF_WEEK) - 2;
		Calendario.add(Calendar.DATE, - StartDay);
		
		PreparedStatement statement;
		
		try {
			
			statement = con.prepareStatement(select);
			
			for(Component com: getComponents()) {
				
				CalendarCell Cell = (CalendarCell) com;
				
				if (!Cell.isTitle()) {
						
						Cell.setText(Calendario.get(Calendar.DATE) + "");
						Cell.setDate(Calendario.getTime());
						DataCella.setTime(Cell.getData());
						Cell.currentMonth(Calendario.get(Calendar.MONTH) == Month - 1);
						Calendario.add(Calendar.DATE, 1);
						
						ResultSet rs = statement.executeQuery();
						
						while (rs.next()) {
							DataConferenza.setTime(rs.getDate(3));
							if(DataCella.get(Calendar.DATE) == DataConferenza.get(Calendar.DATE) && DataCella.get(Calendar.MONTH) == DataConferenza.get(Calendar.MONTH) && DataCella.get(Calendar.YEAR) == DataConferenza.get(Calendar.YEAR)) {
								Cell.setFont(new Font("Tahoma", Font.PLAIN, 12));
								Cell.setText((Calendario.get(Calendar.DATE) - 1) + "\n" + rs.getString(1) + "\n" + rs.getString(2));
								Cell.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							}
						}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 }

