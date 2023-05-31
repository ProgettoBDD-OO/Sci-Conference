package GUI.ConferenzaFrame;

import linker.Controller;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.PanelSlide.AnimateType;
import myTools.myTemplates;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;


public class ConferenzaFrame extends JFrame {

	private Controller controller;

	private myTemplates t;
	private String framePrecedente = "";

	private String IdConferenza;

	private JPanel CentrPanel;
	private ArrayList<SessionePanel> SessioniPanels;
	private int n = 0;
	private JLblButton BackBtn;
	private JLblButton NextBtn;

	private JPanel EntiConteiner;
	private JPanel SponsorConteiner;
	private JPanel OrganizzatoriConteiner;

	private OrganizzatoreInfo OrgInfoPanel;
	private JPopupMenu popupMenu;
	
	private CardLayout IscrizioneCardLayout;
	private JPanel IscrizioneCardPanel;
	private NorthPanel NorthPanel;

	public ConferenzaFrame(String idConferenza, Controller c) {

		IdConferenza = idConferenza;
		controller = c;
		
		t = new myTemplates();
		setTitle("Sci-Conference");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(685, 730);
		setLocationRelativeTo(null);
		setVisible(false);
		setIconImage(t.miniLogo);
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);

			NorthPanel = new NorthPanel();
			MainPanel.add(NorthPanel, BorderLayout.NORTH);


			CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new BorderLayout(0, 0));

				JLabel ProgrammaLbl = new JLabel("Programma");
				ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, new Color(192, 192, 192)));
				ProgrammaLbl.setForeground(t.scBlue);
				ProgrammaLbl.setFont(t.myFont(20));
				ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProgrammaLbl.setPreferredSize(new Dimension(46, 50));
				CentrPanel.add(ProgrammaLbl, BorderLayout.NORTH);

				PanelSlide SessioniSlider = new PanelSlide();
				SessioniSlider.setBackground(t.white);
				CentrPanel.add(SessioniSlider, BorderLayout.CENTER);

				SessioniPanels = new ArrayList<>();
				controller.addSessioniPanel(IdConferenza, SessioniPanels);
				SessioniSlider.show(SessioniPanels.get(n), AnimateType.TO_RIGHT);

				BackBtn = new JLblButton(t.scBlue, "Indietro");
				BackBtn.setFont(t.myFont(14));
				BackBtn.setPreferredSize(new Dimension(65, 19));
				BackBtn.setEnabled(false);
				CentrPanel.add(BackBtn, BorderLayout.WEST);
				BackBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						n --;
						if (n == 0) { BackBtn.setEnabled(false); }

						NextBtn.setEnabled(true);

						SessioniSlider.show(SessioniPanels.get(n), AnimateType.TO_RIGHT);
					}
				});

				NextBtn = new JLblButton(t.scBlue, "Avanti");
				if (SessioniPanels.size() > 1) { NextBtn.setEnabled(true); }
				else { NextBtn.setEnabled(false); }
				NextBtn.setFont(t.myFont(14));
				NextBtn.setPreferredSize(new Dimension(65, 19));
				CentrPanel.add(NextBtn, BorderLayout.EAST);
				NextBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						n ++;
						BackBtn.setEnabled(true);

						if (SessioniPanels.size() - 1 == n) { NextBtn.setEnabled(false); }

						SessioniSlider.show(SessioniPanels.get(n), AnimateType.TO_LEFT);
					}
				});


				JPanel NextInfoPanel = new JPanel();
				NextInfoPanel.setPreferredSize(new Dimension(10, 170));
				CentrPanel.add(NextInfoPanel, BorderLayout.SOUTH);
				NextInfoPanel.setLayout(new BorderLayout(0, 0));

				JPanel EntiPanel = new JPanel();
				EntiPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
				EntiPanel.setBackground(t.lGray);
				EntiPanel.setPreferredSize(new Dimension(190, 10));
				NextInfoPanel.add(EntiPanel, BorderLayout.WEST);
				EntiPanel.setLayout(new BorderLayout(0, 0));

				JLabel EntiLbl = new JLabel("Enti");
				EntiLbl.setFont(t.myFont(18));
				EntiLbl.setHorizontalAlignment(SwingConstants.CENTER);
				EntiLbl.setPreferredSize(new Dimension(18, 25));
				EntiPanel.add(EntiLbl, BorderLayout.NORTH);

				JScrollPane EntiScroller = new JScrollPane();
				EntiScroller.setBorder(null);
				EntiPanel.add(EntiScroller, BorderLayout.CENTER);

				EntiConteiner = new JPanel();
				EntiConteiner.setBackground(t.lGray);
				EntiScroller.setViewportView(EntiConteiner);
				EntiConteiner.setLayout(new BoxLayout(EntiConteiner, BoxLayout.Y_AXIS));

				JPanel SponsorPanel = new JPanel();
				SponsorPanel.setBorder(new EmptyBorder(17, 0, 0, 0));
				SponsorPanel.setBackground(t.lGray);
				SponsorPanel.setPreferredSize(new Dimension(190, 10));
				NextInfoPanel.add(SponsorPanel, BorderLayout.EAST);
				SponsorPanel.setLayout(new BorderLayout(0, 0));

				JLabel SponsorLbl = new JLabel("Sponsor");
				SponsorLbl.setFont(t.myFont(18));
				SponsorLbl.setHorizontalAlignment(SwingConstants.CENTER);
				SponsorLbl.setPreferredSize(new Dimension(18, 30));
				SponsorPanel.add(SponsorLbl, BorderLayout.NORTH);

				JScrollPane SponsorScroller = new JScrollPane();
				SponsorScroller.setBorder(new EmptyBorder(0, 0, 0, 0));
				SponsorPanel.add(SponsorScroller, BorderLayout.CENTER);

				SponsorConteiner = new JPanel();
				SponsorConteiner.setBackground(t.lGray);
				SponsorScroller.setViewportView(SponsorConteiner);
				SponsorConteiner.setLayout(new BoxLayout(SponsorConteiner, BoxLayout.Y_AXIS));

				JPanel OrganizzatoriPanel = new JPanel();
				OrganizzatoriPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
				OrganizzatoriPanel.setBackground(t.lGray);
				NextInfoPanel.add(OrganizzatoriPanel, BorderLayout.CENTER);
				OrganizzatoriPanel.setLayout(new BorderLayout(0, 0));

				JLabel ComitatoLbl = new JLabel("Comitato");
				ComitatoLbl.setBackground(t.lGray);
				ComitatoLbl.setPreferredSize(new Dimension(64, 30));
				ComitatoLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ComitatoLbl.setFont(t.myFont(18));
				OrganizzatoriPanel.add(ComitatoLbl, BorderLayout.NORTH);

				JScrollPane OrganizzatoriScroller = new JScrollPane();
				OrganizzatoriScroller.setBorder(null);
				OrganizzatoriPanel.add(OrganizzatoriScroller, BorderLayout.CENTER);

				OrganizzatoriConteiner = new JPanel();
				OrganizzatoriConteiner.setBackground(t.lGray);
				OrganizzatoriScroller.setViewportView(OrganizzatoriConteiner);
				OrganizzatoriConteiner.setLayout(new BoxLayout(OrganizzatoriConteiner, BoxLayout.Y_AXIS));

				OrgInfoPanel = new OrganizzatoreInfo(40);
				OrgInfoPanel.setPreferredSize(new Dimension(284, 90));
				popupMenu = new JPopupMenu();
				popupMenu.add(OrgInfoPanel);


			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.sxGray);
			SouthPanel.setPreferredSize(new Dimension(10, 42));
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][grow]", "[grow]"));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);

					JButton IndietroBtn = new JButton("Indietro");
					IndietroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					IndietroBtn.setPreferredSize(new Dimension(130, 25));
					SouthPanel.add(IndietroBtn, "cell 0 0,alignx left,growy");
					IndietroBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							controller.backFromConferenza(framePrecedente);
						}
					});

					IscrizioneCardLayout = new CardLayout(0, 0);

					IscrizioneCardPanel = new JPanel();
					IscrizioneCardPanel.setBackground(t.sxGray);
					SouthPanel.add(IscrizioneCardPanel, "cell 1 0,grow");
					IscrizioneCardPanel.setLayout(IscrizioneCardLayout);

					JPanel IscrivitiBtnConteiner = new JPanel();
					IscrivitiBtnConteiner.setBackground(t.sxGray);
					IscrizioneCardPanel.add(IscrivitiBtnConteiner, "Iscrizione");
					IscrivitiBtnConteiner.setLayout(new BorderLayout(0, 0));

						IscrivitiBtn IscrivitiBtn = new IscrivitiBtn(controller);
						IscrivitiBtnConteiner.add(IscrivitiBtn, BorderLayout.EAST);

					JLabel GiàIscrittoLbl = new JLabel("Sei gia iscritto a questa conferenza");
					GiàIscrittoLbl.setFont(t.myFont(16));
					GiàIscrittoLbl.setHorizontalAlignment(SwingConstants.RIGHT);
					GiàIscrittoLbl.setBackground(t.sxGray);
					IscrizioneCardPanel.add(GiàIscrittoLbl, "GiàIscritto");
					
					JPanel RimuoviBtnConteiner = new JPanel();
					RimuoviBtnConteiner.setBackground(t.sxGray);
					RimuoviBtnConteiner.setLayout(new BorderLayout(0, 0));
					IscrizioneCardPanel.add(RimuoviBtnConteiner, "Rimuovi");
					
						RimuoviConfBtn RimuoviBtn = new RimuoviConfBtn(controller, idConferenza);
						RimuoviBtnConteiner.add(RimuoviBtn, BorderLayout.EAST);
	}

	public String getFramePrecedente() { return framePrecedente; }

	public void setFramePrecedente(String frame) { framePrecedente = frame; }

	public String getId() { return IdConferenza; }
	
	public NorthPanel getNorthPanel() { return NorthPanel; }

	public JPanel getEntiConteiner() { return EntiConteiner; }

	public JPanel getSponsorConteiner() { return SponsorConteiner; }

	public JPanel getOrganizzatoriConteiner() { return OrganizzatoriConteiner; }


	public ArrayList<SessionePanel> getSessioniPanels(){ return SessioniPanels; }

	public void showLayer(String layer) { IscrizioneCardLayout.show(IscrizioneCardPanel, layer); }

	public JPanel getIscrizioneCardPanel() { return IscrizioneCardPanel; }


	public void showInfo() {

		for (Component l : OrganizzatoriConteiner.getComponents()) {
			l.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					showMenu(e);
					controller.addOrganizzatoreInfo(OrgInfoPanel, ((InfoLbl) l).getId());
				}
				@Override
				public void mouseExited(MouseEvent e) {
					popupMenu.setVisible(false);
				}
				private void showMenu(MouseEvent e) {
					popupMenu.setLocation(OrganizzatoriConteiner.getLocationOnScreen().x, l.getLocationOnScreen().y + 30);
					popupMenu.setVisible(true);
				}
			});
		}
	}
}