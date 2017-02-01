package Controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Carte;
import Vue.FenGestCarte;
import Vue.FenListCarte;
/*
 * Controleur qui ouvre la fenetre permettant d'ajouter un compte pour un client
 */
public class CtrlGestCarte implements ActionListener
{
	private Client Cli;
	private FenListCarte Fen;
	public CtrlGestCarte(Client cli, FenListCarte fen)
	{
		this.Cli = cli;
		this.Fen = fen;
	}
	public void actionPerformed(ActionEvent e)
	{
		FenGestCarte fen = new FenGestCarte();
		Carte cart = Cli.getCarte(Fen.getCarte());

		fen.setLabelNumCarte(cart.getNumCarte());
		fen.setVisible(true);
	}

}
