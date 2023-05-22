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
		
		myRadioBtn TemaAmbienteLbl = new myRadioBtn("Ambiente", new Color(0, 200, 0), 16);
		buttonGroup.add(TemaAmbienteLbl);
		add(TemaAmbienteLbl, "cell 0 0, alignx left, aligny center");
		
		myRadioBtn TemaChimicaLbl = new myRadioBtn("Chimica", new Color(0, 200, 255), 16);
		buttonGroup.add(TemaChimicaLbl);
		add(TemaChimicaLbl, "cell 1 0, alignx left, aligny center");
		
		myRadioBtn TemaBiologiaLbl = new myRadioBtn("Biologia", new Color(0, 128, 0), 16);
		buttonGroup.add(TemaBiologiaLbl);
		add(TemaBiologiaLbl, "cell 2 0, alignx left, aligny center");
		
		myRadioBtn TemaSostenibilitàLbl = new myRadioBtn("Sostenibilità", new Color(240, 210, 0), 16);
		buttonGroup.add(TemaSostenibilitàLbl);
		add(TemaSostenibilitàLbl, "cell 0 1,alignx left,aligny center");
		
		myRadioBtn TemaInformaticaLbl = new myRadioBtn("Informatica", new Color(0, 100, 255), 16);
		buttonGroup.add(TemaInformaticaLbl);
		add(TemaInformaticaLbl, "cell 1 1,alignx left,aligny center");
		
		myRadioBtn TemaAnatomiaLbl = new myRadioBtn("Anatomia", new Color(250, 88, 80), 16);
		buttonGroup.add(TemaAnatomiaLbl);
		add(TemaAnatomiaLbl, "cell 2 1,alignx left,aligny center");
		
		myRadioBtn TemaFisicaLbl = new myRadioBtn("Fisica", new Color(250, 80, 0), 16);
		buttonGroup.add(TemaFisicaLbl);
		add(TemaFisicaLbl, "cell 0 2,alignx left,aligny center");
		
		myRadioBtn TemaMatematicaLbl = new myRadioBtn("Matematica", new Color(0, 0, 200), 14);
		buttonGroup.add(TemaMatematicaLbl);
		add(TemaMatematicaLbl, "cell 1 2,alignx left,aligny center");
		
		myRadioBtn TemaPsicologiaLbl = new myRadioBtn("Psicologia", new Color(255, 0, 128), 16);
		buttonGroup.add(TemaPsicologiaLbl);
		add(TemaPsicologiaLbl, "cell 2 2,alignx left,aligny center");
		TemaPsicologiaLbl.setActionCommand("Psicologia");
		
		myRadioBtn TemaGeologiaLbl = new myRadioBtn("Geologia", new Color(180, 100, 40), 16);
		buttonGroup.add(TemaGeologiaLbl);
		add(TemaGeologiaLbl, "cell 0 3,alignx left,aligny center");
		
		myRadioBtn TemaAstrologiaLbl = new myRadioBtn("Astrologia", new Color(30, 30, 120), 16);
		buttonGroup.add(TemaAstrologiaLbl);
		add(TemaAstrologiaLbl, "cell 1 3,alignx left,aligny center");
		
		myRadioBtn TemaAltroLbl = new myRadioBtn("Altro", new Color(140, 141, 142), 16);
		buttonGroup.add(TemaAltroLbl);
		add(TemaAltroLbl, "cell 2 3,alignx left,aligny center");
	}
	
	public ButtonGroup getButtonGroup() { return buttonGroup; }
}