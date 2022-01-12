package presentation_espaceProfesseur;


import javax.swing.JOptionPane;

import metier.getionProfesseur.modelVueconsulterDocLivrable2;

public class ControlleurVueconsulterDocLivrable2 {
	private VueconsulterDocLivrable2 livrableDOC2;
	private modelVueconsulterDocLivrable2 modelvueconsulterDocLivrable2;
	private ControlleurVueconsulterDocLivrable1 controlleurVueconsulterDocLivrable1;
	private  VueconsulterDocLivrable1 vueconsulterDocLivrable1;
	private int iDprof;

	public ControlleurVueconsulterDocLivrable2(VueconsulterDocLivrable2 livrableDOC2, int iDprof) {
		super();
		this.iDprof=iDprof;
		this.livrableDOC2 = livrableDOC2;
		passage(livrableDOC2);
	}

	private void passage(VueconsulterDocLivrable2 livrableDOC2) {
		
		livrableDOC2.getButtonConsulterDoc().addActionListener(e-> consulterLivrable());
		livrableDOC2.getValideButton().addActionListener(e-> valider());
		livrableDOC2.getRetour().addActionListener(e -> Retour());
	}

	private void Retour() {
		vueconsulterDocLivrable1=new VueconsulterDocLivrable1()	;
		vueconsulterDocLivrable1.setVisible(true);
		controlleurVueconsulterDocLivrable1=new ControlleurVueconsulterDocLivrable1(vueconsulterDocLivrable1, this.iDprof);
		livrableDOC2.setVisible(false);
	}

	private void valider() {
		int a=JOptionPane.showConfirmDialog(null,"Quitter?", "Quitter", JOptionPane.YES_NO_OPTION );
		if(a!=1)
		livrableDOC2.setVisible(false);
		 
	 }

	private void  consulterLivrable() {
		modelvueconsulterDocLivrable2= new modelVueconsulterDocLivrable2();
		Integer index=livrableDOC2.getTableEtudiant().getSelectedRow();
		if(index == -1)
			JOptionPane.showMessageDialog(null, "Selectionner l'etudiant");
		else
		{
			String livrable=modelvueconsulterDocLivrable2.getlivrable(livrableDOC2.getDocLivrableComboBox().getSelectedItem().toString(),
					livrableDOC2.getTableEtudiant().getModel().getValueAt(index, 0).toString());
			
			livrableDOC2.getPath().setText(livrable);
		
		}
		
			
	}
	
}
