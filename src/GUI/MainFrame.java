package GUI;
import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Menu.FilterItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private JTextField SearchBar;
	private JPanel Menus;
	private boolean ShowFilter = false;
	
	public MainFrame(String Titolo) {
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainPanel.setBackground(new Color(240, 240, 220));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(50, 40));
		
		
		
//_____________________________________________Pannello sinistro
		
		JPanel SxPanel = new JPanel();
		SxPanel.setBackground(new Color(240, 240, 220));
		SxPanel.setPreferredSize(new Dimension(320, 10));
		MainPanel.add(SxPanel, BorderLayout.WEST);
		SxPanel.setLayout(new MigLayout("wrap, fill,", "[]", "[][][][][][]"));
		
		JLabel ProxConfLbl = new JLabel("Conferenze future");
		ProxConfLbl.setForeground(new Color(0, 0, 200));
		ProxConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ProxConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		SxPanel.add(ProxConfLbl, "cell 0 0,growx,aligny top");
		
		JLabel Gennaio = new JLabel("Gennaio");
		Gennaio.setForeground(new Color(0, 0, 200));
		Gennaio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SxPanel.add(Gennaio, "cell 0 1");
		
		JTextPane ConfGennaio = new JTextPane();
		ConfGennaio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ConfGennaio.setText("08 - Ambiente \r\n16 - Energia nucleare\r\n27 - Fisica quantistica\r\n30 - Le rinnovabili\r\n");
		ConfGennaio.setBackground(new Color(240, 240, 220));
		SxPanel.add(ConfGennaio, "cell 0 2,grow");
		
		JLabel Febbraio = new JLabel("Febbraio");
		Febbraio.setForeground(new Color(0, 0, 200));
		Febbraio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SxPanel.add(Febbraio, "cell 0 3");
		
		JTextPane ConfFebbraio = new JTextPane();
		ConfFebbraio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ConfFebbraio.setText("02 - Gli oceani\r\n07 - Vita oltre il pianeta\r\n12 - Acqua\r\n14 - Pi greco\r\n");
		ConfFebbraio.setBackground(new Color(240, 240, 220));
		SxPanel.add(ConfFebbraio, "cell 0 4,grow");
		
		JLabel Calendario = new JLabel("Mostra tutto");
		Calendario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Calendario.setForeground(new Color(0, 0, 200));
		Calendario.setHorizontalAlignment(SwingConstants.RIGHT);
		SxPanel.add(Calendario, "cell 0 5,alignx right");
		
		
		
//_____________________________________________Pannello destro
		
		JPanel DxPanel = new JPanel();
		DxPanel.setBackground(new Color(240, 240, 220));
		DxPanel.setPreferredSize(new Dimension(320, 10));
		MainPanel.add(DxPanel, BorderLayout.EAST);
		DxPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::100px]20[center]20[::100px]"));
		
		JLabel BachecaLbl = new JLabel("Bacheca\r\n");
		BachecaLbl.setForeground(new Color(0, 0, 200));
		BachecaLbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		DxPanel.add(BachecaLbl, "cell 0 0,alignx center,aligny top");
		
		JTextPane Bacheca = new JTextPane();
		Bacheca.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 220)));
		Bacheca.setBackground(new Color(60, 60, 60));
		Bacheca.setMargin(new Insets(5, 5, 5, 5));
		DxPanel.add(Bacheca, "cell 0 1,grow");
		
		JLabel GetIdeaLbl = new JLabel("Aggiungi la tua idea");
		GetIdeaLbl.setForeground(new Color(0, 0, 220));
		GetIdeaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GetIdeaLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DxPanel.add(GetIdeaLbl, "cell 0 2,alignx center,aligny center");
		
		
		
//_____________________________________________Pannello centrale
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 200)));
		CentrPanel.setBackground(new Color(240, 240, 220));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		
		JLabel YourConfTitle = new JLabel("Le tue conferenze");
		YourConfTitle.setBorder(new EmptyBorder(50, 0, 0, 0));
		YourConfTitle.setHorizontalAlignment(SwingConstants.CENTER);
		YourConfTitle.setForeground(new Color(0, 0, 200));
		YourConfTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		CentrPanel.add(YourConfTitle);
		
		
		
