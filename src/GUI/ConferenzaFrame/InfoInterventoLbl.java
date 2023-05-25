package GUI.ConferenzaFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class InfoInterventoLbl extends JLabel {

	private String IdOrganizzatore;

	public InfoInterventoLbl(String txt, String idOrganizzatore) {

		setText(txt);
		setForeground(new Color(30, 47, 60));
		setFont(new Font("Calibri Light", Font.PLAIN, 14));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setAlignmentY(Component.TOP_ALIGNMENT);

		if (!idOrganizzatore.isEmpty()) {

			IdOrganizzatore = idOrganizzatore;
			setFont(new Font("Calibri Light", Font.PLAIN, 15));
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) { setForeground(new Color(0, 0, 200)); }
				@Override
				public void mouseExited(MouseEvent e) { setForeground(new Color(30, 47, 60)); }
			});
		}
	}

	public String getId() { return IdOrganizzatore; }
}