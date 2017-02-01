package Controleur;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlQuitter implements ActionListener
{
	//on doit stocker la fenêtre courante (pour faire le lien)
	//le controleur doit connaitre la Vue
	private Frame Fen;

	public CtrlQuitter (Frame Fen)
	{
		this.Fen=Fen;
	}

	public void actionPerformed (ActionEvent e)
	{
		this.Fen.dispose();
	}
}
