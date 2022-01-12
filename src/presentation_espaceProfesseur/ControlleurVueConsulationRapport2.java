package presentation_espaceProfesseur;

import javax.swing.JOptionPane;

import metier.getionProfesseur.modelVueConsulationRapport2;
import metier.pojo.Etudiant;

public class ControlleurVueConsulationRapport2 {

    private modelVueConsulationRapport2 modelvueConsulationRapport2;
    private ControlleurVueConsulationRapport1 controlleurVueConsulationRapport1;
    private VueConsulationRapport1 vueConsulationRapport1;
    private int iDprof;
    private VueConsulationRapport2 vuerapport;
	public ControlleurVueConsulationRapport2(VueConsulationRapport2 vuerapport, int iDprof) {
		super();
		this.vuerapport = vuerapport;
		this.iDprof=iDprof;
		passage(vuerapport);
	}

	private void passage(VueConsulationRapport2 vuerapport) {

		vuerapport.getButtonConsulter().addActionListener(e -> consulterRapport());
		vuerapport.getValidebutton().addActionListener(e ->valide());
		vuerapport.getRetour().addActionListener(e ->Retour());
	}



	private void Retour() {
		vueConsulationRapport1=new VueConsulationRapport1();
		vueConsulationRapport1.setVisible(true);
		controlleurVueConsulationRapport1=new ControlleurVueConsulationRapport1(vueConsulationRapport1,this.iDprof);
		vuerapport.setVisible(false);
		
	}

	private void consulterRapport() {
		String path;
		modelvueConsulationRapport2= new modelVueConsulationRapport2();
		Integer index =vuerapport.getEtudiantTable().getSelectedRow();
		if(index==-1)
			JOptionPane.showMessageDialog(null, "Selectionnez l'etudiant (e)");
		else
		{
			path=modelvueConsulationRapport2.checkRapport(vuerapport.getEtudiantTable().getModel().getValueAt(index, 0).toString());
			vuerapport.getPath().setText(path);
		}		
		
	}
	private void valide() {
		int a=JOptionPane.showConfirmDialog(null,"Quitter?", "Quitter", JOptionPane.YES_NO_OPTION );
		if(a!=1)
		 vuerapport.setVisible(false);
	}
}
