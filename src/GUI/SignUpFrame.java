package GUI;

import java.awt.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;


public class SignUpFrame extends JFrame {
	
	private JButton LogInSwitchBtn;
	private JButton AnnullaSignUpBtn;
	private JTextField UsernameTxt;
	private JButton ConfermaBtn;
	private JTextField EmailTxt;
	private JPasswordField PasswordTxt;
	private JPasswordField CnfrmPasswordTxt;

	public SignUpFrame(String Titolo) {
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 800);
		setLocationRelativeTo(null);
		setVisible(false);
		
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\bottf\\Documenti\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(246, 247, 248));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(new Color(246, 247, 248));
		NorthPanel.setPreferredSize(new Dimension(10, 150));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel SignUpLbl = new JLabel("Registrati");
			SignUpLbl.setBackground(new Color(246, 247, 248));
			SignUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
			SignUpLbl.setForeground(new Color(138, 140, 142));
			SignUpLbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
			NorthPanel.add(SignUpLbl, BorderLayout.CENTER);
			
		

		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(255, 255, 255));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][]8[::25px][]8[::25px][]8[::25px][]"));
			
				JLabel UsernameLbl = new JLabel("Username:");
				UsernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
				UsernameLbl.setForeground(new Color(20, 40, 60));
				UsernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(UsernameLbl, "cell 0 0,alignx center,aligny bottom");
			
				UsernameTxt = new JTextField();
				UsernameTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
				UsernameTxt.setForeground(new Color(20, 40, 60));
				UsernameTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(UsernameTxt, "cell 0 1,alignx center,growy");
				UsernameTxt.setColumns(20);
				
				JLabel EmailLbl = new JLabel("E-mail:");
				EmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
				EmailLbl.setForeground(new Color(20, 40, 60));
				EmailLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(EmailLbl, "cell 0 2,alignx center,aligny bottom");
				
				EmailTxt = new JTextField();
				EmailTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
				EmailTxt.setForeground(new Color(20, 40, 60));
				EmailTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(EmailTxt, "cell 0 3,alignx center,growy");
				EmailTxt.setColumns(20);
				
				JLabel PasswordLbl = new JLabel("Password\r\n:");
				PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				PasswordLbl.setForeground(new Color(20, 40, 60));
				PasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(PasswordLbl, "cell 0 4,alignx center,aligny bottom");
				
				PasswordTxt = new JPasswordField();
				PasswordTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
				PasswordTxt.setForeground(new Color(20, 40, 60));
				PasswordTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(PasswordTxt, "cell 0 5,alignx center,growy");
				PasswordTxt.setColumns(20);
				
				JLabel CnfrmPasswordLbl = new JLabel("Conferma Password:");
				CnfrmPasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				CnfrmPasswordLbl.setForeground(new Color(20, 40, 60));
				CnfrmPasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(CnfrmPasswordLbl, "cell 0 6,alignx center,aligny bottom");
				
				CnfrmPasswordTxt = new JPasswordField();
				CnfrmPasswordTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
				CnfrmPasswordTxt.setForeground(new Color(20, 40, 60));
				CnfrmPasswordTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(CnfrmPasswordTxt, "cell 0 7,alignx center,growy");
				CnfrmPasswordTxt.setColumns(20);
				
				LogInSwitchBtn = new JButton("Hai gia un account? Accedi.");
				LogInSwitchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		        LogInSwitchBtn.setForeground(new Color(0, 0, 200));
		        LogInSwitchBtn.setHorizontalAlignment(SwingConstants.CENTER);
		        LogInSwitchBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		        LogInSwitchBtn.setFocusPainted(false);
		        LogInSwitchBtn.setMargin(new Insets(0, 0, 0, 0));
		        LogInSwitchBtn.setContentAreaFilled(false);
		        LogInSwitchBtn.setBorderPainted(false);
		        LogInSwitchBtn.setOpaque(false);
				CentrPanel.add(LogInSwitchBtn, "cell 0 8,alignx center,aligny center");
		
			
				
			JPanel WestPanel = new JPanel();
			WestPanel.setBackground(new Color(0, 0, 200));
			WestPanel.setPreferredSize(new Dimension(55, 10));
			MainPanel.add(WestPanel, BorderLayout.WEST);
			WestPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[][][][][][][]"));
			
				JLabel IconConteinerSx_1 = new JLabel("");
				WestPanel.add(IconConteinerSx_1, "cell 0 0,alignx center,aligny center");
				
				JLabel IconConteinerSx_2 = new JLabel("");
				WestPanel.add(IconConteinerSx_2, "cell 0 1, alignx center, aligny center");
				
				JLabel IconConteinerSx_3 = new JLabel("");
				WestPanel.add(IconConteinerSx_3, "cell 0 2, alignx center, aligny center");
				
				JLabel IconConteinerSx_4 = new JLabel("");
				WestPanel.add(IconConteinerSx_4, "cell 0 3, alignx center, aligny center");
				
				JLabel lblNewLabelSx_5 = new JLabel("");
				WestPanel.add(lblNewLabelSx_5, "cell 0 4, alignx center, aligny center");
				
				JLabel IconConteinerSx_6 = new JLabel("");
				WestPanel.add(IconConteinerSx_6, "cell 0 5, alignx center, aligny center");
				
				JLabel lblNewLabelSx_7 = new JLabel("");
				WestPanel.add(lblNewLabelSx_7, "cell 0 6, alignx center, aligny center");
			
				
				
			JPanel EastPanel = new JPanel();
			EastPanel.setPreferredSize(new Dimension(55, 10));
			EastPanel.setBackground(new Color(0, 0, 200));
			MainPanel.add(EastPanel, BorderLayout.EAST);
			EastPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][][][][][]"));
			
				JLabel IconConteinerDx_1 = new JLabel("");
				EastPanel.add(IconConteinerDx_1, "cell 0 0, alignx center, aligny center");
				
				JLabel IconConteinerDx_2 = new JLabel("");
				EastPanel.add(IconConteinerDx_2, "cell 0 1, alignx center, aligny center");
				
				JLabel IconConteinerDx_3 = new JLabel("");
				EastPanel.add(IconConteinerDx_3, "cell 0 2, alignx center, aligny center");
				
				JLabel IconConteinerDx_4 = new JLabel("");
				EastPanel.add(IconConteinerDx_4, "cell 0 3, alignx center, aligny center");
				
				JLabel IconConteinerDx_5 = new JLabel("");
				EastPanel.add(IconConteinerDx_5, "cell 0 4, alignx center, aligny center");
				
				JLabel IconConteinerDx_6 = new JLabel("");
				EastPanel.add(IconConteinerDx_6, "cell 0 5, alignx center, aligny center");
				
				JLabel IconConteinerDx_7 = new JLabel("");
				EastPanel.add(IconConteinerDx_7, "cell 0 6, alignx center, aligny center");
			
			
				
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(new Color(246, 247, 248));
			SouthPanel.setPreferredSize(new Dimension(10, 120));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			
				AnnullaSignUpBtn = new JButton("Annulla");
				AnnullaSignUpBtn.setPreferredSize(new Dimension(120, 30));
				SouthPanel.add(AnnullaSignUpBtn, "cell 0 0,alignx right,aligny center");
				
				ConfermaBtn = new JButton("Conferma\r\n");
				ConfermaBtn.setForeground(new Color(255, 255, 255));
				ConfermaBtn.setBackground(new Color(0, 0, 200));
				ConfermaBtn.setPreferredSize(new Dimension(120, 30));
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny center");
 }
	
	public JButton getAnnullaSignUpBtn() {
		return AnnullaSignUpBtn;
	}
	
	public JButton getLogInSwitchBtn() {
		return LogInSwitchBtn;
	}
	
	public JButton getSignUpConfermaBtn() {
		return ConfermaBtn;
	}
	
	public String getUsername() {
		return UsernameTxt.getText();	}
	
	public JTextField getUsernameField() {
		return UsernameTxt;
	}
	
	public void setUsernameNull() {
		UsernameTxt.setText("");
	}
	
	public String getEmail() {
		return EmailTxt.getText();	}
	
	public JTextField getEmailField() {
		return EmailTxt;
	}
	
	public void setEmailNull() {
		EmailTxt.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return PasswordTxt.getText();	}
	
	public void setPasswordNull() {
		PasswordTxt.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public String getCnfrmPasswordTxt() {
		return CnfrmPasswordTxt.getText();
	}
	
	public void setCnfrmPasswordTxtNull() {
		CnfrmPasswordTxt.setText("");
	}
	
	public JPasswordField getPasswordField() {
		return PasswordTxt;
	}
	
	public JPasswordField getCnfrmPasswordField() {
		return CnfrmPasswordTxt;
	}

}