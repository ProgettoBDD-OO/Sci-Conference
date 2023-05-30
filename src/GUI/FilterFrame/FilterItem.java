package GUI.FilterFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import myTools.JLblButton;
import java.awt.Cursor;


public class FilterItem extends JPanel {

	private boolean Showing = false;
	private ArrayList<FilterItem> SubMenu = new ArrayList<>();
	private JButton FilterItemBtn;

	public FilterItem(String name, Color c, Font f, FilterItem... subMenu) {

		setBackground(new Color(246, 247, 248));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(100, 42));
		setMaximumSize(new Dimension(100, 42));

		FilterItemBtn = new JButton(name);
		FilterItemBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FilterItemBtn.setBorder(null);
		FilterItemBtn.setFont(f);
		FilterItemBtn.setForeground(c);
		FilterItemBtn.setFocusPainted(false);
		add(FilterItemBtn, BorderLayout.CENTER);

		JSeparator FilterSeparator = new JSeparator();
		add(FilterSeparator, BorderLayout.SOUTH);

		for (FilterItem fi : subMenu) {
			this.SubMenu.add(fi);
			fi.setVisible(false);
		}

		FilterItemBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(Showing) { hideMenu(); Showing = false; }

				else { showMenu(); Showing = true; }
			}
		});
	}

	private void showMenu() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (FilterItem element : SubMenu) {

					sleep();
					element.setVisible(true);
				}
			}
		}).start();
	}

	private void hideMenu() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = SubMenu.size() - 1; i >= 0; i--) {

					sleep();
					for (FilterItem fi : SubMenu.get(i).getSubMenu()) {

						fi.setVisible(false);
					}
					SubMenu.get(i).setVisible(false);
				}
			}
		}).start();
	}

	private void sleep() {

		try { Thread.sleep(20); }

		catch(Exception e) { e.getMessage(); }
	}

	public ArrayList<FilterItem> getSubMenu() { return SubMenu; }

	public JButton getFilterItemBtn() { return FilterItemBtn; }

	public String getTxt() { return FilterItemBtn.getText(); }
}