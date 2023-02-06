package GUI;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class SignUpFrame extends JFrame {
	private JTextField emailFieldSignUp;
	private JPasswordField passwordFieldSignUp;
	private JButton annullaSignUpBtn;
	private JTextField nomeUtenteField;

	public SignUpFrame(String Titolo) {
		setTitle(Titolo);
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(false);
		
		ImageIcon IconLogo = new ImageIcon("C:\\Users\\bottf\\Documenti\\miniLogo.png");
		Image IconAppLogo = IconLogo.getImage();
		setIconImage(IconAppLogo);
		
		JPanel SignUpPanel = new JPanel();
		SignUpPanel.setBackground(new Color(232, 232, 232));
		setContentPane(SignUpPanel);
		SignUpPanel.setLayout(new MigLayout("wrap,fill", "[][grow]", "[::100px][::50px]2[::57.00px,grow]2[][][][][::180px,grow][::200px][]"));
		
		JLabel LogoSignUp = new JLabel("");
		SignUpPanel.add(LogoSignUp, "cell 0 0 2 1,alignx center,aligny center");
		LogoSignUp.setPreferredSize(new Dimension(300, 140));
		LogoSignUp.setBounds(new Rectangle(300, 11, 300, 80));
		
		ImageIcon LogoS = new ImageIcon("C:\\Users\\bottf\\Documenti\\logo.png");
		Image img = LogoS.getImage();
		Image imgScale = img.getScaledInstance(LogoSignUp.getWidth(), LogoSignUp.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
		LogoSignUp.setIcon(scaledIcon);
		
		JLabel CredenzialiTestoSignUp = new JLabel("Inserisci le tue credenziali per registrarti");
		CredenzialiTestoSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		CredenzialiTestoSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		SignUpPanel.add(CredenzialiTestoSignUp, "cell 0 1 2 1,alignx center");
		
		JLabel nomeUtenteLbl = new JLabel("Nome Utente:");
		nomeUtenteLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignUpPanel.add(nomeUtenteLbl, "cell 0 3,alignx trailing");
		
		nomeUtenteField = new JTextField();
		SignUpPanel.add(nomeUtenteField, "cell 1 3,growx");
		nomeUtenteField.setColumns(10);
		
		JLabel emailLblSignUp = new JLabel("E-mail:");
		emailLblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignUpPanel.add(emailLblSignUp, "cell 0 4,alignx trailing");
		
		emailFieldSignUp = new JTextField();
		SignUpPanel.add(emailFieldSignUp, "cell 1 4,growx");
		emailFieldSignUp.setColumns(10);
		
		JLabel passwordLblSignUp = new JLabel("Password:");
		passwordLblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SignUpPanel.add(passwordLblSignUp, "cell 0 5,alignx trailing");
		
		passwordFieldSignUp = new JPasswordField();
		SignUpPanel.add(passwordFieldSignUp, "cell 1 5,growx");
		
		JButton signUpConfermaBtn = new JButton("Sign up");
		signUpConfermaBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		SignUpPanel.add(signUpConfermaBtn, "cell 0 7 2 1,alignx center");
		
		annullaSignUpBtn = new JButton("Annulla");
		annullaSignUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SignUpPanel.add(annullaSignUpBtn, "flowx,cell 0 8,alignx center");

 }
	
	public JButton getAnnullaSignUpBtn() {
		return annullaSignUpBtn;
	}
}