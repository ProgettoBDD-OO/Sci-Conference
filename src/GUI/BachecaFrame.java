package GUI;

import linker.ControllerLink;
import myTools.myTemplates;
import myTools.myRadioBtn;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BachecaFrame extends JFrame {
	
	private ControllerLink controllerLink;
	
	private myTemplates t = new myTemplates();
	
	private JTextField NomeConfTxt;
	private JTextArea DescrizioneConfTxt;
	
	private final ButtonGroup buttonGroup;
	
	private JButton AnnullaBachecaBtn; 
	private JButton ConfermaBtn;

	public BachecaFrame(String Titolo, ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.MiniLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
//__________________________________________________________________Pannello Nord
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(t.lGray);
		NorthPanel.setPreferredSize(new Dimension(10, 125));
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		
			JLabel ProposteLbl1 = new JLabel("Aggiungi la tua idea per una conferenza!");
			ProposteLbl1.setForeground(t.tangaroa);
			ProposteLbl1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
			NorthPanel.add(ProposteLbl1, "cell 0 0,alignx center,growy");
			
			JLabel ProposteLbl2 = new JLabel("La tua proposta potrà essere visualizzata sulla bacheca e presa in considerazione.\r\n");
			ProposteLbl2.setForeground(t.tangaroa);
			ProposteLbl2.setFont(new Font("Calibri Light", Font.PLAIN, 20));
			NorthPanel.add(ProposteLbl2, "cell 0 1,alignx center,growy");
			
			
			
//__________________________________________________________________Pannello Centrale
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(255, 255, 255));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BorderLayout(0, 0));
		
		
			JPanel InfoPanel = new JPanel();
			InfoPanel.setPreferredSize(new Dimension(10, 300));
			InfoPanel.setBackground(new Color(255, 255, 255));
			CentrPanel.add(InfoPanel, BorderLayout.NORTH);
			InfoPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][::25px]15[::30px][60px:n]15[::30px]"));
					
						JLabel NomeConfLbl = new JLabel("Nome:");
						NomeConfLbl.setForeground(t.scBlue);
						NomeConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
						InfoPanel.add(NomeConfLbl, "cell 0 0,alignx left,aligny bottom");
					
						NomeConfTxt = new JTextField();
						NomeConfTxt.setForeground(t.tangaroa);
						NomeConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
						NomeConfTxt.setFont(new Font("Calibri Light", Font.PLAIN, 18));
						InfoPanel.add(NomeConfTxt, "cell 0 1,alignx left,growy");
						NomeConfTxt.setColumns(20);
					
					JLabel DescrizioneConfLbl = new JLabel("Descrizione:");
					DescrizioneConfLbl.setForeground(t.scBlue);
					DescrizioneConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					InfoPanel.add(DescrizioneConfLbl, "cell 0 2,alignx left,aligny bottom");
					
					DescrizioneConfTxt = new JTextArea();
					DescrizioneConfTxt.setLineWrap(true);
					DescrizioneConfTxt.setWrapStyleWord(true);
					DescrizioneConfTxt.setForeground(t.tangaroa);
					DescrizioneConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
					DescrizioneConfTxt.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					DescrizioneConfTxt.setPreferredSize(new Dimension(400, 22));
					InfoPanel.add(DescrizioneConfTxt, "cell 0 3,alignx left,growy");
					
					JLabel TemaConfLbl = new JLabel("Tema:");
					TemaConfLbl.setForeground(t.scBlue);
					TemaConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					InfoPanel.add(TemaConfLbl, "cell 0 4,alignx left,aligny bottom");
					
					
			JPanel TemiPanel = new JPanel();
			TemiPanel.setBackground(new Color(255, 255, 255));
			CentrPanel.add(TemiPanel, BorderLayout.CENTER);
			TemiPanel.setLayout(new MigLayout("wrap, fill", "[][][]", "[::50px][::50px][::50px][::50px]"));
			
				buttonGroup = new ButtonGroup();
					
					myRadioBtn TemaAmbienteLbl = new myRadioBtn("Ambiente", new Color(0, 200, 0), 18);
					buttonGroup.add(TemaAmbienteLbl);
					TemiPanel.add(TemaAmbienteLbl, "cell 0 0, alignx left, aligny center");
					
					myRadioBtn TemaChimicaLbl = new myRadioBtn("Chimica", new Color(0, 200, 255), 18);
					buttonGroup.add(TemaChimicaLbl);
					TemiPanel.add(TemaChimicaLbl, "cell 1 0, alignx left, aligny center");
					
					myRadioBtn TemaBiologiaLbl = new myRadioBtn("Biologia", new Color(0, 128, 0), 18);
					buttonGroup.add(TemaBiologiaLbl);
					TemiPanel.add(TemaBiologiaLbl, "cell 2 0, alignx left, aligny center");
					
					myRadioBtn TemaSostenibilitàLbl = new myRadioBtn("Sostenibilità", new Color(240, 210, 0), 18);
					buttonGroup.add(TemaSostenibilitàLbl);
					TemiPanel.add(TemaSostenibilitàLbl, "cell 0 1, alignx left, aligny center");
					
					myRadioBtn TemaInformaticaLbl = new myRadioBtn("Informatica", new Color(0, 100, 255), 18);
					buttonGroup.add(TemaInformaticaLbl);
					TemiPanel.add(TemaInformaticaLbl, "cell 1 1, alignx left,aligny center");
					
					myRadioBtn TemaAnatomiaLbl = new myRadioBtn("Anatomia", new Color(250, 88, 80), 18);
					buttonGroup.add(TemaAnatomiaLbl);
					TemiPanel.add(TemaAnatomiaLbl, "cell 2 1, alignx left,aligny center");
					
					myRadioBtn TemaFisicaLbl = new myRadioBtn("Fisica", new Color(250, 80, 0), 18);
					buttonGroup.add(TemaFisicaLbl);
					TemiPanel.add(TemaFisicaLbl, "cell 0 2, alignx left, aligny center");
					
					myRadioBtn TemaMatematicaLbl = new myRadioBtn("Matematica", t.scBlue, 18);
					buttonGroup.add(TemaMatematicaLbl);
					TemiPanel.add(TemaMatematicaLbl, "cell 1 2, alignx left, aligny center");
					
					myRadioBtn TemaPsicologiaLbl = new myRadioBtn("Psicologia", new Color(255, 0, 128), 18);
					buttonGroup.add(TemaPsicologiaLbl);
					TemiPanel.add(TemaPsicologiaLbl, "cell 2 2, alignx left, aligny center");
					TemaPsicologiaLbl.setActionCommand("Psicologia");
					
					myRadioBtn TemaGeologiaLbl = new myRadioBtn("Geologia", new Color(180, 100, 40), 18);
					buttonGroup.add(TemaGeologiaLbl);
					TemiPanel.add(TemaGeologiaLbl, "cell 0 3, alignx left, aligny center");
					
					myRadioBtn TemaAstrologiaLbl = new myRadioBtn("Astrologia", new Color(30, 30, 120), 18);
					buttonGroup.add(TemaAstrologiaLbl);
					TemiPanel.add(TemaAstrologiaLbl, "cell 1 3, alignx left, aligny center");
					
					myRadioBtn TemaAltroLbl = new myRadioBtn("Altro", t.altGray, 18);
					buttonGroup.add(TemaAltroLbl);
					TemiPanel.add(TemaAltroLbl, "cell 2 3, alignx left, aligny center");
					
					
					
