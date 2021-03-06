package presentation_espaceProfesseur;


import javax.swing.JOptionPane;

import metier.getionProfesseur.modelVueDeposerDoc;

public class ControlleurVueDeposerDoc {
    private VueDeposerDoc depooser;
	private modelVueDeposerDoc modelvueDeposerDoc;
	private ControlleurVueAcceuilProfesseur controlleurVueAcceuilProfesseur;
	private VueAcceuilProfesseur vueAcceuilProfesseurl;
	private int IDprof;

	public ControlleurVueDeposerDoc(VueDeposerDoc depooser, int IDprof) {
		super();
		this.depooser = depooser;
		this.IDprof=IDprof;
		passage(depooser);
	}

	private void passage(VueDeposerDoc depooser) {
		
		depooser.getButtonEnvoyer().addActionListener(e-> deposerDOC());
		depooser.getRetour().addActionListener(e -> Retour());
	}

	private void Retour() {
		vueAcceuilProfesseurl=new VueAcceuilProfesseur();
		vueAcceuilProfesseurl.setVisible(true);
		controlleurVueAcceuilProfesseur=new ControlleurVueAcceuilProfesseur(vueAcceuilProfesseurl, this.IDprof);
		depooser.setVisible(false);
	}

	private void deposerDOC() {
        
		modelvueDeposerDoc= new modelVueDeposerDoc();
		if(depooser.getTypeDocument().getSelectedIndex()==-1)
		{
			JOptionPane.showMessageDialog(null, "Selectionnez le type du document");
		}
			
		else {
		        if(!depooser.getTexLien().getText().equals("")&& 
				   !depooser.getTextCle().getText().equals("")&& 
				   !depooser.getTextTitre().getText().equals("") ) 
		{
		        	modelvueDeposerDoc.DeposerDocument(depooser.getTextTitre().getText(),depooser.getTextCle().getText(),
				this.IDprof,depooser.getTexLien().getText(),
				depooser.getTypeDocument().getSelectedItem().toString());		
		              }
		        }
		
		
		
	
	}
    
    
    
}
