package myTools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class DateComboBox extends JPanel {

	private String[] Giorni = { "G", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
								"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
								"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

	private String[] Mesi = {"M", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

	private String[] Anni = {"A", "22", "23", "24", "25", "26"};

	private JComboBox<String> DayComboBox;
	private JComboBox<String> MonthComboBox;
	private JComboBox<String> YearComboBox;

	private String gg = "";
	private String mm = "";
	private String aa = "";

	public DateComboBox() {

		setBackground(new Color(255, 255, 255));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMaximumSize(new Dimension(150, 25));

		DayComboBox = new JComboBox<>(Giorni);
		DayComboBox.setMaximumSize(new Dimension(55, 25));
		DayComboBox.setPreferredSize(new Dimension(40, 22));
		add(DayComboBox);
		DayComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gg = ((String)DayComboBox.getSelectedItem());
			}
		});

		MonthComboBox = new JComboBox<>(Mesi);
		MonthComboBox.setMaximumSize(new Dimension(55, 25));
		MonthComboBox.setPreferredSize(new Dimension(40, 22));
		add(MonthComboBox);
		MonthComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mm = ((String)MonthComboBox.getSelectedItem());
			}
		});

		YearComboBox = new JComboBox<>(Anni);
		YearComboBox.setMaximumSize(new Dimension(55, 25));
		YearComboBox.setPreferredSize(new Dimension(40, 22));
		add(YearComboBox);
		YearComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aa = "20" + ((String)YearComboBox.getSelectedItem());
			}
		});
	}

	public String getAAMMGG() {

		if (aa.isEmpty() || aa.equals("AA") || mm.isEmpty() || mm.equals("MM") || gg.isEmpty() || gg.equals("GG")) {

			return "";

		} else { return aa + "-" + mm + "-" + gg; }
	}


	public int getDay() { return DayComboBox.getSelectedIndex(); }

	public void setDay(int day) { DayComboBox.setSelectedIndex(day); }


	public int getMonth() { return MonthComboBox.getSelectedIndex() - 1; }

	public void setMonth(int month) { MonthComboBox.setSelectedIndex(month + 1); }


	public int getYear() { return YearComboBox.getSelectedIndex() + 2021; }

	public void setYear(int year) { YearComboBox.setSelectedIndex(year - 2021); }


	public void resetFields() {

		DayComboBox.setSelectedIndex(0);
		MonthComboBox.setSelectedIndex(0);
		YearComboBox.setSelectedIndex(0);
	}
}