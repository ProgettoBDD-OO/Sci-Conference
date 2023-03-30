package GUI;
import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainFrame extends JFrame{
	
	private JTextField ResearchBar;
	private JLblButton AddIdeaBtn;
	private JLblButton CalendarioBtn;
	private JButton LogInBtn;
	private JButton SignUpBtn;
	private boolean ShowFilter = false;
	private JLblButton AccediBtn;
	private JLblButton RegistratiBtn;
	private JPanel UserConfPanel;
	private ArrayList<JRadioButtonMenuItem> TemiArray;
	private JPanel mese1Panel;
	private JPanel mese2Panel;
	private JPanel mese3Panel;
	private Calendar DataAttuale = Calendar.getInstance();
    private int MeseAttuale = DataAttuale.get(GregorianCalendar.MONTH);;
    private CardLayout CentrCardLayout;
    private JPanel CentrCardPanel;
    private JPanel CentrLayer3;
    private JLblButton SfogliaConfBtn;

    private Calendar DataMese1 = Calendar.getInstance();
    private Calendar DataMese2 = Calendar.getInstance();
    private Calendar DataMese3 = Calendar.getInstance();
	
	private JRadioButtonMenuItem TemaAmbienteFltr;
	
	public MainFrame(String Titolo) {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 800);
		setLocationRelativeTo(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(null);
		MainPanel.setBackground(new Color(255, 255, 255));
		setContentPane(MainPanel);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\bottf\\Documenti\\miniLogo.png");
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
		
		JPanel CalendarPanel = new JPanel();
		CalendarPanel.setBackground(new Color(240, 241, 242));
		SxPanel.add(CalendarPanel, BorderLayout.CENTER);
		CalendarPanel.setLayout(new BorderLayout(0, 0));
		
		MeseAttuale = DataAttuale.get(GregorianCalendar.MONTH);
		
		DataMese1.set(Calendar.MONTH, MeseAttuale);
		DataMese2.set(Calendar.MONTH, MeseAttuale + 1);
		DataMese3.set(Calendar.MONTH, MeseAttuale + 2); 
		
		SimpleDateFormat DFDataAttuale = new SimpleDateFormat("MMMM");
		
		JPanel ProxConfPanel = new JPanel();
		ProxConfPanel.setBackground(new Color(240, 241, 242));
		SxPanel.add(ProxConfPanel, BorderLayout.CENTER);
		ProxConfPanel.setLayout(new MigLayout("wrap, fill", "[grow]", "[::50px][][::50px][][::50px][]"));
		
		JLabel mese1Label = new JLabel(DFDataAttuale.format(DataMese1.getTime()));
		mese1Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ProxConfPanel.add(mese1Label, "cell 0 0");
		
		mese1Panel = new JPanel();
		mese1Panel.setLayout(new BoxLayout(mese1Panel, BoxLayout.Y_AXIS));
		ProxConfPanel.add(mese1Panel, "cell 0 1,grow");
		
		JLabel mese2Label = new JLabel(DFDataAttuale.format(DataMese2.getTime()));
		mese2Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ProxConfPanel.add(mese2Label, "cell 0 2");
		
		mese2Panel = new JPanel();
		ProxConfPanel.add(mese2Panel, "cell 0 3,grow");
		mese2Panel.setLayout(new BoxLayout(mese2Panel, BoxLayout.Y_AXIS));
		
		JLabel mese3Label = new JLabel(DFDataAttuale.format(DataMese3.getTime()));
		mese3Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ProxConfPanel.add(mese3Label, "cell 0 4,aligny center");
		
		mese3Panel = new JPanel();
		ProxConfPanel.add(mese3Panel, "cell 0 5,grow");
		mese3Panel.setLayout(new BoxLayout(mese3Panel, BoxLayout.Y_AXIS));
		
		CalendarioBtn = new JLblButton("Mostra tutto");
		CalendarioBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ProxConfPanel.add(CalendarioBtn, "cell 0 6,alignx center,aligny center");
		
		
		
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
		
		ImageIcon Logo = new ImageIcon("C:\\Users\\bottf\\Documenti\\Logo.png");
		Image img = Logo.getImage();
		Image imgScale = img.getScaledInstance(LogoConteiner.getWidth(), LogoConteiner.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		LogoConteiner.setIcon(scaledIcon);
		
		UserConfPanel = new JPanel();
		UserConfPanel.setBackground(new Color(255, 255, 255));
		CentrPanel.add(UserConfPanel, BorderLayout.CENTER);
		UserConfPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel UserConfLbl = new JLabel("Le tue Conferenze");
		UserConfLbl.setPreferredSize(new Dimension(89, 200));
		UserConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
		UserConfLbl.setForeground(new Color(0, 0, 200));
		UserConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		UserConfPanel.add(UserConfLbl,BorderLayout.NORTH);
		
		CentrCardLayout = new CardLayout();
		CentrCardPanel = new JPanel();
		CentrCardPanel.setBackground(new Color(255, 255, 255));
		UserConfPanel.add(CentrCardPanel, BorderLayout.CENTER);
		CentrCardPanel.setLayout(CentrCardLayout);
		
		JPanel CentrLayer1 = new JPanel();
		CentrLayer1.setBackground(new Color(255, 255, 255));
		CentrCardPanel.add(CentrLayer1, "1");
		CentrLayer1.setLayout(new BorderLayout(0, 0));
		
		JPanel AccediRegistratiPanel = new JPanel();
		CentrLayer1.add(AccediRegistratiPanel, BorderLayout.SOUTH);
		AccediRegistratiPanel.setBackground(new Color(255, 255, 255));
		AccediRegistratiPanel.setPreferredSize(new Dimension(10, 200));
		AccediRegistratiPanel.setLayout(new MigLayout("wrap, fill", "[][::10px][]", "[]"));
		
		AccediBtn = new JLblButton("Accedi");
		AccediBtn.setBorderPainted(false);
		AccediBtn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 200)));
		AccediBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AccediBtn.setForeground(new Color(0, 0, 200));
		AccediBtn.setHorizontalAlignment(SwingConstants.CENTER);
		AccediBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AccediBtn.setFocusPainted(false);
		AccediBtn.setMargin(new Insets(0, 0, 0, 0));
		AccediBtn.setContentAreaFilled(false);
		AccediBtn.setOpaque(false);
		AccediRegistratiPanel.add(AccediBtn, "cell 0 0,alignx right,aligny center");
		AccediBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AccediBtn.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccediBtn.setBorderPainted(false);
			}
		});
		
		JLabel OLbl = new JLabel("o");
		OLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OLbl.setForeground(new Color(0, 0, 200));
		AccediRegistratiPanel.add(OLbl, "cell 1 0,alignx center,aligny center");
		
		RegistratiBtn = new JLblButton("Registrati");
		RegistratiBtn.setBorderPainted(false);
		RegistratiBtn.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 200)));
		RegistratiBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RegistratiBtn.setForeground(new Color(0, 0, 200));
		RegistratiBtn.setHorizontalAlignment(SwingConstants.CENTER);
		RegistratiBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RegistratiBtn.setFocusPainted(false);
		RegistratiBtn.setMargin(new Insets(0, 0, 0, 0));
		RegistratiBtn.setContentAreaFilled(false);
		RegistratiBtn.setOpaque(false);
		AccediRegistratiPanel.add(RegistratiBtn, "cell 2 0,alignx left,aligny center");
		
		JLabel PreLogInLbl = new JLabel("Devi effettuare il Log In per vedere le conferenze a cui sei iscritto");
		PreLogInLbl.setBackground(Color.WHITE);
		PreLogInLbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		PreLogInLbl.setHorizontalAlignment(SwingConstants.CENTER);
		CentrLayer1.add(PreLogInLbl, BorderLayout.CENTER);
		
		JPanel CentrLayer2 = new JPanel();
		CentrLayer2.setBackground(new Color(255, 255, 255));
		CentrCardPanel.add(CentrLayer2, "2");
		CentrLayer2.setLayout(new BorderLayout(0, 0));
		
		JLabel NoConfLbl = new JLabel("Non sei iscritto a nessuna conferenza.");
		NoConfLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NoConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
		CentrLayer2.add(NoConfLbl, BorderLayout.CENTER);
		
		JPanel SfogliaConfLabel = new JPanel();
		SfogliaConfLabel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 200)));
		SfogliaConfLabel.setPreferredSize(new Dimension(10, 200));
		SfogliaConfLabel.setBackground(Color.WHITE);
		CentrLayer2.add(SfogliaConfLabel, BorderLayout.SOUTH);
		SfogliaConfLabel.setLayout(new MigLayout("wrap,fill", "[]","[]"));
		
		SfogliaConfBtn = new JLblButton("Sfoglia le conferenze");
		SfogliaConfBtn.setForeground(new Color(0,0,200));
		SfogliaConfBtn.setBorder(new MatteBorder(0,0,1,0,new Color(0,0,200)));
		SfogliaConfLabel.add(SfogliaConfBtn, "cell 0 0,alignx center,aligny center");
		SfogliaConfBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SfogliaConfBtn.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SfogliaConfBtn.setBorderPainted(false);
			}
		});
		
		JScrollPane layer3Scroller = new JScrollPane();
		layer3Scroller.setBackground(new Color(255, 255, 255));
		layer3Scroller.setBorder(new EmptyBorder(0,110,30,100));
		CentrCardPanel.add(layer3Scroller,"3");
		CentrLayer3 = new JPanel();
		CentrLayer3.setBackground(new Color(255, 255, 255));
		layer3Scroller.setViewportView(CentrLayer3);
		CentrLayer3.setLayout(new BoxLayout(CentrLayer3, BoxLayout.Y_AXIS));
		
		
		
		RegistratiBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RegistratiBtn.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RegistratiBtn.setBorderPainted(false);
			}
		});
			
		
		
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
				
				JPopupMenu FilterMenu = new JPopupMenu();
				FilterMenu.setPopupSize(new Dimension(120, 100));
				FilterMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
				FilterBtn.add(FilterMenu);
				
					JMenu DateFltr = new JMenu("Data");
					DateFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
					DateFltr.setForeground(new Color(0, 0, 200));
					FilterMenu.add(DateFltr);
					
						JMenu DataPrecisaFltr = new JMenu("Data Precisa");
						DataPrecisaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						DateFltr.add(DataPrecisaFltr);
						
						JMenu PeriodoFltr = new JMenu("Periodo di tempo");
						PeriodoFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						DateFltr.add(PeriodoFltr);
					
					JMenu PlaceFltr = new JMenu("Luogo");
					PlaceFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
					PlaceFltr.setForeground(new Color(0, 0, 200));
					FilterMenu.add(PlaceFltr);
					
						JMenu NordItaliaFltr = new JMenu("Nord Italia");
						NordItaliaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						PlaceFltr.add(NordItaliaFltr);
						
							JRadioButtonMenuItem ValdAostaFltr = new JRadioButtonMenuItem("Val d'Aosta");
							ValdAostaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(ValdAostaFltr);
							
							JRadioButtonMenuItem LombardiaFltr = new JRadioButtonMenuItem("Lombardia");
							LombardiaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(LombardiaFltr);
							
							JRadioButtonMenuItem mntmNewMenuItem_2 = new JRadioButtonMenuItem("Liguria");
							mntmNewMenuItem_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(mntmNewMenuItem_2);
							
							JRadioButtonMenuItem mntmNewMenuItem_7 = new JRadioButtonMenuItem("Piemonte");
							mntmNewMenuItem_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(mntmNewMenuItem_7);
							
							JRadioButtonMenuItem mntmNewMenuItem_8 = new JRadioButtonMenuItem("Veneto");
							mntmNewMenuItem_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(mntmNewMenuItem_8);
							
							JRadioButtonMenuItem mntmNewMenuItem_9 = new JRadioButtonMenuItem("Trentino Alto Adige");
							mntmNewMenuItem_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(mntmNewMenuItem_9);
							
							JRadioButtonMenuItem mntmNewMenuItem_10 = new JRadioButtonMenuItem("Friuli Venezia Giulia");
							mntmNewMenuItem_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
							NordItaliaFltr.add(mntmNewMenuItem_10);
						
						JMenu CentroItaliaFltr = new JMenu("Centro Italia");
						CentroItaliaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						PlaceFltr.add(CentroItaliaFltr);
						
							JRadioButtonMenuItem mntmNewMenuItem_3 = new JRadioButtonMenuItem("Toscana");
							mntmNewMenuItem_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
							CentroItaliaFltr.add(mntmNewMenuItem_3);
							
							JRadioButtonMenuItem mntmNewMenuItem_4 = new JRadioButtonMenuItem("Emilia Romagna");
							mntmNewMenuItem_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
							CentroItaliaFltr.add(mntmNewMenuItem_4);
							
							JRadioButtonMenuItem mntmNewMenuItem_5 = new JRadioButtonMenuItem("Umbria");
							mntmNewMenuItem_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
							CentroItaliaFltr.add(mntmNewMenuItem_5);
							
							JRadioButtonMenuItem mntmNewMenuItem_6 = new JRadioButtonMenuItem("Abruzzo");
							mntmNewMenuItem_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
							CentroItaliaFltr.add(mntmNewMenuItem_6);
							
							JRadioButtonMenuItem mntmNewMenuItem_11 = new JRadioButtonMenuItem("Lazio");
							mntmNewMenuItem_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
							CentroItaliaFltr.add(mntmNewMenuItem_11);
							
							JRadioButtonMenuItem mntmNewMenuItem_12 = new JRadioButtonMenuItem("Marche");
							mntmNewMenuItem_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
							CentroItaliaFltr.add(mntmNewMenuItem_12);
						
						JMenu SudItaliaFltr = new JMenu("Sud Italia");
						SudItaliaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						PlaceFltr.add(SudItaliaFltr);
						
							JRadioButtonMenuItem mntmNewMenuItem_13 = new JRadioButtonMenuItem("Campania");
							mntmNewMenuItem_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
							SudItaliaFltr.add(mntmNewMenuItem_13);
							
							JRadioButtonMenuItem mntmNewMenuItem_14 = new JRadioButtonMenuItem("Basilicata");
							mntmNewMenuItem_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
							SudItaliaFltr.add(mntmNewMenuItem_14);
							
							JRadioButtonMenuItem mntmNewMenuItem_15 = new JRadioButtonMenuItem("Puglia");
							mntmNewMenuItem_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
							SudItaliaFltr.add(mntmNewMenuItem_15);
							
							JRadioButtonMenuItem mntmNewMenuItem_16 = new JRadioButtonMenuItem("Calabria");
							mntmNewMenuItem_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
							SudItaliaFltr.add(mntmNewMenuItem_16);
							
							JRadioButtonMenuItem mntmNewMenuItem_17 = new JRadioButtonMenuItem("Sicilia");
							mntmNewMenuItem_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
							SudItaliaFltr.add(mntmNewMenuItem_17);
						
							JRadioButtonMenuItem mntmNewMenuItem_18 = new JRadioButtonMenuItem("Sardegna");
							mntmNewMenuItem_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
							SudItaliaFltr.add(mntmNewMenuItem_18);
					
					JMenu ThemeFltr = new JMenu("Tema");
					ThemeFltr.setBackground(new Color(240, 240, 240));
					ThemeFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
					ThemeFltr.setForeground(new Color(0, 0, 200));
					FilterMenu.add(ThemeFltr);
					
					TemiArray = new ArrayList<JRadioButtonMenuItem>();
					
						TemaAmbienteFltr = new JRadioButtonMenuItem("Ambiente");
						TemaAmbienteFltr.setBackground(new Color(240, 240, 240));
						TemaAmbienteFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaAmbienteFltr.setForeground(new Color(0, 200, 0));
						ThemeFltr.add(TemaAmbienteFltr);
						TemiArray.add(TemaAmbienteFltr);
						
						JRadioButtonMenuItem TemaAnatomiaFltr = new JRadioButtonMenuItem("Anatomia");
						TemaAnatomiaFltr.setBackground(new Color(240, 240, 240));
						TemaAnatomiaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaAnatomiaFltr.setForeground(new Color(250, 88, 80));
						ThemeFltr.add(TemaAnatomiaFltr);
						TemiArray.add(TemaAnatomiaFltr);
						
						JRadioButtonMenuItem TemaAstrologiaFltr = new JRadioButtonMenuItem("Astrologia");
						TemaAstrologiaFltr.setBackground(new Color(240, 240, 240));
						TemaAstrologiaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaAstrologiaFltr.setForeground(new Color(30, 30, 120));
						ThemeFltr.add(TemaAstrologiaFltr);
						TemiArray.add(TemaAstrologiaFltr);
						
						JRadioButtonMenuItem TemaBiologiaFltr = new JRadioButtonMenuItem("Biologia");
						TemaBiologiaFltr.setBackground(new Color(240, 240, 240));
						TemaBiologiaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaBiologiaFltr.setForeground(new Color(0, 128, 0));
						ThemeFltr.add(TemaBiologiaFltr);
						TemiArray.add(TemaBiologiaFltr);
						
						JRadioButtonMenuItem TemaChimicaFltr = new JRadioButtonMenuItem("Chimica");
						TemaChimicaFltr.setBackground(new Color(240, 240, 240));
						TemaChimicaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaChimicaFltr.setForeground(new Color(0, 200, 255));
						ThemeFltr.add(TemaChimicaFltr);
						TemiArray.add(TemaChimicaFltr);
						
						JRadioButtonMenuItem TemaFisicaFltr = new JRadioButtonMenuItem("Fisica");
						TemaFisicaFltr.setBackground(new Color(240, 240, 240));
						TemaFisicaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaFisicaFltr.setForeground(new Color(250, 80, 0));
						ThemeFltr.add(TemaFisicaFltr);
						TemiArray.add(TemaFisicaFltr);
						
						JRadioButtonMenuItem TemaGeologiaFltr = new JRadioButtonMenuItem("Geologia");
						TemaGeologiaFltr.setBackground(new Color(240, 240, 240));
						TemaGeologiaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaGeologiaFltr.setForeground(new Color(180, 100, 40));
						ThemeFltr.add(TemaGeologiaFltr);
						TemiArray.add(TemaGeologiaFltr);
						
						JRadioButtonMenuItem TemaInformaticaFltr = new JRadioButtonMenuItem("Informatica");
						TemaInformaticaFltr.setBackground(new Color(240, 240, 240));
						TemaInformaticaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaInformaticaFltr.setForeground(new Color(0, 100, 255));
						ThemeFltr.add(TemaInformaticaFltr);
						TemiArray.add(TemaInformaticaFltr);
						
						JRadioButtonMenuItem TemaMatematicaFltr = new JRadioButtonMenuItem("Matematica");
						TemaMatematicaFltr.setBackground(new Color(240, 240, 240));
						TemaMatematicaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaMatematicaFltr.setForeground(new Color(0, 0, 200));
						ThemeFltr.add(TemaMatematicaFltr);
						TemiArray.add(TemaMatematicaFltr);
						
						JRadioButtonMenuItem TemaPsicologiaFltr = new JRadioButtonMenuItem("Psicologia");
						TemaPsicologiaFltr.setBackground(new Color(240, 240, 240));
						TemaPsicologiaFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaPsicologiaFltr.setForeground(new Color(255, 0, 128));
						ThemeFltr.add(TemaPsicologiaFltr);
						TemiArray.add(TemaPsicologiaFltr);
						
						JRadioButtonMenuItem TemaSostenibilitàFltr = new JRadioButtonMenuItem("Sostenibilità");
						TemaSostenibilitàFltr.setBackground(new Color(240, 240, 240));
						TemaSostenibilitàFltr.setFont(new Font("Tahoma", Font.PLAIN, 13));
						TemaSostenibilitàFltr.setForeground(new Color(240, 210, 0));
						ThemeFltr.add(TemaSostenibilitàFltr);
						TemiArray.add(TemaSostenibilitàFltr);
				
						FilterBtn.addMouseListener(new MouseAdapter() {
		                    @Override
		                    public void mousePressed(MouseEvent e) {
		                        if (ShowFilter) {
		                            FilterMenu.setVisible(false);
		                            ShowFilter = false;
		                        } else {
		                            FilterMenu.show(FilterBtn, FilterBtn.getX() - 10, FilterBtn.getY() + 25);
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
			
			AddIdeaBtn = new JLblButton("Aggiungi la tua idea\r\n");
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
	
	public JButton getAccediBtn() {
		return AccediBtn;
	}
	
	public JButton getRegistratiBtn() {
		return RegistratiBtn;
	}
	
	public JTextField getResearchBar() {
        return ResearchBar;
    }
	
	public ArrayList<JRadioButtonMenuItem> getTemiArray() {
		return TemiArray;
	}
	
	public JPanel getUserConfPanel() {
		return UserConfPanel;
	}
	
	public CardLayout getCentrCardLayout() {
		return CentrCardLayout;
	}
	
	public JPanel getCentrCardPanel() {
		return CentrCardPanel;
	}
	
	public JPanel getCentrLayer3() {
		return CentrLayer3;
	}
	
	public JButton getSfogliaConfBtn() {
		return SfogliaConfBtn;
	}
	
    public void setResearchBarTxtNull() {
        ResearchBar.setText("");
        ResearchBar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ResearchBar.setForeground(new Color(20,40,60));
    }
    
    public JPanel getMese1Panel() {
    	return mese1Panel;
    }
    
    public JPanel getMese2Panel() {
    	return mese2Panel;
    }
    
    public JPanel getMese3Panel() {
    	return mese3Panel;
    }
	
	
}