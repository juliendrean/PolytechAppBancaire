package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Client;
import Modele.Model;
import Vue.FenListCmpt;
import Vue.PanelAgence;

/**
 * @author DREAN BERTIN
 * Controleur qui affiche une fenêtre permettant de voir les comptes pour un client
 */
public class CtrlCmptCli implements ActionListener
{
	private Model model;
	private PanelAgence Pan;
	public CtrlCmptCli(PanelAgence pan, Model mode)
	{
		this.Pan = pan;
		this.model = mode;
	}

	public void actionPerformed(ActionEvent arg0) 
	{	
		Client cli = model.getClient(Pan.getclient());
		FenListCmpt fen = new FenListCmpt();
		fen.setLabelNomcli(Pan.getclient());
		fen.setListCompte(cli.getlescomptesclient());
		fen.setControleurs(new CtrlGestCmpt(cli, fen), new CtrlFenAjoutCompte(fen, cli), new CtrlSupprimeCompte(fen, cli));
		fen.setVisible(true);
	}
	
}
