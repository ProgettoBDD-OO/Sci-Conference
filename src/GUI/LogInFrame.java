package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import linker.ControllerLink;
import myTools.JLblButton;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInFrame extends JFrame {
	
	private ControllerLink controllerLink;
	private Controller controller;
	
	private JTextField UsernameEmailFld;
	private JTextField PasswordFld;
	private JLblButton goToSignUpBtn;
	private JButton AnnullaLogInBtn;
	private JButton ConfermaLogInBtn;

	public LogInFrame(String Titolo, ControllerLink contrLink, Controller contr) {
		
		controllerLink = contrLink;
		controller = contr;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
		setLocationRelativeTo(null);
		setVisible(false);
		
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
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
				LogInLbl.setForeground(new Color(80, 82, 84));
				LogInLbl.setFont(new Font("Calibri Light", Font.PLAIN, 34));
				NorthPanel.add(LogInLbl, BorderLayout.CENTER);
				
	
				
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(new Color(255, 255, 255));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][::100px]8[::25px]10[]"));
						
					JLabel UsernameEmailLbl = new JLabel("Username o Email:");
					UsernameEmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
					UsernameEmailLbl.setForeground(new Color(20, 40, 60));
					UsernameEmailLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(UsernameEmailLbl, "cell 0 0, alignx center, aligny bottom");
					
					UsernameEmailFld = new JTextField();
					UsernameEmailFld.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
					UsernameEmailFld.setForeground(new Color(20, 40, 60));
					UsernameEmailFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(UsernameEmailFld, "cell 0 1, alignx center, growy");
					UsernameEmailFld.setColumns(20);
					
					
					JLabel PasswordLbl = new JLabel("Password\r\n:");
					PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
					PasswordLbl.setForeground(new Color(20, 40, 60));
					PasswordLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(PasswordLbl, "cell 0 2, alignx center, aligny bottom");
					
					PasswordFld = new JTextField();
					PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
					PasswordFld.setForeground(new Color(20, 40, 60));
					PasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(PasswordFld, "cell 0 3, alignx center, growy");
					PasswordFld.setColumns(20);
					
					JLblButton btnNewButton = new JLblButton("Password dimenticata");
					btnNewButton.setFont(new Font("Calibri Light", Font.PLAIN, 14));
					btnNewButton.setForeground(new Color(0, 0, 200));
					CentrPanel.add(btnNewButton, "flowx,cell 0 4,alignx center,aligny top");
					
					
					
				JPanel WestPanel = new JPanel();
				WestPanel.setBackground(new Color(0, 0, 200));
				WestPanel.setPreferredSize(new Dimension(55, 10));
				MainPanel.add(WestPanel, BorderLayout.WEST);
					
				JPanel EastPanel = new JPanel();
				EastPanel.setPreferredSize(new Dimension(55, 10));
				EastPanel.setBackground(new Color(0, 0, 200));
				MainPanel.add(EastPanel, BorderLayout.EAST);
				
				JPanel SouthPanel = new JPanel();
				SouthPanel.setBackground(new Color(246, 247, 248));
				SouthPanel.setPreferredSize(new Dimension(10, 100));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				SouthPanel.setLayout(new BorderLayout(0, 0));
				
					JPanel goToSignUpBtnConteiner = new JPanel();
					goToSignUpBtnConteiner.setPreferredSize(new Dimension(10, 45));
					goToSignUpBtnConteiner.setBackground(new Color(246, 247, 248));
					goToSignUpBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
					SouthPanel.add(goToSignUpBtnConteiner, BorderLayout.SOUTH);
					
							goToSignUpBtn = new JLblButton("Non hai un account? Registrati.");
							
							goToSignUpBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
							goToSignUpBtnConteiner.add(goToSignUpBtn, "cell 0 0,alignx center,aligny top");
							goToSignUpBtn.setForeground(new Color(80, 82, 84));
							goToSignUpBtn.setHorizontalAlignment(SwingConstants.CENTER);
							
							goToSignUpBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									controllerLink.fromLogInToSignUp();
								}
							});
							
							goToSignUpBtn.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									goToSignUpBtn.setForeground(new Color(0, 0, 200));
								}
								@Override
								public void mouseExited(MouseEvent e) {
									goToSignUpBtn.setForeground(new Color(80, 82, 84));
								}
							});
				
					
					JPanel ActionPanel = new JPanel();
					ActionPanel.setBackground(new Color(246, 247, 248));
					ActionPanel.setPreferredSize(new Dimension(10, 120));
					ActionPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
					SouthPanel.add(ActionPanel, BorderLayout.CENTER);
					
						AnnullaLogInBtn = new JButton("Annulla");
						AnnullaLogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						AnnullaLogInBtn.setPreferredSize(new Dimension(120, 30));
						AnnullaLogInBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controllerLink.backFromLogIn();
							}
						});
						ActionPanel.add(AnnullaLogInBtn, "cell 0 0,alignx right,aligny bottom");
						
						ConfermaLogInBtn = new JButton("Conferma\r\n");
						ConfermaLogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						ConfermaLogInBtn.setForeground(new Color(255, 255, 255));
						ConfermaLogInBtn.setBackground(new Color(0, 0, 200));
						ConfermaLogInBtn.setPreferredSize(new Dimension(120, 30));
						
						ConfermaLogInBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controllerLink.confermaLogIn();
							}
						});
						
						ActionPanel.add(ConfermaLogInBtn, "cell 1 0,alignx left,aligny bottom");
 }
	
	public JTextField getUsernameEmailFld() {
		return UsernameEmailFld;
	};
	
	public JTextField getPasswordFld() {
		return PasswordFld;
	};
	
	public String getUsernameEmailTxt() {
		return UsernameEmailFld.getText();
	};
	
	public String getPasswordTxt() {
		return PasswordFld.getText();
	};
	
	public JButton getSignUpSwitchBtn() {
		return goToSignUpBtn;
	}

	public JButton getConfermaLogInBtn() {
		return ConfermaLogInBtn;
	}
	
	public void setUsernameEmailTxtNull() {
		UsernameEmailFld.setText("");
	}
	
	public void setPasswordTxtNull() {
		PasswordFld.setText("");
	}
}