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
	{	boolean dateIsOK=false;
		boolean numIsOK=false;

		dateIsOK =checkDate();
		numIsOK = checkNumCarte();

		if(!dateIsOK)
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Date non valide");
		}

		if(!numIsOK)
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Numéro de carte non valide");
		}

		if (dateIsOK && numIsOK)
		{	
			cli.ajoutCarte(Fen.getDateExpiration(), Fen.getIndexCombo()+1,chiffreNumCarte(Fen.getNumCarte().toCharArray()));
			//cli.ajoutCarte(Fen.getDateExpiration(), Fen.getIndexCombo()+1,Fen.getNumCarte());
			Fen.dispose();
			Fenlist.setListCarte(cli.getlescartesclient());
		}

	}

	private boolean checkDate()
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
		if(c.length ==4)
		{
			c[4]=c[3];
			c[3]=c[2];
			c[2]='/';
		}
		if(c.length != 5)
		{
			test = false ;
		}
		return test;

	}

	private boolean checkNumCarte()
	{
		boolean test = true;
		char[] c = Fen.getNumCarte().toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] < '0' || c[i] > '9')
			{
					test = false;
			}

		}
		if(c.length != 16)
		{
			test = false ;
		}

		return test;
	}
	private String chiffreNumCarte(char[] numCarte)
	{int i;
	String result="";
		for(i=0;i<12;i++)
		{
			numCarte[i]='x';
		}
		for (i=0;i<numCarte.length;i++)
		{
			result=result+numCarte[i];
		}
	return result;
	}

}
