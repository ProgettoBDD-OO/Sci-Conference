package GUI.FilterFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import linker.Controller;
import myTools.myTemplates;


public class FilterFrame extends JFrame {

	private Controller controller;

	private myTemplates t;

	private DateFilters DateFilterPanel;
	private JPanel PlaceFilterPanel;
	private JPanel TopicFilterPanel;

	private String collocazione = "";
	private String tema = "";

	public FilterFrame(Controller c) {

		controller = c;

		t = new myTemplates();
		setTitle("Sci-Conference - Filtri");
		setSize(410, 340);
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(t.scBlue);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));

			JLabel FiltriLbl = new JLabel("Filtri di Ricerca");
			FiltriLbl.setForeground(t.white);
			FiltriLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
			FiltriLbl.setPreferredSize(new Dimension(67, 50));
			FiltriLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(FiltriLbl, BorderLayout.NORTH);


			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(t.lGray);
			CentrPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);

				JScrollPane PlaceFilterScroller = new JScrollPane();
				PlaceFilterScroller.setBorder(null);
				PlaceFilterScroller.getVerticalScrollBar().setUnitIncrement(10);
				PlaceFilterScroller.setPreferredSize(new Dimension(125, 2));
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
				TopicFilterScroller.setPreferredSize(new Dimension(125, 2));
				TopicFilterScroller.getVerticalScrollBar().setUnitIncrement(10);
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

					if (!DateFilterPanel.getDataPrecisaCmbBx().getAAMMGG().isEmpty()) {

						controller.addQueryDataPrecisa("'" + DateFilterPanel.getDataPrecisaCmbBx().getAAMMGG() + "'");
						controller.addDataLbl(getDataPrecisa());
					}
						
					if (!getInizioPeriodo().isEmpty() && !getFinePeriodo().isEmpty()) {
						controller.addQueryPeriodo(", '" + getInizioPeriodo() + "', '" +  getFinePeriodo() + "'");
						controller.addDataLbl("dal " + getInizioPeriodo() + " al " + getFinePeriodo()); 
					}

					controller.backFromFiltri();
				}
			});
	}

	public String getDataPrecisa() { return DateFilterPanel.getDataPrecisaCmbBx().getAAMMGG(); }

	public String getInizioPeriodo() { return DateFilterPanel.getInizioPeriodioCmbBx().getAAMMGG(); }

	public String getFinePeriodo() { return DateFilterPanel.getFinePeriodoCmbBx().getAAMMGG(); }


	private void addPlaceMenu(FilterItem... menu) {

		for (FilterItem element : menu) {

			PlaceFilterPanel.add(element);
			ArrayList<FilterItem> subMenu = element.getSubMenu();

			for(FilterItem f: subMenu) {

				addPlaceMenu(f);

				if (!f.getTxt().equals("Nord Italia") && !f.getTxt().equals("Centro Italia") && !f.getTxt().equals("Sud Italia")) {

					f.getFilterItemBtn().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							collocazione +=  "'" + f.getTxt() + "', ";
							controller.addQueryCollocazioni(collocazione);
							controller.addLuogoToLbl(f.getTxt());
							f.getFilterItemBtn().setEnabled(false);
						}
					});
				}
			}
		}

		PlaceFilterPanel.revalidate();
	}


	private void addTopicMenu(FilterItem... menu) {

		for (FilterItem element : menu) {

			TopicFilterPanel.add(element);
			ArrayList<FilterItem> subMenu = element.getSubMenu();

			for(FilterItem f: subMenu) {

				addTopicMenu(f);
				f.getFilterItemBtn().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						tema = "'" + f.getTxt() + "', ";
						controller.addQueryTemi(tema);
						controller.addTemaToLbl(f.getTxt());
						f.getFilterItemBtn().setEnabled(false);
					}
				});
			}
		}

		TopicFilterPanel.revalidate();
	}
}