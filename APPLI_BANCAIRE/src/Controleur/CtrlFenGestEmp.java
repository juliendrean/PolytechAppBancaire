package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Employe;
import Modele.Model;
import Vue.FenGestionEmploye;
import Vue.PanelEmploye;

public class CtrlFenGestEmp implements ActionListener
{
	private Model model;
	private PanelEmploye Pan;
	
	public CtrlFenGestEmp(PanelEmploye pan, Model mod)
	{
		this.Pan = pan;
		this.model = mod;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		Employe empl = model.getEmploye(Pan.getEmploye());
		FenGestionEmploye fen = new FenGestionEmploye();
		fen.setListAgences(model.getlesCodeAgence());
		fen.setListPostes(model.getCategorieEmploye());
		fen.setLabel(empl.getNomEmploye()+" "+ empl.getPnomEmploye());
		fen.setControleurs(new CtrlModifEmployé(empl, fen));
		fen.setVisible(true);
	}

}
