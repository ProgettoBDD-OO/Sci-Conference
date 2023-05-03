package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import myTools.PanelSlide;
import myTools.PanelSlide.AnimateType;
import net.miginfocom.swing.MigLayout;
import myTools.myTemplates;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.SizeLimitExceededException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import linker.Controller;
import linker.ControllerLink;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import myTools.JLblButton;

public class AfferenzeFrame extends JFrame {
	
	private ControllerLink controllerLink;
	private Controller controller;
	
	myTemplates t = new myTemplates();
	private PanelSlide AfferenzeYearSlider;
	private PanelSlide AfferenzeMonthSlider;
	private JButton AnnullaBachecaBtn;
	
	Calendar DataAttuale = Calendar.getInstance();
	Calendar Mese = Calendar.getInstance();
	SimpleDateFormat s = new SimpleDateFormat("MMMM");
	Integer Month = 3;
	Integer Year = 2023;
	private JLabel MonthLbl;
	private JLblButton NextMonthBtn;
	private JLblButton PrevMonthBtn;
	private JLblButton PrevYearBtn;
	private JLblButton NextYearBtn;
	
	public AfferenzeFrame(String Titolo, ControllerLink contrLink, Controller contr) {
		
		controllerLink = contrLink;
		controller = contr;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 850);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(t.MiniLogo);
		setVisible(false);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
		
			JLabel AfferenzeLbl = new JLabel("Percentuali Istituzioni di Afferenza dei Keynote Speaker");
			AfferenzeLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
			AfferenzeLbl.setPreferredSize(new Dimension(270, 75));
			AfferenzeLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(AfferenzeLbl, BorderLayout.NORTH);
			
			JPanel CntrPanel = new JPanel();
			CntrPanel.setBackground(new Color(255, 255, 255));
			CntrPanel.setLayout(new BoxLayout(CntrPanel, BoxLayout.Y_AXIS));
			MainPanel.add(CntrPanel, BorderLayout.CENTER);
			
			
				JPanel YearPanel = new JPanel();
				YearPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
				YearPanel.setBackground(new Color(255, 255, 255));
				CntrPanel.add(YearPanel);
				YearPanel.setLayout(new BorderLayout(0, 0));
				
					JLabel YearLbl = new JLabel(Year.toString());
					YearLbl.setForeground(new Color(0, 0, 200));
					YearLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
					YearLbl.setHorizontalAlignment(SwingConstants.CENTER);
					YearPanel.add(YearLbl, BorderLayout.NORTH);
					
