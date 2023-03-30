package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLblButton extends JButton{

	public JLblButton(String Text) {
		setText(Text);
        setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 105, 110)));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setForeground(new Color(90, 100, 110));
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        setFocusPainted(false);
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);

       
	}
}