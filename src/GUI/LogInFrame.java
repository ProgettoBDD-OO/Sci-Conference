package GUI;

import linker.Controller;
import myTools.JLblButton;
import myTools.myTemplates;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;

public class LogInFrame extends JFrame {
	
	private Controller controller;
	
	private myTemplates t = new myTemplates();
	
	private JTextField UsernameEmailFld;
	private JPasswordField PasswordFld;
	private JLblButton goToSignUpBtn;
	private JButton AnnullaLogInBtn;
	private JButton ConfermaLogInBtn;

	public LogInFrame(String Titolo, Controller c) {
		
		controller = c;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
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
			
				JLabel LogInLbl = new JLabel("Accedi");
				LogInLbl.setHorizontalAlignment(SwingConstants.CENTER);
				LogInLbl.setForeground(t.gray);
				LogInLbl.setFont(new Font("Calibri Light", Font.PLAIN, 34));
				NorthPanel.add(LogInLbl, BorderLayout.CENTER);
				
				
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][::100px]8[::25px]10[]"));
						
					JLabel UsernameEmailLbl = new JLabel("Username o Email:");
					UsernameEmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
					UsernameEmailLbl.setForeground(t.tangaroa);
					UsernameEmailLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(UsernameEmailLbl, "cell 0 0, alignx center, aligny bottom");
					
					UsernameEmailFld = new JTextField();
					UsernameEmailFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
					UsernameEmailFld.setForeground(t.tangaroa);
					UsernameEmailFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(UsernameEmailFld, "cell 0 1, alignx center, growy");
					UsernameEmailFld.setColumns(20);
					
					
					JLabel PasswordLbl = new JLabel("Password\r\n:");
					PasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
					PasswordLbl.setForeground(t.tangaroa);
					PasswordLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(PasswordLbl, "cell 0 2, alignx center, aligny bottom");
					
					PasswordFld = new JPasswordField();
					PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
					PasswordFld.setForeground(t.tangaroa);
					PasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					CentrPanel.add(PasswordFld, "cell 0 3, alignx center, growy");
					PasswordFld.setColumns(20);
					
					JLblButton btnNewButton = new JLblButton(t.scBlue, "Password dimenticata");
					btnNewButton.setFont(new Font("Calibri Light", Font.PLAIN, 14));
					btnNewButton.setForeground(t.scBlue);
					CentrPanel.add(btnNewButton, "flowx,cell 0 4,alignx center,aligny top");
					
					
				JPanel WestPanel = new JPanel();
				WestPanel.setBackground(t.scBlue);
				WestPanel.setPreferredSize(new Dimension(55, 10));
				MainPanel.add(WestPanel, BorderLayout.WEST);
					
				JPanel EastPanel = new JPanel();
				EastPanel.setPreferredSize(new Dimension(55, 10));
				EastPanel.setBackground(t.scBlue);
				MainPanel.add(EastPanel, BorderLayout.EAST);
				
				JPanel SouthPanel = new JPanel();
				SouthPanel.setBackground(t.lGray);
				SouthPanel.setPreferredSize(new Dimension(10, 100));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				SouthPanel.setLayout(new BorderLayout(0, 0));
				
					JPanel goToSignUpBtnConteiner = new JPanel();
					goToSignUpBtnConteiner.setPreferredSize(new Dimension(10, 45));
					goToSignUpBtnConteiner.setBackground(t.lGray);
					goToSignUpBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
					SouthPanel.add(goToSignUpBtnConteiner, BorderLayout.SOUTH);
					
							goToSignUpBtn = new JLblButton(t.gray, "Non hai un account? Registrati.");
							goToSignUpBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
							goToSignUpBtnConteiner.add(goToSignUpBtn, "cell 0 0,alignx center,aligny top");
							goToSignUpBtn.setHorizontalAlignment(SwingConstants.CENTER);
							
							goToSignUpBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									controller.fromLogInToSignUp();
								}
							});
							
							goToSignUpBtn.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									goToSignUpBtn.setForeground(t.scBlue);
								}
								@Override
								public void mouseExited(MouseEvent e) {
									goToSignUpBtn.setForeground(t.gray);
								}
							});
				
					
					JPanel ActionPanel = new JPanel();
					ActionPanel.setBackground(t.lGray);
					ActionPanel.setPreferredSize(new Dimension(10, 120));
					ActionPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
					SouthPanel.add(ActionPanel, BorderLayout.CENTER);
					
						AnnullaLogInBtn = new JButton("Annulla");
						AnnullaLogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						AnnullaLogInBtn.setPreferredSize(new Dimension(120, 30));
						AnnullaLogInBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.backFromLogIn();
							}
						});
						ActionPanel.add(AnnullaLogInBtn, "cell 0 0,alignx right,aligny bottom");
						
						ConfermaLogInBtn = new JButton("Conferma");
						ConfermaLogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						ConfermaLogInBtn.setForeground(t.white);
						ConfermaLogInBtn.setBackground(t.scBlue);
						ConfermaLogInBtn.setPreferredSize(new Dimension(120, 30));
						
						ConfermaLogInBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.confermaLogIn();
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
	
	public String getUsernameEmail() {
		return UsernameEmailFld.getText();
	};
	
	public String getPassword() {
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