package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Vue.FenAjoutCarte;
import Vue.FenListCarte;


/**
 *
 * @author DREAN BERTIN
 * Controleur qui permet d'ouvrir une fenêtre permettant d'ajouter une nouvelle carte
 *
 */
public class CtrlFenAjoutCarte implements ActionListener
{
	private Client cli;
	private FenListCarte Fen;
	public CtrlFenAjoutCarte(FenListCarte fen, Client cl)
	{
		this.Fen = fen;
		this.cli = cl;
	}
	public void actionPerformed(ActionEvent arg0)
	{
		FenAjoutCarte fen = new FenAjoutCarte();
		fen.setControleur(new CtrlAjoutCarte(cli, fen, Fen));
		fen.setCombo(cli.getTypeCartes());
		fen.setVisible(true);
	}
}