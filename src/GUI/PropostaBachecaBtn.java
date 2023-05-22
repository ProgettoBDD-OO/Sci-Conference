package GUI;

import linker.Controller;
import myTools.JLblButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;


public class PropostaBachecaBtn extends JLblButton {

	public PropostaBachecaBtn(Controller contr, String... Info) {
		
		super(new Color(120, 180, 255), Info);
		setFont(new Font("Calibri Light", Font.PLAIN, 17));
		setBorder(new EmptyBorder(25, 0, 25, 0));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				contr.setInfoConfBacheca(DxPanel.getCbPanel(), getText());
//				showMenu(e);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				DxPanel.getPopupMenu().setVisible(false);
//			}
//			private void showMenu(MouseEvent e) {
//				DxPanel.getPopupMenu().setLocation(DxPanel.getLocationOnScreen().x, getLocationOnScreen().y + 50);
//				DxPanel.getPopupMenu().setVisible(true);
//			}
//		});
	}
}