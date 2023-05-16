package GUI.AdminFrames;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

import linker.Controller;
import myException.EmptyFieldException;


public class InfoDialog extends JDialog {
	
	Controller controller;
	
	private JPanel InfoConteiner;
	
	public InfoDialog(Controller c, String comingFrom) {
		
		controller = c;
		
		setSize(300, 285);
		setModal(true);
		setLocationRelativeTo(null);
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
				InfoConteiner.setLayout(new MigLayout("wrap, fill", "[grow]", "10[]10"));
				
			
			
			JButton ConfermaBtn = new JButton("Conferma");
			ConfermaBtn.setForeground(new Color(255, 255, 255));
			ConfermaBtn.setBackground(new Color(0, 0, 200));
			ConfermaBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (comingFrom.equals("Enti")) { 
						
						try { controller.addQueryEnti(); }
						
						catch (EmptyFieldException efe) { System.out.println(efe); }
						
					} else { 
						
						try { controller.addQuerySponsor(); }
						
						catch (EmptyFieldException efe) { System.out.println(efe); } 
					}
				}
			});
			ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ConfermaBtn.setPreferredSize(new Dimension(89, 30));
			getContentPane().add(ConfermaBtn, BorderLayout.SOUTH);
		
	}
	
	public JPanel getInfoConteiner() { return InfoConteiner; }
}