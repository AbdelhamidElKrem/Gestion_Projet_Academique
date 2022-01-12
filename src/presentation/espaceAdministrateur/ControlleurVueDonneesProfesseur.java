package presentation.espaceAdministrateur;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleTableProfesseur;
import metier.gestion.ModeleVueBienvenu;
import metier.pojo.Administrateur;
import metier.pojo.Etudiant;
import metier.pojo.Professeur;

public class ControlleurVueDonneesProfesseur {
	private VueDonneesProfesseur vueDonneesProfesseur;
	private VueNouvelleDonneeProfesseur vueNouvelleDonneeProfesseur;
	private VueBienvenu vue_bienvenu;

	public ControlleurVueDonneesProfesseur() {
		super();
	}

	public ControlleurVueDonneesProfesseur(VueDonneesProfesseur vueDonneesProfesseur) {
		super();
		this.vueDonneesProfesseur = vueDonneesProfesseur;
	}

	public ControlleurVueDonneesProfesseur(VueNouvelleDonneeProfesseur vueNouvelleDonneeProfesseur) {
		super();
		this.vueNouvelleDonneeProfesseur = vueNouvelleDonneeProfesseur;
	}
	
	public void executeVueProfesseur() {
		
	}
	
	public void executeVueAccueil(Administrateur admin) {
		try {
			vue_bienvenu = new VueBienvenu(new ModeleVueBienvenu(admin));
			this.vueDonneesProfesseur.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeVueNouvelleDonneeProfesseur(Professeur professeur, ModeleTableProfesseur tableProfesseur) {
		try {
			vueNouvelleDonneeProfesseur = new VueNouvelleDonneeProfesseur(professeur,tableProfesseur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
