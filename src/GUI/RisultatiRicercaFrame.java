package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import linker.Controller;
import myTools.myTemplates;
import myTools.myTxtFld;
import net.miginfocom.swing.MigLayout;

public class RisultatiRicercaFrame extends JFrame{

	private myTemplates t;

	private Controller controller;

	private CardLayout RisultatiCardLayout;
	private JPanel RisultatiCardPanel;

	private JPanel RisultatiPanel;

	private JButton IndietroBtn;

	public RisultatiRicercaFrame(Controller c) {

		controller = c;

		t = new myTemplates();
		setTitle("Sci-Conference - Risultati Ricerca");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(470, 560);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);

			JLabel RisultatiLbl = new JLabel("Risultati");
			RisultatiLbl.setForeground(t.tangaroa);
			RisultatiLbl.setFont(t.myFont(28));
			RisultatiLbl.setHorizontalAlignment(SwingConstants.CENTER);
			RisultatiLbl.setPreferredSize(new Dimension(38, 100));
			MainPanel.add(RisultatiLbl, BorderLayout.NORTH);

			RisultatiCardLayout = new CardLayout(0, 0);

			RisultatiCardPanel = new JPanel();
			RisultatiCardPanel.setBackground(t.white);
			RisultatiCardPanel.setLayout(RisultatiCardLayout);
			MainPanel.add(RisultatiCardPanel, BorderLayout.CENTER);

				JLabel NoResultsLbl = new JLabel("La ricerca non ha prodotto risultati.");
				NoResultsLbl.setForeground(t.tangaroa);
				NoResultsLbl.setFont(t.myFont(18));
				NoResultsLbl.setHorizontalAlignment(SwingConstants.CENTER);
				RisultatiCardPanel.add(NoResultsLbl, "NoResults");

				JScrollPane RisultatiScroller = new JScrollPane();
				RisultatiScroller.setBorder(null);
				RisultatiScroller.getVerticalScrollBar().setUnitIncrement(15);
				RisultatiCardPanel.add(RisultatiScroller, "ResultsScroller");

					RisultatiPanel = new JPanel();
					RisultatiScroller.setViewportView(RisultatiPanel);
					RisultatiPanel.setBorder(new EmptyBorder(0, 13, 0, 13));
					RisultatiPanel.setBackground(t.white);
					RisultatiPanel.setLayout(new BoxLayout(RisultatiPanel, BoxLayout.Y_AXIS));


			JPanel IndietroBtnConteiner = new JPanel();
			IndietroBtnConteiner.setBackground(t.white);
			IndietroBtnConteiner.setPreferredSize(new Dimension(10, 100));
			MainPanel.add(IndietroBtnConteiner, BorderLayout.SOUTH);
			IndietroBtnConteiner.setLayout(new MigLayout("wrap, fill", "[]", "[]"));

			IndietroBtn = new JButton("Indietro");
			IndietroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			IndietroBtn.setPreferredSize(new Dimension(107, 25));
			IndietroBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.backFromRisultati();
				}
			});

			IndietroBtnConteiner.add(IndietroBtn, "flowx,cell 0 0,alignx left,aligny center");
	}


	public JPanel getRisultatiCardPanel() {
		return RisultatiCardPanel;
	}

	public void showLayer(String layer) { RisultatiCardLayout.show(RisultatiCardPanel, layer); }

	public JPanel getRisultatiPanel() {
		return RisultatiPanel;
	}

	public JButton getIndietroBtn() {
		return IndietroBtn;
	}
}