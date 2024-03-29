package GUI.ConferenzaFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrganizzatoreInfo extends JPanel {

	private JLabel AfferenzaLbl;
	private JLabel EmailLbl;

	public OrganizzatoreInfo(int height) {

		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JPanel AfferenzaConteiner = new JPanel();
		AfferenzaConteiner.setBackground(new Color(0, 0, 200));
		add(AfferenzaConteiner, BorderLayout.CENTER);
		AfferenzaConteiner.setLayout(new BorderLayout(0, 0));

		AfferenzaLbl = new JLabel("");
		AfferenzaConteiner.add(AfferenzaLbl, BorderLayout.CENTER);
		AfferenzaLbl.setForeground(new Color(255, 255, 255));
		AfferenzaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		AfferenzaLbl.setHorizontalAlignment(SwingConstants.CENTER);

		EmailLbl = new JLabel("");
		EmailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		EmailLbl.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		EmailLbl.setPreferredSize(new Dimension(158, height));
		add(EmailLbl, BorderLayout.SOUTH);
	}

	public void setAfferenza(String txt) { AfferenzaLbl.setText(txt); }

	public void setEmail(String txt) { EmailLbl.setText(txt); }
	
	public void shrinkFont() {
		
		AfferenzaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		EmailLbl.setFont(new Font("Calibri Light", Font.PLAIN, 12));
	}
}