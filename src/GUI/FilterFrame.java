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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import myTools.DateComboBox;
import myTools.FilterItem;
import myTools.JLblButton;

import javax.swing.JSeparator;
import java.awt.event.MouseEvent;

public class FilterFrame extends JFrame {
	
	private JPanel PlaceFilterPanel;
	
	private JPanel DateFilterPanel;
	
	private boolean DataPrecisaVisible;
	private boolean PeriodoVisible;
	private boolean MonthVisible;
	private boolean YearVisible;
	
	private JPanel TopicFilterPanel;
	private ArrayList<FilterItem> ArrayFilterItem = new ArrayList<FilterItem>();
	
	public FilterFrame(String Titolo) {
		
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setSize(400, 400);
		setVisible(false);
		setResizable(false);
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(0, 0, 200));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
			JLabel FiltriLbl = new JLabel("Filtri di Ricerca");
			FiltriLbl.setForeground(new Color(255, 255, 255));
			FiltriLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
			FiltriLbl.setPreferredSize(new Dimension(70, 60));
			FiltriLbl.setHorizontalAlignment(SwingConstants.CENTER);
			MainPanel.add(FiltriLbl, BorderLayout.NORTH);
			
			
			JPanel CentrPanel = new JPanel();
			CentrPanel.setBackground(new Color(246, 247, 248));
			CentrPanel.setLayout(new BorderLayout(0, 0));
			MainPanel.add(CentrPanel, BorderLayout.CENTER);
			
			JScrollPane PlaceFilterScroller = new JScrollPane();
			PlaceFilterScroller.setBorder(null);
			PlaceFilterScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			PlaceFilterScroller.setPreferredSize(new Dimension(100, 2));
			CentrPanel.add(PlaceFilterScroller, BorderLayout.WEST);
			
				PlaceFilterPanel = new JPanel();
				PlaceFilterPanel.setBackground(new Color(246, 247, 248));
				PlaceFilterPanel.setLayout(new BoxLayout(PlaceFilterPanel, BoxLayout.Y_AXIS));
				PlaceFilterScroller.setViewportView(PlaceFilterPanel);
				executePlaceFilter();
				
				
			DataPrecisaVisible = false;
			PeriodoVisible = false;
			MonthVisible = false;
			YearVisible = false;
			
			DateFilterPanel = new JPanel();
			DateFilterPanel.setBackground(new Color(255, 255, 255));
			CentrPanel.add(DateFilterPanel, BorderLayout.CENTER);
			DateFilterPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[34px:n][][][][][][][][][][][]"));
			
				JLabel DateFilterLbl = new JLabel("Filtra per data");
				DateFilterLbl.setForeground(new Color(20, 40, 60));
				DateFilterLbl.setFont(new Font("Calibri Light", Font.PLAIN, 18));
				DateFilterPanel.add(DateFilterLbl, "cell 0 0, alignx center, aligny center");
					
				JSeparator Separator1 = new JSeparator();
				DateFilterPanel.add(Separator1, "cell 0 1,grow");
					
