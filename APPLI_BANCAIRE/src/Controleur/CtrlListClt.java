package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.PanelAgence;

/**
 * @author DREAN BERTIN
 * Controleur qui permet de lister les client pour une Agence
 */
public class CtrlListClt implements ActionListener
{
	private PanelAgence panAg;
	private Model model;
	public CtrlListClt(PanelAgence pane, Model mode)
	{
		this.panAg = pane;
		this.model = mode;
	}
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(model.getAgence(panAg.getnumAgneceSelect()).getCode());
		panAg.setListClientsAgence(model.getAgence(panAg.getnumAgneceSelect()).getNomPnomClients());
	}

}
