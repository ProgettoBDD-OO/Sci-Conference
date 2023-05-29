package myTools;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class TopicSelectionPanel extends JPanel {

	ButtonGroup buttonGroup = new ButtonGroup();

	public TopicSelectionPanel() {

		setLayout(new MigLayout("wrap, fill", "[][][]", "[][][][]"));
		setBackground(new Color(255, 255, 255));

		myRadioBtn TemaAmbiente = new myRadioBtn("Ambiente", new Color(0, 200, 0), 16);
		buttonGroup.add(TemaAmbiente);
		add(TemaAmbiente, "cell 0 0, alignx left, aligny center");

		myRadioBtn TemaChimica = new myRadioBtn("Chimica", new Color(0, 200, 255), 16);
		buttonGroup.add(TemaChimica);
		add(TemaChimica, "cell 1 0, alignx left, aligny center");

		myRadioBtn TemaBiologia = new myRadioBtn("Biologia", new Color(0, 128, 0), 16);
		buttonGroup.add(TemaBiologia);
		add(TemaBiologia, "cell 2 0, alignx left, aligny center");

		myRadioBtn TemaSostenibilità = new myRadioBtn("Sostenibilità", new Color(240, 210, 0), 16);
		buttonGroup.add(TemaSostenibilità);
		add(TemaSostenibilità, "cell 0 1,alignx left,aligny center");

		myRadioBtn TemaInformatica = new myRadioBtn("Informatica", new Color(0, 100, 255), 16);
		buttonGroup.add(TemaInformatica);
		add(TemaInformatica, "cell 1 1,alignx left,aligny center");

		myRadioBtn TemaMedicina = new myRadioBtn("Medicina", new Color(250, 88, 80), 16);
		TemaMedicina.setText("Medicina");
		buttonGroup.add(TemaMedicina);
		add(TemaMedicina, "cell 2 1,alignx left,aligny center");

		myRadioBtn TemaFisica = new myRadioBtn("Fisica", new Color(250, 80, 0), 16);
		buttonGroup.add(TemaFisica);
		add(TemaFisica, "cell 0 2,alignx left,aligny center");

		myRadioBtn TemaMatematica = new myRadioBtn("Matematica", new Color(0, 0, 200), 14);
		buttonGroup.add(TemaMatematica);
		add(TemaMatematica, "cell 1 2,alignx left,aligny center");

		myRadioBtn TemaPsicologia = new myRadioBtn("Psicologia", new Color(255, 0, 128), 16);
		buttonGroup.add(TemaPsicologia);
		add(TemaPsicologia, "cell 2 2,alignx left,aligny center");
		TemaPsicologia.setActionCommand("Psicologia");

		myRadioBtn TemaGeologia = new myRadioBtn("Geologia", new Color(180, 100, 40), 16);
		buttonGroup.add(TemaGeologia);
		add(TemaGeologia, "cell 0 3,alignx left,aligny center");

		myRadioBtn TemaAstrologia = new myRadioBtn("Astrologia", new Color(30, 30, 120), 16);
		buttonGroup.add(TemaAstrologia);
		add(TemaAstrologia, "cell 1 3,alignx left,aligny center");

		myRadioBtn TemaAltro = new myRadioBtn("Altro", new Color(140, 141, 142), 16);
		buttonGroup.add(TemaAltro);
		add(TemaAltro, "cell 2 3,alignx left,aligny center");
	}

	public ButtonGroup getButtonGroup() { return buttonGroup; }
}