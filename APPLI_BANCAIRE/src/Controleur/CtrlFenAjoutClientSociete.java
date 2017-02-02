package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.FenAjoutSociete;
import Vue.PanelAgence;

/**
 * 
 * @author DREAN BERTIN
 * Controleur qui permet d'ouvrir une fenêtre permettant d'ajouter un nouveau client
 *
 */
public class CtrlFenAjoutClientSociete implements ActionListener
{
	PanelAgence Pan;
	Model model;
	public CtrlFenAjoutClientSociete(PanelAgence pan, Model unmodel)
	{
		this.model = unmodel;
		this.Pan = pan;
	}

	public void actionPerformed(ActionEvent e) 
	{
		FenAjoutSociete fenaj= new FenAjoutSociete();
		fenaj.setControleurs(new CtrlAjoutSte(fenaj, model));
		fenaj.setListAgence(model.getlesCodeAgence());
		fenaj.setVisible(true);
	}

}
