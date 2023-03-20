package GUI;
import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame{
	
	private JTextField ResearchBar;
	private JButton AddIdeaBtn;
	private JButton CalendarioBtn;
	private JButton LogInBtn;
	private JButton SignUpBtn;
	private JPanel MenusPanel;
	private boolean ShowFilter = false;
	
	public MainFrame(String Titolo) {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 800);
		setLocationRelativeTo(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(null);
		MainPanel.setBackground(new Color(255, 255, 255));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		
		
//_______________________________________________________________Panello Sinistro
		
		JPanel SxPanel = new JPanel();
		SxPanel.setBackground(new Color(240, 241, 242));
		SxPanel.setPreferredSize(new Dimension(300, 10));
		MainPanel.add(SxPanel, BorderLayout.WEST);
		SxPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel UserPanel = new JPanel();
		UserPanel.setBackground(new Color(240, 241, 242));
		UserPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(150, 151, 152)));
		UserPanel.setPreferredSize(new Dimension(10, 60));
		SxPanel.add(UserPanel, BorderLayout.NORTH);
		UserPanel.setLayout(new MigLayout("wrap, fill", "[][]", "[]"));
		
		LogInBtn = new JButton("Accedi");
		LogInBtn.setBackground(new Color(250, 250, 250));
		LogInBtn.setPreferredSize(new Dimension(130, 30));
		UserPanel.add(LogInBtn, "cell 0 0,alignx right,aligny center");
		
		SignUpBtn = new JButton("Registrati\r\n");
		SignUpBtn.setBackground(new Color(250, 250, 250));
		SignUpBtn.setPreferredSize(new Dimension(130, 30));
		UserPanel.add(SignUpBtn, "cell 1 0,alignx left,aligny center");
		
		JPanel CalendarioPanel = new JPanel();
		CalendarioPanel.setBackground(new Color(240, 241, 242));
		SxPanel.add(CalendarioPanel, BorderLayout.CENTER);
		CalendarioPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][][][]"));
		
		CalendarioBtn = new JButton("Mostra tutto");
		CalendarioBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CalendarioBtn.setForeground(new Color(90, 100, 110));
		CalendarioBtn.setHorizontalAlignment(SwingConstants.CENTER);
		CalendarioBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CalendarioBtn.setFocusPainted(false);
		CalendarioBtn.setMargin(new Insets(0, 0, 0, 0));
		CalendarioBtn.setContentAreaFilled(false);
		CalendarioBtn.setBorderPainted(false);
		CalendarioBtn.setOpaque(false);
		CalendarioPanel.add(CalendarioBtn, "cell 0 4,alignx center,aligny center");
		
		
		
