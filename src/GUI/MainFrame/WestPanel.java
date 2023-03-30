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
	private JPanel ConferenzeMese3;
	private ArrayList<JLblButton> arrayLblButtons;
	
	private JLabel ProxConfMese1Lbl;
	private JLabel ProxConfMese2Lbl;
	private JLabel ProxConfMese3Lbl;
	
	private JLblButton CalendarioBtn;
	
	public WestPanel() {
		
		
		setBackground(c.sxGray);
		setPreferredSize(new Dimension(300, 800));
		setLayout(new BorderLayout(0, 0));
		

		arrayLblButtons = new ArrayList<JLblButton>();
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
				CalendarPanel.add(ProxConfPanel, BorderLayout.CENTER);
				ProxConfPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::40px][][::40px][][::40px][]"));
				
					ProxConfMese1Lbl = new JLabel(DFMeseAttuale.format(DataMese1.getTime()));
					ProxConfMese1Lbl.setForeground(c.gray);
					ProxConfMese1Lbl.setFont(new Font("Calibri Light", Font.PLAIN, 25));
					ProxConfPanel.add(ProxConfMese1Lbl, "cell 0 0,alignx left,aligny bottom");
					
					ConferenzeMese1 = new JPanel();
					ConferenzeMese1.setLayout(new BoxLayout(ConferenzeMese1, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese1, "cell 0 1,grow");
					
					ProxConfMese2Lbl = new JLabel(DFMeseAttuale.format(DataMese2.getTime()));
					ProxConfMese2Lbl.setForeground(c.gray);
					ProxConfMese2Lbl.setFont(new Font("Calibri Light", Font.PLAIN, 25));
					ProxConfPanel.add(ProxConfMese2Lbl, "cell 0 2,alignx left,aligny bottom");
					
					ConferenzeMese2 = new JPanel();
					ConferenzeMese2.setLayout(new BoxLayout(ConferenzeMese2, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese2, "cell 0 3,grow");
					
					ProxConfMese3Lbl = new JLabel(DFMeseAttuale.format(DataMese3.getTime()));
					ProxConfMese3Lbl.setForeground(c.gray);
					ProxConfMese3Lbl.setFont(new Font("Calibri Light", Font.PLAIN, 25));
					ProxConfPanel.add(ProxConfMese3Lbl, "cell 0 4,alignx left,aligny bottom");
					
					ConferenzeMese3 = new JPanel();
					ConferenzeMese3.setLayout(new BoxLayout(ConferenzeMese3, BoxLayout.Y_AXIS));
					ProxConfPanel.add(ConferenzeMese3, "cell 0 5,grow");
					
					
					JPanel CalendarioBtnConteiner = new JPanel();
					CalendarioBtnConteiner.setPreferredSize(new Dimension(10, 100));
					add(CalendarioBtnConteiner, BorderLayout.SOUTH);
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
	}
	
	public CardLayout getUserPanelCardLayout() { return UserCardLayout; } 
	
	public JPanel getUserCardPanel() { return UserCardPanel; } 
	
	public JButton getLogInBtn() { return LogInBtn; }
	
	public JButton getSignUpBtn() { return SignUpBtn; }
	
	public JLabel getUsernameLbl() { return UsernameLbl; }
	
	
	public JPanel getConferenzeMese1() { return ConferenzeMese1; }
	
	public JPanel getConferenzeMese2() { return ConferenzeMese2; }
	
	public JPanel getConferenzeMese3() { return ConferenzeMese3; }
	
	public ArrayList<JLblButton> getArrayLblButtons(){ return arrayLblButtons; }
	
	public JButton getCalendario() { return CalendarioBtn; }
	
}