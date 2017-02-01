package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Compte;
import Vue.FenListCmpt;


//+ Classe qui permet de supprimer un compte client
public class CtrlSupprimeCompte implements ActionListener
{
	private Client Cli;
	private FenListCmpt Fen;
	public CtrlSupprimeCompte(FenListCmpt fen, Client cli)
	{
		this.Cli = cli;
		this.Fen = fen;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		Compte comp = Cli.getCompte(Fen.getCompte());
		comp.SupprimerCompte();
		Fen.setListCompte(Cli.getlescomptesclient());
	}

}
