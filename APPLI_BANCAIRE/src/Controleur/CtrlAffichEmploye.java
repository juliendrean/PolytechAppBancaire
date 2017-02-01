package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.FenPrincipale;
import Vue.PanelEmploye;

public class CtrlAffichEmploye implements ActionListener
{
	//on doit stocker la fenêtre courante (pour faire le lien)
	//le controleur doit connaitre la Vue
	private FenPrincipale Fen;
	private PanelEmploye pan;
	Model model;
	public CtrlAffichEmploye (FenPrincipale Fen, Model model)
	{
		this.model = model;
		pan = Fen.getPanelEmploye();
		this.Fen=Fen;
	}

	public void actionPerformed (ActionEvent e)
	{
		Fen.remove(Fen.getPanelAgence());
		pan.setListAgence(model.getlesCodeAgence());
		Fen.add(pan);
		pan.setControleur(new CtrlListEmp(pan, model), new CtrlFenAjoutEmploye(Fen,model), new CtrlSupprimerEmploye(pan, model), new CtrlFenGestEmp(pan, model), new CtrlFenInfosEmploye(model, pan));
		Fen.repaint();
	}
}