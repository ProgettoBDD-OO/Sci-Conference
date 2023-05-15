package GUI.AdminFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import linker.Controller;

public class PartecipanteComboBox extends JComboBox<Integer>{
	
	private Controller controller;
	
	private Integer[] n = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	
	private String IdIntervento;
	
	public PartecipanteComboBox(String idIntervento, Controller c) {
		
		controller = c;
		IdIntervento = idIntervento;
		
		setModel(new DefaultComboBoxModel<>(n));
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.goToPartecipanti("Modifica", IdIntervento);
			}
		});
	}
}