package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Employe;
import Vue.FenGestionEmploye;

public class CtrlModifEmployé implements ActionListener
{
	private Employe employe;
	private FenGestionEmploye fen;
	
	public CtrlModifEmployé(Employe emp, FenGestionEmploye fe)
	{
		this.employe = emp;
		this.fen = fe;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		employe.modifierEmploye(fen.getIndexAgence(), fen.getIndexPoste());
		fen.setVisible(false);
	}
}