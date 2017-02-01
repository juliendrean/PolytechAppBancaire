package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Vue.FenAjoutCmpt;
import Vue.FenListCmpt;
/**
 * 
 * @author Guillaume
 * Controleur qui permet d'ouvrir la fenetre permettant d'ajouter un compte pour un client
 */
public class CtrlFenAjoutCompte implements ActionListener
{
	private Client cli;
	private FenListCmpt Fen;
	public CtrlFenAjoutCompte(FenListCmpt fen, Client cl)
	{
		this.Fen = fen;
		this.cli = cl;
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		FenAjoutCmpt fen = new FenAjoutCmpt();
		fen.setControleur(new CtrlAjoutCmpte(cli, fen, Fen));
		fen.setCombo(cli.getTypeComptes());
		fen.setVisible(true);
	}
	
}