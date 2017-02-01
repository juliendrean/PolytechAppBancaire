import Controleur.CtrlAffichAgences;
import Controleur.CtrlAffichEmploye;
import Controleur.CtrlQuitter;
import Modele.Model;
import Vue.FenPrincipale;


public class Principal 
{

	/**
	 * @param args
	 */
	static FenPrincipale fen;
	public static void main(String[] args) 
	{
		
		Model mod = new Model();
		fen = new FenPrincipale();
		
		fen.setControleurs(new CtrlQuitter(fen), new CtrlAffichAgences(fen, mod), new CtrlAffichEmploye(fen, mod));
		fen.setVisible(true);

	}
}
