package GUI.ConferenzaFrame;

import linker.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class InsertPswrdFrame extends JFrame{

	private Controller controller;
	private JTextField PasswordFld;

	public InsertPswrdFrame(Controller c) {
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(246, 247, 248));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel InsertPswrdLbl = new JLabel("Inserisci Password");
		InsertPswrdLbl.setPreferredSize(new Dimension(46, 50));
		InsertPswrdLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		InsertPswrdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MainPanel.add(InsertPswrdLbl, BorderLayout.NORTH);
		
		JPanel PasswordFldConteiner = new JPanel();
		PasswordFldConteiner.setBackground(new Color(246, 247, 248));
		MainPanel.add(PasswordFldConteiner, BorderLayout.CENTER);
		PasswordFldConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
		
		PasswordFld = new JTextField();
		PasswordFld.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		PasswordFld.setPreferredSize(new Dimension(7, 25));
		PasswordFldConteiner.add(PasswordFld, "cell 0 0,growx,aligny center");
		PasswordFld.setColumns(10);
		
		JButton ConfermaBtn = new JButton("Conferma");
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		
		ConfermaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.confermaIscrizione();
			}
		});
	}
	
	public JTextField getPasswordFld() { return PasswordFld; }	
}