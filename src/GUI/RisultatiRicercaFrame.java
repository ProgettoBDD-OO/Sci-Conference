package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import linker.ControllerLink;

import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RisultatiRicercaFrame extends JFrame{
	
	private ControllerLink controllerLink;
	
	private CardLayout RisultatiCardLayout;
	private JPanel RisultatiCardPanel;
	
	private JPanel RisultatiPanel;
	
	private JButton IndietroBtn; 

	public RisultatiRicercaFrame(String Titolo, ControllerLink contrLink) {
		
		controllerLink = contrLink;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 650);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
			
			JLabel RisultatiLbl = new JLabel("Risultati");
			RisultatiLbl.setForeground(new Color(20, 40, 60));
			RisultatiLbl.setFont(new Font("Calibri Light", Font.PLAIN, 30));
			RisultatiLbl.setHorizontalAlignment(SwingConstants.CENTER);
			RisultatiLbl.setPreferredSize(new Dimension(38, 100));
			MainPanel.add(RisultatiLbl, BorderLayout.NORTH);
			
			RisultatiCardLayout = new CardLayout(0, 0);
			
			RisultatiCardPanel = new JPanel();
			RisultatiCardPanel.setBackground(new Color(255, 255, 255));
			RisultatiCardPanel.setLayout(RisultatiCardLayout);
			MainPanel.add(RisultatiCardPanel, BorderLayout.CENTER);
				
				JLabel NoResultsLbl = new JLabel("Nessun risultato della ricerca.");
				NoResultsLbl.setForeground(new Color(20, 40, 60));
				NoResultsLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
				NoResultsLbl.setHorizontalAlignment(SwingConstants.CENTER);
				RisultatiCardPanel.add(NoResultsLbl, "1");
				
				JScrollPane RisultatiScroller = new JScrollPane();
				RisultatiScroller.setBorder(null);
				RisultatiCardPanel.add(RisultatiScroller, "2");
				
					RisultatiPanel = new JPanel();
					RisultatiScroller.setViewportView(RisultatiPanel);
					RisultatiPanel.setBorder(new EmptyBorder(0, 15, 0, 15));
					RisultatiPanel.setBackground(new Color(255, 255, 255));
					RisultatiPanel.setLayout(new BoxLayout(RisultatiPanel, BoxLayout.Y_AXIS));
					
					
					
			JPanel IndietroBtnConteiner = new JPanel();
			IndietroBtnConteiner.setBackground(new Color(255, 255, 255));
			IndietroBtnConteiner.setPreferredSize(new Dimension(10, 100));
			MainPanel.add(IndietroBtnConteiner, BorderLayout.SOUTH);
			IndietroBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
			
			IndietroBtn = new JButton("Indietro");
			IndietroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			IndietroBtn.setPreferredSize(new Dimension(125, 30));
			IndietroBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			IndietroBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controllerLink.backFromRisultati();
				}
			});
			
			IndietroBtnConteiner.add(IndietroBtn, "flowx,cell 0 0,alignx left,aligny center");
	}
	
	public CardLayout getRisultatiCardLayout() {
		return RisultatiCardLayout;
	}
	
	public JPanel getRisultatiCardPanel() {
		return RisultatiCardPanel;
	};
	
	public JPanel getRisultatiPanel() {
		return RisultatiPanel;	
	}
	
	public JButton getIndietroBtn() {
		return IndietroBtn;
	}
}