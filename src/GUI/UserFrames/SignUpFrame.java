package GUI.UserFrames;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class SignUpFrame extends JFrame {

	private Controller controller;

	private myTemplates t;

	private JTextField UsernameFld;
	private JTextField EmailFld;
	private JPasswordField PasswordFld;
	private JPasswordField CnfrmPasswordFld;

	public SignUpFrame(Controller c) {

		controller = c;

		t = new myTemplates();
		setTitle("Sci-Conference - Signup");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600, 685);
		setLocationRelativeTo(null);
		setVisible(false);
		setIconImage(t.miniLogo);


		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));

			JPanel NorthPanel = new JPanel();
			NorthPanel.setBackground(t.lGray);
			NorthPanel.setPreferredSize(new Dimension(10, 107));
			MainPanel.add(NorthPanel, BorderLayout.NORTH);
			NorthPanel.setLayout(new BorderLayout(0, 0));

				JLabel SignUpLbl = new JLabel("Registrati");
				SignUpLbl.setBackground(t.lGray);
				SignUpLbl.setHorizontalAlignment(SwingConstants.CENTER);
				SignUpLbl.setForeground(t.gray);
				SignUpLbl.setFont(new Font("Calibri Light", Font.PLAIN, 30));
				NorthPanel.add(SignUpLbl, BorderLayout.CENTER);


			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][]8[::25px][]8[::25px][]8[::25px]60"));

				JLabel EmailLbl = new JLabel("E-mail:");
				EmailLbl.setForeground(t.tangaroa);
				EmailLbl.setFont(t.myFont(16));
				CentrPanel.add(EmailLbl, "cell 0 0,alignx center,aligny bottom");

				EmailFld = new UserFld();
				CentrPanel.add(EmailFld, "cell 0 1,alignx center,growy");


				JLabel UsernameLbl = new JLabel("Username:");
				UsernameLbl.setForeground(t.tangaroa);
				UsernameLbl.setFont(t.myFont(16));
				CentrPanel.add(UsernameLbl, "cell 0 2,alignx center,aligny bottom");

				UsernameFld = new UserFld();
				CentrPanel.add(UsernameFld, "cell 0 3,alignx center,growy");


				JLabel PasswordLbl = new JLabel("Password\r\n:");
				PasswordLbl.setForeground(t.tangaroa);
				PasswordLbl.setFont(t.myFont(16));
				CentrPanel.add(PasswordLbl, "cell 0 4,alignx center,aligny bottom");

				PasswordFld = new PswrdFld();
				CentrPanel.add(PasswordFld, "cell 0 5,alignx center,growy");


				JLabel CnfrmPasswordLbl = new JLabel("Conferma Password:");
				CnfrmPasswordLbl.setForeground(t.tangaroa);
				CnfrmPasswordLbl.setFont(t.myFont(16));
				CentrPanel.add(CnfrmPasswordLbl, "cell 0 6,alignx center,aligny bottom");

				CnfrmPasswordFld = new PswrdFld();
				CentrPanel.add(CnfrmPasswordFld, "cell 0 7,alignx center,growy");


			JPanel WestPanel = new JPanel();
			WestPanel.setBackground(t.scBlue);
			WestPanel.setPreferredSize(new Dimension(47, 10));
			MainPanel.add(WestPanel, BorderLayout.WEST);

			JPanel EastPanel = new JPanel();
			EastPanel.setPreferredSize(new Dimension(47, 10));
			EastPanel.setBackground(t.scBlue);
			MainPanel.add(EastPanel, BorderLayout.EAST);


			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.gray);
			SouthPanel.setPreferredSize(new Dimension(10, 107));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new BorderLayout(0, 0));

				JPanel goToLogInBtnContainer = new JPanel();
				goToLogInBtnContainer.setPreferredSize(new Dimension(10, 37));
				goToLogInBtnContainer.setBackground(t.lGray);
				goToLogInBtnContainer.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				SouthPanel.add(goToLogInBtnContainer, BorderLayout.SOUTH);

						JButton goToLogInBtn = new GoToLogInBtn(controller);
						goToLogInBtnContainer.add(goToLogInBtn, "cell 0 0,alignx center,aligny top");


				JPanel ActionPanel = new JPanel();
				ActionPanel.setBackground(t.lGray);
				ActionPanel.setPreferredSize(new Dimension(10, 102));
				ActionPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
				SouthPanel.add(ActionPanel, BorderLayout.CENTER);

					JButton AnnullaSignUpBtn = new JButton("Annulla");
					AnnullaSignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					AnnullaSignUpBtn.setPreferredSize(new Dimension(102, 25));
					ActionPanel.add(AnnullaSignUpBtn, "cell 0 0,alignx right,aligny bottom");
					AnnullaSignUpBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							controller.backFromSignUp();
						}
					});

					JButton ConfermaSignUpBtn = new JButton("Conferma");
					ConfermaSignUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					ConfermaSignUpBtn.setForeground(t.white);
					ConfermaSignUpBtn.setBackground(t.scBlue);
					ConfermaSignUpBtn.setPreferredSize(new Dimension(102, 25));
					ActionPanel.add(ConfermaSignUpBtn, "cell 1 0,alignx left,aligny bottom");
					ConfermaSignUpBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							controller.confermaSignUp();
						}
					});
	}

	public JTextField getPasswordFld() { return PasswordFld; }

	public JTextField getCnfrmPasswordFld() { return CnfrmPasswordFld; }


	public String getUsername() { return UsernameFld.getText(); }

	public String getEmail() { return EmailFld.getText(); }

	public String getPassword() { return PasswordFld.getText(); }

	public String getCnfrmPassword() { return CnfrmPasswordFld.getText(); }


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

	public void setUsernameError() {

		UsernameFld.setText("");
		UsernameFld.setBorder(new MatteBorder(1, 1, 1, 1, t.red));
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

		} else { return false; }
	}
}