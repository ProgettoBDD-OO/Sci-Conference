package GUI.CalendarFrame;

import linker.Controller;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.myTemplates;

import java.util.Calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class CalendarCustom extends JPanel {

	private Controller controller;

	private myTemplates t;

	private Calendar DataAttuale = Calendar.getInstance();
	private int Month = DataAttuale.get(Calendar.MONTH);
	private int Year = DataAttuale.get(Calendar.YEAR);

	private PanelSlide MainPanelSlide;
	private JLabel MonthYearLbl;
	private JLblButton MeseScorsoBtn;
	private JLblButton MeseProxBtn;

	public CalendarCustom(Controller c) {

		controller = c;

		t = new myTemplates();
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
                @Override
				public void actionPerformed(ActionEvent e) {

                    if(Month == 0) { Month = 12; Year --; }

                    else { Month --; }

                    MainPanelSlide.show(new CalendarPanel(Month, Year, controller), PanelSlide.AnimateType.TO_RIGHT);
                    showMonthYear();
                }
            });

            MeseProxBtn.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
                    if(Month == 11) { Month = 0; Year ++; }

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
		Calendario.set(Year, Month, 1);
		MonthYearLbl.setText(t.toMonthYearFormat(Calendario.getTime()));
	}
}