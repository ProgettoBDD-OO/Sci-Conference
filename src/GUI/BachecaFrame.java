package GUI;

import linker.ControllerLink;
import myTools.myColors;
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
	
	private myColors c = new myColors();
	
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

		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(10, 7, 7, 7));
		MainPanel.setBackground(c.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		
		
//__________________________________________________________________Pannello Nord
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(c.lGray);
		NorthPanel.setPreferredSize(new Dimension(10, 125));
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		
			JLabel ProposteLbl1 = new JLabel("Aggiungi la tua idea per una conferenza!");
			ProposteLbl1.setForeground(c.tangaroa);
			ProposteLbl1.setFont(new Font("Calibri Light", Font.PLAIN, 24));
			NorthPanel.add(ProposteLbl1, "cell 0 0,alignx center,growy");
			
			JLabel ProposteLbl2 = new JLabel("La tua proposta potrà essere visualizzata sulla bacheca e presa in considerazione.\r\n");
			ProposteLbl2.setForeground(c.tangaroa);
			ProposteLbl2.setFont(new Font("Calibri Light", Font.PLAIN, 20));
			NorthPanel.add(ProposteLbl2, "cell 0 1,alignx center,growy");
			
			
			
//__________________________________________________________________Pannello Centrale
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(c.lGray);
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BorderLayout(0, 0));
		
		
			JPanel InfoPanel = new JPanel();
			InfoPanel.setPreferredSize(new Dimension(10, 300));
			InfoPanel.setBackground(c.lGray);
			CentrPanel.add(InfoPanel, BorderLayout.NORTH);
			InfoPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][::25px]15[::30px][60px:n]15[::30px]"));
					
					JSeparator separator = new JSeparator();
					separator.setForeground(c.scBlue);
					separator.setPreferredSize(new Dimension(650, 2));
					InfoPanel.add(separator, "cell 0 0,alignx center,aligny center");
				
					JLabel NomeConfLbl = new JLabel("Nome:");
					NomeConfLbl.setForeground(c.tangaroa);
					NomeConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					InfoPanel.add(NomeConfLbl, "cell 0 1,alignx left,aligny bottom");
				
					NomeConfTxt = new JTextField();
					NomeConfTxt.setForeground(c.scBlue);
					NomeConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, c.altGray));
					NomeConfTxt.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					InfoPanel.add(NomeConfTxt, "cell 0 2,alignx left,growy");
					NomeConfTxt.setColumns(20);
					
					JLabel DescrizioneConfLbl = new JLabel("Descrizione:");
					DescrizioneConfLbl.setForeground(c.tangaroa);
					DescrizioneConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					InfoPanel.add(DescrizioneConfLbl, "cell 0 3,alignx left,aligny bottom");
					
					DescrizioneConfTxt = new JTextArea();
					DescrizioneConfTxt.setLineWrap(true);
					DescrizioneConfTxt.setForeground(c.scBlue);
					DescrizioneConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, c.altGray));
					DescrizioneConfTxt.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					DescrizioneConfTxt.setPreferredSize(new Dimension(400, 22));
					InfoPanel.add(DescrizioneConfTxt, "cell 0 4,alignx left,growy");
					
					JLabel TemaConfLbl = new JLabel("Tema:");
					TemaConfLbl.setForeground(c.tangaroa);
					TemaConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					InfoPanel.add(TemaConfLbl, "cell 0 5,alignx left,aligny bottom");
					
					
			JPanel TemiPanel = new JPanel();
			TemiPanel.setBackground(c.lGray);
			CentrPanel.add(TemiPanel, BorderLayout.CENTER);
			TemiPanel.setLayout(new MigLayout("wrap, fill", "[][][]", "[::50px][::50px][::50px][::50px]"));
			
				buttonGroup = new ButtonGroup();
					
					myRadioBtn TemaAmbienteLbl = new myRadioBtn("Ambiente", new Color(0, 200, 0));
					buttonGroup.add(TemaAmbienteLbl);
					TemiPanel.add(TemaAmbienteLbl, "cell 0 0, alignx left, aligny center");
					
					myRadioBtn TemaChimicaLbl = new myRadioBtn("Chimica", (Color) null);
					buttonGroup.add(TemaChimicaLbl);
					TemaChimicaLbl.setBackground(c.lGray);
					TemaChimicaLbl.setForeground(new Color(0, 200, 255));
					TemaChimicaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaChimicaLbl, "cell 1 0, alignx left, aligny center");
					
					myRadioBtn TemaBiologiaLbl = new myRadioBtn("Biologia", (Color) null);
					buttonGroup.add(TemaBiologiaLbl);
					TemaBiologiaLbl.setBackground(c.lGray);
					TemaBiologiaLbl.setForeground(new Color(0, 128, 0));
					TemaBiologiaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaBiologiaLbl, "cell 2 0, alignx left, aligny center");
					
					myRadioBtn TemaSostenibilitàLbl = new myRadioBtn("Sostenibilità", (Color) null);
					buttonGroup.add(TemaSostenibilitàLbl);
					TemaSostenibilitàLbl.setBackground(c.lGray);
					TemaSostenibilitàLbl.setForeground(new Color(240, 210, 0));
					TemaSostenibilitàLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaSostenibilitàLbl, "cell 0 1, alignx left, aligny center");
					
					myRadioBtn TemaInformaticaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaInformaticaLbl);
					TemaInformaticaLbl.setBackground(c.lGray);
					TemaInformaticaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemaInformaticaLbl.setForeground(new Color(0, 100, 255));
					TemiPanel.add(TemaInformaticaLbl, "cell 1 1, alignx left,aligny center");
					
					myRadioBtn TemaAnatomiaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaAnatomiaLbl);
					TemaAnatomiaLbl.setBackground(c.lGray);
					TemaAnatomiaLbl.setForeground(new Color(250, 88, 80));
					TemaAnatomiaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaAnatomiaLbl, "cell 2 1, alignx left,aligny center");
					
					myRadioBtn TemaFisicaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaFisicaLbl);
					TemaFisicaLbl.setBackground(c.lGray);
					TemaFisicaLbl.setForeground(new Color(250, 80, 0));
					TemaFisicaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaFisicaLbl, "cell 0 2, alignx left, aligny center");
					
					myRadioBtn TemaMatematicaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaMatematicaLbl);
					TemaMatematicaLbl.setBackground(c.lGray);
					TemaMatematicaLbl.setForeground(c.scBlue);
					TemaMatematicaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaMatematicaLbl, "cell 1 2, alignx left, aligny center");
					
					myRadioBtn TemaPsicologiaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaPsicologiaLbl);
					TemaPsicologiaLbl.setBackground(c.lGray);
					TemaPsicologiaLbl.setForeground(new Color(255, 0, 128));
					TemaPsicologiaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaPsicologiaLbl, "cell 2 2, alignx left, aligny center");
					TemaPsicologiaLbl.setActionCommand("Psicologia");
					
					myRadioBtn TemaGeologiaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaGeologiaLbl);
					TemaGeologiaLbl.setBackground(c.lGray);
					TemaGeologiaLbl.setForeground(new Color(180, 100, 40));
					TemaGeologiaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaGeologiaLbl, "cell 0 3, alignx left, aligny center");
					
					myRadioBtn TemaAstrologiaLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaAstrologiaLbl);
					TemaAstrologiaLbl.setBackground(c.lGray);
					TemaAstrologiaLbl.setForeground(new Color(30, 30, 120));
					TemaAstrologiaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaAstrologiaLbl, "cell 1 3, alignx left, aligny center");
					
					myRadioBtn TemaAltroLbl = new myRadioBtn((String) null, (Color) null);
					buttonGroup.add(TemaAltroLbl);
					TemaAltroLbl.setBackground(c.lGray);
					TemaAltroLbl.setForeground(c.altGray);
					TemaAltroLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					TemiPanel.add(TemaAltroLbl, "cell 2 3, alignx left, aligny center");
					
					
					
//__________________________________________________________________Pannello Nord
		
		JPanel SouthPanel = new JPanel();
		SouthPanel.setBackground(c.lGray);
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
			ConfermaBtn.setForeground(c.white);
			ConfermaBtn.setBackground(c.scBlue);
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