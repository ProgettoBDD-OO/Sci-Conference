package GUI.ConferenzaFrame;

import myTools.myTemplates;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class NorthPanel extends JPanel {

	private myTemplates t;
	
	private JLabel NomeLbl;
	private JLabel TemaLbl;
	private JLabel DataInizioLbl;
	private JLabel SpazioLbl;
	private JLabel DataFineLbl;
	private JLabel CollocazioneLbl;
	private JLabel DescrizioneLbl;
	
	public NorthPanel() {

		t = new myTemplates();
		setBorder(new EmptyBorder(25, 0, 0, 0));
		setBackground(t.lGray);
		setLayout(new BorderLayout(0, 0));
		
		NomeLbl = new JLabel("Titolo");
		NomeLbl.setPreferredSize(new Dimension(26, 60));
		NomeLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		NomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NomeLbl.setFont(t.myFont(34));
		add(NomeLbl, BorderLayout.NORTH);

		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(t.lGray);
		add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][]"));

			TemaLbl = new JLabel("Tema");
			TemaLbl.setFont(t.myFont(24));
			CentrPanel.add(TemaLbl, "cell 0 0,alignx center,aligny top");

			JPanel DatePanel = new JPanel();
			CentrPanel.add(DatePanel, "cell 0 1,grow");
			DatePanel.setBackground(t.lGray);
			DatePanel.setLayout(new MigLayout("wrap, fill", "[][::15px][]", "[]"));

			DataInizioLbl = new JLabel("Data Inizio");
			DataInizioLbl.setFont(t.myFont(24));
			DatePanel.add(DataInizioLbl, "cell 0 0,alignx right,aligny center");

			SpazioLbl = new JLabel("-");
			SpazioLbl.setFont(t.myFont(24));
			DatePanel.add(SpazioLbl, "cell 1 0,alignx center,aligny center");

			DataFineLbl = new JLabel("Data Fine");
			DataFineLbl.setFont(t.myFont(24));
			DatePanel.add(DataFineLbl, "cell 2 0,alignx left,aligny center");

			CollocazioneLbl = new JLabel("Collocazione");
			CollocazioneLbl.setFont(t.myFont(24));
			CentrPanel.add(CollocazioneLbl, "cell 0 2,alignx center,aligny center");

			DescrizioneLbl = new JLabel("Descrizione");
			DescrizioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
			DescrizioneLbl.setPreferredSize(new Dimension(54, 50));
			DescrizioneLbl.setFont(t.myFont(20));
			add(DescrizioneLbl, BorderLayout.SOUTH);
	}
	
	public JLabel getNomeLbl() { return NomeLbl; }

	public void setNome(String nome) { NomeLbl.setText(nome); }

	public JLabel getTemaLbl() { return TemaLbl; }

	public void setTema(String tema) { TemaLbl.setText(tema); }

	public void setDataInizio(String dataInizio) { DataInizioLbl.setText(dataInizio); }

	public void setDataFine(String dataFine) { DataFineLbl.setText(dataFine); }

	public void setDescrizione(String descrizione) { DescrizioneLbl.setText(descrizione); }

	public void setCollocazione(String collocazione) { CollocazioneLbl.setText(collocazione); }
}