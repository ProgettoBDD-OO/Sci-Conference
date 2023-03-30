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
	private JLabel DescrizioneLbl1;
	private JLabel DescrizioneLbl2;
	
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
		DescrizioneConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));
		
			DescrizioneLbl1 = new JLabel("Descrizione");
			DescrizioneLbl1.setForeground(new Color(0, 0, 200));
			DescrizioneLbl1.setFont(new Font("Calibri Light", Font.PLAIN, 14));
			DescrizioneConteiner.add(DescrizioneLbl1, "cell 0 0,alignx center,aligny center");
			
			DescrizioneLbl2 = new JLabel("Descrizione");
			DescrizioneLbl2.setForeground(new Color(0, 0, 200));
			DescrizioneLbl2.setFont(new Font("Calibri Light", Font.PLAIN, 14));
			DescrizioneConteiner.add(DescrizioneLbl2, "cell 0 1,alignx center,aligny center");
		
		TemaLbl = new JLabel("Tema");
		TemaLbl.setPreferredSize(new Dimension(46, 25));
		TemaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TemaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		add(TemaLbl, BorderLayout.SOUTH);
	}
	
	public void setNomeLbl(String nome) { NomeLbl.setText(nome); }

    public void setTemaLbl(String tema) { TemaLbl.setText(tema); }

    public void setDescrizioneLbl1(String descrizione) { DescrizioneLbl1.setText(descrizione); }
    
    public void setDescrizioneLbl2(String descrizione) { DescrizioneLbl2.setText(descrizione); }
}