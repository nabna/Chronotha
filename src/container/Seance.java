package container;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import static org.apache.commons.lang3.StringUtils.*;

import common.DbObject;

@XmlRootElement
public class Seance extends DbObject {
    
	private static final long serialVersionUID = 1L;
	
	private Module module;
	private Formateur formateur;
	private Planning planning;
	private int rang;
	private int debut;
	private int duree;

	public Module getModule() {
		return module;
	}

	@XmlElement
	public void setModule(Module module) {
		this.module = module;
	}

	public int getDebut() {
		return debut;
	}

	@XmlElement
	public void setDebut(int debut) {
		this.debut = debut;
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

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	@Override
	public String toString() {
		return module.getAbbreviation() + " - " + capitalize(left(formateur.getPrenom(), 1) + left(formateur.getNom(), 2));
	}
	

}

