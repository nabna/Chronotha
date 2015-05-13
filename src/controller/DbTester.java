package controller;

import connector.SimpleDbConnector;
//import connector.SimpleDbConnector;
import container.Formateur;
//import container.Module;

public class DbTester {

	public static void main(String[] args) {
		//Module module = new Module();
		//module.setAbbreviation("MO");
		//module.setColor("FF0000");
		//module.setName("Tarab andalousie ");
		//module.setNbSeance(40);
		
		//SimpleDbConnector.update(module);
		//module.setId(1);
		
		
		Formateur formateur = new Formateur();
		
		
		SimpleDbConnector.save(formateur);
		Formateur.setTitre("Gestion");
		Formateur.setNom("elha");
		Formateur.setPrenom("naba ");
		//module.setEmail("nabaouiae@yahoo.fr");
		SimpleDbConnector.update(formateur);
		formateur.setId(1);
	
	}
	
}
