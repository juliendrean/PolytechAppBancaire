package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.FenPrincipale;
import Vue.PanelAgence;

public class CtrlAffichAgences implements ActionListener
{
	//on doit stocker la fenêtre courante (pour faire le lien)
	//le controleur doit connaitre la Vue
	private FenPrincipale Fen;
	private PanelAgence agenc;
	Model model;
	public CtrlAffichAgences (FenPrincipale Fen, Model unModel)
	{
		model = unModel;
		agenc = Fen.getPanelAgence();
		this.Fen=Fen;
	}
	public void actionPerformed (ActionEvent e)
	{
		Fen.remove(Fen.getPanelEmploye());
		agenc.setControleurs(new CtrlListClt(agenc, model), new CtrlFenAjoutClientParticulier(agenc, model), new CtrlFenAjoutClientSociete(agenc, model), new CtrlCmptCli(agenc, model), new CtrlCrtCli(agenc, model), new CtrlSupprimerClient(agenc,model), new CtrlFenInfosClient(model, agenc));
		model = new Model();
		agenc.setListAgence(model.getlesCodeAgence());
		Fen.add(agenc);
		Fen.repaint();
	}
}