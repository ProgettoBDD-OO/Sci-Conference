package GUI.FilterFrame;

import javax.swing.*;

import myTools.JLblButton;

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
	private JLblButton FilterItemBtn;
	
	public FilterItem(String name, Color c, Font f, FilterItem... subMenu) {
				
		setBackground(new Color(246, 247, 248));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(100, 50));
		setMaximumSize(new Dimension(100, 50));
		
		FilterItemBtn = new JLblButton(c, name);
		FilterItemBtn.setBorder(null);
		FilterItemBtn.setFont(f);
		add(FilterItemBtn, BorderLayout.CENTER);
		
		JSeparator FilterSeparator = new JSeparator();
		add(FilterSeparator, BorderLayout.SOUTH);
		
		for (int i = 0; i < subMenu.length; i++) {
			this.SubMenu.add(subMenu[i]);
			subMenu[i].setVisible(false);
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
					for (int j = 0; j < SubMenu.get(i).getSubMenu().size(); j++) {
						
						SubMenu.get(i).getSubMenu().get(j).setVisible(false);
					}
					SubMenu.get(i).setVisible(false);
				}
			}
		}).start();
	}
	
	private void sleep() {
		
		try { Thread.sleep(20); } 
		
		catch(Exception e) {}
	}
	
	public ArrayList<FilterItem> getSubMenu() { return SubMenu; }
	
	public JLblButton getFilterItemBtn() { return FilterItemBtn; }
	
	public String getTxt() { return FilterItemBtn.getText(); }
	
	public void setTxtWhite() { FilterItemBtn.setForeground(new Color(255, 255, 255)); }
}