//_____________________________________________Pannello superiore
		
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(new Color(240, 240, 220));
		NorthPanel.setPreferredSize(new Dimension(30, 220));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new MigLayout("wrap, fill", "[200:n:320]20[]20[200:n:320,grow]", "[][:200px:200px,grow]"));
		
		JButton LogInBtn = new JButton("Accedi");
		LogInBtn.setMinimumSize(new Dimension(100, 30));
		LogInBtn.setMaximumSize(new Dimension(110, 40));
		LogInBtn.setPreferredSize(new Dimension(110, 30));
		NorthPanel.add(LogInBtn, "cell 0 0,alignx left,aligny bottom");
		
		JButton SignUpBtn = new JButton("Registrati");
		SignUpBtn.setMinimumSize(new Dimension(100, 30));
		SignUpBtn.setMaximumSize(new Dimension(110, 30));
		SignUpBtn.setPreferredSize(new Dimension(110, 30));
		NorthPanel.add(SignUpBtn, "cell 0 1,alignx left,aligny top");
		
		
		JScrollPane FilterScrollPane = new JScrollPane();
		FilterScrollPane.setBackground(new Color(240, 240, 220));
        FilterScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        FilterScrollPane.setBorder(null);
        NorthPanel.add(FilterScrollPane, "cell 2 1,grow");
        
        Menus = new JPanel();
        Menus.setBackground(new Color(240, 240, 220));
        Menus.setLayout(new BoxLayout(Menus, BoxLayout.Y_AXIS));
        FilterScrollPane.setViewportView(Menus);
        execute();
        FilterScrollPane.setVisible(false);
        
		JButton FilterBtn = new JButton("");
		FilterBtn.setBackground(new Color(0, 0, 200));
		FilterBtn.setMinimumSize(new Dimension(30, 30));
		FilterBtn.setMaximumSize(new Dimension(30, 30));
		FilterBtn.setPreferredSize(new Dimension(30, 30));
		NorthPanel.add(FilterBtn, "flowx,cell 2 0,alignx left,growy");
		
		FilterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (ShowFilter) {
					FilterScrollPane.setVisible(false);
					ShowFilter = false;
				} else {
					FilterScrollPane.setVisible(true);
					ShowFilter = true;
				}
			}
		});
		
		SearchBar = new JTextField();
		SearchBar.setMinimumSize(new Dimension(250, 30));
		SearchBar.setPreferredSize(new Dimension(250, 30));
		SearchBar.setMaximumSize(new Dimension(300, 50));
		SearchBar.setHorizontalAlignment(SwingConstants.LEFT);
		SearchBar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		SearchBar.setForeground(new Color(192, 192, 192));
		SearchBar.setText("cerca una conferenza");
		SearchBar.setColumns(10);
		NorthPanel.add(SearchBar, "cell 2 0,grow");
		
		JLabel LogoConteiner = new JLabel("");
		LogoConteiner.setPreferredSize(new Dimension(530, 140));
        LogoConteiner.setBounds(new Rectangle(228, 11, 620, 170));
		LogoConteiner.setHorizontalAlignment(SwingConstants.CENTER);
		NorthPanel.add(LogoConteiner, "cell 1 1,grow");
		
		ImageIcon Logo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\logo.png");
		Image img = Logo.getImage();
		Image imgScale = img.getScaledInstance(LogoConteiner.getWidth(), LogoConteiner.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        LogoConteiner.setIcon(scaledIcon);
	}

	private void execute() {
		FilterItem DtFltrSpecific = new FilterItem("Data specifica", Color.black);
		FilterItem DtFltrBetween = new FilterItem("Periodo di tempo", Color.black);
		FilterItem DtFltrMonth = new FilterItem("Mese", Color.black);
		
		FilterItem CityFilter = new FilterItem("Città", Color.black);
		FilterItem RegioneFilter = new FilterItem("Regione", Color.black);
		
		FilterItem DataFilters = new FilterItem("Filtra per data", Color.blue,  DtFltrSpecific, DtFltrBetween, DtFltrMonth);
		FilterItem PlaceFilters = new FilterItem("Filtra per luogo", Color.blue, CityFilter, RegioneFilter);
		FilterItem ThemeFilters = new FilterItem("Filtra per tema", Color.blue);
		
		addMenu(DataFilters, PlaceFilters, ThemeFilters);
	}
	
	private void addMenu(FilterItem...menu) {
		for(int i = 0; i < menu.length; i++) {
			Menus.add(menu[i]);
			ArrayList<FilterItem>subMenu = menu[i].getSubMenu();
			for(FilterItem m:subMenu) {
				addMenu(m);
			}
		}
		
		Menus.revalidate();
	}
}