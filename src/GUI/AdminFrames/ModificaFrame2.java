package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import GUI.ConferenzaFrame.SessionePanel;
import linker.Controller;
import linker.ControllerLink;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.myTemplates;
import myTools.PanelSlide.AnimateType;

public class ModificaFrame2 extends JFrame {
	

	ControllerLink controllerLink;
	private Controller controller;
	
	myTemplates t = new myTemplates();

	private JPanel foooooooJPanel;

	
	private ArrayList<ModSessioniPanel> arrayList;
	private ModSessioniPanel sessionePanel;

	private JLblButton BackBtn;
	private JLblButton NextBtn;

	private int currentSession;
	

	public ModificaFrame2(String Titolo, ControllerLink contrLink, Controller contr) {
		
		controllerLink = contrLink;
		controller = contr;
		
		setTitle(Titolo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 900);
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
				
					JLabel ProgrammaLbl = new JLabel("Programma");
					ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
					ProgrammaLbl.setForeground(new Color(0, 0, 200));
					ProgrammaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 24));
					ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
					ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
					foooooooJPanel.add(ProgrammaLbl, BorderLayout.NORTH);
					
					PanelSlide SessioniSlider = new PanelSlide();
					SessioniSlider.setBackground(new Color(255, 255, 255));
					foooooooJPanel.add(SessioniSlider, BorderLayout.CENTER);
					
					
					arrayList = new ArrayList<ModSessioniPanel>();
					
					sessionePanel = new ModSessioniPanel(currentSession, controller);
					SessioniSlider.show(sessionePanel, AnimateType.TO_RIGHT);
					
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
							
							sessionePanel = new ModSessioniPanel(currentSession, controller);
							SessioniSlider.show(sessionePanel, AnimateType.TO_RIGHT);
						}
					});
					
					NextBtn = new JLblButton(new Color(0, 0, 200), "Avanti");
					NextBtn.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					NextBtn.setPreferredSize(new Dimension(75, 19));
					foooooooJPanel.add(NextBtn, BorderLayout.EAST);
					NextBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							currentSession ++;						
							BackBtn.setEnabled(true); 
							
							if (sessionePanel.isLastSession()) { NextBtn.setEnabled(false); }
							sessionePanel = new ModSessioniPanel(currentSession, controller);
							SessioniSlider.show(sessionePanel, AnimateType.TO_LEFT);
						}
					});
	}
}