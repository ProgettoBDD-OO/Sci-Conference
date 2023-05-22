package GUI.MainFrame;


import myTools.JLblButton;
import myTools.myTemplates;

import java.util.Calendar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class WestPanel extends JPanel{
	
	myTemplates t = new myTemplates();
	
	private CardLayout UserCardLayout;
	private JPanel UserCardPanel;
	
	private JButton LogInBtn;
	private JButton SignUpBtn;
	private JLabel UsernameLbl;
	
	private Calendar DataAttuale = Calendar.getInstance();
	private int MeseAttuale = DataAttuale.get(Calendar.MONTH);;
	
	private Calendar DataMese1 = Calendar.getInstance();
	private Calendar DataMese2 = Calendar.getInstance();
	
	private JPanel ConferenzeMese1;
	private JPanel ConferenzeMese2;
	
	private JLabel ConfMese1Lbl;
	private JLabel ConfMese2Lbl;
	
	private JLblButton CalendarioBtn;
	private JPanel AfferenzePanel;
	private JLabel AfferenzeLbl;
	private JLblButton AfferenzeBtn;
	private JPanel DescrizioneLbl;
	private JLabel Desc1;
	private JLabel Desc2;
	private JLabel Desc3;
	
	public WestPanel() {
		

		setBackground(t.sxGray);
		setPreferredSize(new Dimension(300, 800));
		setLayout(new BorderLayout(0, 0));
		
		UserCardLayout = new CardLayout(0, 0);
		
		UserCardPanel = new JPanel();
		UserCardPanel.setPreferredSize(new Dimension(10, 75));
		UserCardPanel.setLayout(UserCardLayout);
		add(UserCardPanel, BorderLayout.NORTH);
		
			JPanel UserPanelBeforeAccess = new JPanel();
			UserPanelBeforeAccess.setBackground(t.sxGray);
			UserPanelBeforeAccess.setBorder(new MatteBorder(0, 0, 1, 0, t.altGray));
			UserPanelBeforeAccess.setPreferredSize(new Dimension(10, 60));
			UserPanelBeforeAccess.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			UserCardPanel.add(UserPanelBeforeAccess, "BeforeAccess");
			
				LogInBtn = new JButton("Accedi");
				LogInBtn.setToolTipText("clicca per accedere");
				LogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				LogInBtn.setBackground(t.white);
				LogInBtn.setPreferredSize(new Dimension(135, 37));
				UserPanelBeforeAccess.add(LogInBtn, "cell 0 0,alignx right,aligny center");
				
				SignUpBtn = new JButton("Registrati");
				SignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				SignUpBtn.setForeground(t.white);
				SignUpBtn.setBackground(t.scBlue);
				SignUpBtn.setPreferredSize(new Dimension(135, 37));
				UserPanelBeforeAccess.add(SignUpBtn, "cell 1 0,alignx left,aligny center");
				
			JPanel UserPanelAfterAccess = new JPanel();
			UserPanelAfterAccess.setBackground(t.sxGray);
			UserPanelAfterAccess.setPreferredSize(new Dimension(10, 60));
			UserCardPanel.add(UserPanelAfterAccess, "AfterAccess");
				UserPanelAfterAccess.setLayout(new BorderLayout(0, 0));
				
				UsernameLbl = new JLabel("Nome utente loggato");
				UsernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
				UsernameLbl.setBorder(new EmptyBorder(8, 0, 0, 0));
				UsernameLbl.setForeground(t.gray);
				UsernameLbl.setFont(t.myFont(24));
				UserPanelAfterAccess.add(UsernameLbl);
				
				
			JPanel CalendarPanel = new JPanel();
			CalendarPanel.setBorder(new EmptyBorder(0, 0, 75, 0));
			CalendarPanel.setBackground(t.sxGray);
			add(CalendarPanel, BorderLayout.CENTER);
			CalendarPanel.setLayout(new BorderLayout(0, 0));
			
				MeseAttuale = DataAttuale.get(Calendar.MONTH);
				DataMese1.set(Calendar.MONTH, MeseAttuale);
				DataMese2.set(Calendar.MONTH, MeseAttuale + 1);
				SimpleDateFormat DfMeseAttuale = new SimpleDateFormat("MMMM");
			
				JLabel ProxConfLbl = new JLabel("Prossime Conferenze");
				CalendarPanel.add(ProxConfLbl, BorderLayout.NORTH);
				ProxConfLbl.setPreferredSize(new Dimension(40, 80));
				ProxConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProxConfLbl.setForeground(t.gray);
				ProxConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 27));
			
				JPanel ProxConfPanel = new JPanel();
				ProxConfPanel.setBackground(t.sxGray);
				CalendarPanel.add(ProxConfPanel, BorderLayout.CENTER);
				ProxConfPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::40px][][::40px][]"));
				
					ConfMese1Lbl = new JLabel(DfMeseAttuale.format(DataMese1.getTime()));
					ConfMese1Lbl.setForeground(t.gray);
					ConfMese1Lbl.setFont(t.myFont(25));
					ProxConfPanel.add(ConfMese1Lbl, "cell 0 0,alignx left,aligny bottom");
					
					ConferenzeMese1 = new JPanel();
					ConferenzeMese1.setBackground(t.sxGray);
					ConferenzeMese1.setLayout(new BoxLayout(ConferenzeMese1, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese1, "cell 0 1,grow");
					
					ConfMese2Lbl = new JLabel(DfMeseAttuale.format(DataMese2.getTime()));
					ConfMese2Lbl.setForeground(t.gray);
					ConfMese2Lbl.setFont(t.myFont(25));
					ProxConfPanel.add(ConfMese2Lbl, "cell 0 2,alignx left,aligny bottom");
					
					ConferenzeMese2 = new JPanel();
					ConferenzeMese2.setBackground(t.sxGray);
					ConferenzeMese2.setLayout(new BoxLayout(ConferenzeMese2, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese2, "cell 0 3,grow");
					
					
					JPanel CalendarioBtnConteiner = new JPanel();
					CalendarioBtnConteiner.setBackground(t.sxGray);
					CalendarioBtnConteiner.setPreferredSize(new Dimension(10, 50));
					CalendarPanel.add(CalendarioBtnConteiner, BorderLayout.SOUTH);
					CalendarioBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
			
						CalendarioBtn = new JLblButton(t.gray, "Mostra tutto");
						CalendarioBtn.setFont(t.myFont(18));
						CalendarioBtnConteiner.add(CalendarioBtn, "cell 0 0,alignx center, aligny center");
						CalendarioBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								CalendarioBtn.setForeground(t.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								CalendarioBtn.setForeground(t.gray);
							}
						});
						
					AfferenzePanel = new JPanel();
					AfferenzePanel.setBackground(new Color(0, 0, 200));
					AfferenzePanel.setPreferredSize(new Dimension(10, 150));
					AfferenzePanel.setLayout(new BorderLayout(0, 0));
					add(AfferenzePanel, BorderLayout.SOUTH);
						
						AfferenzeBtn = new JLblButton(t.scBlue, "Visualizza percentuali");
						AfferenzeBtn.setBackground(new Color(255, 255, 255));
						AfferenzeBtn.setContentAreaFilled(true);
						AfferenzeBtn.setFont(t.myFont(17));
						AfferenzeBtn.setPreferredSize(new Dimension(133, 40));
						AfferenzePanel.add(AfferenzeBtn, BorderLayout.SOUTH);
						
						AfferenzeLbl = new JLabel("Riepilogo Afferenze");
						AfferenzeLbl.setForeground(t.white);
						AfferenzeLbl.setPreferredSize(new Dimension(46, 45));
						AfferenzeLbl.setHorizontalAlignment(SwingConstants.CENTER);
						AfferenzeLbl.setFont(t.myFont(23));
						AfferenzePanel.add(AfferenzeLbl, BorderLayout.NORTH);
						
						DescrizioneLbl = new JPanel();
						DescrizioneLbl.setBackground(new Color(0, 0, 200));
						AfferenzePanel.add(DescrizioneLbl, BorderLayout.CENTER);
						DescrizioneLbl.setLayout(new BoxLayout(DescrizioneLbl, BoxLayout.Y_AXIS));
						
						Desc1 = new JLabel("Visualizza i riepiloghi annuali e mensili");
						Desc1.setAlignmentX(Component.CENTER_ALIGNMENT);
						Desc1.setForeground(t.white);
						Desc1.setFont(t.myFont(15));
						Desc1.setHorizontalAlignment(SwingConstants.CENTER);
						DescrizioneLbl.add(Desc1);
						
						Desc2 = new JLabel("delle percentuali delle istituzioni di afferenza");
						Desc2.setAlignmentX(Component.CENTER_ALIGNMENT);
						Desc2.setForeground(t.white);
						Desc2.setFont(t.myFont(15));
						DescrizioneLbl.add(Desc2);
						
						Desc3 = new JLabel("dei keynote speaker");
						Desc3.setAlignmentX(Component.CENTER_ALIGNMENT);
						Desc3.setForeground(t.white);
						Desc3.setFont(t.myFont(15));
						DescrizioneLbl.add(Desc3);
	}
	
	public void showAfterAccessLayer(String username) { 

		UsernameLbl.setText(username);
		UserCardLayout.show(UserCardPanel, "AfterAccess"); 
	}
	
	public JButton getLogInBtn() { return LogInBtn; }
	
	public JButton getSignUpBtn() { return SignUpBtn; }
	
	public JPanel getConferenzeMese1() { return ConferenzeMese1; }
	
	public JPanel getConferenzeMese2() { return ConferenzeMese2; }
	
	public JButton getCalendario() { return CalendarioBtn; }
	
	public JButton getAfferenzeBtn() { return AfferenzeBtn; }
}