package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Carte;
import Vue.FenListCarte;


//+ Classe qui permet de supprimer un compte client
public class CtrlSupprimeCarte implements ActionListener
{
	private Client Cli;
	private FenListCarte Fen;
	public CtrlSupprimeCarte(FenListCarte fen, Client cli)
	{
		this.Cli = cli;
		this.Fen = fen;
	}
	public void actionPerformed(ActionEvent arg0)
	{
		Carte cart = Cli.getCarte(Fen.getCarte());
		cart.SupprimerCarte();
		Fen.setListCarte(Cli.getlescomptesclient());
	}

}
