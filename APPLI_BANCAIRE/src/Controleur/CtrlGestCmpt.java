package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Compte;
import Vue.FenGestCmp;
import Vue.FenListCmpt;
/*
 * Controleur qui ouvre la fenetre permettant d'ajouter un compte pour un client
 */
public class CtrlGestCmpt implements ActionListener
{
	private Client Cli;
	private FenListCmpt Fen;
	public CtrlGestCmpt(Client cli, FenListCmpt fen)
	{
		this.Cli = cli;
		this.Fen = fen;
	}
	public void actionPerformed(ActionEvent e) 
	{
		FenGestCmp fen = new FenGestCmp();
		Compte comp = Cli.getCompte(Fen.getCompte());
		fen.setControleur(new CtrlDepotCmpt(fen, comp, Fen, Cli), new CtrlRetraitCmpt(fen, comp, Fen, Cli));
		fen.setLabelNumCompte(comp.getNumCompte());
		fen.setVisible(true);
	}

}
