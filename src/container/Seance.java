package container;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Seance {

	private Module module;
	private Formateur formateur;
	private int duree;

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

	public Formateur getFormateur() {
		return formateur;
	}

	@XmlElement
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
