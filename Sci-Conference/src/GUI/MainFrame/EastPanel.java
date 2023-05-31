package GUI.MainFrame;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.JLblButton;
import myTools.myTemplates;
import myTools.myTxtFld;
import net.miginfocom.swing.MigLayout;


public class EastPanel extends JPanel {

	private Controller controller;

	private myTemplates t;

	private JPanel ResearchContainer;
	private JButton FilterBtn;
	private myTxtFld ResearchBar;

	private JPanel FilterLblConteiner;
	private JLabel DateLbl;
	private JLabel PlacesLbl;
	private JLabel TopicsLbl;
	private JLblButton ClearFltrBtn;

	private JPanel Bacheca;
	private JLblButton AddIdeaBtn;
	private ConferenzaBachecaPanel ConfBachecaPanel;
	private JPopupMenu popupMenu;

	public EastPanel(Controller c) {

		controller = c;

		t = new myTemplates();
		setBackground(t.dxGray);
		setPreferredSize(new Dimension(260, 800));
		setLayout(new BorderLayout(0, 0));

		JPanel ResearchPanel = new JPanel();
		add(ResearchPanel, BorderLayout.NORTH);
		ResearchPanel.setBackground(t.white);
		ResearchPanel.setBorder(new MatteBorder(0, 0, 1, 0, t.altGray));
		ResearchPanel.setPreferredSize(new Dimension(10, 130));
		ResearchPanel.setLayout(new BorderLayout(0, 0));

			ResearchContainer = new JPanel();
			ResearchContainer.setBackground(t.white);
			ResearchContainer.setPreferredSize(new Dimension(10, 42));
			ResearchPanel.add(ResearchContainer, BorderLayout.NORTH);
			ResearchContainer.setLayout(new MigLayout("wrap, fill", "[][grow]", "[]"));

				FilterBtn = new JButton("");
				ResearchContainer.add(FilterBtn, "cell 0 0,alignx center,aligny center");
				FilterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				FilterBtn.setBackground(t.scBlue);
				FilterBtn.setMinimumSize(new Dimension(25, 25));
				FilterBtn.setPreferredSize(new Dimension(25, 25));

				ResearchBar = new myTxtFld(" Cerca una conferenza", controller);
				ResearchContainer.add(ResearchBar, "cell 1 0,growx,aligny center");


			FilterLblConteiner = new JPanel();
			FilterLblConteiner.setBorder(new EmptyBorder(4, 0, 4, 0));
			ResearchPanel.add(FilterLblConteiner, BorderLayout.CENTER);
			FilterLblConteiner.setBackground(t.white);
			FilterLblConteiner.setLayout(new BoxLayout(FilterLblConteiner, BoxLayout.Y_AXIS));

				DateLbl = new JLabel("");
				DateLbl.setFont(t.myFont(14));
				FilterLblConteiner.add(DateLbl);

				PlacesLbl = new JLabel("");
				PlacesLbl.setFont(t.myFont(14));
				FilterLblConteiner.add(PlacesLbl);

				TopicsLbl = new JLabel("");
				FilterLblConteiner.add(TopicsLbl);
				TopicsLbl.setFont(t.myFont(14));

			JPanel ClearFltrContainer = new JPanel();
			ClearFltrContainer.setBackground(t.white);
			ClearFltrContainer.setPreferredSize(new Dimension(10, 25));
			ResearchPanel.add(ClearFltrContainer, BorderLayout.SOUTH);
			ClearFltrContainer.setLayout(new MigLayout("wrap, fill", "[]", "[]"));

				ClearFltrBtn = new JLblButton(t.scBlue, "Clear All");
				ClearFltrBtn.setVisible(false);
				ClearFltrContainer.add(ClearFltrBtn, "cell 0 0,alignx center,aligny center");
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
				BachecaLbl.setFont(t.myFont(22));
				BachecaPanel.add(BachecaLbl, "cell 0 0,alignx center,aligny center");

				ConfBachecaPanel = new ConferenzaBachecaPanel();
				ConfBachecaPanel.setPreferredSize(new Dimension(260, 140));

				Bacheca = new JPanel();
				Bacheca.setBackground(t.gray);
				Bacheca.setBorder(new MatteBorder(4, 4, 4, 4, t.scBlue));
				Bacheca.setLayout(new BoxLayout(Bacheca, BoxLayout.Y_AXIS));
				BachecaPanel.add(Bacheca, "cell 0 1, grow");

				popupMenu = new JPopupMenu();
				popupMenu.add(ConfBachecaPanel);

				AddIdeaBtn = new JLblButton(t.gray, "Aggiungi la tua idea");
				AddIdeaBtn.setFont(t.myFont(16));
				BachecaPanel.add(AddIdeaBtn, "cell 0 2,alignx center,aligny center");

				AddIdeaBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) { AddIdeaBtn.setForeground(t.scBlue); }
					@Override
					public void mouseExited(MouseEvent e) { AddIdeaBtn.setForeground(t.gray); }
				});
	}

	public JButton getFilterBtn() { return FilterBtn; }

	public myTxtFld getResearchBar() { return ResearchBar; }

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

	public ConferenzaBachecaPanel getCbPanel() { return ConfBachecaPanel; }

	public JPanel getBacheca() { return Bacheca; }

	public JButton getAddIdeaBtn() { return AddIdeaBtn; }
}