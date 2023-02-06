package GUI;
<<<<<<< HEAD
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
=======

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextPane;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class CommentoBachecaFrame extends JFrame {
	private final JLabel TemaTestoLbl = new JLabel("Seleziona il Tema:");
	private JButton annullaCommentoBachecaBtn;
	private JButton TemaAmbienteBtn;
	private JButton TemaFisicaBtn;
	private JButton TemaChimicaBtn;
	private JButton TemaMatematicaBtn;
	private JButton TemaSostenibilitàBtn;
	private JButton TemaAltroBtn;
	private JPanel TemaSelezionatoPanel;
>>>>>>> ad49237d0132d715413b07616f00ba071df1a6fa
	
	public CommentoBachecaFrame(String Titolo) {
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 850);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		
<<<<<<< HEAD
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
			NorthPanel.add(ProposteLbl1, "cell 0 0,alignx center,aligny center");
			
			JLabel ProposteLbl2 = new JLabel("La tua proposta potrà essere vista sulla bacheca e presa in considerazione.\r\n");
			ProposteLbl2.setForeground(new Color(20, 30, 40));
			ProposteLbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			NorthPanel.add(ProposteLbl2, "cell 0 1,alignx center,aligny center");
		
		
		
//__________________________________________________________________Pannello Centrale
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(246, 247, 248));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BorderLayout(0, 0));
		
		
			JPanel InfoPanel = new JPanel();
			InfoPanel.setPreferredSize(new Dimension(10, 300));
			InfoPanel.setBackground(new Color(246, 247, 248));
			CentrPanel.add(InfoPanel, BorderLayout.NORTH);
			InfoPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::60px][::25px]15[::30px][]15[::30px]"));
			
				JLabel NomeConfLbl = new JLabel("Nome:");
				NomeConfLbl.setForeground(new Color(20, 30, 40));
				NomeConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				InfoPanel.add(NomeConfLbl, "cell 0 0,alignx left,aligny bottom");
				
				NomeConfTxt = new JTextField();
				NomeConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(150, 154, 158)));
				NomeConfTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				InfoPanel.add(NomeConfTxt, "cell 0 1,alignx left,growy");
				NomeConfTxt.setColumns(20);
				
				JLabel DescrizioneConfLbl = new JLabel("Descrizione:");
				DescrizioneConfLbl.setForeground(new Color(20, 30, 40));
				DescrizioneConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				InfoPanel.add(DescrizioneConfLbl, "cell 0 2,alignx left,aligny bottom");
				
				JTextArea DescrizioneConfTxt = new JTextArea();
				DescrizioneConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(150, 154, 158)));
				DescrizioneConfTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
				DescrizioneConfTxt.setPreferredSize(new Dimension(400, 22));
				InfoPanel.add(DescrizioneConfTxt, "cell 0 3,alignx left,growy");
				
				JLabel TemaConfLbl = new JLabel("Tema:");
				TemaConfLbl.setForeground(new Color(20, 30, 40));
				TemaConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				InfoPanel.add(TemaConfLbl, "cell 0 4,alignx left,aligny bottom");
			
				
			JPanel TemiPanel = new JPanel();
			TemiPanel.setBorder(new EmptyBorder(5, 5, 10, 5));
			TemiPanel.setBackground(new Color(246, 247, 248));
			CentrPanel.add(TemiPanel, BorderLayout.CENTER);
			TemiPanel.setLayout(new MigLayout("wrap, fill", "[::60px][][::60px][]", "[::50px][::50px][::50px][::50px]"));
			
				TemaAmbienteBtn = new JToggleButton("");
				TemaAmbienteBtn.setBackground(new Color(0, 200, 0));
				TemaAmbienteBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAmbienteBtn, "cell 0 0, alignx center, aligny center");
				
				JLabel TemaAmbienteLbl = new JLabel("Ambiente");
				TemaAmbienteLbl.setForeground(new Color(0, 200, 0));
				TemaAmbienteLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAmbienteLbl, "cell 1 0");
				
				TemaChimicaBtn = new JToggleButton("");
				TemaChimicaBtn.setBackground(new Color(0, 150, 220));
				TemaChimicaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaChimicaBtn, "cell 2 0, alignx center, aligny center");
				
				JLabel TemaChimicaLbl = new JLabel("Chimica");
				TemaChimicaLbl.setForeground(new Color(0, 150, 220));
				TemaChimicaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaChimicaLbl, "cell 3 0");
				
				TemaSostenibilitàBtn = new JToggleButton("");
				TemaSostenibilitàBtn.setBackground(new Color(240, 210, 0));
				TemaSostenibilitàBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaSostenibilitàBtn, "cell 0 1, alignx center, aligny center");
				
				JLabel TemaSostenibilitàLbl = new JLabel("Sostenibilità");
				TemaSostenibilitàLbl.setForeground(new Color(240, 210, 0));
				TemaSostenibilitàLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaSostenibilitàLbl, "cell 1 1");
				
				TemaMatematicaBtn = new JToggleButton("");
				TemaMatematicaBtn.setBackground(new Color(0, 0, 200));
				TemaMatematicaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaMatematicaBtn, "cell 2 1, alignx center, aligny center");
				
				JLabel TemaMatematicaLbl = new JLabel("Matematica");
				TemaMatematicaLbl.setForeground(new Color(0, 0, 200));
				TemaMatematicaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaMatematicaLbl, "cell 3 1");
				
				TemaFisicaBtn = new JToggleButton("");
				TemaFisicaBtn.setBackground(new Color(250, 80, 0));
				TemaFisicaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaFisicaBtn, "cell 0 2, alignx center, aligny center");
				
				JLabel TemaFisicaLbl = new JLabel("Fisica");
				TemaFisicaLbl.setForeground(new Color(250, 80, 0));
				TemaFisicaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaFisicaLbl, "cell 1 2");
				
				TemaAstrologiaBtn = new JToggleButton("");
				TemaAstrologiaBtn.setBackground(new Color(30, 30, 120));
				TemaAstrologiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAstrologiaBtn, "cell 2 2, alignx center, aligny center");
				
				JLabel TemaAstrologiaLbl = new JLabel("Astrologia");
				TemaAstrologiaLbl.setForeground(new Color(30, 30, 120));
				TemaAstrologiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAstrologiaLbl, "cell 3 2");
				
				TemaGeologiaBtn = new JToggleButton("");
				TemaGeologiaBtn.setBackground(new Color(180, 100, 40));
				TemaGeologiaBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaGeologiaBtn, "cell 0 3, alignx center, aligny center");
				
				JLabel TemaGeologiaLbl = new JLabel("Geologia");
				TemaGeologiaLbl.setForeground(new Color(180, 100, 40));
				TemaGeologiaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaGeologiaLbl, "cell 1 3");
				
				TemaAltroBtn = new JToggleButton("");
				TemaAltroBtn.setBackground(new Color(125, 130, 135));
				TemaAltroBtn.setPreferredSize(new Dimension(33, 33));
				TemiPanel.add(TemaAltroBtn, "cell 2 3, alignx center, aligny center");
				
				JLabel TemaAltroLbl = new JLabel("Altro");
				TemaAltroLbl.setForeground(new Color(125, 130, 135));
				TemaAltroLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TemiPanel.add(TemaAltroLbl, "cell 3 3");
				
		
		
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
=======
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\bottf\\Documenti\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		//_____________________________________________Logo superiore
		
		JPanel CommentoBachecaPanel = new JPanel();
		CommentoBachecaPanel.setBackground(new Color(232, 232, 232));
		setContentPane(CommentoBachecaPanel);
		CommentoBachecaPanel.setLayout(new MigLayout("wrap,fill", "[grow]", "[::100px][::50px]2[::57.00px]2[][][][][::180px,grow][::200px][]"));
		
		JLabel LogoCommentoBacheca = new JLabel("");
		CommentoBachecaPanel.add(LogoCommentoBacheca, "cell 0 0,alignx right,aligny center");
		LogoCommentoBacheca.setPreferredSize(new Dimension(530, 140));
		LogoCommentoBacheca.setBounds(new Rectangle(300, 11, 300, 80));
		
		ImageIcon LogoCB = new ImageIcon("C:\\Users\\bottf\\Documenti\\logo.png");
		Image img = LogoCB.getImage();
		Image imgScale = img.getScaledInstance(LogoCommentoBacheca.getWidth(), LogoCommentoBacheca.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
		LogoCommentoBacheca.setIcon(scaledIcon);
		
		//_____________________________________________Testi superiori
		
		JLabel PropostaTestoLbl1 = new JLabel("Proponi la tua idea in merito alle Conferenze!");
		PropostaTestoLbl1.setForeground(new Color(0, 0, 160));
		PropostaTestoLbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
		PropostaTestoLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		PropostaTestoLbl1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CommentoBachecaPanel.add(PropostaTestoLbl1, "cell 0 1,alignx left,aligny center");
		
		JLabel PropostaTestoLbl2 = new JLabel("Questa sarà poi pubblicata in Bacheca ed eventualmente presa in considerazione");
		PropostaTestoLbl2.setForeground(new Color(0, 0, 160));
		PropostaTestoLbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PropostaTestoLbl2.setHorizontalAlignment(SwingConstants.CENTER);
		PropostaTestoLbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
		CommentoBachecaPanel.add(PropostaTestoLbl2, "cell 0 2,alignx left,aligny center");
		
		//_____________________________________________Area commento
		
		JTextPane PannelloCommento = new JTextPane();
		PannelloCommento.setPreferredSize(new Dimension(600, 300));
		PannelloCommento.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 220)));
		PannelloCommento.setBackground(new Color(81, 82, 83));
		PannelloCommento.setMargin(new Insets(5, 5, 5, 5));
		CommentoBachecaPanel.add(PannelloCommento, "cell 0 4,alignx left,aligny center");
		CommentoBachecaPanel.add(TemaTestoLbl, "cell 0 6,aligny top");
		TemaTestoLbl.setForeground(new Color(0, 0, 160));
		TemaTestoLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		//_____________________________________________Area selezione tema
		
		JPanel TemiPanel = new JPanel();
		TemiPanel.setBackground(new Color(221, 221, 221));
		CommentoBachecaPanel.add(TemiPanel, "cell 0 7,grow");
		SpringLayout sl_TemiPanel = new SpringLayout();
		TemiPanel.setLayout(sl_TemiPanel);
		
		TemaAmbienteBtn = new JButton("");
		TemaAmbienteBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaAmbienteBtn, 10, SpringLayout.NORTH, TemiPanel);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaAmbienteBtn, 10, SpringLayout.WEST, TemiPanel);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaAmbienteBtn, 58, SpringLayout.NORTH, TemiPanel);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaAmbienteBtn, 58, SpringLayout.WEST, TemiPanel);
		TemaAmbienteBtn.setBackground(new Color(0, 255, 0));
		TemaAmbienteBtn.setOpaque(true);
		TemiPanel.add(TemaAmbienteBtn);
		
		JLabel TemaAmbienteLbl = new JLabel("AMBIENTE");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaAmbienteLbl, 25, SpringLayout.NORTH, TemiPanel);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaAmbienteLbl, 14, SpringLayout.EAST, TemaAmbienteBtn);
		TemaAmbienteLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaAmbienteLbl);
		
		
		TemaFisicaBtn = new JButton("");
		TemaFisicaBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaFisicaBtn, 6, SpringLayout.SOUTH, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaFisicaBtn, 0, SpringLayout.WEST, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaFisicaBtn, 54, SpringLayout.SOUTH, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaFisicaBtn, 0, SpringLayout.EAST, TemaAmbienteBtn);
		TemaFisicaBtn.setOpaque(true);
		TemaFisicaBtn.setBackground(new Color(210, 0, 0));
		TemiPanel.add(TemaFisicaBtn);
		
		JLabel TemaFisicaLbl = new JLabel("FISICA");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaFisicaLbl, 28, SpringLayout.SOUTH, TemaAmbienteLbl);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaFisicaLbl, 0, SpringLayout.WEST, TemaAmbienteLbl);
		TemaFisicaLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaFisicaLbl);
		
		
		TemaChimicaBtn = new JButton("");
		TemaChimicaBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaChimicaBtn, 6, SpringLayout.SOUTH, TemaFisicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaChimicaBtn, 0, SpringLayout.WEST, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaChimicaBtn, 54, SpringLayout.SOUTH, TemaFisicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaChimicaBtn, 48, SpringLayout.WEST, TemaAmbienteBtn);
		TemaChimicaBtn.setOpaque(true);
		TemaChimicaBtn.setBackground(new Color(0, 255, 255));
		TemiPanel.add(TemaChimicaBtn);
		
		JLabel TemaChimicaLbl = new JLabel("CHIMICA");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaChimicaLbl, 32, SpringLayout.SOUTH, TemaFisicaLbl);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaChimicaLbl, 0, SpringLayout.WEST, TemaAmbienteLbl);
		TemaChimicaLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaChimicaLbl);
		
		
		TemaMatematicaBtn = new JButton("");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaMatematicaBtn, 0, SpringLayout.NORTH, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaMatematicaBtn, 33, SpringLayout.EAST, TemaAmbienteLbl);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaMatematicaBtn, 0, SpringLayout.SOUTH, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaMatematicaBtn, 81, SpringLayout.EAST, TemaAmbienteLbl);
		TemaMatematicaBtn.setOpaque(true);
		TemaMatematicaBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		TemaMatematicaBtn.setBackground(new Color(0, 0, 255));
		TemiPanel.add(TemaMatematicaBtn);
		
		JLabel TemaMatematicaLbl = new JLabel("MATEMATICA");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaMatematicaLbl, 0, SpringLayout.NORTH, TemaAmbienteLbl);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaMatematicaLbl, 14, SpringLayout.EAST, TemaMatematicaBtn);
		TemaMatematicaLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaMatematicaLbl);
		
		
		TemaSostenibilitàBtn = new JButton("");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaSostenibilitàBtn, 0, SpringLayout.NORTH, TemaFisicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaSostenibilitàBtn, 0, SpringLayout.WEST, TemaMatematicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaSostenibilitàBtn, 0, SpringLayout.SOUTH, TemaFisicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaSostenibilitàBtn, 0, SpringLayout.EAST, TemaMatematicaBtn);
		TemaSostenibilitàBtn.setOpaque(true);
		TemaSostenibilitàBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		TemaSostenibilitàBtn.setBackground(new Color(255, 255, 0));
		TemiPanel.add(TemaSostenibilitàBtn);
		
		JLabel TemaSostenibilitàLbl = new JLabel("SOSTENIBILITA'");
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaSostenibilitàLbl, 0, SpringLayout.WEST, TemaMatematicaLbl);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaSostenibilitàLbl, 0, SpringLayout.SOUTH, TemaFisicaLbl);
		TemaSostenibilitàLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaSostenibilitàLbl);
		
		
	    TemaAltroBtn = new JButton("");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaAltroBtn, 0, SpringLayout.NORTH, TemaChimicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaAltroBtn, 0, SpringLayout.WEST, TemaMatematicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaAltroBtn, 0, SpringLayout.SOUTH, TemaChimicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaAltroBtn, 0, SpringLayout.EAST, TemaMatematicaBtn);
		TemaAltroBtn.setOpaque(true);
		TemaAltroBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
		TemaAltroBtn.setBackground(Color.DARK_GRAY);
		TemiPanel.add(TemaAltroBtn);
		
		JLabel TemaAltroLbl = new JLabel("ALTRO");
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaAltroLbl, 0, SpringLayout.NORTH, TemaChimicaLbl);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaAltroLbl, 0, SpringLayout.WEST, TemaMatematicaLbl);
		TemaAltroLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaAltroLbl);
		
		
		JLabel TemaSelezionatoLbl = new JLabel("Tema selezionato:");
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaSelezionatoLbl, 0, SpringLayout.SOUTH, TemaAmbienteBtn);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaSelezionatoLbl, -45, SpringLayout.EAST, TemiPanel);
		TemaSelezionatoLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		TemiPanel.add(TemaSelezionatoLbl);
		
		TemaSelezionatoPanel = new JPanel();
		sl_TemiPanel.putConstraint(SpringLayout.NORTH, TemaSelezionatoPanel, 11, SpringLayout.NORTH, TemaFisicaBtn);
		sl_TemiPanel.putConstraint(SpringLayout.WEST, TemaSelezionatoPanel, -182, SpringLayout.EAST, TemiPanel);
		sl_TemiPanel.putConstraint(SpringLayout.SOUTH, TemaSelezionatoPanel, 0, SpringLayout.SOUTH, TemaFisicaLbl);
		sl_TemiPanel.putConstraint(SpringLayout.EAST, TemaSelezionatoPanel, -60, SpringLayout.EAST, TemiPanel);
		TemaSelezionatoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		TemiPanel.add(TemaSelezionatoPanel);
		
		//_____________________________________________Pulsanti inferiori
		
		annullaCommentoBachecaBtn = new JButton("Annulla");
		annullaCommentoBachecaBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CommentoBachecaPanel.add(annullaCommentoBachecaBtn, "flowx,cell 0 8,alignx right");
		
		JButton PubblicaBtn = new JButton("Pubblica");
		PubblicaBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CommentoBachecaPanel.add(PubblicaBtn, "cell 0 8,alignx right");
		
>>>>>>> ad49237d0132d715413b07616f00ba071df1a6fa
	}
	
	public JButton getIndietroCommentoBachecaBtn() {
		return annullaCommentoBachecaBtn;
	}
<<<<<<< HEAD
}
=======
	
	public JButton getTemaAmbienteBtn() {
		return TemaAmbienteBtn;
	}
	
	public JButton getTemaFisicaBtn() {
		return TemaFisicaBtn;
	}
	
	public JButton getTemaChimicaBtn() {
		return TemaChimicaBtn;
	}
	
	public JButton getTemaMatematicaBtn() {
		return TemaMatematicaBtn;
	}
	
	public JButton getTemaSostenibilitàBtn() {
		return TemaSostenibilitàBtn;
	}
	
	public JButton getTemaAltroBtn() {
		return TemaAltroBtn;
	}
	
	public JPanel getTemaSelezionatoPanel() {
		return TemaSelezionatoPanel;
	}
}

>>>>>>> ad49237d0132d715413b07616f00ba071df1a6fa
