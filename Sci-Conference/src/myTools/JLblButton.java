package myTools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;


public class JLblButton extends JButton {

	private myTemplates t;

	public JLblButton(Color c, String... Info) {

		t = new myTemplates();
		setText(Info[0]);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setForeground(c);
		setFont(t.myFont(14));
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		setBorder(new MatteBorder(0, 0, 1, 0, c));
		setBorderPainted(false);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { setForeground(t.scBlue); }
			@Override
			public void mouseExited(MouseEvent e) { setForeground(c); }
		});
	}
}