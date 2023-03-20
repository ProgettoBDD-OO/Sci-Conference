package GUI;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommentoBachecaFrame extends JFrame {
	
	private JToggleButton TemaAmbienteBtn;
	private JToggleButton TemaSostenibilitàBtn;
	private JToggleButton TemaFisicaBtn;
	private JToggleButton TemaGeologiaBtn;
	private JToggleButton TemaChimicaBtn;
	private JToggleButton TemaMatematicaBtn;
	private JToggleButton TemaAstrologiaBtn;
	private JToggleButton TemaAltroBtn;
	private JButton annullaCommentoBachecaBtn; 
	private JTextField NomeConfTxt;

	public CommentoBachecaFrame(String Titolo) {
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
		MainPanel.setBackground(new Color(246, 247, 248));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		
		
//__________________________________________________________________Pannello Nord
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(new Color(246, 247, 248));
		NorthPanel.setPreferredSize(new Dimension(10, 125));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));
		
			JLabel ProposteLbl1 = new JLabel("Aggiungi la tua idea per una conferenza!");
			ProposteLbl1.setForeground(new Color(20, 30, 40));
			ProposteLbl1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			NorthPanel.add(ProposteLbl1, "cell 0 0,alignx center,growy");
			
			JLabel ProposteLbl2 = new JLabel("La tua proposta potrà essere vista sulla bacheca e presa in considerazione.\r\n");
			ProposteLbl2.setForeground(new Color(20, 30, 40));
			ProposteLbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			NorthPanel.add(ProposteLbl2, "cell 0 1,alignx center,growy");
		
		
		
