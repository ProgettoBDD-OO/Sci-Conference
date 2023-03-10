package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EmptyBorder;

public class InfoConferenzaFrame extends JFrame {
	
	private JLabel NomeConferenzaLbl;
	private JLabel DataInizioLbl;
	private JLabel DataFineLbl;
	private JLabel DescrizioneLbl;
	private JLabel SpazioLbl;
	private JPanel NorthCentrPanel;
	private JLabel TemaLbl;
	private JPanel SouthPanel;
	private JButton IndietroBtn;
	
	public InfoConferenzaFrame(String Titolo) {
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(246, 247, 248));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBorder(new EmptyBorder(25, 0, 0, 0));
		NorthPanel.setBackground(new Color(246, 247, 248));
		NorthPanel.setPreferredSize(new Dimension(10, 225));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new BorderLayout(0, 0));
		
		NomeConferenzaLbl = new JLabel("Titolo");
		NomeConferenzaLbl.setPreferredSize(new Dimension(26, 60));
		NorthPanel.add(NomeConferenzaLbl, BorderLayout.NORTH);
		NomeConferenzaLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		NomeConferenzaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		NomeConferenzaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 34));
			
			DescrizioneLbl = new JLabel("Descrizione");
			DescrizioneLbl.setPreferredSize(new Dimension(54, 50));
			DescrizioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 22));
			DescrizioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
			NorthPanel.add(DescrizioneLbl, BorderLayout.SOUTH);
			
			NorthCentrPanel = new JPanel();
			NorthCentrPanel.setBackground(new Color(246, 247, 248));
			NorthPanel.add(NorthCentrPanel, BorderLayout.CENTER);
			NorthCentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));
			
			TemaLbl = new JLabel("Tema");
			TemaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
			NorthCentrPanel.add(TemaLbl, "cell 0 0,alignx center,aligny center");
			
			JPanel DatePanel = new JPanel();
			NorthCentrPanel.add(DatePanel, "cell 0 1,grow");
			DatePanel.setBackground(new Color(246, 247, 248));
			DatePanel.setLayout(new MigLayout("wrap, fill", "[][::15px][]", "[]"));
			
				DataInizioLbl = new JLabel("Data Inizio");
				DataInizioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
				DatePanel.add(DataInizioLbl, "cell 0 0,alignx right,aligny center");
				
				SpazioLbl = new JLabel("-");
				SpazioLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
				DatePanel.add(SpazioLbl, "cell 1 0,alignx center,aligny center");
				
				DataFineLbl = new JLabel("Data Fine");
				DataFineLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
				DatePanel.add(DataFineLbl, "cell 2 0,alignx left,aligny center");
				
				SouthPanel = new JPanel();
				SouthPanel.setBackground(new Color(246, 247, 248));
				SouthPanel.setPreferredSize(new Dimension(10, 100));
				MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
				
				IndietroBtn = new JButton("Indietro");
				IndietroBtn.setPreferredSize(new Dimension(150, 30));
				IndietroBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				SouthPanel.add(IndietroBtn, "cell 0 0,alignx left,aligny bottom");
			
	}
	
	public JLabel getNomeConferenzaLbl() {
		return NomeConferenzaLbl;
	}
	
	public JLabel getTemaLbl() {
		return TemaLbl;
	}
	
	public JLabel getDataInizioLbl() {
		return DataInizioLbl;
	}
	
	public JLabel getDataFineLbl() {
		return DataFineLbl;
	}
	
	public JLabel getDescrizioneLbl() {
		return DescrizioneLbl;
	}
	
	public JButton getIndietroBtn() {
		return IndietroBtn;
	}
}