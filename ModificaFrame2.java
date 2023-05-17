package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.myTemplates;
import myTools.PanelSlide.AnimateType;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class ModificaFrame2 extends JFrame {

	Controller controller;
	
	myTemplates t = new myTemplates();

	private JPanel foooooooJPanel;
	
	private ArrayList<ModSessioniPanel> SessioniPanels;

	private JLblButton BackBtn;
	private JLblButton NextBtn;

	private int currentSession = 0;
	private int nInterventi = 0;

	private JButton AnnullaBtn;

	private JButton ConfermaBtn;

	public ModificaFrame2(String Titolo, Controller c) {
		
		controller = c;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 700);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(246, 247, 248));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			JLabel ModConfLbl = new JLabel("Modifica le altre informazioni");
			ModConfLbl.setForeground(t.gray);
			ModConfLbl.setFont(t.myFont(28));
			ModConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			ModConfLbl.setPreferredSize(new Dimension(46, 100));
			MainPanel.add(ModConfLbl, BorderLayout.NORTH);
			
			JPanel CtrPanel = new JPanel();
			CtrPanel.setBackground(t.white);
			CtrPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(CtrPanel, BorderLayout.CENTER);
			
				foooooooJPanel = new JPanel();
				foooooooJPanel.setPreferredSize(new Dimension(10, 350));
				foooooooJPanel.setBackground(new Color(255, 255, 255));
				CtrPanel.add(foooooooJPanel, BorderLayout.NORTH);
				foooooooJPanel.setLayout(new BorderLayout(0, 0));
				
					JLabel ProgrammaLbl = new JLabel("Elenco Sessioni");
					ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
					ProgrammaLbl.setForeground(new Color(0, 0, 200));
					ProgrammaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
					ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
					ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
					foooooooJPanel.add(ProgrammaLbl, BorderLayout.NORTH);
					
					PanelSlide SessioniSlider = new PanelSlide();
					SessioniSlider.setBackground(new Color(255, 255, 255));
					foooooooJPanel.add(SessioniSlider, BorderLayout.CENTER);
					
					
					SessioniPanels = new ArrayList<ModSessioniPanel>();
					
					for (int i = 0; i < 4; i++) {
						
						SessioniPanels.add(new ModSessioniPanel(i, controller));
						nInterventi = controller.addModSessioneInfo(i, SessioniPanels.get(i));
						SessioniPanels.get(i).setNInterventi(nInterventi);
					}
					
					SessioniSlider.show(SessioniPanels.get(currentSession), AnimateType.TO_RIGHT);
					
					BackBtn = new JLblButton(new Color(0, 0, 200), "Indietro");
					BackBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					BackBtn.setPreferredSize(new Dimension(75, 19));
					BackBtn.setEnabled(false);
					foooooooJPanel.add(BackBtn, BorderLayout.WEST);
					BackBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							currentSession --;
							if (currentSession == 0) { BackBtn.setEnabled(false); } 
							
							else { NextBtn.setEnabled(true); }
							
							SessioniSlider.show(SessioniPanels.get(currentSession), AnimateType.TO_RIGHT);
						}
					});
					
					NextBtn = new JLblButton(new Color(0, 0, 200), "Avanti");
					NextBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					NextBtn.setPreferredSize(new Dimension(75, 19));
					foooooooJPanel.add(NextBtn, BorderLayout.EAST);
					
					JPanel panel = new JPanel();
					CtrPanel.add(panel, BorderLayout.CENTER);
					panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
					NextBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							currentSession ++;						
							BackBtn.setEnabled(true); 
							
							if (SessioniPanels.size() - 1 == currentSession) { NextBtn.setEnabled(false); }
							SessioniSlider.show(SessioniPanels.get(currentSession), AnimateType.TO_LEFT);
						}
					});
					
					JPanel SouthPanel = new JPanel();
					SouthPanel.setBackground(t.lGray);
					SouthPanel.setPreferredSize(new Dimension(10, 80));
					SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
					MainPanel.add(SouthPanel, BorderLayout.SOUTH);
					
						AnnullaBtn = new JButton("Annulla");
						AnnullaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						AnnullaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
						AnnullaBtn.setPreferredSize(new Dimension(150, 35));
						SouthPanel.add(AnnullaBtn, "cell 0 0,alignx right,aligny bottom");
						AnnullaBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								controller.backFromAggiunta2();
							}
						});
						
						ConfermaBtn = new JButton("Inserisci Conferenza");
						ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						ConfermaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
						ConfermaBtn.setForeground(t.white);
						ConfermaBtn.setBackground(t.scBlue);
						ConfermaBtn.setPreferredSize(new Dimension(150, 35));
						SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
						ConfermaBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.confermaAggiunta();
							}
						});
	}
	
	public ArrayList<ModSessioniPanel> getSessioniPanel() { return SessioniPanels; }
}