package GUI.MainFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import myTools.JLblButton;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class CentrPanel extends JPanel{

	private myTemplates t;

	private CardLayout CentrCardLayout;
	private JPanel CentrCardPanel;

	private JLabel CentrLbl;

	private JButton AccediBtn;
	private JButton RegistratiBtn;

	private JPanel AfterAccess2;

	private JLblButton AggiungiConfBtn;
	private JLblButton ModifcaConfBtn;
	private JLblButton RimuoviConfBtn;

	public CentrPanel() {

		t = new myTemplates();
		setBackground(t.white);
		setLayout(new BorderLayout(0, 0));

		JPanel LogoPanel = new JPanel();
		LogoPanel.setBackground(t.white);
		LogoPanel.setBorder(new MatteBorder(0, 0, 1, 0, t.altGray));
		LogoPanel.setPreferredSize(new Dimension(10, 150));
		LogoPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
		add(LogoPanel, BorderLayout.NORTH);


			JLabel LogoContainer = new JLabel("");
			LogoContainer.setBounds(new Rectangle(0, 0, 460, 130));
			LogoPanel.add(LogoContainer, "cell 0 0,alignx center,aligny bottom");

			ImageIcon Logo = new ImageIcon(getClass().getResource("/Images/logo.png"));
			Image img = Logo.getImage();
			Image imgScale = img.getScaledInstance(LogoContainer.getWidth(), LogoContainer.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(imgScale);
			LogoContainer.setIcon(scaledIcon);


		JPanel UserConfPanel = new JPanel();
		UserConfPanel.setBackground(t.white);
		UserConfPanel.setLayout(new BorderLayout(0, 0));
		add(UserConfPanel, BorderLayout.CENTER);

			CentrLbl = new JLabel("Le tue Conferenze");
			CentrLbl.setPreferredSize(new Dimension(89, 200));
			CentrLbl.setHorizontalAlignment(SwingConstants.CENTER);
			CentrLbl.setForeground(t.scBlue);
			CentrLbl.setFont(t.myFont(28));
			UserConfPanel.add(CentrLbl, BorderLayout.NORTH);


			CentrCardLayout = new CardLayout();

			CentrCardPanel = new JPanel();
			CentrCardPanel.setBackground(t.white);
			UserConfPanel.add(CentrCardPanel, BorderLayout.CENTER);
			CentrCardPanel.setLayout(CentrCardLayout);

				JPanel BeforeAccess = new JPanel();
				BeforeAccess.setBackground(t.white);
				CentrCardPanel.add(BeforeAccess, "BeforeAccess");
				BeforeAccess.setLayout(new BorderLayout(0, 0));

					JLabel AccediRegistratiLbl = new JLabel("Accedi o Registrati per iscriverti ad una conferenza o visualizzare quelle a cui gia partecipi.");
					AccediRegistratiLbl.setForeground(t.altGray);
					AccediRegistratiLbl.setFont(t.myFont(20));
					AccediRegistratiLbl.setHorizontalAlignment(SwingConstants.CENTER);
					BeforeAccess.add(AccediRegistratiLbl, BorderLayout.CENTER);

					JPanel AccediRegistratiPanel = new JPanel();
					AccediRegistratiPanel.setBackground(t.white);
					AccediRegistratiPanel.setPreferredSize(new Dimension(10, 250));
					AccediRegistratiPanel.setLayout(new MigLayout("wrap, fill", "[][::10px][]", "[]"));
					BeforeAccess.add(AccediRegistratiPanel, BorderLayout.SOUTH);

						AccediBtn = new JLblButton(t.scBlue, "Accedi");
						AccediBtn.setFont(t.myFont(20));
						AccediRegistratiPanel.add(AccediBtn, "cell 0 0,alignx right,aligny top");
						AccediBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								AccediBtn.setBorderPainted(true);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								AccediBtn.setBorderPainted(false);
							}
						});

						JLabel OLbl = new JLabel("o");
						OLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
						OLbl.setForeground(t.scBlue);
						AccediRegistratiPanel.add(OLbl, "cell 1 0,alignx center,aligny top");

						RegistratiBtn = new JLblButton(t.scBlue, "Registrati");
						RegistratiBtn.setFont(t.myFont(20));
						AccediRegistratiPanel.add(RegistratiBtn, "cell 2 0,alignx left,aligny top");

						RegistratiBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseEntered(MouseEvent e) {
								RegistratiBtn.setBorderPainted(true);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								RegistratiBtn.setBorderPainted(false);
							}
						});


				JPanel AfterAccess1 = new JPanel();
				AfterAccess1.setBackground(t.white);
				CentrCardPanel.add(AfterAccess1, "NoConf");
				AfterAccess1.setLayout(new BorderLayout(0, 0));

				JLabel NoConfLbl = new JLabel("Non sei iscritto ancora ad una conferenza");
				NoConfLbl.setForeground(t.altGray);
				NoConfLbl.setFont(t.myFont(20));
				NoConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
				AfterAccess1.add(NoConfLbl, BorderLayout.CENTER);

				JScrollPane ConfScroller = new JScrollPane();
				ConfScroller.setBackground(t.white);
				ConfScroller.setBorder(new EmptyBorder(0, 110, 30, 100));
				CentrCardPanel.add(ConfScroller, "UserConf");

				AfterAccess2 = new JPanel();
				AfterAccess2.setBackground(t.white);
				AfterAccess2.setLayout(new BoxLayout(AfterAccess2, BoxLayout.Y_AXIS));
				ConfScroller.setViewportView(AfterAccess2);

				JPanel AdminPanel = new JPanel();
				AdminPanel.setBackground(new Color(255, 255, 255));
				CentrCardPanel.add(AdminPanel, "Admin");
				AdminPanel.setLayout(new MigLayout("wrap, fill", "[][][]", "[]"));

					AggiungiConfBtn = new JLblButton(t.scBlue, "Aggiungi una conferenza");
					AggiungiConfBtn.setFont(t.myFont(20));
					AdminPanel.add(AggiungiConfBtn, "cell 0 0, alignx center, aligny center");
					AggiungiConfBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							AggiungiConfBtn.setBorderPainted(true);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							AggiungiConfBtn.setBorderPainted(false);
						}
					});

					ModifcaConfBtn = new JLblButton(t.scBlue, "Modifica una conferenza");
					ModifcaConfBtn.setFont(t.myFont(20));
					AdminPanel.add(ModifcaConfBtn, "cell 1 0, alignx center, aligny center");
					ModifcaConfBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							ModifcaConfBtn.setBorderPainted(true);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							ModifcaConfBtn.setBorderPainted(false);
						}
					});

					RimuoviConfBtn = new JLblButton(t.scBlue, "Rimuovi una conferenza");
					RimuoviConfBtn.setFont(t.myFont(20));
					AdminPanel.add(RimuoviConfBtn, "cell 2 0, alignx center, aligny center");
					RimuoviConfBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							RimuoviConfBtn.setForeground(t.red);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							RimuoviConfBtn.setForeground(t.scBlue);
						}
					});
	}

	public JPanel getCentrCardPanel() { return CentrCardPanel; }

	public void showLayer(String layer) { CentrCardLayout.show(CentrCardPanel, layer); }


	public JLabel getCentrLbl() { return CentrLbl; }


	public JButton getAccediBtn() { return AccediBtn; }

	public JButton getRegistratiBtn() { return RegistratiBtn; }


	public JPanel getUserConfAfterAccess2() { return AfterAccess2;}


	public JLblButton getAggiungiConfBtn() { return AggiungiConfBtn; }

	public JLblButton getModificaConfBtn() { return ModifcaConfBtn; }

	public JLblButton getRimuoviConfBtn() { return RimuoviConfBtn; }
}