package container;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import common.DbObject;

@XmlRootElement
public class Formateur extends DbObject {

	private String titre;
	private String nom;
	private String prenom;
	private String email;

	public String getTitre() {
		return titre;
	}

	@XmlElement
	public static  void setTitre(String titre) {
		//this.titre = titre;
	}

	public String getNom() {
		return nom;
	}

	@XmlElement
	public static void setNom(String nom) {
		//this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	@XmlElement
	public static void setPrenom(String prenom) {
		//this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

}
