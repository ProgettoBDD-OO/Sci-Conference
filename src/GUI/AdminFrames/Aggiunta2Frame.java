package GUI.AdminFrames;

import linker.Controller;
import GUI.ConferenzaFrame.SessionePanel;
import myTools.JLblButton;
import myTools.PanelSlide;
import myTools.PanelSlide.AnimateType;
import myTools.myTemplates;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;


public class Aggiunta2Frame extends JFrame {

	Controller controller;

	private myTemplates t;
	private Integer[] n = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	private JLabel EntiLbl;
	private JComboBox<Integer> EntiComboBox;
	private JScrollPane EntiScroller;
	private JPanel EntiConteiner;
	private ArrayList<String> Enti;

	private JLabel SponsorLbl;
	private JPanel SponsorConteiner;
	private JComboBox<Integer> SponsorComboBox;
	private JScrollPane SponsorScroller;

	private JLabel OrganizzatoriLbl;
	private JPanel OrganizzatoriContainer;
	private JComboBox<Integer> OrganizzatoriComboBox;

	private JPanel SessioniContainer;
	private JComboBox<Integer> SessioniComboBox;
	private ArrayList<SessionePanel> Sessioni;
	private PanelSlide SessioniSlider;
	private int currentSession;
	private JLblButton BackBtn;
	private JLblButton NextBtn;

	private BackFromAggiunta2Btn IndietroBtn;
	private ConfermaAggiuntaConfBtn ConfermaBtn;


	public Aggiunta2Frame(Controller c) {

		controller = c;
		t = new myTemplates();
		
		setTitle("Sci-Conference - Aggiunta");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(642, 815);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);

