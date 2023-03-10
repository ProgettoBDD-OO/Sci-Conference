package GUI;

import java.awt.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogInFrame extends JFrame {
	
	private JButton SignUpSwitchBtn;
	private JButton AnnullaLogInBtn;
	private JButton ConfermaBtn;
	private JTextField UsernameEmailTxt;
	private JPasswordField PasswordTxt;
	private JLabel UsernameEmailLbl;
	private JLabel PasswordLbl;

	public LogInFrame(String Titolo) {
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
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
		
			JLabel LogInLbl = new JLabel("Accedi");
			LogInLbl.setBackground(new Color(246, 247, 248));
			LogInLbl.setHorizontalAlignment(SwingConstants.CENTER);
			LogInLbl.setForeground(new Color(138, 140, 142));
			LogInLbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
			NorthPanel.add(LogInLbl, BorderLayout.CENTER);
			
		

		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(255, 255, 255));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][::100px]8[::25px][]"));
					
				UsernameEmailLbl = new JLabel("Username o Email:");
				UsernameEmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
				UsernameEmailLbl.setForeground(new Color(20, 40, 60));
				UsernameEmailLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(UsernameEmailLbl, "cell 0 0,alignx center,aligny bottom");
				
				UsernameEmailTxt = new JTextField();
				UsernameEmailTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
				UsernameEmailTxt.setForeground(new Color(20, 40, 60));
				UsernameEmailTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				CentrPanel.add(UsernameEmailTxt, "cell 0 1,alignx center,growy");
				UsernameEmailTxt.setColumns(20);
				
				
				PasswordLbl = new JLabel("Password\r\n:");
				PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				PasswordLbl.setForeground(new Color(20, 40, 60));
				PasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				CentrPanel.add(PasswordLbl, "cell 0 2,alignx center,aligny bottom");
				
				PasswordTxt = new JPasswordField();
				PasswordTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
				PasswordTxt.setForeground(new Color(20, 40, 60));
				PasswordTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				CentrPanel.add(PasswordTxt, "cell 0 3,alignx center,growy");
				PasswordTxt.setColumns(20);
		
				SignUpSwitchBtn = new JButton("Non hai un account? Registrati.");
				SignUpSwitchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		        SignUpSwitchBtn.setForeground(new Color(0, 0, 200));
		        SignUpSwitchBtn.setHorizontalAlignment(SwingConstants.CENTER);
		        SignUpSwitchBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		        SignUpSwitchBtn.setFocusPainted(false);
		        SignUpSwitchBtn.setMargin(new Insets(0, 0, 0, 0));
		        SignUpSwitchBtn.setContentAreaFilled(false);
		        SignUpSwitchBtn.setBorderPainted(false);
		        SignUpSwitchBtn.setOpaque(false);
				CentrPanel.add(SignUpSwitchBtn, "cell 0 4,alignx center,aligny center");
				
				
				
			JPanel WestPanel = new JPanel();
			WestPanel.setBackground(new Color(0, 0, 200));
			WestPanel.setPreferredSize(new Dimension(55, 10));
			MainPanel.add(WestPanel, BorderLayout.WEST);
			WestPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][][][][][]"));
			
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
			
				AnnullaLogInBtn = new JButton("Annulla");
				AnnullaLogInBtn.setPreferredSize(new Dimension(120, 30));
				SouthPanel.add(AnnullaLogInBtn, "cell 0 0,alignx right,aligny center");
				
				ConfermaBtn = new JButton("Conferma\r\n");
				ConfermaBtn.setForeground(new Color(255, 255, 255));
				ConfermaBtn.setBackground(new Color(0, 0, 200));
				ConfermaBtn.setPreferredSize(new Dimension(120, 30));
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny center");
 }
	
	public JButton getAnnullaLogInBtn() {
		return AnnullaLogInBtn;
	}
	
	public JButton getSignUpSwitchBtn() {
		return SignUpSwitchBtn;
		
	}
	public JButton getLogInConfermaBtn() {
		return ConfermaBtn;
	}
	
	public String getUsernameEmailTxt() {
		return UsernameEmailTxt.getText();	}
	
	public void setUsernameEmailNull() {
		UsernameEmailTxt.setText("");
	}
	
	@SuppressWarnings("deprecation")
	public String getPasswordLogIn() {
		return PasswordTxt.getText();	}
	
	public void setPasswordNullLogIn() {
		PasswordTxt.setText("");
	}
	
	public JTextField getUsernameEmail() {
		return  UsernameEmailTxt;
	}
	
	public JPasswordField getPassword() {
		return PasswordTxt;
	}
}