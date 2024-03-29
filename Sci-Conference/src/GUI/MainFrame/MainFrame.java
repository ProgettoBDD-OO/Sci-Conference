package GUI.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import linker.Controller;
import myTools.JLblButton;


public class MainFrame extends JFrame {

	private Controller controller;

	private WestPanel SxPanel;
	private CentrPanel CtrPanel;
	private EastPanel DxPanel;

	public MainFrame(Controller c) {

		controller = c;

		setTitle("Sci-Conference");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 685);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());

		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(null);
		MainPanel.setBackground(new Color(255, 255, 255));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));



//_______________________________________________________________Panello Sinistro

		SxPanel = new WestPanel();

			controller.addConfToCalendarPanel(SxPanel);

			SxPanel.getCalendario().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToCalendario();
				}
			});

			SxPanel.getSignUpBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToSignUp();
				}
			});

			SxPanel.getLogInBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToLogIn();
				}
			});

			SxPanel.getAfferenzeBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToAfferenze();
				}
			});

		MainPanel.add(SxPanel, BorderLayout.WEST);


//_______________________________________________________________Panello Centrale

		CtrPanel = new CentrPanel();

			CtrPanel.getRegistratiBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToSignUp();
				}
			});

			CtrPanel.getAccediBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToLogIn();
				}
			});

			CtrPanel.getAggiungiConfBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToAggiunta();
				}
			});

			CtrPanel.getModificaConfBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToElencoModifica();
				}
			});

			CtrPanel.getRimuoviConfBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToRisultati3();
				}
			});

		MainPanel.add(CtrPanel, BorderLayout.CENTER);


//_______________________________________________________________Panello Destro

		DxPanel = new EastPanel(controller);

			controller.addConfToBacheca(DxPanel);

			DxPanel.getFilterBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					DxPanel.getFilterBtn().setEnabled(false);
					controller.goToFiltri();
				}
			});

			DxPanel.getResearchBar().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == 10) { controller.goToRisultati(); }
				}
			});

			DxPanel.getClearFltrBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.resetQueryFiltri();
					DxPanel.resetFilterLbl();
					DxPanel.getClearFltrBtn().setVisible(false);
				}
			});


			for (Component lBtn : DxPanel.getBacheca().getComponents()) {

				lBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						controller.setInfoConfBacheca(DxPanel.getCbPanel(), ((JLblButton) lBtn).getText());
						showMenu(e);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						DxPanel.getPopupMenu().setVisible(false);
					}
					private void showMenu(MouseEvent e) {
						DxPanel.getPopupMenu().setLocation(DxPanel.getLocationOnScreen().x, lBtn.getLocationOnScreen().y + 50);
						DxPanel.getPopupMenu().setVisible(true);
					}
				});
			}


			DxPanel.getAddIdeaBtn().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.goToBacheca();
				}
			});

		MainPanel.add(DxPanel, BorderLayout.EAST);

		setVisible(true);
	}


	public WestPanel getSxPanel() { return SxPanel; }

	public CentrPanel getCtrPanel() { return CtrPanel; }

	public EastPanel getDxPanel() { return DxPanel; }

	public String getResearchTxt() { return DxPanel.getResearchBar().getText(); }
}