			JLabel AddConfLbl = new JLabel("Aggiungi le altre informazioni");
			AddConfLbl.setForeground(t.gray);
			AddConfLbl.setFont(t.myFont(28));
			AddConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			AddConfLbl.setPreferredSize(new Dimension(46, 85));
			MainPanel.add(AddConfLbl, BorderLayout.NORTH);

			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.white);
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			CentrPanel.setLayout(new MigLayout("fill", "[grow]", "[][::30px][::30px][][::30px][::30px][::250px]"));


			JPanel EntiSponsorContainer = new JPanel();
			EntiSponsorContainer.setBackground(t.white);
			CentrPanel.add(EntiSponsorContainer, "cell 0 0,grow");
			EntiSponsorContainer.setLayout(new MigLayout("wrap, fill", "[][]", "[::30px][::30px][]"));

				Enti = new ArrayList<>();

				EntiLbl = new JLabel("Enti (seleziona il numero)");
				EntiLbl.setForeground(t.scBlue);
				EntiLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				EntiSponsorContainer.add(EntiLbl, "cell 0 0,alignx center,aligny top");

				EntiComboBox = new JComboBox<>();
				EntiComboBox.setPreferredSize(new Dimension(85, 22));
				EntiComboBox.setModel(new DefaultComboBoxModel<>(n));
				EntiSponsorContainer.add(EntiComboBox, "cell 0 1,alignx center,aligny top");
				EntiComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						controller.goToEnti();
					}
				});

				EntiScroller = new JScrollPane();
				EntiScroller.setBorder(null);
				EntiSponsorContainer.add(EntiScroller, "cell 0 2, grow");

				EntiConteiner = new JPanel();
				EntiConteiner.setMaximumSize(new Dimension(32767, 85));
				EntiConteiner.setBackground(t.white);
				EntiScroller.setViewportView(EntiConteiner);
				EntiConteiner.setLayout(new BoxLayout(EntiConteiner, BoxLayout.Y_AXIS));

				SponsorLbl = new JLabel("Sponsor (seleziona il numero)");
				SponsorLbl.setForeground(t.scBlue);
				EntiSponsorContainer.add(SponsorLbl, "cell 1 0,alignx center,aligny top");
				SponsorLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));

				SponsorComboBox = new JComboBox<>();
				SponsorComboBox.setPreferredSize(new Dimension(85, 22));
				SponsorComboBox.setModel(new DefaultComboBoxModel<>(n));
				EntiSponsorContainer.add(SponsorComboBox, "cell 1 1,alignx center,aligny top");
				SponsorComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						controller.goToSponsor();
					}
				});

				SponsorScroller = new JScrollPane();
				SponsorScroller.setBorder(null);
				EntiSponsorContainer.add(SponsorScroller, "cell 1 2,grow");

				SponsorConteiner = new JPanel();
				SponsorConteiner.setMaximumSize(new Dimension(32767, 85));
				SponsorConteiner.setBackground(t.white);
				SponsorScroller.setViewportView(SponsorConteiner);
				SponsorConteiner.setLayout(new BoxLayout(SponsorConteiner, BoxLayout.Y_AXIS));


			OrganizzatoriLbl = new JLabel("Organizzatori");
			OrganizzatoriLbl.setForeground(t.scBlue);
			OrganizzatoriLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			CentrPanel.add(OrganizzatoriLbl, "cell 0 1,alignx left,aligny center");

			OrganizzatoriComboBox = new JComboBox<>();
			OrganizzatoriComboBox.setEnabled(false);
			OrganizzatoriComboBox.setPreferredSize(new Dimension(85, 22));
			OrganizzatoriComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
			OrganizzatoriComboBox.setModel(new DefaultComboBoxModel<>(n));
			CentrPanel.add(OrganizzatoriComboBox, "cell 0 2,alignx left,aligny top");
			OrganizzatoriComboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						controller.goToOrganizzatori();
					}
				});

			OrganizzatoriContainer = new JPanel();
			OrganizzatoriContainer.setBackground(t.white);
			OrganizzatoriContainer.setLayout(new GridLayout(4, 3, 0, 0));
			CentrPanel.add(OrganizzatoriContainer, "cell 0 3,grow");


			Sessioni = new ArrayList<>();

			JLabel SessioniLbl = new JLabel("Sessioni (seleziona il numero)");
			SessioniLbl.setForeground(t.scBlue);
			SessioniLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			CentrPanel.add(SessioniLbl, "cell 0 4,alignx left,aligny center");

			SessioniComboBox = new JComboBox<>();
			SessioniComboBox.setPreferredSize(new Dimension(100, 22));
			SessioniComboBox.setModel(new DefaultComboBoxModel<>(n));
			CentrPanel.add(SessioniComboBox, "cell 0 5,alignx left,aligny top");
			SessioniComboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToSessioni();
				}
			});


			SessioniContainer = new JPanel();
			SessioniContainer.setPreferredSize(new Dimension(10, 300));
			SessioniContainer.setBackground(t.white);
			SessioniContainer.setLayout(new BorderLayout(0, 0));
			CentrPanel.add(SessioniContainer, "cell 0 6,grow");

				JLabel ProgrammaLbl = new JLabel("Elenco Sessioni");
				ProgrammaLbl.setBorder(new MatteBorder(1, 0, 0, 0, new Color(192, 192, 192)));
				ProgrammaLbl.setForeground(t.scBlue);
				ProgrammaLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				ProgrammaLbl.setHorizontalAlignment(SwingConstants.CENTER);
				ProgrammaLbl.setPreferredSize(new Dimension(38, 42));
				SessioniContainer.add(ProgrammaLbl, BorderLayout.NORTH);

				SessioniSlider = new PanelSlide();
				SessioniSlider.setBackground(t.white);
				SessioniSlider.show(new JLabel(), AnimateType.TO_RIGHT);
				SessioniContainer.add(SessioniSlider, BorderLayout.CENTER);

				BackBtn = new JLblButton(t.scBlue, "Indietro");
				BackBtn.setEnabled(false);
				BackBtn.setFont(t.myFont(14));
				BackBtn.setPreferredSize(new Dimension(65, 19));
				SessioniContainer.add(BackBtn, BorderLayout.WEST);
				BackBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						currentSession --;
						if (currentSession == 0) { BackBtn.setEnabled(false); }

						NextBtn.setEnabled(true);

						SessioniSlider.show(Sessioni .get(currentSession), AnimateType.TO_RIGHT);
					}
				});

				NextBtn = new JLblButton(new Color(0, 0, 200), "Avanti");
				NextBtn.setFont(t.myFont(14));
				NextBtn.setPreferredSize(new Dimension(65, 19));
				NextBtn.setEnabled(false);
				SessioniContainer.add(NextBtn, BorderLayout.EAST);
				NextBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						currentSession ++;
						BackBtn.setEnabled(true);

						if (Sessioni.size() - 1 == currentSession) { NextBtn.setEnabled(false); }
						SessioniSlider.show(Sessioni .get(currentSession), AnimateType.TO_LEFT);
					}
				});


			JPanel SouthPanel = new JPanel();
			SouthPanel.setBackground(t.lGray);
			SouthPanel.setPreferredSize(new Dimension(10, 70));
			SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
			MainPanel.add(SouthPanel, BorderLayout.SOUTH);

				IndietroBtn = new BackFromAggiunta2Btn(controller);
				SouthPanel.add(IndietroBtn, "cell 0 0,alignx right,aligny bottom");

				ConfermaBtn = new ConfermaAggiuntaConfBtn(controller);
				SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
	}

    public JComboBox<Integer> getnEnti() { return EntiComboBox; }

    public JPanel getEntiConteiner() { return EntiConteiner; }

    public ArrayList<String> getEnti(){ return Enti; }


    public JComboBox<Integer> getnSponsor() { return SponsorComboBox; }

    public JPanel getSponsorConteiner() { return SponsorConteiner; }


    public JComboBox<Integer> getNumeroOrganizzatori() { return OrganizzatoriComboBox; }

    public JPanel getOrganizzatoriConteiner() { return OrganizzatoriContainer; }


    public JComboBox<Integer> getNumeroSessioni() { return SessioniComboBox; }

	public PanelSlide getSessioniSlider() { return SessioniSlider; }

    public ArrayList<SessionePanel> getSessioni() { return Sessioni; }

    public JLblButton getNextBtn() { return NextBtn; }


    public boolean fieldsAreEmpty() {

    	if (EntiConteiner.getComponents().length == 0 || SponsorConteiner.getComponents().length == 0
    	|| OrganizzatoriContainer.getComponents().length == 0 || getSessioni().isEmpty()) {

    		return true;

		} else { return false; }
    }
}
