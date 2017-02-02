package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Compte;
import Vue.FenGestCmp;
import Vue.FenListCmpt;

/**
 * 
 * @author DREAN BERTIN
 * Controleur qui permet de déposer de l'argent pour un compte
 */
public class CtrlDepotCmpt implements ActionListener
{
	private FenGestCmp Fen;
	private Compte compte;
	private FenListCmpt Fenlist;
	private Client Cli;
	public CtrlDepotCmpt(FenGestCmp fen, Compte com, FenListCmpt fenlist, Client cli)
	{
		this.Fen = fen;
		this.compte = com;
		this.Fenlist = fenlist;
		this.Cli = cli;
	}
	public void actionPerformed(ActionEvent e) 
	{
		boolean test = true;
		char[] c = Fen.getMontant().toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] < '0' || c[i] > '9')
			{
				if(c [i] != '.')
				{
					test = false;
				}
			}
		}
		if(test)
		{
			compte.ajoutArgent(Fen.getMontant());
			Fen.dispose();
			Fenlist.setListCompte(Cli.getlescomptesclient());
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Montant non valide");
		}
	}
	
}
