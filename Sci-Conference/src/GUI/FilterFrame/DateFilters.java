package GUI.FilterFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import myTools.DateComboBox;
import myTools.JLblButton;
import myTools.myTemplates;
import net.miginfocom.swing.MigLayout;


public class DateFilters extends JPanel {

	private myTemplates t;

	private boolean DataPrecisaVisible = false;
	private boolean PeriodoVisible = false;
	private DateComboBox DataPrecisaCmbBx;
	private DateComboBox InizioPeriodoCmbBx;
	private DateComboBox FinePeriodoCmbBx;

	public DateFilters() {

		t = new myTemplates();
		setBackground(t.white);
		setLayout(new MigLayout("wrap, fill", "[]", "[34px:n][][][][][][][]"));

			JLabel DateFilterLbl = new JLabel("Filtra per data");
			DateFilterLbl.setForeground(t.tangaroa);
			DateFilterLbl.setFont(new Font("Calibri Light", Font.PLAIN, 16));
			add(DateFilterLbl, "cell 0 0, alignx center, aligny center");

			JSeparator Separator1 = new JSeparator();
			add(Separator1, "cell 0 1,grow");

				JLblButton DataPrecisaBtn = new JLblButton(t.tangaroa, "Data precisa");
				DataPrecisaBtn.setFont(new Font("Calibri Light", Font.PLAIN, 13));
				DataPrecisaBtn.setHorizontalAlignment(SwingConstants.RIGHT);
				add(DataPrecisaBtn, "cell 0 2,alignx center,aligny center");

				DataPrecisaCmbBx = new DateComboBox();
				DataPrecisaCmbBx.setVisible(false);
				DataPrecisaCmbBx.setMinimumSize(new Dimension(140, 20));
				add(DataPrecisaCmbBx, "cell 0 3,alignx center,aligny center");

				DataPrecisaBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {

						if (DataPrecisaVisible) { DataPrecisaCmbBx.setVisible(false); DataPrecisaVisible = false; }

						else { DataPrecisaCmbBx.setVisible(true); DataPrecisaVisible = true; }
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						DataPrecisaBtn.setForeground(t.scBlue);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						DataPrecisaBtn.setForeground(t.tangaroa);
					}
				});

			JSeparator Separator2 = new JSeparator();
			add(Separator2, "cell 0 4,grow");

				JLblButton PeriodoBtn = new JLblButton(t.tangaroa, "Periodo");
				PeriodoBtn.setFont(new Font("Calibri Light", Font.PLAIN, 13));
				PeriodoBtn.setHorizontalAlignment(SwingConstants.RIGHT);
				add(PeriodoBtn, "cell 0 5,alignx center,aligny center");

				InizioPeriodoCmbBx = new DateComboBox();
				InizioPeriodoCmbBx.setVisible(false);
				InizioPeriodoCmbBx.setMaximumSize(new Dimension(140, 20));
				add(InizioPeriodoCmbBx, "cell 0 6,alignx center,aligny center");

				FinePeriodoCmbBx = new DateComboBox();
				FinePeriodoCmbBx.setVisible(false);
				FinePeriodoCmbBx.setMaximumSize(new Dimension(140, 20));
				add(FinePeriodoCmbBx, "cell 0 7,alignx center,aligny center");

				PeriodoBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (PeriodoVisible) {
							InizioPeriodoCmbBx.setVisible(false);
							FinePeriodoCmbBx.setVisible(false);
							PeriodoVisible = false;
						} else {
							InizioPeriodoCmbBx.setVisible(true);
							FinePeriodoCmbBx.setVisible(true);
							PeriodoVisible = true;
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						PeriodoBtn.setForeground(t.scBlue);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						PeriodoBtn.setForeground(t.tangaroa);
					}
				});
	}

	public DateComboBox getDataPrecisaCmbBx() { return DataPrecisaCmbBx; }

	public DateComboBox getInizioPeriodioCmbBx() { return InizioPeriodoCmbBx; }

	public DateComboBox getFinePeriodoCmbBx() { return FinePeriodoCmbBx; }
}