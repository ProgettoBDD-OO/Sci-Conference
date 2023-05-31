package GUI.AdminFrames;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import linker.Controller;
import myException.EmptyFieldException;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class InfoDialog extends JDialog {

	private Controller controller;

	private myTemplates t;

	private JPanel InfoConteiner;

	public InfoDialog(Controller c, String comingFrom) {

		controller = c;
		t = new myTemplates();
		
		setSize(300, 285);
		setModal(true);
		setLocationRelativeTo(null);
		setIconImage(t.miniLogo);

		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			MainPanel.add(scrollPane, BorderLayout.CENTER);

				InfoConteiner = new JPanel();
				InfoConteiner.setBackground(t.white);
				scrollPane.setViewportView(InfoConteiner);
				InfoConteiner.setLayout(new MigLayout("wrap, fill", "[grow]", "10[]10"));

			JButton ConfermaBtn = new JButton("Conferma");
			ConfermaBtn.setForeground(t.white);
			ConfermaBtn.setBackground(t.scBlue);
			ConfermaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ConfermaBtn.setPreferredSize(new Dimension(89, 30));
			MainPanel.add(ConfermaBtn, BorderLayout.SOUTH);
			ConfermaBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if (comingFrom.equals("Enti")) {

						try { controller.addEnti(); }

						catch (EmptyFieldException efe) { System.out.println(efe); }

					} else {

						try { controller.addSponsor(); }

						catch (EmptyFieldException efe) { System.out.println(efe); }
					}
				}
			});
	}

	public JPanel getInfoConteiner() { return InfoConteiner; }
}