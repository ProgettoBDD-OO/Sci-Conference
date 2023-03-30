package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import linker.Controller;
import linker.ControllerLink;
import myTools.DateComboBox;
import myTools.FilterItem;
import myTools.JLblButton;
import myTools.myColors;

import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class FilterFrame extends JFrame {
	
	Controller controller;
	ControllerLink controllerLink;
	
	private myColors c = new myColors();
	
	private JPanel PlaceFilterPanel;
	
	private JPanel DateFilterPanel;
	private boolean DataPrecisaVisible;
	private boolean PeriodoVisible;
	private boolean MonthVisible;
	private boolean YearVisible;
	
	private JPanel TopicFilterPanel;
	
	public FilterFrame(String Titolo, Controller contr, ControllerLink contrLink) {
		
		controller = contr;
		controllerLink = contrLink;
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setSize(400, 400);
		setVisible(false);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controllerLink.foo();
			}
		});
		
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(c.scBlue);
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel FiltriLbl = new JLabel("Filtri di Ricerca");
			FiltriLbl.setForeground(c.white);
			FiltriLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
			FiltriLbl.setPreferredSize(new Dimension(70, 60));
			FiltriLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(FiltriLbl, BorderLayout.NORTH);
			
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(c.lGray);
			CentrPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			
				JScrollPane PlaceFilterScroller = new JScrollPane();
				PlaceFilterScroller.setBorder(null);
				PlaceFilterScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				PlaceFilterScroller.setPreferredSize(new Dimension(100, 2));
				CentrPanel.add(PlaceFilterScroller, BorderLayout.WEST);
				
					PlaceFilterPanel = new JPanel();
					PlaceFilterPanel.setBackground(c.lGray);
					PlaceFilterPanel.setLayout(new BoxLayout(PlaceFilterPanel, BoxLayout.Y_AXIS));
					PlaceFilterScroller.setViewportView(PlaceFilterPanel);
					executePlaceFilter();
					
					
				DataPrecisaVisible = false;
				PeriodoVisible = false;
				MonthVisible = false;
				YearVisible = false;
				
				DateFilterPanel = new JPanel();
				DateFilterPanel.setBackground(c.white);
				CentrPanel.add(DateFilterPanel, BorderLayout.CENTER);
				DateFilterPanel.setLayout(new MigLayout("wrap, fill", "[]", "[34px:n][][][][][][][][][][][]"));
				
					JLabel DateFilterLbl = new JLabel("Filtra per data");
					DateFilterLbl.setForeground(c.tangaroa);
					DateFilterLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
					DateFilterPanel.add(DateFilterLbl, "cell 0 0, alignx center, aligny center");
						
					JSeparator Separator1 = new JSeparator();
					DateFilterPanel.add(Separator1, "cell 0 1,grow");
						
						JLblButton DataPrecisaBtn = new JLblButton(c.tangaroa, "Data precisa");
						DataPrecisaBtn.setFont(new Font("Calibri Light", Font.PLAIN, 14));
						DataPrecisaBtn.setHorizontalAlignment(SwingConstants.RIGHT);
						DateFilterPanel.add(DataPrecisaBtn, "cell 0 2,alignx center,aligny center");
					
						DateComboBox DataPrecisaCmbBx = new DateComboBox();
						DataPrecisaCmbBx.setVisible(false);
						DataPrecisaCmbBx.setMaximumSize(new Dimension(165, 25));
						DataPrecisaCmbBx.setMinimumSize(new Dimension(165, 25));
						DateFilterPanel.add(DataPrecisaCmbBx, "cell 0 3,alignx center,aligny center");
					
						DataPrecisaBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								
								if (DataPrecisaVisible) { DataPrecisaCmbBx.setVisible(false); DataPrecisaVisible = false; } 
								
								else { DataPrecisaCmbBx.setVisible(true); DataPrecisaVisible = true; }
							}
							@Override
							public void mouseEntered(MouseEvent e) {
								DataPrecisaBtn.setForeground(c.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								DataPrecisaBtn.setForeground(c.tangaroa);
							}
						});
						
					JSeparator Separator2 = new JSeparator();
					DateFilterPanel.add(Separator2, "cell 0 4,grow");
					
						JLblButton PeriodoBtn = new JLblButton(c.tangaroa, "Periodo");
						PeriodoBtn.setFont(new Font("Calibri Light", Font.PLAIN, 14));
						PeriodoBtn.setHorizontalAlignment(SwingConstants.RIGHT);
						DateFilterPanel.add(PeriodoBtn, "cell 0 5,alignx center,aligny center");
						
						DateComboBox InizioPeriodoCmbBx = new DateComboBox();
						InizioPeriodoCmbBx.setVisible(false);
						InizioPeriodoCmbBx.setMaximumSize(new Dimension(165, 25));
						InizioPeriodoCmbBx.setMinimumSize(new Dimension(165, 25));
						DateFilterPanel.add(InizioPeriodoCmbBx, "cell 0 7,alignx center,aligny center");
						
						DateComboBox FinePeriodoCmbBx = new DateComboBox();
						FinePeriodoCmbBx.setVisible(false);
						FinePeriodoCmbBx.setMaximumSize(new Dimension(165, 25));
						FinePeriodoCmbBx.setMinimumSize(new Dimension(165, 25));
						DateFilterPanel.add(FinePeriodoCmbBx, "cell 0 8,alignx center,aligny center");
						
						PeriodoBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								if (PeriodoVisible) { 
									InizioPeriodoCmbBx.setVisible(false); 
									FinePeriodoCmbBx.setVisible(false);
									PeriodoVisible = false; 
								} else { 
									InizioPeriodoCmbBx.setVisible(true);
									FinePeriodoCmbBx.setVisible(true); 
									PeriodoVisible = true; 
								}
							}
							@Override
							public void mouseEntered(MouseEvent e) {
								PeriodoBtn.setForeground(c.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								PeriodoBtn.setForeground(c.tangaroa);
							}
						});
						
					JSeparator Separator3 = new JSeparator();
					DateFilterPanel.add(Separator3, "cell 0 9,grow");
					
						JPanel YearMonthConteiner = new JPanel();
						YearMonthConteiner.setBackground(c.white);
						DateFilterPanel.add(YearMonthConteiner, "cell 0 10,grow");
						YearMonthConteiner.setLayout(new MigLayout("wrap, fill", "[grow][grow]", "[][][]"));
						
						JLblButton MeseBtn = new JLblButton(c.tangaroa, "Mese");
						MeseBtn.setFont(new Font("Calibri Light", Font.PLAIN, 14));
						MeseBtn.setHorizontalAlignment(SwingConstants.RIGHT);
						YearMonthConteiner.add(MeseBtn, "cell 0 0,alignx center,aligny center");
						
						JComboBox<String> MeseBox = new JComboBox<String>();
						MeseBox.setVisible(false);
						MeseBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
						YearMonthConteiner.add(MeseBox, "cell 0 1,alignx center,aligny center");
						
						MeseBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								
								if (MonthVisible) { MeseBox.setVisible(false); MonthVisible = false; } 
								
								else { MeseBox.setVisible(true); MonthVisible = true; }
							}
							@Override
							public void mouseEntered(MouseEvent e) {
								MeseBtn.setForeground(c.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								MeseBtn.setForeground(c.tangaroa);
							}
						});
						
						JLblButton YearBtn = new JLblButton(c.tangaroa, "Anno");
						YearBtn.setFont(new Font("Calibri Light", Font.PLAIN, 14));
						YearMonthConteiner.add(YearBtn, "cell 1 0,alignx center,aligny center");
						
						JComboBox<String> YearBox = new JComboBox<String>();
						YearBox.setVisible(false);
						YearBox.setModel(new DefaultComboBoxModel<String>(new String[] {"22", "23", "24", "25", "26", "27"}));
						YearMonthConteiner.add(YearBox, "cell 1 1,alignx center,aligny center");
					
						YearBtn.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								
								if (YearVisible) { YearBox.setVisible(false); YearVisible = false; } 
								
								else { YearBox.setVisible(true); YearVisible = true; }
							}
							@Override
							public void mouseEntered(MouseEvent e) {
								YearBtn.setForeground(c.scBlue);
							}
							@Override
							public void mouseExited(MouseEvent e) {
								YearBtn.setForeground(c.tangaroa);
							}
						});
					
				JScrollPane TopicFilterScroller = new JScrollPane();
				TopicFilterScroller.setBorder(null);
				TopicFilterScroller.setPreferredSize(new Dimension(100, 2));
				TopicFilterScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				CentrPanel.add(TopicFilterScroller, BorderLayout.EAST);
				
					TopicFilterPanel = new JPanel();
					TopicFilterPanel.setBackground(c.lGray);
					TopicFilterPanel.setLayout(new BoxLayout(TopicFilterPanel, BoxLayout.Y_AXIS));
					TopicFilterScroller.setViewportView(TopicFilterPanel);
					executeTopicFilter();
	}
	
	
	private void executePlaceFilter() {
		
				FilterItem ValDAostaFilter = new FilterItem("Val d'Aosta", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem LombardiaFilter = new FilterItem("Lombardia", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem PiemonteFilter = new FilterItem("Piemonte", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem VenetoFilter = new FilterItem("Veneto", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem LiguriaFilter = new FilterItem("Liguria", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem FriuliVeneziaGiuliaFilter = new FilterItem("Friuli Venezia Giulia", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem TrentinoFilter = new FilterItem("Trentino Alto Adige", c.black, new Font("Calibri Light", Font.PLAIN, 12));
			
			FilterItem NordItaliaFilter = new FilterItem("Nord Italia", c.dBlue, new Font("Calibri Light", Font.PLAIN, 13), 
					   ValDAostaFilter, LombardiaFilter, PiemonteFilter, VenetoFilter, LiguriaFilter, FriuliVeneziaGiuliaFilter, TrentinoFilter);
			
			
				FilterItem EmiliaRomagnaFilter = new FilterItem("Emilia Romagna", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem ToscanaFilter = new FilterItem("Toscana", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem UmbriaFilter = new FilterItem("Umbria", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem MarcheFilter = new FilterItem("Marche", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem AbruzzoFilter = new FilterItem("Abruzzo", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem MoliseFilter = new FilterItem("Molise", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem LazioFilter = new FilterItem("Lazio", c.black, new Font("Calibri Light", Font.PLAIN, 12));
			
			FilterItem CentroItaliaFilter = new FilterItem("Centro Italia", c.dBlue, new Font("Calibri Light", Font.PLAIN, 13),
					   EmiliaRomagnaFilter, ToscanaFilter, UmbriaFilter, MarcheFilter, AbruzzoFilter, MoliseFilter, LazioFilter);
			
			
				FilterItem CampaniaFilter = new FilterItem("Campania", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem BasilicataFilter = new FilterItem("Basilicata", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem PugliaFilter = new FilterItem("Puglia", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem CalabriaFilter = new FilterItem("Calabria", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem SiciliaFilter = new FilterItem("Sicilia", c.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem SardegnaFilter = new FilterItem("Sardegna", c.black, new Font("Calibri Light", Font.PLAIN, 12));
			
			FilterItem SudItaliaFilter = new FilterItem("Sud Italia", c.dBlue, new Font("Calibri Light", Font.PLAIN, 13), 
					CampaniaFilter, BasilicataFilter, PugliaFilter, CalabriaFilter, SiciliaFilter, SardegnaFilter);
		
		FilterItem PlaceFilters = new FilterItem("Filtra per luogo", c.scBlue, new Font("Calibri Light", Font.PLAIN, 14), NordItaliaFilter, CentroItaliaFilter, SudItaliaFilter);
		
		addPlaceMenu(PlaceFilters);
	}
	
	
	private void executeTopicFilter() {
		
			FilterItem TemaPsicologia = new FilterItem("Psicologia", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaAnatomia = new FilterItem("Anatomia ", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaFisica = new FilterItem("Fisica", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaGeologia = new FilterItem("Geologia", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaSostenibilità = new FilterItem("Sostenibilità", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaAmbiente = new FilterItem("Ambiente", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaBiologia = new FilterItem("Biologia", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaChimica = new FilterItem("Chimica", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaInformatica = new FilterItem("Informatica", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaMatematica = new FilterItem("Matematica", c.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaAstrologia = new FilterItem("Astrologia", c.black, new Font("Calibri Light", Font.PLAIN, 13));
		
		FilterItem TopicFilters = new FilterItem("Filtra per tema", c.scBlue, new Font("Calibri Light", Font.PLAIN, 14), 
													TemaPsicologia, TemaAnatomia, TemaFisica, TemaGeologia, TemaSostenibilità, TemaAmbiente,
													TemaBiologia, TemaChimica, TemaInformatica, TemaMatematica, TemaAstrologia);
		addTopicMenu(TopicFilters);
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
							
							String filtro = "collocazione = ''" + f.getTxt() + "'' OR ";
							controllerLink.addQueryCollocazioni(filtro);
							controllerLink.addLuogoToLbl(f.getTxt());
							f.setBackground(c.dBlue);
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
						
						String filtro = "tema = '" + f.getTxt() + "' OR ";
						controllerLink.addQueryTemi(filtro);
						controllerLink.addTemaToLbl(f.getTxt());
						f.setBackground(c.dBlue);
						f.setTxtWhite();
					}
				});
			}
		}
		
		TopicFilterPanel.revalidate();
	}
}