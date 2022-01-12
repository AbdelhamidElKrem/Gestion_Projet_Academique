package presentation.espaceAdministrateur;

import metier.gestion.ModeleTableProjet;
import metier.gestion.ModeleVueBienvenu;
import metier.gestion.ModeleVueDonneesProjets;
import metier.pojo.Administrateur;

public class ControlleurVueDonneesProjets {
	private VueDonneesProjets vueDonneesProjets;
	private VueEditProjet vueEditProjet;
	private VueStatistiques vueStatistiques;
	private VueAjouterProjet vueAjouterProjet;
	private VueBienvenu vue_bienvenu;

	public ControlleurVueDonneesProjets() {
		super();
	}

	public ControlleurVueDonneesProjets(VueDonneesProjets vueDonneesProjets) {
		super();
		this.vueDonneesProjets = vueDonneesProjets;
	}

	public ControlleurVueDonneesProjets(VueEditProjet vueEditProjet) {
		super();
		this.vueEditProjet = vueEditProjet;
	}

	public ControlleurVueDonneesProjets(VueStatistiques vueStatistiques) {
		super();
		this.vueStatistiques = vueStatistiques;
	}

	public void executeVueEditProjet(ModeleVueDonneesProjets modele) {
		
		try {
			this.vueEditProjet = new VueEditProjet(modele);
			//this.vueDonneesProjets.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeVueAccueil(Administrateur admin) {
		try {
			vue_bienvenu = new VueBienvenu(new ModeleVueBienvenu(admin));
			this.vueDonneesProjets.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exercuteVueStatistique(ModeleVueDonneesProjets modele) {
		try {
			this.vueStatistiques = new VueStatistiques(modele);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exercuteVueAjouterProjet(ModeleVueDonneesProjets modele) {
		try {
			this.vueAjouterProjet = new VueAjouterProjet(modele);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exercuteVueDonneesProjets(ModeleVueDonneesProjets modele) {
		try {
			this.vueDonneesProjets = new VueDonneesProjets(modele);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
