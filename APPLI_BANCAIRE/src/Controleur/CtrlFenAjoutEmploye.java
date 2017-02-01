package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.FenAjoutEmpl;
import Vue.FenPrincipale;

public class CtrlFenAjoutEmploye implements ActionListener
{
	FenPrincipale Fen;
	Model model;
	public CtrlFenAjoutEmploye(FenPrincipale fen, Model unmodel)
	{
		this.model = unmodel;
		this.Fen = fen;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		FenAjoutEmpl fenajEmpl= new FenAjoutEmpl();
		fenajEmpl.setListAgence(model.getlesCodeAgence());
		fenajEmpl.setListCategorie(model.getCategorieEmploye());
		fenajEmpl.setControleur(new CtrlAjoutEmploye(fenajEmpl, this.model));
		fenajEmpl.setVisible(true);
	}
	
}
