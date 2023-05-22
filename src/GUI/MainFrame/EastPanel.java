package GUI.MainFrame;

import myTools.myTemplates;
import myTools.myTxtFld;
import myTools.JLblButton;
import linker.Controller;

import java.util.ArrayList;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import net.miginfocom.swing.MigLayout;


public class EastPanel extends JPanel {

	Controller controller;
	
	myTemplates t = new myTemplates();
	
	private JPanel ResearchConteiner;
	private JButton FilterBtn;
	private myTxtFld ResearchBar;
	
	private JPanel FilterLblConteiner;
	private JLabel DateLbl;
	private JLabel PlacesLbl;
	private JLabel TopicsLbl;
	private JLblButton ClearFltrBtn;
	
	private JPanel Bacheca;
	private JLblButton AddIdeaBtn;
	private ConferenzaBachecaPanel CbPanel;
	private JPopupMenu popupMenu;
	
	public EastPanel(Controller c) {
		
		controller = c;
		
		setBackground(t.dxGray);
		setPreferredSize(new Dimension(300, 800));
		setLayout(new BorderLayout(0, 0));
		
		JPanel ResearchPanel = new JPanel();
		add(ResearchPanel, BorderLayout.NORTH);
		ResearchPanel.setBackground(t.white);
		ResearchPanel.setBorder(new MatteBorder(0, 0, 1, 0, t.altGray));
		ResearchPanel.setPreferredSize(new Dimension(10, 150));
		ResearchPanel.setLayout(new BorderLayout(0, 0));
		
			ResearchConteiner = new JPanel();
			ResearchConteiner.setBackground(t.white);
			ResearchConteiner.setPreferredSize(new Dimension(10, 50));
			ResearchPanel.add(ResearchConteiner, BorderLayout.NORTH);
			ResearchConteiner.setLayout(new MigLayout("wrap, fill", "[][grow]", "[]"));
			
				FilterBtn = new JButton("");
				ResearchConteiner.add(FilterBtn, "cell 0 0,alignx center,aligny center");
				FilterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				FilterBtn.setBackground(t.scBlue);
				FilterBtn.setMinimumSize(new Dimension(30, 30));
				FilterBtn.setPreferredSize(new Dimension(30, 30));
			
				ResearchBar = new myTxtFld(" Cerca una conferenza", controller);
				ResearchConteiner.add(ResearchBar, "cell 1 0,growx,aligny center");
				
			
			FilterLblConteiner = new JPanel();
			FilterLblConteiner.setBorder(new EmptyBorder(5, 0, 5, 0));
			ResearchPanel.add(FilterLblConteiner, BorderLayout.CENTER);
			FilterLblConteiner.setBackground(t.white);
			FilterLblConteiner.setLayout(new BoxLayout(FilterLblConteiner, BoxLayout.Y_AXIS));
			
				DateLbl = new JLabel("");
				DateLbl.setFont(t.myFont(16));
				FilterLblConteiner.add(DateLbl);
				
				PlacesLbl = new JLabel("");
				PlacesLbl.setFont(t.myFont(16));
				FilterLblConteiner.add(PlacesLbl);
				
				TopicsLbl = new JLabel("");
				FilterLblConteiner.add(TopicsLbl);
				TopicsLbl.setFont(t.myFont(16));
				
			JPanel ClearFltrConteiner = new JPanel();
			ClearFltrConteiner.setBackground(t.white);
			ClearFltrConteiner.setPreferredSize(new Dimension(10, 30));
			ResearchPanel.add(ClearFltrConteiner, BorderLayout.SOUTH);
			ClearFltrConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				
				ClearFltrBtn = new JLblButton(t.scBlue, "Clear All");
				ClearFltrBtn.setVisible(false);
				ClearFltrConteiner.add(ClearFltrBtn, "cell 0 0,alignx center,aligny center");
				ClearFltrBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						ClearFltrBtn.setBorderPainted(true);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						ClearFltrBtn.setBorderPainted(false);
					}
				});
			
			
			JPanel BachecaPanel = new JPanel();
			BachecaPanel.setBackground(t.dxGray);
			add(BachecaPanel, BorderLayout.CENTER);
			BachecaPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::100px][][::100px]"));
			
				JLabel BachecaLbl = new JLabel("Bacheca");
				BachecaLbl.setForeground(t.gray);
				BachecaLbl.setFont(t.myFont(26));
				BachecaPanel.add(BachecaLbl, "cell 0 0,alignx center,aligny center");
				
				CbPanel = new ConferenzaBachecaPanel();
				CbPanel.setPreferredSize(new Dimension(300, 150));
				
				Bacheca = new JPanel();
				Bacheca.setBackground(t.gray);
				Bacheca.setBorder(new MatteBorder(5, 5, 5, 5, t.scBlue));
				Bacheca.setLayout(new BoxLayout(Bacheca, BoxLayout.Y_AXIS));
				BachecaPanel.add(Bacheca, "cell 0 1, grow");
				
				popupMenu = new JPopupMenu();
				popupMenu.add(CbPanel);
				
				AddIdeaBtn = new JLblButton(t.gray, "Aggiungi la tua idea");
				AddIdeaBtn.setFont(t.myFont(18));
				BachecaPanel.add(AddIdeaBtn, "cell 0 2,alignx center,aligny center");
				
				AddIdeaBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) { AddIdeaBtn.setForeground(t.scBlue); }
					@Override
					public void mouseExited(MouseEvent e) { AddIdeaBtn.setForeground(t.gray); }
				});
	}
	
	public JButton getFilterBtn() { return FilterBtn; }
	
	public JTextField getResearchBar() { return ResearchBar; }
	
	public void addDateLbl(String txt) { 
		
		if (DateLbl.getText().isEmpty()) { DateLbl.setText(" " + txt); }
		
		else { DateLbl.setText(DateLbl.getText() + ", e " + txt); }
	}
	
	public void addPlacesLbl(String txt) { 
		
		if (!PlacesLbl.getText().contains(txt)) {
			PlacesLbl.setText(PlacesLbl.getText() + " " + txt);
		} 
	}
	
	public void addTopicsLbl(String txt) { 
		
		if (!TopicsLbl.getText().contains(txt)) {
			TopicsLbl.setText(TopicsLbl.getText() + " " + txt); 			
		}
	}
	
	public void resetFilterLbl() { DateLbl.setText(""); PlacesLbl.setText(""); TopicsLbl.setText(""); }
	
	public JLblButton getClearFltrBtn() { return ClearFltrBtn; }
	
	public JPopupMenu getPopupMenu() { return popupMenu; }
	
	public ConferenzaBachecaPanel getCbPanel() { return CbPanel; }
	
	public JPanel getBacheca() { return Bacheca; }
	
	public JButton getAddIdeaBtn() { return AddIdeaBtn; }	
}