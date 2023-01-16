package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;


import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private JTextField Comment_Text;
	private JTextArea BulletinBoard_Text;
	private JButton Comment_Button;
	
	public MainFrame() {
		new JFrame("Science Conference GUI");
		setBounds(100, 100, 1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JPanel MainFramePanel = new JPanel();
		MainFramePanel.setBounds(0, 0, 1184, 661);
		getContentPane().add(MainFramePanel);
		MainFramePanel.setLayout(null);
		
		JLabel Title = new JLabel("Science Conference");
		Title.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		Title.setBounds(409, 25, 366, 89);
		MainFramePanel.add(Title);
		
		JLabel WEST_Label = new JLabel("Recommended Conferences");
		WEST_Label.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		WEST_Label.setBounds(33, 151, 301, 38);
		MainFramePanel.add(WEST_Label);
		
		JPanel RecConf_Panel = new JPanel();
		RecConf_Panel.setBackground(Color.GRAY);
		RecConf_Panel.setBounds(53, 200, 253, 429);
		MainFramePanel.add(RecConf_Panel);
		RecConf_Panel.setLayout(null);
		
		JLabel RecConf_Text = new JLabel();
		RecConf_Text.setText("'On Earth' Conference - Milan");
				
				
				
		RecConf_Text.setVerticalAlignment(SwingConstants.TOP);
		RecConf_Text.setBounds(10, 11, 233, 407);
		RecConf_Panel.add(RecConf_Text);
		
		JLabel BulletinBoard_Title = new JLabel("Bulletin Board");
		BulletinBoard_Title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		BulletinBoard_Title.setBounds(391, 151, 293, 54);
		MainFramePanel.add(BulletinBoard_Title);
		
		JPanel BulletinBoard_Panel = new JPanel();
		BulletinBoard_Panel.setBackground(Color.GRAY);
		BulletinBoard_Panel.setBounds(391, 216, 477, 370);
		MainFramePanel.add(BulletinBoard_Panel);
		BulletinBoard_Panel.setLayout(null);
		
		JTextArea BulletinBoard_Text = new JTextArea("Mario");
		BulletinBoard_Text.setBackground(Color.GRAY);
		BulletinBoard_Text.setBounds(10, 11, 457, 348);
		BulletinBoard_Panel.add(BulletinBoard_Text);
		BulletinBoard_Text.setAlignmentY(BOTTOM_ALIGNMENT);
		
		JPanel Comment_Panel = new JPanel();
		Comment_Panel.setBounds(391, 597, 366, 32);
		MainFramePanel.add(Comment_Panel);
		Comment_Panel.setLayout(null);
		
		Comment_Text = new JTextField();
		Comment_Text.setForeground(Color.GRAY);
		Comment_Text.setText("Insert here your comment...");
		Comment_Text.setBounds(0, 0, 366, 32);
		Comment_Panel.add(Comment_Text);
		Comment_Text.setColumns(10);
		
		JButton Comment_Button = new JButton("Send");
		Comment_Button.setBounds(767, 597, 101, 32);
		MainFramePanel.add(Comment_Button);
		
		JLabel ConferenceFilter_Text = new JLabel("Find your conference!");
		ConferenceFilter_Text.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ConferenceFilter_Text.setBounds(919, 216, 135, 21);
		MainFramePanel.add(ConferenceFilter_Text);
		
		JComboBox FilterSelection = new JComboBox();
		FilterSelection.setModel(new DefaultComboBoxModel(new String[] {"Most popular", "Least popular", "Last month", "Next Month"}));
		FilterSelection.setBounds(1064, 217, 110, 20);
		MainFramePanel.add(FilterSelection);
		
		JLabel Filter_Text = new JLabel("Filters:");
		Filter_Text.setFont(new Font("Times New Roman", Font.BOLD, 11));
		Filter_Text.setBounds(1092, 200, 52, 14);
		MainFramePanel.add(Filter_Text);
		
		JPanel Filter_Panel = new JPanel();
		Filter_Panel.setBackground(Color.GRAY);
		Filter_Panel.setBounds(919, 257, 225, 302);
		MainFramePanel.add(Filter_Panel);
		Filter_Panel.setLayout(null);
		
		JLabel Filter_List = new JLabel("");
		Filter_List.setBounds(10, 11, 205, 280);
		Filter_Panel.add(Filter_List);
		
		JPanel Login_Panel = new JPanel();
		Login_Panel.setBackground(Color.LIGHT_GRAY);
		Login_Panel.setBounds(919, 41, 225, 89);
		MainFramePanel.add(Login_Panel);
		Login_Panel.setLayout(null);
		
		JLabel Login_Text = new JLabel("Log-In");
		Login_Text.setForeground(Color.DARK_GRAY);
		Login_Text.setFont(new Font("Times New Roman", Font.BOLD, 25));
		Login_Text.setBounds(70, 11, 85, 30);
		Login_Panel.add(Login_Text);
		
		JButton Login_Button = new JButton("Sign up!");
		Login_Button.setBounds(52, 52, 120, 23);
		Login_Panel.add(Login_Button);
		
		JLabel UserIconLabel = new JLabel();
		UserIconLabel.setBounds(190, 0, 47, 41);
		Login_Panel.add(UserIconLabel);
		

	}
	
	   public String getComment_Text() {
		   String comment = Comment_Text.getText();
		   return comment;
	}
	   
	   public JTextArea getBulletinBoard_Text() {
		  return BulletinBoard_Text;
	  }
	   
	   public JButton getComment_Button() {
		   return Comment_Button;
	   }
}


