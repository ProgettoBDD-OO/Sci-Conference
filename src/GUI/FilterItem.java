package GUI;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilterItem extends JPanel {
	
	private boolean Showing = false;
	private ArrayList<FilterItem> SubMenu = new ArrayList<>();
	
	public FilterItem(String FilterItemName, Color ColoreTesto,  FilterItem... subMenu) {
				
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setPreferredSize(new Dimension(Integer.MAX_VALUE, 45));
		setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		
		JLabel FilterItemLbl = new JLabel("MenuItem");
		FilterItemLbl.setText(FilterItemName);
		FilterItemLbl.setForeground(ColoreTesto);
		FilterItemLbl.setHorizontalAlignment(SwingConstants.CENTER);
		FilterItemLbl.setBounds(10, 11, 100, 26);
		add(FilterItemLbl);
		
		JSeparator FilterSeparator = new JSeparator();
		FilterSeparator.setBounds(10, 35, 100, 2);
		add(FilterSeparator);
		
		for (int i = 0; i < subMenu.length; i++) {
			this.SubMenu.add(subMenu[i]);
			subMenu[i].setVisible(false);
		}
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(Showing) { hideMenu(); Showing = false; } 
				
				else { showMenu(); Showing = true; }
			}
		});
	}

	public ArrayList<FilterItem> getSubMenu() { return SubMenu; }
	
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
				for (int i = SubMenu.size()-1; i >= 0; i--) {
					sleep();
					SubMenu.get(i).setVisible(false);
				}
			}
		}).start();
	}
	
	private void sleep() {
		
		try { Thread.sleep(20); } catch(Exception e) {}
	}
}