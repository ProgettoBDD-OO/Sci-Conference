package GUI.FilterFrame;

import myTools.myTemplates;

public class TopicFilters {

	myTemplates t = new myTemplates();
	
	protected FilterItem executeTopicFilter() {
		
			FilterItem TemaPsicologia = new FilterItem("Psicologia", t.black, t.myFont(13));
			FilterItem TemaAnatomia = new FilterItem("Anatomia ", t.black, t.myFont(13));
			FilterItem TemaFisica = new FilterItem("Fisica", t.black, t.myFont(13));
			FilterItem TemaGeologia = new FilterItem("Geologia", t.black, t.myFont(13));
			FilterItem TemaSostenibilità = new FilterItem("Sostenibilità", t.black,t.myFont(13));
			FilterItem TemaAmbiente = new FilterItem("Ambiente", t.black, t.myFont(13));
			FilterItem TemaBiologia = new FilterItem("Biologia", t.black, t.myFont(13));
			FilterItem TemaChimica = new FilterItem("Chimica", t.black, t.myFont(13));
			FilterItem TemaInformatica = new FilterItem("Informatica", t.black, t.myFont(13));
			FilterItem TemaMatematica = new FilterItem("Matematica", t.black, t.myFont(13));
			FilterItem TemaAstrologia = new FilterItem("Astrologia", t.black, t.myFont(13));
		
		FilterItem TopicFilters = new FilterItem("Filtra per tema", t.scBlue, t.myFont(13), 
												 TemaPsicologia, TemaAnatomia, TemaFisica, TemaGeologia, TemaSostenibilità, TemaAmbiente,
												 TemaBiologia, TemaChimica, TemaInformatica, TemaMatematica, TemaAstrologia);
		return TopicFilters;
	}
}