					JLblButton DataPrecisaBtn = new JLblButton("Data precisa");
					DataPrecisaBtn.setForeground(new Color(20, 40, 60));
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
							DataPrecisaBtn.setForeground(new Color(0, 0, 200));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							DataPrecisaBtn.setForeground(new Color(20, 40, 60));
						}
					});
					
				JSeparator Separator2 = new JSeparator();
				DateFilterPanel.add(Separator2, "cell 0 4,grow");
				
					JLblButton PeriodoBtn = new JLblButton("Periodo");
					PeriodoBtn.setForeground(new Color(20, 40, 60));
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
							PeriodoBtn.setForeground(new Color(0, 0, 200));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							PeriodoBtn.setForeground(new Color(20, 40, 60));
						}
					});
					
				JSeparator Separator3 = new JSeparator();
				DateFilterPanel.add(Separator3, "cell 0 9,grow");
				
					JPanel YearMonthConteiner = new JPanel();
					YearMonthConteiner.setBackground(new Color(255, 255, 255));
					DateFilterPanel.add(YearMonthConteiner, "cell 0 10,grow");
					YearMonthConteiner.setLayout(new MigLayout("wrap, fill", "[grow][grow]", "[][][]"));
					
					JLblButton MeseBtn = new JLblButton("Mese");
					MeseBtn.setForeground(new Color(20, 40, 60));
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
							MeseBtn.setForeground(new Color(0, 0, 200));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							MeseBtn.setForeground(new Color(20, 40, 60));
						}
					});
					
					JLblButton YearBtn = new JLblButton("Anno");
					YearBtn.setForeground(new Color(20, 40, 60));
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
							YearBtn.setForeground(new Color(0, 0, 200));
						}
						@Override
						public void mouseExited(MouseEvent e) {
							YearBtn.setForeground(new Color(20, 40, 60));
						}
					});
				
			JScrollPane TopicFilterScroller = new JScrollPane();
			TopicFilterScroller.setBorder(null);
			TopicFilterScroller.setPreferredSize(new Dimension(100, 2));
			TopicFilterScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			CentrPanel.add(TopicFilterScroller, BorderLayout.EAST);
			
				TopicFilterPanel = new JPanel();
				TopicFilterPanel.setBackground(new Color(246, 247, 248));
				TopicFilterPanel.setLayout(new BoxLayout(TopicFilterPanel, BoxLayout.Y_AXIS));
				TopicFilterScroller.setViewportView(TopicFilterPanel);
				executeTopicFilter();
	}
	
	
	private void executePlaceFilter() {
		
				FilterItem ValDAostaFilter = new FilterItem("Val d'Aosta", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem LombardiaFilter = new FilterItem("Lombardia", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem PiemonteFilter = new FilterItem("Piemonte", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem VenetoFilter = new FilterItem("Veneto", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem LiguriaFilter = new FilterItem("Liguria", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem FriuliVeneziaGiuliaFilter = new FilterItem("Friuli Venezia Giulia", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem TrentinoFilter = new FilterItem("Trentino Alto Adige", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
			
			FilterItem NordItaliaFilter = new FilterItem("Nord Italia", new Color(0, 0, 140), new Font("Calibri Light", Font.PLAIN, 13), 
					   ValDAostaFilter, LombardiaFilter, PiemonteFilter, VenetoFilter, LiguriaFilter, FriuliVeneziaGiuliaFilter, TrentinoFilter);
			
			
				FilterItem EmiliaRomagnaFilter = new FilterItem("Emilia Romagna", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem ToscanaFilter = new FilterItem("Toscana", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem UmbriaFilter = new FilterItem("Umbria", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem MarcheFilter = new FilterItem("Marche", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem AbruzzoFilter = new FilterItem("Abruzzo", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem MoliseFilter = new FilterItem("Molise", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem LazioFilter = new FilterItem("Lazio", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
			
			FilterItem CentroItaliaFilter = new FilterItem("Centro Italia", new Color(0, 0, 140), new Font("Calibri Light", Font.PLAIN, 13),
					   EmiliaRomagnaFilter, ToscanaFilter, UmbriaFilter, MarcheFilter, AbruzzoFilter, MoliseFilter, LazioFilter);
			
			
				FilterItem CampaniaFilter = new FilterItem("Campania", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem BasilicataFilter = new FilterItem("Basilicata", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem PugliaFilter = new FilterItem("Puglia", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem CalabriaFilter = new FilterItem("Calabria", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem SiciliaFilter = new FilterItem("Sicilia", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
				FilterItem SardegnaFilter = new FilterItem("Sardegna", Color.black, new Font("Calibri Light", Font.PLAIN, 12));
			
			FilterItem SudItaliaFilter = new FilterItem("Sud Italia", new Color(0, 0, 140), new Font("Calibri Light", Font.PLAIN, 13), 
					CampaniaFilter, BasilicataFilter, PugliaFilter, CalabriaFilter, SiciliaFilter, SardegnaFilter);
		
		FilterItem PlaceFilters = new FilterItem("Filtra per luogo", new Color(0, 0, 200), new Font("Calibri Light", Font.PLAIN, 14), NordItaliaFilter, CentroItaliaFilter, SudItaliaFilter);
		
		addPlaceMenu(PlaceFilters);
	}
	
	
	private void executeTopicFilter() {
		
			FilterItem TemaPsicologia = new FilterItem("Psicologia", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaAnatomia = new FilterItem("Anatomia ", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaFisica = new FilterItem("Fisica", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaGeologia = new FilterItem("Geologia", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaSostenibilità = new FilterItem("Sostenibilità", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaAmbiente = new FilterItem("Ambiente", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaBiologia = new FilterItem("Biologia", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaChimica = new FilterItem("Chimica", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaInformatica = new FilterItem("Informatica", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaMatematica = new FilterItem("Matematica", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
			FilterItem TemaAstrologia = new FilterItem("Astrologia", Color.black, new Font("Calibri Light", Font.PLAIN, 13));
		
		FilterItem TopicFilters = new FilterItem("Filtra per tema", new Color(0, 0, 200), new Font("Calibri Light", Font.PLAIN, 14), 
													TemaPsicologia, TemaAnatomia, TemaFisica, TemaGeologia, TemaSostenibilità, TemaAmbiente,
													TemaBiologia, TemaChimica, TemaInformatica, TemaMatematica, TemaAstrologia);
		addTopicMenu(TopicFilters);
	}
	
	private void addPlaceMenu(FilterItem...menu) {
		
		for(int i = 0; i < menu.length; i++) {
			PlaceFilterPanel.add(menu[i]);
			ArrayList<FilterItem>subMenu = menu[i].getSubMenu();
			
			for(FilterItem m: subMenu) {
				addPlaceMenu(m);
			}
		}
		
		PlaceFilterPanel.revalidate();
	}
	
	
	private void addTopicMenu(FilterItem...menu) {
		
		for(int i = 0; i < menu.length; i++) {
			
			TopicFilterPanel.add(menu[i]);
			ArrayList<FilterItem>subMenu = menu[i].getSubMenu();
			
			for(FilterItem m: subMenu) {
				addTopicMenu(m);
				ArrayFilterItem.add(m);
			}
		}
		
		TopicFilterPanel.revalidate();
	}
	
	public ArrayList<FilterItem> getArrayFilterItem(){
		return ArrayFilterItem;
	}
}