package GUI.CalendarFrame;

import linker.Controller;
import myTools.myTemplates;
import myTools.JLblButton;
import myTools.PanelSlide;

import java.util.Calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class CalendarCustom extends JPanel {
	
	private myTemplates t = new myTemplates();
	
	private Controller controller;
	
	private Calendar DataAttuale = Calendar.getInstance();
	private int Month = DataAttuale.get(Calendar.MONTH);
	private int Year = DataAttuale.get(Calendar.YEAR);
	
	private PanelSlide MainPanelSlide;
	private JLabel MonthYearLbl;
	private JLblButton MeseScorsoBtn;
	private JLblButton MeseProxBtn;
	
	public CalendarCustom(Controller c) {
		
		controller = c;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(t.white);
		NorthPanel.setPreferredSize(new Dimension(10, 150));
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[][][]", "[]"));
		add(NorthPanel, BorderLayout.NORTH);
		
			MeseScorsoBtn = new JLblButton(t.tangaroa, "Mese precedente");
	        MeseScorsoBtn.setFont(t.myFont(18));
			NorthPanel.add(MeseScorsoBtn, "cell 0 0,alignx left,aligny center");
			
			MonthYearLbl = new JLabel("Mese - Anno");
			MonthYearLbl.setForeground(t.scBlue);
			MonthYearLbl.setFont(t.myFont(28));
			NorthPanel.add(MonthYearLbl, "cell 1 0,alignx center,aligny center");
			
			MeseProxBtn = new JLblButton(t.tangaroa, "Mese successivo");
	        MeseProxBtn.setFont(t.myFont(18));
			NorthPanel.add(MeseProxBtn, "cell 2 0,alignx right,aligny center");

            MeseScorsoBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                    if(Month == 1) { Month = 12; Year --; }
                    
                    else { Month --; }
                    
                    MainPanelSlide.show(new CalendarPanel(Month, Year, controller), PanelSlide.AnimateType.TO_RIGHT);
                    showMonthYear();
                }
            });

            MeseProxBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(Month == 12) { Month = 1; Year ++; }
                    
                    else { Month ++; }
                    
                    MainPanelSlide.show(new CalendarPanel(Month, Year, controller), PanelSlide.AnimateType.TO_LEFT);
                    showMonthYear();
                }
            });
            
		MainPanelSlide = new PanelSlide();
		MainPanelSlide.setBackground(new Color(255, 255, 255));
		MainPanelSlide.show(new CalendarPanel(Month, Year, controller), PanelSlide.AnimateType.TO_RIGHT);
		add(MainPanelSlide, BorderLayout.CENTER);
		
		showMonthYear();
	}
	
	
	private void showMonthYear() {
		
		Calendar Calendario = Calendar.getInstance();
		Calendario.set(Year, Month - 1, 1);
		MonthYearLbl.setText(t.toMonthYearFormat(Calendario.getTime()));
	}
}