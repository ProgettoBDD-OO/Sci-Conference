package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.PanelSlide.AnimateType;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class Modifica2Frame extends JFrame {

	private Controller controller;

	private myTemplates t;

	private JPanel SessioniPanel;

	private ArrayList<ModSessionePanel> SessioniPanels;

	private JLblButton BackBtn;
	private JLblButton NextBtn;

	private int currentSession = 0;

	private JButton IndietroBtn;
	private JButton ConfermaBtn;

	public Modifica2Frame(Controller c) {

		controller = c;
		t = new myTemplates();
		
		setTitle("Sci-Conference - Modifica");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);

			JLabel ModificaInfoLbl = new JLabel("Modifica le altre informazioni");
			ModificaInfoLbl.setForeground(t.gray);
			ModificaInfoLbl.setFont(t.myFont(28));
			ModificaInfoLbl.setHorizontalAlignment(SwingConstants.CENTER);
			ModificaInfoLbl.setPreferredSize(new Dimension(46, 100));
			MainPanel.add(ModificaInfoLbl, BorderLayout.NORTH);

			JPanel CtrPanel = new JPanel();
			CtrPanel.setBackground(t.white);
			CtrPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(CtrPanel, BorderLayout.CENTER);

				SessioniPanel = new JPanel();
				SessioniPanel.setPreferredSize(new Dimension(10, 350));
				SessioniPanel.setBackground(new Color(255, 255, 255));
				CtrPanel.add(SessioniPanel, BorderLayout.CENTER);
				SessioniPanel.setLayout(new BorderLayout(0, 0));

					JLabel ProgrammaLbl = new JLabel("Elenco Sessioni");
					ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, new Color(192, 192, 192)));
					ProgrammaLbl.setForeground(t.scBlue);
					ProgrammaLbl.setFont(t.myFont(24));
					ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
					ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
					SessioniPanel.add(ProgrammaLbl, BorderLayout.NORTH);

					PanelSlide SessioniSlider = new PanelSlide();
					SessioniSlider.setBackground(t.white);
					SessioniPanel.add(SessioniSlider, BorderLayout.CENTER);


					SessioniPanels = new ArrayList<>();
					controller.addModSessioneInfo(SessioniPanels);
					SessioniSlider.show(SessioniPanels.get(currentSession), AnimateType.TO_RIGHT);

					BackBtn = new JLblButton(t.scBlue, "Indietro");
					BackBtn.setFont(t.myFont(16));
					BackBtn.setPreferredSize(new Dimension(75, 19));
					BackBtn.setEnabled(false);
					SessioniPanel.add(BackBtn, BorderLayout.WEST);
					BackBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							currentSession --;
							if (currentSession == 0) { BackBtn.setEnabled(false); }

							NextBtn.setEnabled(true);

							SessioniSlider.show(SessioniPanels.get(currentSession), AnimateType.TO_RIGHT);
						}
					});

					NextBtn = new JLblButton(t.scBlue, "Avanti");
					NextBtn.setEnabled(false);
					NextBtn.setFont(t.myFont(16));
					NextBtn.setPreferredSize(new Dimension(75, 19));
					SessioniPanel.add(NextBtn, BorderLayout.EAST);
					NextBtn.addActionListener(new ActionListener() {
						@Override
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

				IndietroBtn = new JButton("Indietro");
				IndietroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				IndietroBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				IndietroBtn.setPreferredSize(new Dimension(150, 35));
				SouthPanel.add(IndietroBtn, "cell 0 0,alignx right,aligny bottom");
				IndietroBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						controller.backFromModifica2();
					}
				});

				ConfermaBtn = new JButton("Modifica Conferenza");
				ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				ConfermaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
				ConfermaBtn.setForeground(t.white);
				ConfermaBtn.setBackground(t.scBlue);
				ConfermaBtn.setPreferredSize(new Dimension(150, 35));
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
				ConfermaBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						controller.confermaModifica();
					}
				});
				
				if (SessioniPanels.size() > 1) { NextBtn.setEnabled(true); }
	}

	public ArrayList<ModSessionePanel> getSessioniPanel() { return SessioniPanels; }

	public String getIdSessione() { return SessioniPanels.get(currentSession).getIdSessione(); }

	public int getN() { return currentSession; }

	public int getCurrentIntervento() { return SessioniPanels.get(currentSession).getIntervento(); }

	public ArrayList<ModInterventoPanel> getInterventi() { return SessioniPanels.get(currentSession).getInterventi(); }
	
	public JLblButton getNextBtn() { return NextBtn; }
}