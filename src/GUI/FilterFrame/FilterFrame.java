package GUI.FilterFrame;

import linker.Controller;
import myTools.myTemplates;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;


public class FilterFrame extends JFrame {
	
	Controller controller;
	
	private myTemplates t = new myTemplates();
	private DateFilters DateFilterPanel;
	private JPanel PlaceFilterPanel;
	private JPanel TopicFilterPanel;
	
	private String collocazione = "";
	private String tema = "";
	
	public FilterFrame(String Titolo,  Controller c) {
		
		controller = c;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setSize(400, 400);
		setVisible(false);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.scBlue);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel FiltriLbl = new JLabel("Filtri di Ricerca");
			FiltriLbl.setForeground(t.white);
			FiltriLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
			FiltriLbl.setPreferredSize(new Dimension(70, 60));
			FiltriLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(FiltriLbl, BorderLayout.NORTH);
			
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.lGray);
			CentrPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			
				JScrollPane PlaceFilterScroller = new JScrollPane();
				PlaceFilterScroller.setBorder(null);
				PlaceFilterScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				PlaceFilterScroller.setPreferredSize(new Dimension(100, 2));
				CentrPanel.add(PlaceFilterScroller, BorderLayout.WEST);
				
					PlaceFilterPanel = new JPanel();
					PlaceFilterPanel.setBackground(t.lGray);
					PlaceFilterPanel.setLayout(new BoxLayout(PlaceFilterPanel, BoxLayout.Y_AXIS));
					PlaceFilterScroller.setViewportView(PlaceFilterPanel);
					
					PlaceFilters placeFilters = new PlaceFilters();
					addPlaceMenu(placeFilters.executePlaceFilter(PlaceFilterPanel));
					
					DateFilterPanel = new DateFilters();
					CentrPanel.add(DateFilterPanel, BorderLayout.CENTER);
				
					
				JScrollPane TopicFilterScroller = new JScrollPane();
				TopicFilterScroller.setBorder(null);
				TopicFilterScroller.setPreferredSize(new Dimension(100, 2));
				TopicFilterScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				CentrPanel.add(TopicFilterScroller, BorderLayout.EAST);
				
					TopicFilterPanel = new JPanel();
					TopicFilterPanel.setBackground(t.lGray);
					TopicFilterPanel.setLayout(new BoxLayout(TopicFilterPanel, BoxLayout.Y_AXIS));
					TopicFilterScroller.setViewportView(TopicFilterPanel);
					TopicFilters topicFilters = new TopicFilters();
					addTopicMenu(topicFilters.executeTopicFilter());
					
					
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					
					if (DateFilterPanel.getDataPrecisaCmbBx().getAAMMGG().isEmpty()) {
						
						controller.backFromFiltri();
						
					} else { 
						
						controller.addQueryData("data_inizio = '" + DateFilterPanel.getDataPrecisaCmbBx().getAAMMGG() + "' OR "); 
						controller.addDataLbl(DateFilterPanel.getDataPrecisaCmbBx().getAAMMGG());
						controller.backFromFiltri();
					}
					
					if (DateFilterPanel.getInizioPeriodioCmbBx().getAAMMGG().isEmpty()) {
						
						controller.backFromFiltri();
						
					} else {
						controller.addDataLbl("dal " + DateFilterPanel.getInizioPeriodioCmbBx().getAAMMGG() + " al " +DateFilterPanel.getFinePeriodoCmbBx().getAAMMGG());
						controller.addQueryData("data_inizio BETWEEN '" + DateFilterPanel.getInizioPeriodioCmbBx().getAAMMGG() + "' AND '"+ DateFilterPanel.getFinePeriodoCmbBx().getAAMMGG() +"' OR ");
					}
				}
			});
	}
	
	
	private void addPlaceMenu(FilterItem... menu) {
		
		for(int i = 0; i < menu.length; i++) {
				
			PlaceFilterPanel.add(menu[i]);
			ArrayList<FilterItem> subMenu = menu[i].getSubMenu();
				
			for(FilterItem f: subMenu) {
					
				addPlaceMenu(f);
	
				if (!f.getTxt().equals("Nord Italia") && !f.getTxt().equals("Centro Italia") && !f.getTxt().equals("Sud Italia")) {
						
					f.getFilterItemBtn().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							collocazione +=  "'" + f.getTxt() + "', ";
							controller.addQueryCollocazioni(collocazione);
							controller.addLuogoToLbl(f.getTxt());
							f.setBackground(t.dBlue);
							f.setTxtWhite();
						}
					});
				}
			}
		}
		
		PlaceFilterPanel.revalidate();
	}
	
	
	private void addTopicMenu(FilterItem... menu) {
		
		for(int i = 0; i < menu.length; i++) {
			
			TopicFilterPanel.add(menu[i]);
			ArrayList<FilterItem> subMenu = menu[i].getSubMenu();
			
			for(FilterItem f: subMenu) {
				
				addTopicMenu(f);
				f.getFilterItemBtn().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						tema = "'" + f.getTxt() + "', ";
						controller.addQueryTemi(tema);
						controller.addTemaToLbl(f.getTxt());
						f.setBackground(t.dBlue);
						f.setTxtWhite();
					}
				});
			}
		}
		
		TopicFilterPanel.revalidate();
	}
}