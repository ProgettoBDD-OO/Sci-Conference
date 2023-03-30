package GUI.AdminFrames;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import linker.ControllerLink;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoFrame extends JFrame {
	
	ControllerLink controllerLink;
	
	ArrayList<JTextField> InfoFld;
	private JPanel InfoConteiner;
	
	public InfoFrame(ControllerLink contrLink, String comingFrom) {
		
		controllerLink = contrLink;
		
		setSize(300, 300);
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			MainPanel.add(scrollPane, BorderLayout.CENTER);
			
				InfoConteiner = new JPanel();
				InfoConteiner.setBackground(new Color(255, 255, 255));
				scrollPane.setViewportView(InfoConteiner);
				InfoConteiner.setLayout(new BoxLayout(InfoConteiner, BoxLayout.Y_AXIS));
				
					InfoFld  = new ArrayList<JTextField>();
			
			JButton ConfermaBtn = new JButton("Conferma");
			ConfermaBtn.setForeground(new Color(255, 255, 255));
			ConfermaBtn.setBackground(new Color(0, 0, 200));
			ConfermaBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					controllerLink.addEnti();
				}
			});
			ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ConfermaBtn.setPreferredSize(new Dimension(89, 30));
			getContentPane().add(ConfermaBtn, BorderLayout.SOUTH);
		
	}
	
	public ArrayList<JTextField> getInfo(){ return InfoFld; }
	
	public JPanel getEntiConteiner() { return InfoConteiner; }
}