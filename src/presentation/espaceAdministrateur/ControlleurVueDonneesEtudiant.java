package presentation.espaceAdministrateur;

import metier.gestion.ModeleTableEtudiant;
import metier.gestion.ModeleVueBienvenu;
import metier.pojo.Administrateur;
import metier.pojo.Etudiant;
import presentation.espaceEtudiant.VueAccueil;

public class ControlleurVueDonneesEtudiant {
	private VueDonneesEtudiant vueEtudiant;
	private VueNouvelleDonneeEtudiant vueNouvelleDonneeEtudiant;
	private VueBienvenu vue_bienvenu;

	public ControlleurVueDonneesEtudiant() {

	}

	public ControlleurVueDonneesEtudiant(VueDonneesEtudiant vueEtudiant) {
		super();
		this.vueEtudiant = vueEtudiant;
	}

	public ControlleurVueDonneesEtudiant(VueNouvelleDonneeEtudiant vueNouvelleDonneeEtudiant) {
		super();
		this.vueNouvelleDonneeEtudiant = vueNouvelleDonneeEtudiant;
	}
	
	public void executeVueAccueil(Administrateur admin) {
		try {
			vue_bienvenu = new VueBienvenu(new ModeleVueBienvenu(admin));
			this.vueEtudiant.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeVueNouvelleDonneeEtudiant(Etudiant etudiant, ModeleTableEtudiant tableEtudiant) {
		try {
			vueNouvelleDonneeEtudiant = new VueNouvelleDonneeEtudiant(etudiant, tableEtudiant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
