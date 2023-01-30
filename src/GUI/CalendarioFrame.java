package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class CalendarioFrame extends JFrame{
	
	private JButton IndietroCalendarioBtn;
	
	public CalendarioFrame(String Titolo) {
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 1000);
		setLocationRelativeTo(null);
		setVisible(false);
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\bottf\\Documenti\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel CalendarioPanel = new JPanel();
		CalendarioPanel.setBackground(new Color(232, 232, 232));
		setContentPane(CalendarioPanel);
		CalendarioPanel.setLayout(new MigLayout("wrap,fill", "[grow]", "[::100px][::50px]2[::57.00px,grow]2[][][][][::180px,grow][::200px][]"));
		
		JLabel LogoCalendario = new JLabel("");
		CalendarioPanel.add(LogoCalendario, "cell 0 0,alignx center,aligny center");
		LogoCalendario.setPreferredSize(new Dimension(300, 140));
		LogoCalendario.setBounds(new Rectangle(300, 11, 300, 80));
		
		ImageIcon LogoC = new ImageIcon("C:\\Users\\bottf\\Documenti\\logo.png");
		Image img = LogoC.getImage();
		Image imgScale = img.getScaledInstance(LogoCalendario.getWidth(), LogoCalendario.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
		LogoCalendario.setIcon(scaledIcon);
		
		JLabel TestoCalendario = new JLabel("Calendario delle conferenze scientifiche");
		TestoCalendario.setForeground(Color.BLUE);
		TestoCalendario.setFont(new Font("Tahoma", Font.BOLD, 24));
		CalendarioPanel.add(TestoCalendario, "cell 0 1");
		
		JPanel ListaCalendarioPanel = new JPanel();
		ListaCalendarioPanel.setBackground(Color.LIGHT_GRAY);
		CalendarioPanel.add(ListaCalendarioPanel, "cell 0 2 1 7,grow");
		ListaCalendarioPanel.setLayout(new SpringLayout());
		
		IndietroCalendarioBtn = new JButton("Indietro");
		IndietroCalendarioBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CalendarioPanel.add(IndietroCalendarioBtn, "cell 0 9,alignx right");
	}
	
	public JButton getIndietroCalendarioBtn() {
		return IndietroCalendarioBtn;
	}
}
