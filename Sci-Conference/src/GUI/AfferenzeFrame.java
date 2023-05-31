package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import linker.Controller;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.PanelSlide.AnimateType;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class AfferenzeFrame extends JFrame {

	private Controller controller;

	private myTemplates t;

	private PanelSlide AfferenzeYearSlider;
	private PanelSlide AfferenzeMonthSlider;
	private JButton AnnullaBachecaBtn;

	private Calendar DataAttuale;
	private Calendar Mese;
	private Integer Month;
	private Integer Year;
	private JLabel MonthLbl;
	private JLblButton NextMonthBtn;
	private JLblButton PrevMonthBtn;
	private JLblButton PrevYearBtn;
	private JLblButton NextYearBtn;

	public AfferenzeFrame(Controller c) {

		controller = c;
		t = new myTemplates();

		DataAttuale = Calendar.getInstance();
		Mese = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("MMMM");
		
		Mese.set(Calendar.MONTH, DataAttuale.get(Calendar.MONTH) - 1);
		Month = Mese.get(Calendar.MONTH);
		Year = DataAttuale.get(Calendar.YEAR);
		
		setTitle("Sci-Conference - Afferenze Keynote");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(850, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(t.miniLogo);
		setVisible(false);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);


			JLabel AfferenzeLbl = new JLabel("Percentuali Istituzioni di Afferenza dei Keynote Speaker");
			AfferenzeLbl.setFont(t.myFont(20));
			AfferenzeLbl.setPreferredSize(new Dimension(230, 65));
			AfferenzeLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(AfferenzeLbl, BorderLayout.NORTH);

			JPanel CntrPanel = new JPanel();
			CntrPanel.setBackground(t.white);
			CntrPanel.setLayout(new BoxLayout(CntrPanel, BoxLayout.Y_AXIS));
			MainPanel.add(CntrPanel, BorderLayout.CENTER);


				JPanel YearPanel = new JPanel();
				YearPanel.setBorder(new EmptyBorder(17, 0, 17, 0));
				YearPanel.setBackground(t.white);
				CntrPanel.add(YearPanel);
				YearPanel.setLayout(new BorderLayout(0, 0));

					JLabel YearLbl = new JLabel(Year.toString());
					YearLbl.setForeground(t.scBlue);
					YearLbl.setFont(t.myFont(16));
					YearLbl.setHorizontalAlignment(SwingConstants.CENTER);
					YearPanel.add(YearLbl, BorderLayout.NORTH);

					AfferenzeYearSlider = new PanelSlide();
					AfferenzeMonthSlider = new PanelSlide();
					YearPanel.add(AfferenzeYearSlider, BorderLayout.CENTER);
					AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_RIGHT);

					PrevYearBtn = new JLblButton(t.scBlue, "Precedente");
					PrevYearBtn.setFont(t.myFont(13));
					PrevYearBtn.setPreferredSize(new Dimension(80, 10));
					YearPanel.add(PrevYearBtn, BorderLayout.WEST);
					PrevYearBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							Year--;
							Month = 11;
							Mese.set(Calendar.MONTH, Month);
							YearLbl.setText(Year.toString());
							MonthLbl.setText(s.format(Mese.getTime()));
							NextYearBtn.setEnabled(true);
							NextMonthBtn.setEnabled(true);
							AfferenzeMonthSlider.show(new AfferenzePanel(controller, Month, Year), AnimateType.TO_RIGHT);
							AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_RIGHT);
						}
					});

					NextYearBtn = new JLblButton(t.scBlue, "Successivo");
					NextYearBtn.setEnabled(false);
					NextYearBtn.setFont(t.myFont(13));
					NextYearBtn.setPreferredSize(new Dimension(80, 10));
					YearPanel.add(NextYearBtn, BorderLayout.EAST);
					NextYearBtn.addActionListener(new ActionListener() {
						@Override
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
				MonthPanel.setPreferredSize(new Dimension(10, 230));
				MonthPanel.setMaximumSize(new Dimension(730, 32767));
				MonthPanel.setBackground(t.white);
				MonthPanel.setLayout(new BorderLayout(0, 0));
				CntrPanel.add(MonthPanel);

					MonthLbl = new JLabel(s.format(Mese.getTime()));
					MonthLbl.setForeground(t.scBlue);
					MonthLbl.setFont(t.myFont(15));
					MonthLbl.setHorizontalAlignment(SwingConstants.CENTER);
					MonthPanel.add(MonthLbl, BorderLayout.NORTH);

					MonthPanel.add(AfferenzeMonthSlider, BorderLayout.CENTER);
					AfferenzeMonthSlider.show(new AfferenzePanel(controller, Month, Year), AnimateType.TO_LEFT);
					PrevMonthBtn = new JLblButton(t.scBlue, "Precedente");
					PrevMonthBtn.setFont(t.myFont(12));
					PrevMonthBtn.setPreferredSize(new Dimension(65, 10));
					MonthPanel.add(PrevMonthBtn, BorderLayout.WEST);
					PrevMonthBtn.addActionListener(new ActionListener() {
						@Override
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
					NextMonthBtn.setFont(t.myFont(12));
					NextMonthBtn.setPreferredSize(new Dimension(65, 10));
					MonthPanel.add(NextMonthBtn, BorderLayout.EAST);
					NextMonthBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(Month == 11) {
		                        Month = 0;
		                        Year ++;
		                        if (Year == DataAttuale.get(Calendar.YEAR)) { NextYearBtn.setEnabled(false); }
		                        YearLbl.setText(Year.toString());
		                        AfferenzeYearSlider.show(new AfferenzePanel(controller, -1, Year), AnimateType.TO_LEFT);
		                    
							} else { Month ++; }
							
							if (Month == DataAttuale.get(Calendar.MONTH) - 1 && Year == DataAttuale.get(Calendar.YEAR)) { 
								NextMonthBtn.setEnabled(false); 
							}
							Mese.set(Calendar.MONTH, Month);
							MonthLbl.setText(s.format(Mese.getTime()));
							AfferenzeMonthSlider.show(new AfferenzePanel(controller, Mese.get(Calendar.MONTH), Year), AnimateType.TO_LEFT);
						}
					});


				JPanel SouthPanel = new JPanel();
				SouthPanel.setBackground(t.lGray);
				SouthPanel.setPreferredSize(new Dimension(10, 65));
				SouthPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);

					AnnullaBachecaBtn = new JButton("Annulla");
					AnnullaBachecaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					AnnullaBachecaBtn.setPreferredSize(new Dimension(130, 30));
					SouthPanel.add(AnnullaBachecaBtn, "cell 0 0,alignx left,aligny bottom");
					AnnullaBachecaBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							controller.backFromAfferenze();
						}
					});
	}
}