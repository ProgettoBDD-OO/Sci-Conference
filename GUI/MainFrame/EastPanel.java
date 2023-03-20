package GUI.MainFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.JLblButton;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EastPanel extends JPanel{

	private JTextField ResearchBar;
	private JButton FilterBtn;
	private JLblButton AddIdeaBtn;
	
	public EastPanel() {
		
		setBackground(new Color(242, 243, 244));
		setPreferredSize(new Dimension(300, 800));
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel ResearchPanel = new JPanel();
		add(ResearchPanel, BorderLayout.NORTH);
		ResearchPanel.setBackground(new Color(255, 255, 255));
		ResearchPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(150, 151, 152)));
		ResearchPanel.setPreferredSize(new Dimension(10, 140));
		ResearchPanel.setLayout(new MigLayout("wrap, fill", "[][grow]", "[][][][][]"));
			
			FilterBtn = new JButton("");
			FilterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			FilterBtn.setBackground(new Color(0, 0, 200));
			FilterBtn.setMinimumSize(new Dimension(30, 30));
			FilterBtn.setPreferredSize(new Dimension(30, 30));
			ResearchPanel.add(FilterBtn, "cell 0 0,alignx center,aligny top");
				
			ResearchBar = new JTextField();
			ResearchBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 200)));
			ResearchBar.setForeground(new Color(150, 150, 150));
			ResearchBar.setFont(new Font("Tahoma", Font.ITALIC, 12));
			ResearchBar.setText("cerca una conferenza");
			ResearchBar.setPreferredSize(new Dimension(10, 30));
			ResearchBar.setColumns(10);
			ResearchPanel.add(ResearchBar, "cell 1 0,growx,aligny top");
				
				JLabel lblNewLabel = new JLabel("");
				ResearchPanel.add(lblNewLabel, "cell 1 1,alignx left,aligny center");
				
				JLabel lblNewLabel_1 = new JLabel("");
				ResearchPanel.add(lblNewLabel_1, "cell 1 2,alignx left,aligny center");
				
				JLabel lblNewLabel_2 = new JLabel("");
				ResearchPanel.add(lblNewLabel_2, "cell 1 3,alignx left,aligny center");
				
				JLblButton btnNewButton = new JLblButton("Clear All");
				btnNewButton.setVisible(false);
				btnNewButton.setFont(new Font("Calibri Light", Font.PLAIN, 12));
				ResearchPanel.add(btnNewButton, "cell 1 4,alignx right,aligny center");
			
				
					
			
			JPanel BachecaPanel = new JPanel();
			BachecaPanel.setBackground(new Color(243, 244, 245));
			add(BachecaPanel, BorderLayout.CENTER);
			BachecaPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::100px][][::100px]"));
			
				JLabel BachecaLbl = new JLabel("Bacheca");
				BachecaLbl.setForeground(new Color(100, 105, 110));
				BachecaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 26));
				BachecaPanel.add(BachecaLbl, "cell 0 0,alignx center,aligny center");
				JPanel Bacheca = new JPanel();
				Bacheca.setMaximumSize(new Dimension(32767, 500));
				Bacheca.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 200)));
				Bacheca.setBackground(new Color(140, 141, 142));
				BachecaPanel.add(Bacheca, "cell 0 1,grow");
				
				AddIdeaBtn = new JLblButton("Aggiungi la tua idea\r\n");
				AddIdeaBtn.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				BachecaPanel.add(AddIdeaBtn, "cell 0 2,alignx center,aligny center");
				
				AddIdeaBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						AddIdeaBtn.setForeground(new Color(0, 0, 200));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						AddIdeaBtn.setForeground(new Color(90, 100, 110));
						}
					});
	}
	

	public JButton getAddIdeaBtn() {
		return AddIdeaBtn;
	}
	
	public JButton getFilterBtn() {
		return FilterBtn;
	}
	
	public JTextField getResearchBar() {
		return ResearchBar;
	}
}