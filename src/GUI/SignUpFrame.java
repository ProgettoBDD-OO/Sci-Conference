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

import linker.Controller;
import myTools.JLblButton;
import myTools.myTemplates;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class SignUpFrame extends JFrame {
	
	private Controller controller;
	
	private myTemplates t = new myTemplates();
	
	private JTextField UsernameFld;
	private JTextField EmailFld;
	private JPasswordField PasswordFld;
	private JPasswordField CnfrmPasswordFld;
	private JButton AnnullaSignUpBtn;
	private JButton ConfermaSignUpBtn;
	private JButton goToLogInBtn;
	
	public SignUpFrame(String Titolo, Controller c) {
		
		controller = c;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 800);
		setLocationRelativeTo(null);
		setVisible(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(t.lGray);
		NorthPanel.setPreferredSize(new Dimension(10, 150));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel SignUpLbl = new JLabel("Registrati");
			SignUpLbl.setBackground(t.lGray);
			SignUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
			SignUpLbl.setForeground(t.gray);
			SignUpLbl.setFont(new Font("Calibri Light", Font.PLAIN, 34));
			NorthPanel.add(SignUpLbl, BorderLayout.CENTER);
			
		

		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(t.white);
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][]8[::25px][]8[::25px][]8[::25px]60"));
				
				JLabel EmailLbl = new JLabel("E-mail:");
				CentrPanel.add(EmailLbl, "cell 0 0,alignx center,aligny bottom");
				EmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
				EmailLbl.setForeground(t.tangaroa);
				EmailLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					
				EmailFld = new JTextField();
				EmailFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				EmailFld.setForeground(t.tangaroa);
				EmailFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(EmailFld, "cell 0 1,alignx center,growy");
				EmailFld.setColumns(20);
				
				JLabel UsernameLbl = new JLabel("Username:");
				UsernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
				UsernameLbl.setForeground(t.tangaroa);
				UsernameLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(UsernameLbl, "cell 0 2,alignx center,aligny bottom");
				
				UsernameFld = new JTextField();
				CentrPanel.add(UsernameFld, "cell 0 3,alignx center,growy");
				UsernameFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				UsernameFld.setForeground(t.tangaroa);
				UsernameFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				UsernameFld.setColumns(20);
				
				JLabel PasswordLbl = new JLabel("Password\r\n:");
				PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				PasswordLbl.setForeground(t.tangaroa);
				PasswordLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(PasswordLbl, "cell 0 4,alignx center,aligny bottom");
				
				PasswordFld = new JPasswordField();
				PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				PasswordFld.setForeground(t.tangaroa);
				PasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(PasswordFld, "cell 0 5,alignx center,growy");
				PasswordFld.setColumns(20);
				
				JLabel CnfrmPasswordLbl = new JLabel("Conferma Password:");
				CnfrmPasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
				CnfrmPasswordLbl.setForeground(t.tangaroa);
				CnfrmPasswordLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(CnfrmPasswordLbl, "cell 0 6,alignx center,aligny bottom");
				
				CnfrmPasswordFld = new JPasswordField();
				CnfrmPasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
				CnfrmPasswordFld.setForeground(t.tangaroa);
				CnfrmPasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				CentrPanel.add(CnfrmPasswordFld, "cell 0 7,alignx center,growy");
				CnfrmPasswordFld.setColumns(20);
		
				
			JPanel WestPanel = new JPanel();
			WestPanel.setBackground(t.scBlue);
			WestPanel.setPreferredSize(new Dimension(55, 10));
			MainPanel.add(WestPanel, BorderLayout.WEST);
			
			JPanel EastPanel = new JPanel();
			EastPanel.setPreferredSize(new Dimension(55, 10));
			EastPanel.setBackground(t.scBlue);
			MainPanel.add(EastPanel, BorderLayout.EAST);
			
			
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.gray);
			SouthPanel.setPreferredSize(new Dimension(10, 100));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new BorderLayout(0, 0));
			
				JPanel goToLogInBtnConteiner = new JPanel();
				goToLogInBtnConteiner.setPreferredSize(new Dimension(10, 45));
				goToLogInBtnConteiner.setBackground(t.lGray);
				goToLogInBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				SouthPanel.add(goToLogInBtnConteiner, BorderLayout.SOUTH);
				
						goToLogInBtn = new JLblButton(t.gray, "Non hai un account? Registrati.");
						goToLogInBtn.setText("Hai già un account? Accedi");
						goToLogInBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
						goToLogInBtn.setHorizontalAlignment(SwingConstants.CENTER);
						
						goToLogInBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.fromSignUpToLogIn();
							}
						});
						
						goToLogInBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								goToLogInBtn.setForeground(t.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								goToLogInBtn.setForeground(t.gray);
							}
						});
			
						goToLogInBtnConteiner.add(goToLogInBtn, "cell 0 0,alignx center,aligny top");
				
				JPanel ActionPanel = new JPanel();
				ActionPanel.setBackground(t.lGray);
				ActionPanel.setPreferredSize(new Dimension(10, 120));
				ActionPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
				SouthPanel.add(ActionPanel, BorderLayout.CENTER);
				
					AnnullaSignUpBtn = new JButton("Annulla");
					AnnullaSignUpBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controller.backFromSignUp();
						}
					});
					AnnullaSignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					AnnullaSignUpBtn.setPreferredSize(new Dimension(120, 30));
					ActionPanel.add(AnnullaSignUpBtn, "cell 0 0,alignx right,aligny bottom");
					
					ConfermaSignUpBtn = new JButton("Conferma");
					ConfermaSignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					ConfermaSignUpBtn.setForeground(t.white);
					ConfermaSignUpBtn.setBackground(t.scBlue);
					ConfermaSignUpBtn.setPreferredSize(new Dimension(120, 30));
					ConfermaSignUpBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controller.confermaSignUp();
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
	
	
	public String getUsername() {
		return UsernameFld.getText();
	};
	
	public String getEmail() {
		return EmailFld.getText();
	};
	
	public String getPassword() {
		return PasswordFld.getText();
	};
	
	public String getCnfrmPassword() {
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

	public void setFieldsNull(){
		UsernameFld.setText("");
		EmailFld.setText("");
		PasswordFld.setText("");
		CnfrmPasswordFld.setText("");
	}
	
	public void setEmailError() {
		
		EmailFld.setText("");
		EmailFld.setBorder(new MatteBorder(1, 1, 1, 1, t.red));
	}
	
	public void setPasswordError() {
		
		PasswordFld.setText("");
		CnfrmPasswordFld.setText("");
		PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, t.red));
		CnfrmPasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, t.red));
	}
	
	public boolean FieldsAreEmpty() {
		
		if (getEmail().isEmpty() || getUsername().isEmpty() || getPassword().isEmpty() || getCnfrmPassword().isEmpty()) {
			
			return true;
			
		} else {
			return false;
		}
	}
}