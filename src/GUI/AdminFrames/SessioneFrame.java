package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import myTools.myTemplates;

public class SessioneFrame extends JDialog {
	
	private myTemplates t = new myTemplates();
	
	private JTextField txtCoordinatore;
	private JTextField txtKeynoteSpeaker;

	public SessioneFrame() {
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		setModal(true);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel SessioneLbl = new JLabel("Inserisci Sessione x");
			SessioneLbl.setPreferredSize(new Dimension(77, 50));
			SessioneLbl.setForeground(t.gray);
			SessioneLbl.setBorder(new EmptyBorder(10, 0, 0, 0));
			SessioneLbl.setFont(t.myFont(24));
			SessioneLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(SessioneLbl, BorderLayout.NORTH);
		
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(Color.WHITE);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][][]"));
			
				JLabel lblNewLabel = new JLabel("Data e ora di inizio");
				lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				CentrPanel.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
				
				JLabel lblNewLabel_1 = new JLabel("Data e ora di fine");
				lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				CentrPanel.add(lblNewLabel_1, "cell 0 1,alignx center,aligny center");
				
				txtCoordinatore = new JTextField();
				txtCoordinatore.setPreferredSize(new Dimension(7, 30));
				txtCoordinatore.setForeground(t.scBlue);
				txtCoordinatore.setFont(t.myFont(14));
				txtCoordinatore.setText("Coordinatore");
				CentrPanel.add(txtCoordinatore, "cell 0 2,growx,aligny center");
				
				txtKeynoteSpeaker = new JTextField();
				txtKeynoteSpeaker.setPreferredSize(new Dimension(7, 30));
				txtKeynoteSpeaker.setForeground(t.scBlue);
				txtKeynoteSpeaker.setFont(t.myFont(14));
				txtKeynoteSpeaker.setText("Keynote Speaker");
				CentrPanel.add(txtKeynoteSpeaker, "cell 0 3,growx,aligny center");
		
		
		JButton ConfermaBtn = new JButton("Prossima Sessione");
		ConfermaBtn.setPreferredSize(new Dimension(79, 40));
		ConfermaBtn.setForeground(t.white);
		ConfermaBtn.setBackground(t.scBlue);
		ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
		
	}
}