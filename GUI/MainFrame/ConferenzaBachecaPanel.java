package GUI.MainFrame;

import myTools.myTemplates;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class ConferenzaBachecaPanel extends JPanel {
	
	private myTemplates t = new myTemplates();
	
	private JLabel NomeLbl;
	private JLabel TemaLbl;
	private JTextArea DescrizioneLbl;
	
	public ConferenzaBachecaPanel() {
		
		setBackground(new Color(246, 247, 248));
		setLayout(new BorderLayout(0, 0));
		
		NomeLbl = new JLabel("Nome");
		NomeLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		NomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NomeLbl.setPreferredSize(new Dimension(46, 50));
		add(NomeLbl, BorderLayout.NORTH);
		
		
		JPanel DescrizioneConteiner = new JPanel();
		DescrizioneConteiner.setBackground(new Color(255, 255, 255));
		add(DescrizioneConteiner, BorderLayout.CENTER);
		DescrizioneConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
		
			DescrizioneLbl = new JTextArea("Descrizione");
			DescrizioneLbl.setPreferredSize(new Dimension(10, 22));
			DescrizioneLbl.setLineWrap(true);
			DescrizioneLbl.setWrapStyleWord(true);
			DescrizioneLbl.setForeground(new Color(0, 0, 200));
			DescrizioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 14));
			DescrizioneConteiner.add(DescrizioneLbl, "cell 0 0,grow");
		
		TemaLbl = new JLabel("Tema");
		TemaLbl.setPreferredSize(new Dimension(46, 25));
		TemaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TemaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		add(TemaLbl, BorderLayout.SOUTH);
	}
	
	public void setNomeLbl(String nome) { NomeLbl.setText(nome); }

    public void setTemaLbl(String tema) { TemaLbl.setText(tema); }

    public void setDescrizioneLbl(String descrizione) { DescrizioneLbl.setText(descrizione); }
}