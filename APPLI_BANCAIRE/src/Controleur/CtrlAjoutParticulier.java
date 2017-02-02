package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.FenAjoutParticulier;
/**
 * 
 * @author DREAN BERTIN
 * Controleur qui ajoute un client Particulier
 */
public class CtrlAjoutParticulier implements ActionListener
{

	private Model model;
	private FenAjoutParticulier Fen;
	public CtrlAjoutParticulier(FenAjoutParticulier fen, Model mod)
	{
		this.Fen = fen;
		this.model = mod;
	}
	public void actionPerformed(ActionEvent e) 
	{
		int codeCli = model.countClients()+1;
		char[] cp = Fen.getCodePostal().toCharArray();
		
		if(Fen.getCodePostal().equals("") || Fen.getNom().equals("") || Fen.getPNom().equals("") || Fen.getAdresse().equals("") || Fen.getVille().equals("") )
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
		}
		else if (cp.length != 5)
		{
			javax.swing.JOptionPane.showMessageDialog(null,"code postal incorrect"); 
		}
		else if (cp[0] < '0' || cp[0] > '9' &&
			cp[1] < '0' || cp[1] > '9' &&
			cp[2] < '0' || cp[2] > '9' &&
			cp[3] < '0' || cp[3] > '9' &&
			cp[4] < '0' || cp[4] > '9')
		{
			javax.swing.JOptionPane.showMessageDialog(null,"Code postal incorrect"); 
		}	
		else
		{
			model.getAgence(Fen.getnumAgneceSelect()).ajoutClient(codeCli, Fen.getNom(), Fen.getPNom(), Fen.getAdresse(), Fen.getCodePostal(), Fen.getVille());
			model.getAgence(Fen.getnumAgneceSelect()).ajoutParticulier(codeCli, Fen.getCivilite());
			model.getAgence(Fen.getnumAgneceSelect()).récupérerClients();
			Fen.dispose();
		}
		
	}

}