					AfferenzeYearSlider = new PanelSlide();
					AfferenzeMonthSlider = new PanelSlide();
					YearPanel.add(AfferenzeYearSlider, BorderLayout.CENTER);
					AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_RIGHT);
					
					PrevYearBtn = new JLblButton(t.scBlue, "Precedente");
					PrevYearBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					PrevYearBtn.setPreferredSize(new Dimension(95, 10));
					YearPanel.add(PrevYearBtn, BorderLayout.WEST);
					PrevYearBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							Year--;
							Month = 0;
							Mese.set(Calendar.MONTH, Month);
							YearLbl.setText(Year.toString());
							MonthLbl.setText(s.format(Mese.getTime()));
							AfferenzeMonthSlider.show(new AfferenzePanel(controller, Month, Year), AnimateType.TO_RIGHT);
							AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_RIGHT);
						}
					});
					
					NextYearBtn = new JLblButton(t.scBlue, "Successivo");
					NextYearBtn.setEnabled(false);
					NextYearBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					NextYearBtn.setPreferredSize(new Dimension(95, 10));
					YearPanel.add(NextYearBtn, BorderLayout.EAST);
					NextYearBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
								Year ++;
								if (Year == DataAttuale.get(Calendar.YEAR)) { NextYearBtn.setEnabled(false); }
								Month = 0;
								Mese.set(Calendar.MONTH, Month);
								YearLbl.setText(Year.toString());
								MonthLbl.setText(s.format(Mese.getTime()));
								AfferenzeMonthSlider.show(new AfferenzePanel(controller, Month, Year), AnimateType.TO_LEFT);
								AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_LEFT);
						}
					});
				
				JPanel MonthPanel = new JPanel();
				MonthPanel.setPreferredSize(new Dimension(10, 275));
				MonthPanel.setMaximumSize(new Dimension(775, 32767));
				MonthPanel.setBackground(new Color(255, 255, 255));
				MonthPanel.setLayout(new BorderLayout(0, 0));
				CntrPanel.add(MonthPanel);
				
					MonthLbl = new JLabel(s.format(Mese.getTime()));
					MonthLbl.setForeground(new Color(0, 0, 200));
					MonthLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					MonthLbl.setHorizontalAlignment(SwingConstants.CENTER);
					MonthPanel.add(MonthLbl, BorderLayout.NORTH);
				
					MonthPanel.add(AfferenzeMonthSlider, BorderLayout.CENTER);
					AfferenzeMonthSlider.show(new AfferenzePanel(controller, Month, Year), AnimateType.TO_LEFT);
					PrevMonthBtn = new JLblButton(t.scBlue, "Precedente");
					PrevMonthBtn.setFont(new Font("Calibri Light", Font.PLAIN, 14));
					PrevMonthBtn.setPreferredSize(new Dimension(75, 10));
					MonthPanel.add(PrevMonthBtn, BorderLayout.WEST);
					PrevMonthBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(Month == 0) {
		                        Month = 11;
		                        Year --;
		                        NextYearBtn.setEnabled(true);
		                        NextMonthBtn.setEnabled(true);
		                        YearLbl.setText(Year.toString());
		                        AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_RIGHT);
		                    } else {
		                        Month --;
		                        NextMonthBtn.setEnabled(true);
		                    }
							Mese.set(Calendar.MONTH, Month);
							MonthLbl.setText(s.format(Mese.getTime()));
							AfferenzeMonthSlider.show(new AfferenzePanel(controller, Month, Year), AnimateType.TO_RIGHT);
						}
					});
					
					NextMonthBtn = new JLblButton(t.scBlue, "Successivo");
					NextMonthBtn.setEnabled(false);
					NextMonthBtn.setFont(new Font("Calibri Light", Font.PLAIN, 14));
					NextMonthBtn.setPreferredSize(new Dimension(75, 10));
					MonthPanel.add(NextMonthBtn, BorderLayout.EAST);
					NextMonthBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(Month == 11) {
		                        Month = 0;
		                        Year ++;
		                        if (Year == DataAttuale.get(Calendar.YEAR)) { NextYearBtn.setEnabled(false); }
		                        YearLbl.setText(Year.toString());
		                        AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_LEFT);
		                    } else {
		                        Month ++;
		                    }
							if (Month == DataAttuale.get(Calendar.MONTH)) { NextMonthBtn.setEnabled(false); }
							Mese.set(Calendar.MONTH, Month);
							MonthLbl.setText(s.format(Mese.getTime()));
							AfferenzeMonthSlider.show(new AfferenzePanel(controller, Mese.get(Calendar.MONTH), Year), AnimateType.TO_LEFT);
						}
					});
					
					
				JPanel SouthPanel = new JPanel();
				SouthPanel.setBackground(t.lGray);
				SouthPanel.setPreferredSize(new Dimension(10, 75));
				SouthPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);
					
					AnnullaBachecaBtn = new JButton("Annulla");
					AnnullaBachecaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					AnnullaBachecaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					AnnullaBachecaBtn.setPreferredSize(new Dimension(150, 35));
					SouthPanel.add(AnnullaBachecaBtn, "cell 0 0,alignx left,aligny bottom");
					AnnullaBachecaBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controllerLink.backFromAfferenze();
						}
					});
	}
}