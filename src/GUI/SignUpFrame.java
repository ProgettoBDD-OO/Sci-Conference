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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import linker.ControllerLink;
import myTools.JLblButton;
import myTools.myColors;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SignUpFrame extends JFrame {
	
	private ControllerLink controllerLink;
	
	private myColors c;
	
	private JTextField UsernameFld;
	private JTextField EmailFld;
	private JTextField PasswordFld;
	private JTextField CnfrmPasswordFld;
	private JButton AnnullaSignUpBtn;
	private JButton ConfermaSignUpBtn;
	private JButton goToLogInBtn;
	
	public SignUpFrame(String Titolo, ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 800);
		setLocationRelativeTo(null);
		setVisible(false);
		
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(c.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(c.lGray);
		NorthPanel.setPreferredSize(new Dimension(10, 150));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel SignUpLbl = new JLabel("Registrati");
			SignUpLbl.setBackground(c.lGray);
			SignUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
			SignUpLbl.setForeground(c.gray);
			SignUpLbl.setFont(new Font("Calibri Light", Font.PLAIN, 34));
			NorthPanel.add(SignUpLbl, BorderLayout.CENTER);
			
		

		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(c.white);
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][]8[::25px][]8[::25px][]8[::25px]60"));
				
				JLabel EmailLbl = new JLabel("E-mail:");
				CentrPanel.add(EmailLbl, "cell 0 0,alignx center,aligny bottom");
				EmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
				EmailLbl.setForeground(c.tangaroa);
				EmailLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					
				EmailFld = new JTextField();
				EmailFld.setBorder(new MatteBorder(1, 1, 1, 1, c.scBlue));
				EmailFld.setForeground(c.tangaroa);
				EmailFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(EmailFld, "cell 0 1,alignx center,growy");
				EmailFld.setColumns(20);
				
				JLabel UsernameLbl = new JLabel("Username:");
				UsernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
				UsernameLbl.setForeground(c.tangaroa);
				UsernameLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(UsernameLbl, "cell 0 2,alignx center,aligny bottom");
				
				UsernameFld = new JTextField();
				CentrPanel.add(UsernameFld, "cell 0 3,alignx center,growy");
				UsernameFld.setBorder(new MatteBorder(1, 1, 1, 1, c.scBlue));
				UsernameFld.setForeground(c.tangaroa);
				UsernameFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				UsernameFld.setColumns(20);
				
				JLabel PasswordLbl = new JLabel("Password\r\n:");
				PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				PasswordLbl.setForeground(c.tangaroa);
				PasswordLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(PasswordLbl, "cell 0 4,alignx center,aligny bottom");
				
				PasswordFld = new JTextField();
				PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, c.scBlue));
				PasswordFld.setForeground(c.tangaroa);
				PasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(PasswordFld, "cell 0 5,alignx center,growy");
				PasswordFld.setColumns(20);
				
				JLabel CnfrmPasswordLbl = new JLabel("Conferma Password:");
				CnfrmPasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				CnfrmPasswordLbl.setForeground(c.tangaroa);
				CnfrmPasswordLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(CnfrmPasswordLbl, "cell 0 6,alignx center,aligny bottom");
				
				CnfrmPasswordFld = new JTextField();
				CnfrmPasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, c.scBlue));
				CnfrmPasswordFld.setForeground(c.tangaroa);
				CnfrmPasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(CnfrmPasswordFld, "cell 0 7,alignx center,growy");
				CnfrmPasswordFld.setColumns(20);
		
				
			JPanel WestPanel = new JPanel();
			WestPanel.setBackground(c.scBlue);
			WestPanel.setPreferredSize(new Dimension(55, 10));
			MainPanel.add(WestPanel, BorderLayout.WEST);
			
			JPanel EastPanel = new JPanel();
			EastPanel.setPreferredSize(new Dimension(55, 10));
			EastPanel.setBackground(c.scBlue);
			MainPanel.add(EastPanel, BorderLayout.EAST);
			
			
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(c.gray);
			SouthPanel.setPreferredSize(new Dimension(10, 100));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new BorderLayout(0, 0));
			
				JPanel goToLogInBtnConteiner = new JPanel();
				goToLogInBtnConteiner.setPreferredSize(new Dimension(10, 45));
				goToLogInBtnConteiner.setBackground(c.lGray);
				goToLogInBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				SouthPanel.add(goToLogInBtnConteiner, BorderLayout.SOUTH);
				
						goToLogInBtn = new JLblButton(c.gray, "Non hai un account? Registrati.");
						goToLogInBtn.setText("Hai già un account? Accedi");
						goToLogInBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
						goToLogInBtn.setHorizontalAlignment(SwingConstants.CENTER);
						
						goToLogInBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controllerLink.fromSignUpToLogIn();
							}
						});
						
						goToLogInBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								goToLogInBtn.setForeground(c.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								goToLogInBtn.setForeground(c.gray);
							}
						});
			
						goToLogInBtnConteiner.add(goToLogInBtn, "cell 0 0,alignx center,aligny top");
				
				JPanel ActionPanel = new JPanel();
				ActionPanel.setBackground(c.lGray);
				ActionPanel.setPreferredSize(new Dimension(10, 120));
				ActionPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
				SouthPanel.add(ActionPanel, BorderLayout.CENTER);
				
					AnnullaSignUpBtn = new JButton("Annulla");
					AnnullaSignUpBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controllerLink.backFromSignUp();
						}
					});
					AnnullaSignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					AnnullaSignUpBtn.setPreferredSize(new Dimension(120, 30));
					ActionPanel.add(AnnullaSignUpBtn, "cell 0 0,alignx right,aligny bottom");
					
					ConfermaSignUpBtn = new JButton("Conferma");
					ConfermaSignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					ConfermaSignUpBtn.setForeground(c.white);
					ConfermaSignUpBtn.setBackground(c.scBlue);
					ConfermaSignUpBtn.setPreferredSize(new Dimension(120, 30));
					ConfermaSignUpBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controllerLink.confermaSignUp();
						}
					});
					ActionPanel.add(ConfermaSignUpBtn, "cell 1 0,alignx left,aligny bottom");
 }
	
	public JTextField getPasswordFld() {
		return PasswordFld;
	};
	
	public JTextField getCnfrmPasswordFld() {
		return CnfrmPasswordFld;
	};
	
	
	public String getUsernameTxt() {
		return UsernameFld.getText();
	};
	
	public String getEmailTxt() {
		return EmailFld.getText();
	};
	
	public String getPasswordTxt() {
		return PasswordFld.getText();
	};
	
	public String getCnfrmPasswordTxt() {
		return CnfrmPasswordFld.getText();
	};
	
	
	public JButton getAnnullaSignUpBtn() {
		return AnnullaSignUpBtn;
	}
	
	public JButton getLogInSwitchBtn() {
		return goToLogInBtn;
	}
	
	public JButton getConfermaSignUpBtn() {
		return ConfermaSignUpBtn;
	}
	
	public void setUsernameNull() {
		UsernameFld.setText("");
	}

	public void setEmailNull() {
		EmailFld.setText("");
	}

	public void setPasswordTxtNull() {
		PasswordFld.setText("");
	}

	public void setCnfrmPasswordTxtNull() {
		CnfrmPasswordFld.setText("");
	}
}