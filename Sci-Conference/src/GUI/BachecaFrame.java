package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import linker.Controller;
import myTools.TopicSelectionPanel;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;

public class BachecaFrame extends JFrame {

	private Controller controller;

	private myTemplates t = new myTemplates();

	private JTextField NomeConfTxt;
	private JTextArea DescrizioneConfTxt;
	private TopicSelectionPanel TemiConteiner;

	public BachecaFrame(Controller c) {

		controller = c;

		setTitle("Sci-Conference - Bacheca");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(642, 685);
		setLocationRelativeTo(null);
		setVisible(false);
		setResizable(false);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.lGray);
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));
		setContentPane(MainPanel);


		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(t.lGray);
		NorthPanel.setPreferredSize(new Dimension(10, 130));
		NorthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][]"));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);

			JLabel ProposteLbl1 = new JLabel("Aggiungi la tua idea per una conferenza!");
			ProposteLbl1.setForeground(t.tangaroa);
			ProposteLbl1.setFont(t.myFont(22));
			NorthPanel.add(ProposteLbl1, "cell 0 0,alignx center,growy");

			JLabel ProposteLbl2 = new JLabel("La tua proposta potrà essere visualizzata sulla bacheca e presa in considerazione.");
			ProposteLbl2.setForeground(t.tangaroa);
			ProposteLbl2.setFont(t.myFont(18));
			NorthPanel.add(ProposteLbl2, "cell 0 1,alignx center,growy");


		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(t.white);
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BorderLayout(0, 0));


			JPanel InfoPanel = new JPanel();
			InfoPanel.setPreferredSize(new Dimension(10, 244));
			InfoPanel.setBackground(t.white);
			CentrPanel.add(InfoPanel, BorderLayout.NORTH);
			InfoPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][::25px]15[::30px][60px:n]15[::30px]"));

						JLabel NomeConfLbl = new JLabel("Nome:");
						NomeConfLbl.setForeground(t.scBlue);
						NomeConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
						InfoPanel.add(NomeConfLbl, "cell 0 0,alignx left,aligny bottom");

						NomeConfTxt = new JTextField();
						NomeConfTxt.setForeground(t.tangaroa);
						NomeConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
						NomeConfTxt.setFont(new Font("Calibri Light", Font.PLAIN, 16));
						InfoPanel.add(NomeConfTxt, "cell 0 1,alignx left,growy");
						NomeConfTxt.setColumns(20);

					JLabel DescrizioneConfLbl = new JLabel("Descrizione:");
					DescrizioneConfLbl.setForeground(t.scBlue);
					DescrizioneConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					InfoPanel.add(DescrizioneConfLbl, "cell 0 2,alignx left,aligny bottom");

					DescrizioneConfTxt = new JTextArea();
					DescrizioneConfTxt.setLineWrap(true);
					DescrizioneConfTxt.setWrapStyleWord(true);
					DescrizioneConfTxt.setForeground(t.tangaroa);
					DescrizioneConfTxt.setBorder(new MatteBorder(1, 1, 1, 1, t.scBlue));
					DescrizioneConfTxt.setFont(t.myFont(16));
					DescrizioneConfTxt.setPreferredSize(new Dimension(340, 22));
					InfoPanel.add(DescrizioneConfTxt, "cell 0 3,alignx left,growy");

					JLabel TemaConfLbl = new JLabel("Tema:");
					TemaConfLbl.setForeground(t.scBlue);
					TemaConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
					InfoPanel.add(TemaConfLbl, "cell 0 4,alignx left,aligny bottom");


			TemiConteiner = new TopicSelectionPanel();
			CentrPanel.add(TemiConteiner, BorderLayout.CENTER);


		JPanel SouthPanel = new JPanel();
		SouthPanel.setBackground(t.lGray);
		SouthPanel.setPreferredSize(new Dimension(10, 85));
		SouthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		MainPanel.add(SouthPanel, BorderLayout.SOUTH);
		SouthPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));

			JButton AnnullaBtn = new JButton("Annulla");
			AnnullaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			AnnullaBtn.setPreferredSize(new Dimension(130, 30));
			SouthPanel.add(AnnullaBtn, "cell 0 0,alignx right,aligny bottom");
			AnnullaBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.backFromBacheca();
				}
			});

			JButton ConfermaBtn = new JButton("Conferma");
			ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ConfermaBtn.setForeground(t.white);
			ConfermaBtn.setBackground(t.scBlue);
			ConfermaBtn.setPreferredSize(new Dimension(130, 30));
			SouthPanel.add(ConfermaBtn, "cell 1 0,alignx left,aligny bottom");
			ConfermaBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.confermaBacheca();
				}
			});
	}

	public String getNomeConf() { return NomeConfTxt.getText(); }

	public String getDescrizioneConf() { return DescrizioneConfTxt.getText(); }

	public ButtonGroup getButtonGroup() { return TemiConteiner.getButtonGroup(); }


	public boolean fieldsAreEmpty() {

		if (getNomeConf().isEmpty() || getDescrizioneConf().isEmpty() || getButtonGroup().getSelection().getActionCommand().isEmpty()) {

			return true;

		} else { return false; }
	}
}