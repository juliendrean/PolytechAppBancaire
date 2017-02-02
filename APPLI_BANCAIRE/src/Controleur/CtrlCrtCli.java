package Controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Model;
import Vue.FenListCarte;
import Vue.PanelAgence;

/**
 * @author Math
 * Controleur qui affiche une fenêtre permettant de voir les cartes d'un client
 */
public class CtrlCrtCli implements ActionListener
{
	private Model model;
	private PanelAgence Pan;
	public CtrlCrtCli(PanelAgence pan, Model mode)
	{
		this.Pan = pan;
		this.model = mode;
	}

	public void actionPerformed(ActionEvent arg0)
	{
		Client cli = model.getClient(Pan.getclient());
		FenListCarte fen = new FenListCarte();
		fen.setLabelNomcli(Pan.getclient());
		fen.setListCarte(cli.getlescartesclient());
		fen.setControleurs( new CtrlFenAjoutCarte(fen, cli), new CtrlSupprimeCarte(fen, cli));
		fen.setVisible(true);
	}

}
