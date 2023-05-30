package GUI.ConferenzaFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class InsertPswrdDialog extends JDialog {

	private myTemplates t;

	private Controller controller;
	private JPasswordField PasswordFld;
	private JLabel PswrdErrataLbl;

	public InsertPswrdDialog(Controller c) {

		controller = c;

		t = new myTemplates();
		setSize(300, 225);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));

		JLabel InsertPswrdLbl = new JLabel("Inserisci Password");
		InsertPswrdLbl.setPreferredSize(new Dimension(46, 50));
		InsertPswrdLbl.setFont(t.myFont(18));
		InsertPswrdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(InsertPswrdLbl, BorderLayout.NORTH);

		JPanel PasswordFldConteiner = new JPanel();
		PasswordFldConteiner.setBackground(t.lGray);
		MainPanel.add(PasswordFldConteiner, BorderLayout.CENTER);
		PasswordFldConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));

			PasswordFld = new JPasswordField();
			PasswordFld.setFont(t.myFont(14));
			PasswordFld.setPreferredSize(new Dimension(7, 25));
			PasswordFldConteiner.add(PasswordFld, "cell 0 0,growx,aligny center");
			PasswordFld.setColumns(10);

			PswrdErrataLbl = new JLabel("Password errata.");
			PswrdErrataLbl.setVisible(false);
			PswrdErrataLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			PswrdErrataLbl.setForeground(new Color(255, 0, 0));
			PasswordFldConteiner.add(PswrdErrataLbl, "cell 0 1,alignx center,aligny center");


		JButton ConfermaBtn = new JButton("Conferma");
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setBackground(new Color(0, 0, 200));
		ConfermaBtn.setForeground(new Color(255, 255, 255));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		ConfermaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.confermaIscrizione();
			}
		});
	}

	public String getPasswordFld() { return PasswordFld.getText(); }

	public JLabel getPswrdErrataLbl() { return PswrdErrataLbl; }

	public void setError() {

		PasswordFld.setText("");
		PasswordFld.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
		PswrdErrataLbl.setVisible(true);
	}
}