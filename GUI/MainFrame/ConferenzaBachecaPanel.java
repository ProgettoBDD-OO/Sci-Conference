package GUI.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;

public class ConferenzaBachecaPanel extends JPanel {

	private myTemplates t;

	private JLabel NomeLbl;
	private JLabel TemaLbl;
	private JTextArea DescrizioneLbl;

	public ConferenzaBachecaPanel() {

		t = new myTemplates();
		setBackground(t.lGray);
		setLayout(new BorderLayout(0, 0));

		NomeLbl = new JLabel("Nome");
		NomeLbl.setFont(t.myFont(20));
		NomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NomeLbl.setPreferredSize(new Dimension(46, 50));
		add(NomeLbl, BorderLayout.NORTH);


		JPanel DescrizioneConteiner = new JPanel();
		DescrizioneConteiner.setBackground(t.white);
		add(DescrizioneConteiner, BorderLayout.CENTER);
		DescrizioneConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));

			DescrizioneLbl = new JTextArea("Descrizione");
			DescrizioneLbl.setPreferredSize(new Dimension(10, 22));
			DescrizioneLbl.setLineWrap(true);
			DescrizioneLbl.setWrapStyleWord(true);
			DescrizioneLbl.setForeground(t.scBlue);
			DescrizioneLbl.setFont(t.myFont(14));
			DescrizioneConteiner.add(DescrizioneLbl, "cell 0 0,grow");

		TemaLbl = new JLabel("Tema");
		TemaLbl.setPreferredSize(new Dimension(46, 25));
		TemaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		TemaLbl.setFont(t.myFont(16));
		add(TemaLbl, BorderLayout.SOUTH);
	}

	public void setNomeLbl(String nome) { NomeLbl.setText(nome); }

    public void setTemaLbl(String tema) { TemaLbl.setText(tema); }

    public void setDescrizioneLbl(String descrizione) { DescrizioneLbl.setText(descrizione); }
}