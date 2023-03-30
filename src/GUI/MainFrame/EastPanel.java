package GUI.MainFrame;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import myTools.JLblButton;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;

public class EastPanel extends JPanel {

	myTemplates c = new myTemplates();
	
	private JPanel ResearchConteiner;
	private JButton FilterBtn;
	private JTextField ResearchBar;
	
	private JPanel FilterLblConteiner;
	private JLabel DateLbl;
	private JLabel PlacesLbl;
	private JLabel TopicsLbl;
	private JLblButton ClearFltrBtn;
	
	private JPanel Bacheca;
	private JLblButton AddIdeaBtn;
	private ArrayList<JLblButton> arrayConfBacheca;
	private ConferenzaBachecaPanel CbPanel;
	private JPopupMenu popupMenu;
	
	public EastPanel() {
		
		setBackground(c.dxGray);
		setPreferredSize(new Dimension(300, 800));
		setLayout(new BorderLayout(0, 0));
		
		JPanel ResearchPanel = new JPanel();
		add(ResearchPanel, BorderLayout.NORTH);
		ResearchPanel.setBackground(c.white);
		ResearchPanel.setBorder(new MatteBorder(0, 0, 1, 0, c.altGray));
		ResearchPanel.setPreferredSize(new Dimension(10, 150));
		ResearchPanel.setLayout(new BorderLayout(0, 0));
		
			ResearchConteiner = new JPanel();
			ResearchConteiner.setBackground(c.white);
			ResearchConteiner.setPreferredSize(new Dimension(10, 50));
			ResearchPanel.add(ResearchConteiner, BorderLayout.NORTH);
			ResearchConteiner.setLayout(new MigLayout("wrap, fill", "[][grow]", "[]"));
			
				FilterBtn = new JButton("");
				ResearchConteiner.add(FilterBtn, "cell 0 0,alignx center,aligny center");
				FilterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				FilterBtn.setBackground(c.scBlue);
				FilterBtn.setMinimumSize(new Dimension(30, 30));
				FilterBtn.setPreferredSize(new Dimension(30, 30));
			
				ResearchBar = new JTextField();
				ResearchConteiner.add(ResearchBar, "cell 1 0,growx,aligny center");
				ResearchBar.setHorizontalAlignment(SwingConstants.LEFT);
				ResearchBar.setBorder(new MatteBorder(1, 1, 1, 1, c.scBlue));
				ResearchBar.setForeground(c.altGray);
				ResearchBar.setFont(new Font("Tahoma", Font.ITALIC, 12));
				ResearchBar.setText("cerca una conferenza");
				ResearchBar.setPreferredSize(new Dimension(10, 30));
				ResearchBar.setColumns(10);
			
			FilterLblConteiner = new JPanel();
			FilterLblConteiner.setBorder(new EmptyBorder(5, 0, 5, 0));
			ResearchPanel.add(FilterLblConteiner, BorderLayout.CENTER);
			FilterLblConteiner.setBackground(c.white);
			FilterLblConteiner.setLayout(new BoxLayout(FilterLblConteiner, BoxLayout.Y_AXIS));
			
				DateLbl = new JLabel("");
				DateLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				FilterLblConteiner.add(DateLbl);
				
				PlacesLbl = new JLabel("");
				PlacesLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				FilterLblConteiner.add(PlacesLbl);
				
				TopicsLbl = new JLabel("");
				FilterLblConteiner.add(TopicsLbl);
				TopicsLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				
				JPanel ClearFltrConteiner = new JPanel();
				ClearFltrConteiner.setBackground(c.white);
				ClearFltrConteiner.setPreferredSize(new Dimension(10, 30));
				ResearchPanel.add(ClearFltrConteiner, BorderLayout.SOUTH);
				ClearFltrConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
				
			ClearFltrBtn = new JLblButton(c.scBlue, "Clear All");
			ClearFltrBtn.setBorder(new MatteBorder(0, 0, 1, 0, c.scBlue));
			ClearFltrBtn.setVisible(false);
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
			ClearFltrConteiner.add(ClearFltrBtn, "cell 0 0,alignx center,aligny center");
			
			
			JPanel BachecaPanel = new JPanel();
			BachecaPanel.setBackground(c.dxGray);
			add(BachecaPanel, BorderLayout.CENTER);
			BachecaPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::100px][][::100px]"));
			
				JLabel BachecaLbl = new JLabel("Bacheca");
				BachecaLbl.setForeground(c.gray);
				BachecaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 26));
				BachecaPanel.add(BachecaLbl, "cell 0 0,alignx center,aligny center");
				
				arrayConfBacheca = new ArrayList<JLblButton>();
				CbPanel = new ConferenzaBachecaPanel();
				CbPanel.setPreferredSize(new Dimension(300, 150));
				
				Bacheca = new JPanel();
				Bacheca.setBackground(c.gray);
				Bacheca.setBorder(new MatteBorder(5, 5, 5, 5, c.scBlue));
				Bacheca.setLayout(new BoxLayout(Bacheca, BoxLayout.Y_AXIS));
				BachecaPanel.add(Bacheca, "cell 0 1, grow");
				
				popupMenu = new JPopupMenu();
				popupMenu.add(CbPanel);
				
				AddIdeaBtn = new JLblButton(c.gray, "Aggiungi la tua idea");
				AddIdeaBtn.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				BachecaPanel.add(AddIdeaBtn, "cell 0 2,alignx center,aligny center");
				
				AddIdeaBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) { AddIdeaBtn.setForeground(c.scBlue); }
					@Override
					public void mouseExited(MouseEvent e) { AddIdeaBtn.setForeground(c.gray); }
				});
	}
	
	public JButton getFilterBtn() { return FilterBtn; }
	
	public JTextField getResearchBar() { return ResearchBar; }
	
	public void addDateLbl(String txt) { DateLbl.setText(txt); }
	
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
	
	public ArrayList<JLblButton> getArrayConfBacheca(){ return arrayConfBacheca; }
	
	public JPopupMenu getPopupMenu() { return popupMenu; }
	
	public ConferenzaBachecaPanel getCbPanel() { return CbPanel; }
	
	public JPanel getBacheca() { return Bacheca; }
	
	public JButton getAddIdeaBtn() { return AddIdeaBtn; }	
}