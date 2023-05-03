package GUI.MainFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import myTools.JLblButton;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Component;


public class WestPanel extends JPanel{
	
	myTemplates c = new myTemplates();
	
	private CardLayout UserCardLayout;
	private JPanel UserCardPanel;
	
	private JButton LogInBtn;
	private JButton SignUpBtn;
	private JLabel UsernameLbl;
	
	private Calendar DataAttuale = Calendar.getInstance();
	private int MeseAttuale = DataAttuale.get(Calendar.MONTH);;
	
	private Calendar DataMese1 = Calendar.getInstance();
	private Calendar DataMese2 = Calendar.getInstance();
	private Calendar DataMese3 = Calendar.getInstance();
	
	private JPanel ConferenzeMese1;
	private JPanel ConferenzeMese2;
	
	private JLabel ProxConfMese1Lbl;
	private JLabel ProxConfMese2Lbl;
	
	private JLblButton CalendarioBtn;
	private JPanel AfferenzePanel;
	private JLabel lblNewLabel;
	private JLblButton AfferenzeBtn;
	private JPanel DescrizioneLbl;
	private JLabel Desc1;
	private JLabel Desc2;
	private JLabel Desc3;
	
	public WestPanel() {
		
		
		setBackground(c.sxGray);
		setPreferredSize(new Dimension(300, 800));
		setLayout(new BorderLayout(0, 0));
		
		UserCardLayout = new CardLayout(0, 0);
		
		UserCardPanel = new JPanel();
		UserCardPanel.setPreferredSize(new Dimension(10, 75));
		UserCardPanel.setLayout(UserCardLayout);
		add(UserCardPanel, BorderLayout.NORTH);
		
			JPanel UserPanelBeforeAccess = new JPanel();
			UserPanelBeforeAccess.setBackground(c.sxGray);
			UserPanelBeforeAccess.setBorder(new MatteBorder(0, 0, 1, 0, c.altGray));
			UserPanelBeforeAccess.setPreferredSize(new Dimension(10, 60));
			UserPanelBeforeAccess.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			UserCardPanel.add(UserPanelBeforeAccess, "1");
			
				LogInBtn = new JButton("Accedi");
				LogInBtn.setToolTipText("clicca per accedere");
				LogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				LogInBtn.setBackground(c.white);
				LogInBtn.setPreferredSize(new Dimension(135, 37));
				UserPanelBeforeAccess.add(LogInBtn, "cell 0 0,alignx right,aligny center");
				
				SignUpBtn = new JButton("Registrati\r\n");
				SignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				SignUpBtn.setForeground(c.white);
				SignUpBtn.setBackground(c.scBlue);
				SignUpBtn.setPreferredSize(new Dimension(135, 37));
				UserPanelBeforeAccess.add(SignUpBtn, "cell 1 0,alignx left,aligny center");
				
			JPanel UserPanelAfterAccess = new JPanel();
			UserPanelAfterAccess.setBackground(c.sxGray);
			UserPanelAfterAccess.setPreferredSize(new Dimension(10, 60));
			UserCardPanel.add(UserPanelAfterAccess, "2");
			UserPanelAfterAccess.setLayout(new MigLayout("wrap, fill", "[::50px][]", "[]"));
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setBackground(c.gray);
				btnNewButton.setMaximumSize(new Dimension(33, 33));
				btnNewButton.setPreferredSize(new Dimension(33, 33));
				UserPanelAfterAccess.add(btnNewButton, "cell 0 0,alignx center,aligny center");
				
				UsernameLbl = new JLabel("Nome utente loggato");
				UsernameLbl.setBorder(new EmptyBorder(8, 0, 0, 0));
				UsernameLbl.setForeground(c.gray);
				UsernameLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
				UserPanelAfterAccess.add(UsernameLbl, "cell 1 0,alignx left,aligny center");
				
				
			JPanel CalendarPanel = new JPanel();
			CalendarPanel.setBorder(new EmptyBorder(0, 0, 75, 0));
			CalendarPanel.setBackground(c.sxGray);
			add(CalendarPanel, BorderLayout.CENTER);
			CalendarPanel.setLayout(new BorderLayout(0, 0));
			
				MeseAttuale = DataAttuale.get(Calendar.MONTH);
				DataMese1.set(Calendar.MONTH, MeseAttuale);
				DataMese2.set(Calendar.MONTH, MeseAttuale + 1);
				DataMese3.set(Calendar.MONTH, MeseAttuale + 2);
				SimpleDateFormat DFMeseAttuale = new SimpleDateFormat("MMMM");
			
				JLabel ProxConfLbl = new JLabel("Prossime Conferenze");
				CalendarPanel.add(ProxConfLbl, BorderLayout.NORTH);
				ProxConfLbl.setPreferredSize(new Dimension(40, 80));
				ProxConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProxConfLbl.setForeground(c.gray);
				ProxConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 27));
			
				JPanel ProxConfPanel = new JPanel();
				ProxConfPanel.setBackground(c.sxGray);
				CalendarPanel.add(ProxConfPanel, BorderLayout.CENTER);
				ProxConfPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::40px][][::40px][]"));
				
					ProxConfMese1Lbl = new JLabel(DFMeseAttuale.format(DataMese1.getTime()));
					ProxConfMese1Lbl.setForeground(c.gray);
					ProxConfMese1Lbl.setFont(new Font("Calibri Light", Font.PLAIN, 25));
					ProxConfPanel.add(ProxConfMese1Lbl, "cell 0 0,alignx left,aligny bottom");
					
					ConferenzeMese1 = new JPanel();
					ConferenzeMese1.setBackground(c.sxGray);
					ConferenzeMese1.setLayout(new BoxLayout(ConferenzeMese1, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese1, "cell 0 1,grow");
					
					ProxConfMese2Lbl = new JLabel(DFMeseAttuale.format(DataMese2.getTime()));
					ProxConfMese2Lbl.setForeground(c.gray);
					ProxConfMese2Lbl.setFont(new Font("Calibri Light", Font.PLAIN, 25));
					ProxConfPanel.add(ProxConfMese2Lbl, "cell 0 2,alignx left,aligny bottom");
					
					ConferenzeMese2 = new JPanel();
					ConferenzeMese2.setBackground(c.sxGray);
					ConferenzeMese2.setLayout(new BoxLayout(ConferenzeMese2, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese2, "cell 0 3,grow");
					
					
					JPanel CalendarioBtnConteiner = new JPanel();
					CalendarioBtnConteiner.setBackground(c.sxGray);
					CalendarioBtnConteiner.setPreferredSize(new Dimension(10, 50));
					CalendarPanel.add(CalendarioBtnConteiner, BorderLayout.SOUTH);
					CalendarioBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
			
						CalendarioBtn = new JLblButton(c.gray, "Mostra tutto");
						CalendarioBtn.setFont(new Font("Calibri Light", Font.PLAIN, 18));
						CalendarioBtnConteiner.add(CalendarioBtn, "cell 0 0,alignx center, aligny center");
						CalendarioBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								CalendarioBtn.setForeground(c.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								CalendarioBtn.setForeground(c.gray);
							}
						});
						
					AfferenzePanel = new JPanel();
					AfferenzePanel.setBackground(new Color(0, 0, 200));
					AfferenzePanel.setPreferredSize(new Dimension(10, 150));
					AfferenzePanel.setLayout(new BorderLayout(0, 0));
					add(AfferenzePanel, BorderLayout.SOUTH);
						
						AfferenzeBtn = new JLblButton(c.scBlue, "Visualizza percentuali");
						AfferenzeBtn.setBackground(new Color(255, 255, 255));
						AfferenzeBtn.setContentAreaFilled(true);
						AfferenzeBtn.setFont(new Font("Calibri Light", Font.PLAIN, 17));
						AfferenzeBtn.setPreferredSize(new Dimension(133, 40));
						AfferenzePanel.add(AfferenzeBtn, BorderLayout.SOUTH);
						
						lblNewLabel = new JLabel("Riepilogo Afferenze");
						lblNewLabel.setForeground(c.white);
						lblNewLabel.setPreferredSize(new Dimension(46, 45));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 23));
						AfferenzePanel.add(lblNewLabel, BorderLayout.NORTH);
						
						DescrizioneLbl = new JPanel();
						DescrizioneLbl.setBackground(new Color(0, 0, 200));
						AfferenzePanel.add(DescrizioneLbl, BorderLayout.CENTER);
						DescrizioneLbl.setLayout(new BoxLayout(DescrizioneLbl, BoxLayout.Y_AXIS));
						
						Desc1 = new JLabel("Visualizza i riepiloghi annuali e mensili ");
						Desc1.setAlignmentX(Component.CENTER_ALIGNMENT);
						Desc1.setForeground(new Color(255, 255, 255));
						Desc1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
						Desc1.setHorizontalAlignment(SwingConstants.CENTER);
						DescrizioneLbl.add(Desc1);
						
						Desc2 = new JLabel("delle percentuali delle istituzioni di afferenza");
						Desc2.setAlignmentX(Component.CENTER_ALIGNMENT);
						Desc2.setForeground(new Color(255, 255, 255));
						Desc2.setFont(new Font("Calibri Light", Font.PLAIN, 15));
						DescrizioneLbl.add(Desc2);
						
						Desc3 = new JLabel(" dei keynote speaker");
						Desc3.setAlignmentX(Component.CENTER_ALIGNMENT);
						Desc3.setForeground(new Color(255, 255, 255));
						Desc3.setFont(new Font("Calibri Light", Font.PLAIN, 15));
						DescrizioneLbl.add(Desc3);
	}
	
	public CardLayout getUserPanelCardLayout() { return UserCardLayout; } 
	
	public JPanel getUserCardPanel() { return UserCardPanel; } 
	
	public JButton getLogInBtn() { return LogInBtn; }
	
	public JButton getSignUpBtn() { return SignUpBtn; }
	
	public JLabel getUsernameLbl() { return UsernameLbl; }
	
	
	public JPanel getConferenzeMese1() { return ConferenzeMese1; }
	
	public JPanel getConferenzeMese2() { return ConferenzeMese2; }
	
	public JButton getCalendario() { return CalendarioBtn; }
	
	public JButton getAfferenzeBtn() { return AfferenzeBtn; }
}