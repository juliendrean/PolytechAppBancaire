package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Employe;
import Modele.Model;
import Vue.PanelEmploye;

public class CtrlSupprimerEmploye implements ActionListener
{
	private PanelEmploye Pan;
	private Model model;
	public CtrlSupprimerEmploye(PanelEmploye pan, Model mod)
	{
		this.Pan = pan;
		this.model = mod;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		Employe emp = model.getEmploye(Pan.getEmploye());
		model.SupprimerEmploye(emp);
		model.getAgence(Pan.getnumAgneceSelect()).récupérerEmploye();
		Pan.setListEmployeAgence(model.getAgence(Pan.getnumAgneceSelect()).getNomPnomEmploye());
	}

}
