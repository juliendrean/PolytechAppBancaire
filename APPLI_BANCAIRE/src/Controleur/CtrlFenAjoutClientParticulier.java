package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.FenAjoutParticulier;
import Vue.PanelAgence;

/**
 * 
 * @author DREAN BERTIN
 * Controleur qui permet d'ouvrir une fenêtre permettant d'ajouter un nouveau client
 *
 */
public class CtrlFenAjoutClientParticulier implements ActionListener
{
	PanelAgence Pan;
	Model model;
	public CtrlFenAjoutClientParticulier(PanelAgence pan, Model unmodel)
	{
		this.model = unmodel;
		this.Pan = pan;
	}

	public void actionPerformed(ActionEvent e) 
	{
		FenAjoutParticulier fenaj = new FenAjoutParticulier();
		fenaj.setControleurs(new CtrlAjoutParticulier(fenaj, model));
		fenaj.setListAgence(model.getlesCodeAgence());
		fenaj.setVisible(true);
	}

}
