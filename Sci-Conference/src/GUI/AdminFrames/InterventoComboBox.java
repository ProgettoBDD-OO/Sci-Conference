package GUI.AdminFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import linker.Controller;

public class InterventoComboBox extends JComboBox<Integer> {

	private Controller controller;

	public InterventoComboBox(int n, Controller c) {

		controller = c;

		Integer[] nInterventi = new Integer[n];

		for (int i = 0; i < nInterventi.length; i++) {

			nInterventi[i] = i + 1;
		}

		setModel(new DefaultComboBoxModel<>(nInterventi));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.goToModIntervento(getSelectedIndex() + 1);
			}
		});
	}
}