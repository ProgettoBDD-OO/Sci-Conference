package GUI.FilterFrame;

import javax.swing.JPanel;

import myTools.myTemplates;

public class PlaceFilters {

	protected FilterItem executePlaceFilter(JPanel panel) {

		myTemplates t = new myTemplates();

				FilterItem ValDAostaFilter = new FilterItem("Val di Aosta", t.black, t.myFont(12));
				FilterItem LombardiaFilter = new FilterItem("Lombardia", t.black, t.myFont(12));
				FilterItem PiemonteFilter = new FilterItem("Piemonte", t.black, t.myFont(12));
				FilterItem VenetoFilter = new FilterItem("Veneto", t.black, t.myFont(12));
				FilterItem LiguriaFilter = new FilterItem("Liguria", t.black, t.myFont(12));
				FilterItem FriuliVeneziaGiuliaFilter = new FilterItem("Friuli Venezia Giulia", t.black, t.myFont(12));
				FilterItem TrentinoFilter = new FilterItem("Trentino Alto Adige", t.black, t.myFont(12));

			FilterItem NordItaliaFilter = new FilterItem("Nord Italia", t.dBlue, t.myFont(13),
					   ValDAostaFilter, LombardiaFilter, PiemonteFilter, VenetoFilter, LiguriaFilter, FriuliVeneziaGiuliaFilter, TrentinoFilter);


				FilterItem EmiliaRomagnaFilter = new FilterItem("Emilia Romagna", t.black, t.myFont(12));
				FilterItem ToscanaFilter = new FilterItem("Toscana", t.black, t.myFont(12));
				FilterItem UmbriaFilter = new FilterItem("Umbria", t.black, t.myFont(12));
				FilterItem MarcheFilter = new FilterItem("Marche", t.black, t.myFont(12));
				FilterItem AbruzzoFilter = new FilterItem("Abruzzo", t.black, t.myFont(12));
				FilterItem MoliseFilter = new FilterItem("Molise", t.black, t.myFont(12));
				FilterItem LazioFilter = new FilterItem("Lazio", t.black, t.myFont(12));

			FilterItem CentroItaliaFilter = new FilterItem("Centro Italia", t.dBlue, t.myFont(12),
					   EmiliaRomagnaFilter, ToscanaFilter, UmbriaFilter, MarcheFilter, AbruzzoFilter, MoliseFilter, LazioFilter);


				FilterItem CampaniaFilter = new FilterItem("Campania", t.black, t.myFont(12));
				FilterItem BasilicataFilter = new FilterItem("Basilicata", t.black, t.myFont(12));
				FilterItem PugliaFilter = new FilterItem("Puglia", t.black, t.myFont(12));
				FilterItem CalabriaFilter = new FilterItem("Calabria", t.black, t.myFont(12));
				FilterItem SiciliaFilter = new FilterItem("Sicilia", t.black, t.myFont(12));
				FilterItem SardegnaFilter = new FilterItem("Sardegna", t.black,t.myFont(12));

			FilterItem SudItaliaFilter = new FilterItem("Sud Italia", t.dBlue, t.myFont(13),
					CampaniaFilter, BasilicataFilter, PugliaFilter, CalabriaFilter, SiciliaFilter, SardegnaFilter);

		FilterItem PlaceFilters = new FilterItem("Filtra per luogo", t.scBlue, t.myFont(14), NordItaliaFilter, CentroItaliaFilter, SudItaliaFilter);

		return PlaceFilters;
	}
}