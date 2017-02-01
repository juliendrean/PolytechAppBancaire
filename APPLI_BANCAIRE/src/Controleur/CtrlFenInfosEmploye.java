package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Employe;
import Modele.Model;
import Vue.FenInfos;
import Vue.PanelEmploye;

public class CtrlFenInfosEmploye implements ActionListener
{

	private Model model;
	private PanelEmploye Pan;
	
	public CtrlFenInfosEmploye(Model mod, PanelEmploye pan)
	{
		this.model = mod; 
		this.Pan = pan;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		Employe empl = model.getInfosEmploye(Pan.getEmploye());
		FenInfos fen = new FenInfos();
		fen.setLabels(empl.getNomEmploye(), empl.getPnomEmploye(), empl.getAdresseEmploye(), empl.getCpEmploye(), empl.getVilleEmploye(), model.getvilleAgenceEmploye(Pan.getEmploye()), "Catégorie : "+empl.getLibelleCategorie());
		fen.setVisible(true);
		}
	
}
