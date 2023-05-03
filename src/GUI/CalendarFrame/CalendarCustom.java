package GUI.CalendarFrame;

import javax.swing.*;

import linker.ControllerLink;
import myTools.PanelSlide;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import myTools.JLblButton;

public class CalendarCustom extends JPanel {
	
	private ControllerLink controllerLink;
	
	private int Year;
	private int Month;
	private PanelSlide MainPanelSlide;
	private JLabel MonthYearLbl;
	private JLblButton MeseScorsoBtn;
	private JLblButton MeseProxBtn;
	
	public CalendarCustom(ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setLayout(new BorderLayout(0, 0));
		thisMonth();
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(new Color(255, 255, 255));
		NorthPanel.setPreferredSize(new Dimension(10, 150));
		add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[][][]", "[]"));
		
			MeseScorsoBtn = new JLblButton(new Color(20, 40, 60), "Mese precedente");
	        MeseScorsoBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
			NorthPanel.add(MeseScorsoBtn, "cell 0 0,alignx left,aligny center");
			
			MonthYearLbl = new JLabel("Mese - Anno");
			MonthYearLbl.setForeground(new Color(0, 0, 200));
			MonthYearLbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
			NorthPanel.add(MonthYearLbl, "cell 1 0,alignx center,aligny center");
			
			MeseProxBtn = new JLblButton(new Color(20, 40, 60), "Mese successivo");
	        MeseProxBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
			NorthPanel.add(MeseProxBtn, "cell 2 0,alignx right,aligny center");
			
			MeseScorsoBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    MeseScorsoBtn.setForeground(new Color(0, 0, 200));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    MeseScorsoBtn.setForeground(new Color(20, 30, 40));
                }
            });

            MeseScorsoBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(Month == 1) {
                        Month = 12;
                        Year --;
                    } else {
                        Month --;
                    }
                    MainPanelSlide.show(new CalendarPanel(Month, Year, controllerLink), PanelSlide.AnimateType.TO_RIGHT);
                    showMonthYear();
                }
            });
		
            
            MeseProxBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    MeseProxBtn.setForeground(new Color(0, 0, 200));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    MeseProxBtn.setForeground(new Color(20, 30, 40));
                }
            });

            MeseProxBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(Month == 12) {
                        Month = 1;
                        Year ++;
                    } else {
                        Month ++;
                    }
                    MainPanelSlide.show(new CalendarPanel(Month, Year, controllerLink), PanelSlide.AnimateType.TO_LEFT);
                    showMonthYear();
                }
            });
            
		MainPanelSlide = new PanelSlide();
		MainPanelSlide.setBackground(new Color(255, 255, 255));
		MainPanelSlide.show(new CalendarPanel(Month, Year, controllerLink), PanelSlide.AnimateType.TO_RIGHT);
		add(MainPanelSlide, BorderLayout.CENTER);
		showMonthYear();
	}
	
	
	private void thisMonth(){
		
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(new Date());
		Month = Calendario.get(Calendar.MONTH) + 1;
		Year = Calendario.get(Calendar.YEAR);
	}
	
	private void showMonthYear(){
		Calendar Calendario = Calendar.getInstance();
		Calendario.set(Calendar.MONTH, Month - 1);
		Calendario.set(Calendar.YEAR, Year);
		Calendario.set(Calendar.DATE, 1);
		SimpleDateFormat FormatoData = new SimpleDateFormat("MMMM - yyyy");
		MonthYearLbl.setText(FormatoData.format(Calendario.getTime()));
	}
}