//__________________________________________________________________Pannello Centrale
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(246, 247, 248));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BorderLayout(0, 0));
		
		
			JPanel InfoPanel = new JPanel();
			InfoPanel.setPreferredSize(new Dimension(10, 300));
			InfoPanel.setBackground(new Color(246, 247, 248));
			CentrPanel.add(InfoPanel, BorderLayout.NORTH);
			InfoPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][][::25px]15[::30px][60px:n]15[::30px]"));
					
					JSeparator separator = new JSeparator();
					separator.setForeground(new Color(0, 0, 200));
					separator.setPreferredSize(new Dimension(650, 2));
					InfoPanel.add(separator, "cell 0 0,alignx center,aligny center");
				
					JLabel NomeConfLbl = new JLabel("Nome:");
					NomeConfLbl.setForeground(new Color(20, 30, 40));
					NomeConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
					InfoPanel.add(NomeConfLbl, "cell 0 1,alignx left,aligny bottom");
				
				NomeConfTxt = new JTextField();
				NomeConfTxt.setForeground(new Color(0, 0, 200));
				NomeConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(150, 154, 158)));
				NomeConfTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				InfoPanel.add(NomeConfTxt, "cell 0 2,alignx left,growy");
				NomeConfTxt.setColumns(20);
				
				JLabel DescrizioneConfLbl = new JLabel("Descrizione:");
				DescrizioneConfLbl.setForeground(new Color(20, 30, 40));
				DescrizioneConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				InfoPanel.add(DescrizioneConfLbl, "cell 0 3,alignx left,aligny bottom");
				
				JTextArea DescrizioneConfTxt = new JTextArea();
				DescrizioneConfTxt.setForeground(new Color(0, 0, 200));
				DescrizioneConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(150, 154, 158)));
				DescrizioneConfTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				DescrizioneConfTxt.setPreferredSize(new Dimension(400, 22));
				InfoPanel.add(DescrizioneConfTxt, "cell 0 4,alignx left,growy");
				
				JLabel TemaConfLbl = new JLabel("Tema:");
				TemaConfLbl.setForeground(new Color(20, 30, 40));
				TemaConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				InfoPanel.add(TemaConfLbl, "cell 0 5,alignx left,aligny bottom");
			
				
			JPanel TemiPanel = new JPanel();
			TemiPanel.setBorder(new EmptyBorder(5, 5, 10, 5));
			TemiPanel.setBackground(new Color(246, 247, 248));
			CentrPanel.add(TemiPanel, BorderLayout.CENTER);
			TemiPanel.setLayout(new MigLayout("wrap, fill", "[::60px][][::60px][][::60px][]", "[::50px][::50px][::50px][::50px]"));
			
				TemaAmbienteBtn = new JToggleButton("");
				TemaAmbienteBtn.setBackground(new Color(0, 200, 0));
				TemaAmbienteBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAmbienteBtn, "cell 0 0, alignx center, aligny center");
				
				JLabel TemaAmbienteLbl = new JLabel("Ambiente");
				TemaAmbienteLbl.setForeground(new Color(0, 200, 0));
				TemaAmbienteLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAmbienteLbl, "cell 1 0");
				
				TemaChimicaBtn = new JToggleButton("");
				TemaChimicaBtn.setBackground(new Color(0, 200, 255));
				TemaChimicaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaChimicaBtn, "cell 2 0, alignx center, aligny center");
				
				JLabel TemaChimicaLbl = new JLabel("Chimica");
				TemaChimicaLbl.setForeground(new Color(0, 200, 255));
				TemaChimicaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaChimicaLbl, "cell 3 0");
				
				JToggleButton TemaBiologiaBtn = new JToggleButton("");
				TemaBiologiaBtn.setBackground(new Color(0, 128, 0));
				TemaBiologiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaBiologiaBtn, "cell 4 0,alignx center,aligny center");
				
				JLabel TemaBiologiaLbl = new JLabel("Biologia");
				TemaBiologiaLbl.setForeground(new Color(0, 128, 0));
				TemaBiologiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaBiologiaLbl, "cell 5 0,alignx left,aligny center");
				
				TemaSostenibilitàBtn = new JToggleButton("");
				TemaSostenibilitàBtn.setBackground(new Color(240, 210, 0));
				TemaSostenibilitàBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaSostenibilitàBtn, "cell 0 1, alignx center, aligny center");
				
				JLabel TemaSostenibilitàLbl = new JLabel("Sostenibilità");
				TemaSostenibilitàLbl.setForeground(new Color(240, 210, 0));
				TemaSostenibilitàLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaSostenibilitàLbl, "flowx,cell 1 1");
				
				JToggleButton TemaInformaticaBtn = new JToggleButton("");
				TemaInformaticaBtn.setBackground(new Color(0, 100, 255));
				TemaInformaticaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaInformaticaBtn, "cell 2 1,alignx center,aligny center");
				
				JLabel TemaInformaticaLbl = new JLabel("Informatica");
				TemaInformaticaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemaInformaticaLbl.setForeground(new Color(0, 100, 255));
				TemiPanel.add(TemaInformaticaLbl, "cell 3 1,alignx left,aligny center");
				
				JToggleButton TemaAnatomiaBtn = new JToggleButton("");
				TemaAnatomiaBtn.setBackground(new Color(250, 88, 80));
				TemaAnatomiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAnatomiaBtn, "cell 4 1,alignx center,aligny center");
				
				JLabel TemaAnatomiaLbl = new JLabel("Anatomia");
				TemaAnatomiaLbl.setForeground(new Color(250, 88, 80));
				TemaAnatomiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAnatomiaLbl, "cell 5 1,alignx left,aligny center");
				
				TemaFisicaBtn = new JToggleButton("");
				TemaFisicaBtn.setBackground(new Color(250, 80, 0));
				TemaFisicaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaFisicaBtn, "cell 0 2, alignx center, aligny center");
				
				JLabel TemaFisicaLbl = new JLabel("Fisica");
				TemaFisicaLbl.setForeground(new Color(250, 80, 0));
				TemaFisicaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaFisicaLbl, "flowx,cell 1 2");
				
				TemaMatematicaBtn = new JToggleButton("");
				TemaMatematicaBtn.setBackground(new Color(0, 0, 200));
				TemaMatematicaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaMatematicaBtn, "cell 2 2,alignx center,aligny center");
				
				JLabel TemaMatematicaLbl = new JLabel("Matematica");
				TemaMatematicaLbl.setForeground(new Color(0, 0, 200));
				TemaMatematicaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaMatematicaLbl, "cell 3 2");
				
				JToggleButton TemaPsicologiaBtn = new JToggleButton("");
				TemaPsicologiaBtn.setBackground(new Color(255, 0, 128));
				TemaPsicologiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaPsicologiaBtn, "cell 4 2,alignx center,aligny center");
				
				JLabel TemaPsicologiaLbl = new JLabel("Psicologia");
				TemaPsicologiaLbl.setForeground(new Color(255, 0, 128));
				TemaPsicologiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaPsicologiaLbl, "cell 5 2,alignx left,aligny center");
				
				TemaGeologiaBtn = new JToggleButton("");
				TemaGeologiaBtn.setBackground(new Color(180, 100, 40));
				TemaGeologiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaGeologiaBtn, "cell 0 3, alignx center, aligny center");
				
				JLabel TemaGeologiaLbl = new JLabel("Geologia");
				TemaGeologiaLbl.setForeground(new Color(180, 100, 40));
				TemaGeologiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaGeologiaLbl, "cell 1 3");
				
				TemaAstrologiaBtn = new JToggleButton("");
				TemaAstrologiaBtn.setBackground(new Color(30, 30, 120));
				TemaAstrologiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAstrologiaBtn, "cell 2 3,alignx center,aligny center");
				
				JLabel TemaAstrologiaLbl = new JLabel("Astrologia");
				TemaAstrologiaLbl.setForeground(new Color(30, 30, 120));
				TemaAstrologiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAstrologiaLbl, "cell 3 3");
				
				TemaAltroBtn = new JToggleButton("");
				TemaAltroBtn.setBackground(new Color(125, 130, 135));
				TemaAltroBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAltroBtn, "cell 4 3,alignx center,aligny center");
				
				JLabel TemaAltroLbl = new JLabel("Altro");
				TemaAltroLbl.setForeground(new Color(125, 130, 135));
				TemaAltroLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAltroLbl, "cell 5 3,alignx left,aligny center");
				
		
		
