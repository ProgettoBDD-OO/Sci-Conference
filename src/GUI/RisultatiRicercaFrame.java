package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Logica.Connessione;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;

public class RisultatiRicercaFrame extends JFrame {
	
	private MainFrame View;
    ArrayList<JLblButton> ArrayLblButton;
    private JPanel RisultatiPanel;
    private JButton IndietroRisultatiBtn;
	 
	public RisultatiRicercaFrame(String titolo,MainFrame Vista) {
		
	 this.View = Vista;

	 setTitle(titolo);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize(750, 850);
	 setLocationRelativeTo(null);
	 setVisible(false);
	 setResizable(false);
	
	 JPanel MainPanel = new JPanel();
	 MainPanel.setBackground(new Color(246, 247, 248));
	 setContentPane(MainPanel);
	 MainPanel.setLayout(new BorderLayout(0, 0));
	
 	 RisultatiPanel = new JPanel();
	 MainPanel.add(RisultatiPanel, BorderLayout.CENTER);
	 RisultatiPanel.setLayout(new BoxLayout(RisultatiPanel, BoxLayout.Y_AXIS));
	 
	 JPanel IndietroRisultatiPanel = new JPanel();
	 MainPanel.add(IndietroRisultatiPanel, BorderLayout.SOUTH);
	 IndietroRisultatiPanel.setLayout(new MigLayout("wrap,fill", "[][][]", "[]"));
	 
	 IndietroRisultatiBtn = new JButton("Indietro");
	 IndietroRisultatiBtn.setFont(new Font("Tahoma", Font.PLAIN, 22));
	 IndietroRisultatiPanel.add(IndietroRisultatiBtn, "cell 1 0,alignx center,aligny center");

	 }
	 
	 public JPanel getRisultatiPanel() {
		 return RisultatiPanel;
	 }
	 
	 public JButton getIndietroRisultatiBtn() {
		 return IndietroRisultatiBtn;
	 }
	 
}
