package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Model;
import Vue.FenInfos;
import Vue.PanelAgence;

public class CtrlFenInfosClient implements ActionListener
{
	private Model model;
	private PanelAgence Pan;
	public CtrlFenInfosClient(Model mod, PanelAgence pan)
	{
		model = mod;
		Pan = pan;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		Client cli = model.getInfosClient(Pan.getclient());
		String villeAgence = model.getvilleAgenceClient(Pan.getclient());
		FenInfos fen = new FenInfos();
		fen.setTitle("Infos Client");
		
		fen.setLabels(cli.getNomClient(), cli.getPnomClients(), cli.getAdresseClient(), cli.getCodePostalClient(), cli.getVilleClient(), villeAgence, cli.getParticularite());
		fen.setVisible(true);
	}

}
