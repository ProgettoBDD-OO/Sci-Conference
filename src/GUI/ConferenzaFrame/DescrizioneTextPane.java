package GUI.ConferenzaFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class DescrizioneTextPane extends JTextPane{

	public DescrizioneTextPane(String txt) {
		
		setText(txt);
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(30, 47, 60));
		setFont(new Font("Calibri Light", Font.PLAIN, 14));
		setEditable(false);
		setPreferredSize(new Dimension(200, 40));
		
		StyledDocument doc = getStyledDocument();
		SimpleAttributeSet attributeSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), attributeSet, false);
	}
}