//__________________________________________________________________Pannello Nord
		
		JPanel SouthPanel = new JPanel();
		SouthPanel.setBackground(t.lGray);
		SouthPanel.setPreferredSize(new Dimension(10, 100));
		MainPanel.add(SouthPanel, BorderLayout.SOUTH);
		SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
		
			AnnullaBachecaBtn = new JButton("Annulla");
			AnnullaBachecaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			AnnullaBachecaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			AnnullaBachecaBtn.setPreferredSize(new Dimension(150, 35));
			AnnullaBachecaBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.backFromBacheca();
				}
			});
			SouthPanel.add(AnnullaBachecaBtn, "cell 0 0,alignx right,aligny bottom");
			
			ConfermaBtn = new JButton("Conferma\r\n");
			ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ConfermaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			ConfermaBtn.setForeground(t.white);
			ConfermaBtn.setBackground(t.scBlue);
			ConfermaBtn.setPreferredSize(new Dimension(150, 35));
			ConfermaBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.confermaBacheca();
				}
			});
			SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
	}
	
	public ButtonGroup getButtonGroup() { return buttonGroup; }
	
	public String getNomeConfTxt() { return NomeConfTxt.getText(); }
	
	public String getDescrizioneConfTxt() { return DescrizioneConfTxt.getText(); }
	
	public JButton getIndietroCommentoBachecaBtn() { return AnnullaBachecaBtn; }
	
	public JButton getPubblicaBtn() { return ConfermaBtn; }
}