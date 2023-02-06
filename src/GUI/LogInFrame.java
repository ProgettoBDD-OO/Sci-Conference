package GUI;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class LogInFrame extends JFrame {
	private JTextField emailFieldLogIn;
	private JPasswordField passwordFieldLogIn;
	private JButton annullaLogInBtn;

	public LogInFrame(String Titolo) {
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(false);
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\bottf\\Documenti\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel LogInPanel = new JPanel();
		LogInPanel.setBackground(new Color(232, 232, 232));
		setContentPane(LogInPanel);
		LogInPanel.setLayout(new MigLayout("wrap,fill", "[][grow]", "[::100px][::50px]2[::57.00px,grow]2[][][][][::180px,grow][::200px][]"));
		
		JLabel LogoLogIn = new JLabel("");
		LogInPanel.add(LogoLogIn, "cell 0 0 2 1,alignx center,aligny center");
		LogoLogIn.setPreferredSize(new Dimension(300, 140));
		LogoLogIn.setBounds(new Rectangle(300, 11, 300, 80));
		
		ImageIcon LogoL = new ImageIcon("C:\\Users\\bottf\\Documenti\\logo.png");
		Image img = LogoL.getImage();
		Image imgScale = img.getScaledInstance(LogoLogIn.getWidth(), LogoLogIn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
		LogoLogIn.setIcon(scaledIcon);
		
		JLabel CredenzialiTestoLogIn = new JLabel("Inserisci le tue credenziali per effettuare il Log-In");
		CredenzialiTestoLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		CredenzialiTestoLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		LogInPanel.add(CredenzialiTestoLogIn, "cell 0 1 2 1,alignx center");
		
		JLabel emailLblLogIn = new JLabel("E-mail:");
		emailLblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LogInPanel.add(emailLblLogIn, "cell 0 3,alignx trailing");
		
		emailFieldLogIn = new JTextField();
		LogInPanel.add(emailFieldLogIn, "cell 1 3,growx");
		emailFieldLogIn.setColumns(10);
		
		JLabel passwordLblLogIn = new JLabel("Password:");
		passwordLblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LogInPanel.add(passwordLblLogIn, "cell 0 5,alignx trailing");
		
		passwordFieldLogIn = new JPasswordField();
		LogInPanel.add(passwordFieldLogIn, "cell 1 5,growx");
		
		JButton logInConfermaBtn = new JButton("Log-In");
		logInConfermaBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		LogInPanel.add(logInConfermaBtn, "cell 0 7 2 1,alignx center");
		
		annullaLogInBtn = new JButton("Annulla");
		annullaLogInBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LogInPanel.add(annullaLogInBtn, "flowx,cell 0 8,alignx center");

 }
	
	public JButton getAnnullaLogInBtn() {
		return annullaLogInBtn;
	}
}