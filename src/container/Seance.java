package container;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import common.DbObject;

@XmlRootElement
public class Seance extends DbObject {
    
	private Module module;
	private Formateur formateur;
	private int duree;
	private int rang;

	public Module getModule() {
		return module;
	}

	@XmlElement
	public void setModule(Module module) {
		this.module = module;
	}

	public int getDuree() {
		return duree;
	}

	@XmlElement
	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getRang() {
		return rang;
	}

	@XmlElement
	public void setRang(int rang) {
		this.rang = rang;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	@XmlElement
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


}

