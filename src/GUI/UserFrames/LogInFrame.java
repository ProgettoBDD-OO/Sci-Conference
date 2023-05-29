package GUI.UserFrames;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
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

public class LogInFrame extends JFrame {

	private Controller controller;

	private myTemplates t;

	private JTextField UsernameEmailFld;
	private JPasswordField PasswordFld;
	private GoToSignUpBtn goToSignUpBtn;

	public LogInFrame(Controller c) {

		controller = c;

		t = new myTemplates();
		setTitle("Sci-Conference - Login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(false);
		setIconImage(t.miniLogo);


		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);


			JPanel NorthPanel = new JPanel();
			NorthPanel.setBackground(t.lGray);
			NorthPanel.setPreferredSize(new Dimension(10, 125));
			NorthPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(NorthPanel, BorderLayout.NORTH);

				JLabel LogInLbl = new JLabel("Accedi");
				LogInLbl.setHorizontalAlignment(SwingConstants.CENTER);
				LogInLbl.setForeground(t.gray);
				LogInLbl.setFont(t.myFont(34));
				NorthPanel.add(LogInLbl, BorderLayout.CENTER);


			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]8[::25px][::100px]8[::25px]75"));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);

					JLabel UsernameEmailLbl = new JLabel("Username o Email:");
					UsernameEmailLbl.setForeground(t.tangaroa);
					UsernameEmailLbl.setFont(t.myFont(18));
					CentrPanel.add(UsernameEmailLbl, "cell 0 0, alignx center, aligny bottom");

					UsernameEmailFld = new UserFld();
					CentrPanel.add(UsernameEmailFld, "cell 0 1, alignx center, growy");


					JLabel PasswordLbl = new JLabel("Password:");
					PasswordLbl.setForeground(t.tangaroa);
					PasswordLbl.setFont(t.myFont(18));
					CentrPanel.add(PasswordLbl, "cell 0 2, alignx center, aligny bottom");

					PasswordFld = new JPasswordField();
					PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
					PasswordFld.setForeground(t.tangaroa);
					PasswordFld.setFont(t.myFont(18));
					PasswordFld.setColumns(20);
					CentrPanel.add(PasswordFld, "cell 0 3, alignx center, growy");


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
				SouthPanel.setPreferredSize(new Dimension(10, 125));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				SouthPanel.setLayout(new BorderLayout(0, 0));

					JPanel ActionPanel = new JPanel();
					ActionPanel.setBackground(t.lGray);
					ActionPanel.setPreferredSize(new Dimension(10, 120));
					ActionPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
					SouthPanel.add(ActionPanel, BorderLayout.CENTER);

						JButton AnnullaLogInBtn = new JButton("Annulla");
						AnnullaLogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						AnnullaLogInBtn.setPreferredSize(new Dimension(120, 30));
						ActionPanel.add(AnnullaLogInBtn, "cell 0 0,alignx right,aligny bottom");
						AnnullaLogInBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.backFromLogIn();
							}
						});

						JButton ConfermaLogInBtn = new JButton("Conferma");
						ConfermaLogInBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						ConfermaLogInBtn.setForeground(t.white);
						ConfermaLogInBtn.setBackground(t.scBlue);
						ConfermaLogInBtn.setPreferredSize(new Dimension(120, 30));
						ActionPanel.add(ConfermaLogInBtn, "cell 1 0,alignx left,aligny bottom");
						ConfermaLogInBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controller.confermaLogIn();
							}
						});

					JPanel goToSignUpBtnContainer = new JPanel();
					goToSignUpBtnContainer.setPreferredSize(new Dimension(10, 50));
					goToSignUpBtnContainer.setBackground(t.lGray);
					goToSignUpBtnContainer.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
					SouthPanel.add(goToSignUpBtnContainer, BorderLayout.SOUTH);

						goToSignUpBtn = new GoToSignUpBtn(controller);
						goToSignUpBtnContainer.add(goToSignUpBtn, "cell 0 0,alignx center,aligny top");
 }

	public JTextField getUsernameEmailFld() { return UsernameEmailFld; }

	public JTextField getPasswordFld() { return PasswordFld; }


	public String getUsernameEmail() { return UsernameEmailFld.getText(); }

	public String getPassword() { return PasswordFld.getText(); }


	public void setUsernameEmailTxtNull() { UsernameEmailFld.setText(""); }

	public void setPasswordTxtNull() { PasswordFld.setText(""); }
}