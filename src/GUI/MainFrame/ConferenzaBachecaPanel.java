package GUI.MainFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;

public class ConferenzaBachecaPanel extends JPanel {
	
	private JLabel NomeLbl;
	private JLabel TemaLbl;
	private JLabel DescrizioneLbl;
	
	public ConferenzaBachecaPanel() {
		
		setBackground(new Color(246, 247, 248));
		setLayout(new BorderLayout(0, 0));
		
		NomeLbl = new JLabel("Nome");
		NomeLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		NomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NomeLbl.setPreferredSize(new Dimension(46, 50));
		add(NomeLbl, BorderLayout.NORTH);
		
		TemaLbl = new JLabel("Tema");
		TemaLbl.setPreferredSize(new Dimension(46, 25));
		TemaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TemaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		add(TemaLbl, BorderLayout.SOUTH);
		
		JPanel DescrizioneConteiner = new JPanel();
		DescrizioneConteiner.setBackground(new Color(255, 255, 255));
		add(DescrizioneConteiner, BorderLayout.CENTER);
		DescrizioneConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
		
		DescrizioneLbl = new JLabel("Descrizione");
		DescrizioneLbl.setForeground(new Color(0, 0, 200));
		DescrizioneConteiner.add(DescrizioneLbl, "cell 0 0,alignx center,aligny center");
		DescrizioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		DescrizioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void setNomeLbl(String nome) { NomeLbl.setText(nome); }

    public void setTemaLbl(String tema) { TemaLbl.setText(tema); }

    public void setDescrizioneLbl(String descrizione) { DescrizioneLbl.setText(descrizione); }
}