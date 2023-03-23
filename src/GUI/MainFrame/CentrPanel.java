package GUI.MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import myTools.JLblButton;
import myTools.myColors;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class CentrPanel extends JPanel{

	private myColors c = new myColors();
	
	private CardLayout CentralCardLayout;
	private JPanel CentrCardPanel;
	
	private JButton AccediBtn;
	private JButton RegistratiBtn;

	private JPanel UserConfAfterAccess2;
	private ArrayList<JLblButton> arrayLblButtons;
	
	public CentrPanel() {
		
		setBackground(c.white);
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel LogoPanel = new JPanel();
		LogoPanel.setBackground(c.white);
		LogoPanel.setBorder(new MatteBorder(0, 0, 1, 0, c.altGray));
		LogoPanel.setPreferredSize(new Dimension(10, 150));
		LogoPanel.setLayout(new MigLayout("wrap, fill", "[]", "[]"));
		add(LogoPanel, BorderLayout.NORTH);
		
			JLabel LogoConteiner = new JLabel("");
			LogoConteiner.setBounds(new Rectangle(0, 0, 460, 130));
			LogoPanel.add(LogoConteiner, "cell 0 0,alignx center,aligny bottom");
			
			ImageIcon Logo = new ImageIcon("C:\\Users\\Raul\\OneDrive\\Documenti\\Progetto OO-DB\\logo.png");
			Image img = Logo.getImage();
			Image imgScale = img.getScaledInstance(LogoConteiner.getWidth(), LogoConteiner.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(imgScale);
			LogoConteiner.setIcon(scaledIcon);
	
		
		JPanel UserConfPanel = new JPanel();
		UserConfPanel.setBackground(c.white);
		UserConfPanel.setLayout(new BorderLayout(0, 0));
		add(UserConfPanel, BorderLayout.CENTER);
		
			JLabel UserConfLbl = new JLabel("Le tue Conferenze");
			UserConfLbl.setPreferredSize(new Dimension(89, 200));
			UserConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
			UserConfPanel.add(UserConfLbl, BorderLayout.NORTH);
			UserConfLbl.setForeground(c.scBlue);
			UserConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 28));
			
			
			CentralCardLayout = new CardLayout();
			
			CentrCardPanel = new JPanel();
			CentrCardPanel.setBackground(c.white);
			UserConfPanel.add(CentrCardPanel, BorderLayout.CENTER);
			CentrCardPanel.setLayout(CentralCardLayout);
			
				JPanel UserConfBeforeAccess = new JPanel();
				UserConfBeforeAccess.setBackground(c.white);
				CentrCardPanel.add(UserConfBeforeAccess, "1");
				UserConfBeforeAccess.setLayout(new BorderLayout(0, 0));
			
					JLabel AccediRegistratiLbl = new JLabel("Accedi o Registrati per iscriverti ad una conferenza o visualizzare quelle a cui gia partecipi.");
					AccediRegistratiLbl.setForeground(c.altGray);
					AccediRegistratiLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
					AccediRegistratiLbl.setHorizontalAlignment(SwingConstants.CENTER);
					UserConfBeforeAccess.add(AccediRegistratiLbl, BorderLayout.CENTER);
					
					JPanel AccediRegistratiPanel = new JPanel();
					AccediRegistratiPanel.setBackground(c.white);
					AccediRegistratiPanel.setPreferredSize(new Dimension(10, 250));
					AccediRegistratiPanel.setLayout(new MigLayout("wrap, fill", "[][::10px][]", "[]"));
					UserConfBeforeAccess.add(AccediRegistratiPanel, BorderLayout.SOUTH);
					
						AccediBtn = new JLblButton(c.scBlue, "Accedi");
						AccediBtn.setFont(new Font("Calibri Light", Font.PLAIN, 20));
						AccediBtn.setBorder(new MatteBorder(0, 0, 1, 0, c.scBlue));
						AccediRegistratiPanel.add(AccediBtn, "cell 0 0,alignx right,aligny top");
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
						OLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
						OLbl.setForeground(c.scBlue);
						AccediRegistratiPanel.add(OLbl, "cell 1 0,alignx center,aligny top");
						
						RegistratiBtn = new JLblButton(c.scBlue, "Registrati");
						RegistratiBtn.setFont(new Font("Calibri Light", Font.PLAIN, 20));
						RegistratiBtn.setBorder(new MatteBorder(0, 0, 1, 0, c.scBlue));
						AccediRegistratiPanel.add(RegistratiBtn, "cell 2 0,alignx left,aligny top");
						
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
						
						
				JPanel UserConfAfterAccess1 = new JPanel();
				UserConfAfterAccess1.setBackground(c.white);
				CentrCardPanel.add(UserConfAfterAccess1, "2");
				UserConfAfterAccess1.setLayout(new BorderLayout(0, 0));
				
				JLabel NoConfLbl = new JLabel("Non sei iscritto ancora ad una conferenza");
				NoConfLbl.setForeground(c.altGray);
				NoConfLbl.setFont(new Font("Calibri Light", Font.PLAIN, 20));
				NoConfLbl.setHorizontalAlignment(SwingConstants.CENTER);
				UserConfAfterAccess1.add(NoConfLbl, BorderLayout.CENTER);
				
				JScrollPane ConfScroller = new JScrollPane();
				CentrCardPanel.add(ConfScroller, "3");
				ConfScroller.setBackground(c.white);
				ConfScroller.setBorder(new EmptyBorder(0, 110, 30, 100));
				
				UserConfAfterAccess2 = new JPanel();
				UserConfAfterAccess2.setBackground(c.white);
				UserConfAfterAccess2.setLayout(new BoxLayout(UserConfAfterAccess2, BoxLayout.Y_AXIS));
				ConfScroller.setViewportView(UserConfAfterAccess2);
				
				arrayLblButtons = new ArrayList<JLblButton>();
	}
	

	public CardLayout getCentralCardLayout() { return CentralCardLayout;}
	
	public JPanel getCentrCardPanel() { return CentrCardPanel;	 }
	
	public JButton getAccediBtn() { return AccediBtn; }
	
	public JButton getRegistratiBtn() { return RegistratiBtn; }
	
	public JPanel getUserConfAfterAccess2() { return UserConfAfterAccess2;}
	
	public ArrayList<JLblButton> getArrayLblButtons(){ return arrayLblButtons; }
}