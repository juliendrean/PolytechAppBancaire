package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Vue.FenAjoutCarte;
import Vue.FenListCarte;

public class CtrlAjoutCarte implements ActionListener
{
	private Client cli;
	private FenAjoutCarte Fen;
	private FenListCarte Fenlist;

	public CtrlAjoutCarte(Client cl, FenAjoutCarte fen, FenListCarte li)
	{
		this.Fen = fen;
		this.cli = cl;
		this.Fenlist = li;
	}

	public void actionPerformed(ActionEvent arg0)
	{
		boolean test = true;
		char[] c = Fen.getDateExpiration().toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] < '0' || c[i] > '9')
			{
				if(c [i] != '/')
				{
					test = false;

				}

			}

		}
		if(c.length > 8)
		{
			test = false ;
		}
		if(test)
		{
			cli.ajoutCompte(Fen.getDateExpiration(), Fen.getIndexCombo()+1);
			Fen.dispose();
			Fenlist.setListCarte(cli.getlescomptesclient());
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Date non valide");
		}
	}

}