//__________________________________________________________________Pannello Nord
		
		JPanel SouthPanel = new JPanel();
		SouthPanel.setBackground(new Color(246, 247, 248));
		SouthPanel.setPreferredSize(new Dimension(10, 100));
		MainPanel.add(SouthPanel, BorderLayout.SOUTH);
		SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
		
			annullaCommentoBachecaBtn = new JButton("Annulla");
			annullaCommentoBachecaBtn.setPreferredSize(new Dimension(120, 30));
			SouthPanel.add(annullaCommentoBachecaBtn, "cell 0 0,alignx right,aligny bottom");
			
			JButton PubblicaBtn = new JButton("Conferma\r\n");
			PubblicaBtn.setPreferredSize(new Dimension(120, 30));
			SouthPanel.add(PubblicaBtn, "cell 1 0,alignx left,aligny bottom");
		
	}
	
	
	public JToggleButton getTemaAmbienteBtn() {
		return TemaAmbienteBtn;
	}
	
	public JToggleButton getTemaFisicaBtn() {
		return TemaFisicaBtn;
	}
	
	public JToggleButton getTemaChimicaBtn() {
		return TemaChimicaBtn;
	}
	
	public JToggleButton getTemaMatematicaBtn() {
		return TemaMatematicaBtn;
	}
	
	public JToggleButton getTemaSostenibilitàBtn() {
		return TemaSostenibilitàBtn;
	}
	
	public JToggleButton getTemaAltroBtn() {
		return TemaAltroBtn;
	}
	
	public JButton getIndietroCommentoBachecaBtn() {
		return annullaCommentoBachecaBtn;
	}
}