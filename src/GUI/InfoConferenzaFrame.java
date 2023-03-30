package GUI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EmptyBorder;

import linker.ControllerLink;
import myTools.myTemplates;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.CardLayout;

public class InfoConferenzaFrame extends JFrame {
	
	private ControllerLink controllerLink;

	private myTemplates t = new myTemplates();
	
	private JLabel NomeConferenzaLbl;
	private JPanel NorthCentrPanel;
	private JLabel TemaLbl;
	private JLabel DataInizioLbl;
	private JLabel SpazioLbl;
	private JLabel DataFineLbl;
	private JTextArea DescrizioneLbl;
	
	private JPanel CentrPanel;
	
	private JPanel SouthPanel;
	
	private JButton IndietroBtn;
	
	private CardLayout IscrizioneCardLayout;
	private JPanel IscrizioneCardPanel;
	private JButton IscrivitiBtn;
	private JPanel IscrivitiBtnConteiner;
	private JLabel GiàIscrittoLbl;
	
	public InfoConferenzaFrame(String Titolo, ControllerLink contr) {
		
		controllerLink = contr;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
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
					
					DescrizioneLbl = new JTextArea("Descrizione");
					DescrizioneLbl.setLineWrap(true);
					DescrizioneLbl.setBorder(null);
					DescrizioneLbl.setWrapStyleWord(true);
					DescrizioneLbl.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
					DescrizioneLbl.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
					DescrizioneLbl.setPreferredSize(new Dimension(54, 50));
					DescrizioneLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
					DescrizioneLbl.setBackground(t.lGray);
					NorthPanel.add(DescrizioneLbl, BorderLayout.SOUTH);
				
				
			CentrPanel = new JPanel();
			CentrPanel.setBackground(new Color(246, 247, 248));
			CentrPanel.setLayout(new BoxLayout(CentrPanel, BoxLayout.Y_AXIS));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			
			
			SouthPanel = new JPanel();
			SouthPanel.setBackground(new Color(246, 247, 248));
			SouthPanel.setPreferredSize(new Dimension(10, 50));
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][grow]", "[grow]"));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);
				
					IndietroBtn = new JButton("Indietro");
					IndietroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					IndietroBtn.setPreferredSize(new Dimension(150, 30));
					IndietroBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					IndietroBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controllerLink.backFromConferenza(controllerLink.getFramePrecedente());
						}
					});
					SouthPanel.add(IndietroBtn, "cell 0 0,alignx left,growy");
					
					IscrizioneCardLayout = new CardLayout(0, 0);
					
					IscrizioneCardPanel = new JPanel();
					IscrizioneCardPanel.setBackground(new Color(246, 247, 248));
					SouthPanel.add(IscrizioneCardPanel, "cell 1 0,grow");
					IscrizioneCardPanel.setLayout(IscrizioneCardLayout);
					
					IscrivitiBtnConteiner = new JPanel();
					IscrivitiBtnConteiner.setBackground(new Color(246, 247, 248));
					IscrizioneCardPanel.add(IscrivitiBtnConteiner, "1");
					IscrivitiBtnConteiner.setLayout(new BorderLayout(0, 0));
					
					IscrivitiBtn = new JButton("Iscriviti");
					IscrivitiBtnConteiner.add(IscrivitiBtn, BorderLayout.EAST);
					IscrivitiBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					IscrivitiBtn.setForeground(new Color(255, 255, 255));
					IscrivitiBtn.setBackground(new Color(0, 0, 200));
					IscrivitiBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
					IscrivitiBtn.setPreferredSize(new Dimension(150, 30));
					
					IscrivitiBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controllerLink.goToIscrizione();
						}
					});
					
					GiàIscrittoLbl = new JLabel("Sei gia iscritto a questa conferenza");
					GiàIscrittoLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					GiàIscrittoLbl.setHorizontalAlignment(SwingConstants.RIGHT);
					GiàIscrittoLbl.setBackground(new Color(246, 247, 248));
					IscrizioneCardPanel.add(GiàIscrittoLbl, "2");
	}
	
	public JLabel getNomeConferenzaLbl() { return NomeConferenzaLbl; }
	
	public JLabel getTemaLbl() { return TemaLbl; }
	
	public JLabel getDataInizioLbl() { return DataInizioLbl; }
	
	public JLabel getDataFineLbl() { return DataFineLbl; }
	
	public JTextArea getDescrizioneLbl() { return DescrizioneLbl; }
	
	
	public JButton getIndietroBtn() { return IndietroBtn; }
	
	public CardLayout getIscrizioneCardLayout() { return IscrizioneCardLayout; }
	
	public JPanel getIscrizioneCardPanel() { return IscrizioneCardPanel; }
}