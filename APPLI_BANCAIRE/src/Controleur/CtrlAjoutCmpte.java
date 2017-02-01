package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Vue.FenAjoutCmpt;
import Vue.FenListCmpt;

public class CtrlAjoutCmpte implements ActionListener
{
	private Client cli;
	private FenAjoutCmpt Fen;
	private FenListCmpt Fenlist;
	public CtrlAjoutCmpte(Client cl, FenAjoutCmpt fen, FenListCmpt li)
	{
		this.Fen = fen;
		this.cli = cl;
		this.Fenlist = li;
	}
	public void actionPerformed(ActionEvent arg0) 
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
			cli.ajoutCompte(Fen.getMontant(), Fen.getIndexCombo()+1);
			Fen.dispose();
			Fenlist.setListCompte(cli.getlescomptesclient());
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Montant non valide");
		}
	}
}
