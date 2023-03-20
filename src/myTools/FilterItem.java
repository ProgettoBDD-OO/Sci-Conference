package myTools;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.BorderLayout;

public class FilterItem extends JPanel {
	
	private boolean Showing = false;
	private ArrayList<FilterItem> SubMenu = new ArrayList<>();
	private JToggleButton FilterItemLbl;
	
	public FilterItem(String FilterItemName, Color ColoreTesto, Font GrandezzaFont, FilterItem... subMenu) {
				
		setBackground(new Color(246, 247, 248));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		
		FilterItemLbl = new JToggleButton("MenuItem");
		FilterItemLbl.setContentAreaFilled(false);
		FilterItemLbl.setBorder(null);
		FilterItemLbl.setFont(GrandezzaFont);
		FilterItemLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FilterItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
		FilterItemLbl.setText(FilterItemName);
		FilterItemLbl.setForeground(ColoreTesto);
		this.setPreferredSize(new Dimension(100, 50));
		this.setMaximumSize(new Dimension(100, 50));
		setLayout(new BorderLayout(0, 0));
		add(FilterItemLbl, BorderLayout.CENTER);
		
		JSeparator FilterSeparator = new JSeparator();
		add(FilterSeparator, BorderLayout.SOUTH);
		
		for (int i = 0; i < subMenu.length; i++) {
			this.SubMenu.add(subMenu[i]);
			subMenu[i].setVisible(false);
		}
		
		FilterItemLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(Showing) {
					hideMenu();
					Showing = false;
				} else {
					showMenu();
					Showing = true;
				}
			}
		});
	}
	

	public ArrayList<FilterItem> getSubMenu() {
		return SubMenu;
	}
	
	private void showMenu() {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < SubMenu.size(); i++) {
					sleep();
					SubMenu.get(i).setVisible(true);
				}
			}
		}).start();
	}
	
	private void hideMenu() {
		new Thread(new Runnable() {
			public void run() {
				for (int i = SubMenu.size() - 1; i >= 0; i--) {
					sleep();
					SubMenu.get(i).setVisible(false);
				}
			}
		}).start();
	}
	
	private void sleep() {
		try {
			Thread.sleep(20);
		} catch(Exception e) {}
	}
	
	public JToggleButton getFilterItemLbl() { return FilterItemLbl; }
}