//_______________________________________________________________Panello Centrale		
		
		JPanel CentrPanel = new JPanel();
		CentrPanel.setBackground(new Color(255, 255, 255));
		MainPanel.add(CentrPanel, BorderLayout.CENTER);
		CentrPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel LogoPanel = new JPanel();
		LogoPanel.setBackground(new Color(255, 255, 255));
		LogoPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(150, 151, 152)));
		LogoPanel.setPreferredSize(new Dimension(10, 140));
		CentrPanel.add(LogoPanel, BorderLayout.NORTH);
		LogoPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
		
		JLabel LogoConteiner = new JLabel("");
		LogoConteiner.setBounds(new Rectangle(0, 0, 460, 130));
		LogoPanel.add(LogoConteiner, "cell 0 0,alignx center,aligny bottom");
		
		ImageIcon Logo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\logo.png");
		Image img = Logo.getImage();
		Image imgScale = img.getScaledInstance(LogoConteiner.getWidth(), LogoConteiner.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		LogoConteiner.setIcon(scaledIcon);
		
		JPanel UserConfPanel = new JPanel();
		UserConfPanel.setBackground(new Color(255, 255, 255));
		CentrPanel.add(UserConfPanel, BorderLayout.CENTER);
		UserConfPanel.setLayout(new MigLayout("wrap, fill", "[]", "[][][]"));
		
		JLabel UserConfLbl = new JLabel("Le tue Conferenze");
		UserConfLbl.setForeground(new Color(0, 0, 200));
		UserConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		UserConfPanel.add(UserConfLbl, "cell 0 0,alignx center,aligny center");
		
		JLabel lblNewLabel = new JLabel("Aggiungi una conferenza\r\n");
		lblNewLabel.setForeground(new Color(90, 100, 110));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		UserConfPanel.add(lblNewLabel, "cell 0 2,alignx center,aligny center");
			
		
		
//_______________________________________________________________Panello Destro
		
		JPanel DxPanel = new JPanel();
		DxPanel.setBackground(new Color(242, 243, 244));
		DxPanel.setPreferredSize(new Dimension(300, 10));
		MainPanel.add(DxPanel, BorderLayout.EAST);
		DxPanel.setLayout(new BorderLayout(0, 0));
		
			JPanel ResearchPanel = new JPanel();
			ResearchPanel.setBackground(new Color(255, 255, 255));
			ResearchPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(150, 151, 152)));
			ResearchPanel.setPreferredSize(new Dimension(10, 140));
			DxPanel.add(ResearchPanel, BorderLayout.NORTH);
			ResearchPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[][grow]"));
			
				JButton FilterBtn = new JButton("");
				FilterBtn.setMinimumSize(new Dimension(30, 30));
				FilterBtn.setPreferredSize(new Dimension(30, 30));
				ResearchPanel.add(FilterBtn, "flowx,cell 0 0,alignx center,aligny top");
				
				ResearchBar = new JTextField();
				ResearchBar.setForeground(new Color(150, 150, 150));
				ResearchBar.setFont(new Font("Tahoma", Font.ITALIC, 11));
				ResearchBar.setText("cerca una conferenza");
				ResearchBar.setPreferredSize(new Dimension(10, 30));
				ResearchPanel.add(ResearchBar, "cell 0 0,growx,aligny top");
				ResearchBar.setColumns(10);
				
				JScrollPane FilterScrollPane = new JScrollPane();
				FilterScrollPane.setBackground(new Color(255, 255, 255));
	        	FilterScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        	FilterScrollPane.setBorder(null);	
	        	ResearchPanel.add(FilterScrollPane, "cell 0 1,grow");
	        	
				MenusPanel = new JPanel();
		   		MenusPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		    	MenusPanel.setMaximumSize(new Dimension(120, 32767));
		    	MenusPanel.setBackground(new Color(255, 255, 255));
		    	MenusPanel.setLayout(new BoxLayout(MenusPanel, BoxLayout.Y_AXIS));
		    	FilterScrollPane.setViewportView(MenusPanel);
		    	
		    	execute();
		    	FilterScrollPane.setVisible(false);
		    	
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
			
		    	
			JPanel BachecaPanel = new JPanel();
			BachecaPanel.setBackground(new Color(243, 244, 245));
			DxPanel.add(BachecaPanel, BorderLayout.CENTER);
			BachecaPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::100px][][::100px]"));
			
			JLabel BachecaLbl = new JLabel("Bacheca");
			BachecaLbl.setForeground(new Color(90, 100, 110));
			BachecaLbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
			BachecaPanel.add(BachecaLbl, "cell 0 0,alignx center,aligny center");
			
			JPanel Bacheca = new JPanel();
			Bacheca.setMaximumSize(new Dimension(32767, 500));
			Bacheca.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 200)));
			Bacheca.setBackground(new Color(140, 141, 142));
			BachecaPanel.add(Bacheca, "cell 0 1,grow");
			
			AddIdeaBtn = new JButton("Aggiungi la tua idea\r\n");
			AddIdeaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        AddIdeaBtn.setForeground(new Color(90, 100, 110));
	        AddIdeaBtn.setHorizontalAlignment(SwingConstants.CENTER);
	        AddIdeaBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        AddIdeaBtn.setFocusPainted(false);
	        AddIdeaBtn.setMargin(new Insets(0, 0, 0, 0));
	        AddIdeaBtn.setContentAreaFilled(false);
	        AddIdeaBtn.setBorderPainted(false);
	        AddIdeaBtn.setOpaque(false);
			BachecaPanel.add(AddIdeaBtn, "cell 0 2,alignx center,aligny center");
		
			
		setVisible(true);
	};
	
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
			MenusPanel.add(menu[i]);
			ArrayList<FilterItem>subMenu = menu[i].getSubMenu();
			for(FilterItem m:subMenu) {
				addMenu(m);
			}
		}
		MenusPanel.revalidate();
	}
	
	public JButton getAddIdeaBtn() {
		return AddIdeaBtn;
	}
	
	public JButton getCalendario() {
		return CalendarioBtn;
	}
	
	public JButton getLogInBtn() {
		return LogInBtn;
	}
	
	public JButton getSignUpBtn() {
		return SignUpBtn;
	}
}