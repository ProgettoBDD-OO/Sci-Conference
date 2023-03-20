package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import linker.ControllerLink;

import java.awt.Font;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertPswrdFrame extends JFrame{

	private ControllerLink controllerLink;
	private JTextField PasswordFld;

	public InsertPswrdFrame(ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		
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
				controllerLink.confermaIscrizione();
			}
		});
	}
	
	public JTextField getPasswordFld() { return PasswordFld; }	
}