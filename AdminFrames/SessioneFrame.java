package GUI.AdminFrames;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class SessioneFrame extends JFrame {
	private JTextField textField_2;
	private JTextField textField_3;

	public SessioneFrame() {
		
		setSize(300, 300);
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Images/mini_logo.png")).getImage());
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		setContentPane(MainPanel);
		MainPanel.setLayout(new MigLayout("wrap, fill", "[][grow]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		MainPanel.add(lblNewLabel, "cell 0 0,alignx trailing,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		MainPanel.add(lblNewLabel_1, "cell 0 1,alignx trailing,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		MainPanel.add(lblNewLabel_2, "cell 0 2,alignx trailing,aligny center");
		
		textField_2 = new JTextField();
		MainPanel.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		MainPanel.add(lblNewLabel_3, "cell 0 3,alignx trailing,aligny center");
		
		textField_3 = new JTextField();
		MainPanel.add(textField_3, "cell 1 3,growx");
		textField_3.setColumns(10);
		
	}
}