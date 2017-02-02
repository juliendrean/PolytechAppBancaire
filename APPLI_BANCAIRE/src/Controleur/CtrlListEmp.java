package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Model;
import Vue.PanelEmploye;

/**
 * 
 * @author DREAN BERTIN
 * Controleur qui permet de lister les Employés pour une Agence
 */
public class CtrlListEmp implements ActionListener 
{
	private PanelEmploye panEmp;
	private Model model;
	
	public CtrlListEmp(PanelEmploye pane, Model mode)
	{
		this.panEmp = pane;
		this.model = mode;
	}
	public void actionPerformed(ActionEvent e) 
	{
		panEmp.setListEmployeAgence(model.getAgence(panEmp.getnumAgneceSelect()).getNomPnomEmploye());
	}

}
