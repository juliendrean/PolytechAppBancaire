package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Model;
import Vue.PanelAgence;

public class CtrlSupprimerClient implements ActionListener
{
	private Model model;
	private PanelAgence Pan;
	public CtrlSupprimerClient(PanelAgence pan, Model mode)
	{
		this.Pan = pan;
		this.model = mode;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		Client cli = model.getClient(Pan.getclient());
		model.SupprimerClient(cli);
		Pan.setListClientsAgence(model.getAgence(Pan.getnumAgneceSelect()).getNomPnomClients());
	}

}
