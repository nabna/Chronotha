package controller;

import java.util.List;

import common.IDbObject;

import connector.SimpleDbConnector;
//import connector.SimpleDbConnector;
import container.Formateur;
import container.Module;

public class DbTester {

	public static void main(String[] args) {
	/*
	   Module module = new Module();
		module.setAbbreviation("MO");
		module.setColor("FF0000");
		module.setName("Tarab andalousie ");
		module.setNbSeance(40);
		
		SimpleDbConnector.update(module);
		module.setId(1);
		
		
		Formateur formateur = new Formateur();
		// premiere insertion id = 0
		formateur.setTitre("Gestion");
		formateur.setNom("elha");
		formateur.setPrenom("naba");
		formateur.setEmail("nabaouiae@yahoo.fr");
		SimpleDbConnector.save(formateur);
		// deuxieme insertion id = 1
		formateur.setTitre("Gestion");
		formateur.setNom("elha");
		formateur.setPrenom("naba");
		formateur.setEmail("nabaouiae@yahoo.fr");
		SimpleDbConnector.save(formateur);
		
		// update id = 1
		formateur.setId(1);
		formateur.setTitre("Gestion 1");
		formateur.setNom("elha 1");
		formateur.setPrenom("naba 1");
		formateur.setEmail("nabaouiae1@yahoo.fr");
		SimpleDbConnector.update(formateur);
		
		
		//formateur.setId(1);
		//formateur.setTitre("Gestion");
		//formateur.setNom("elha");
		//formateur.setPrenom("naba");
		//formateur.setEmail("nabaouiae@yahoo.fr");
		//formateur.setId(1);
		//SimpleDbConnector.delete(formateur);
		*/
		
		
//		Formateur formateur1 = (Formateur) SimpleDbConnector.get(Formateur.class, 2);
//	    System.out.println(formateur1.getNom());
//	    System.out.println(formateur1.getPrenom());
		
		List<IDbObject> formateurs = SimpleDbConnector.getAll(Formateur.class);
		System.out.println(formateurs);
	}
	

	
}
