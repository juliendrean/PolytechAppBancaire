package Vue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.List;
import java.util.Vector;

import javax.swing.JButton;

import Controleur.CtrlFenAjoutCarte;
import Controleur.CtrlSupprimeCarte;

public class FenListCarte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNomClt = null;
	private List listCartes = null;
	private JButton jButtonGestCarte = null;
	private JButton jButtonAjouteCarte = null;
	private JButton jButtonSupprimerCarte = null;

	/**
	 * This is the default constructor
	 */
	public FenListCarte() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(617, 256);
		this.setLocation(400, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Cartes du client");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNomClt = new JLabel();
			jLabelNomClt.setText("JLabel");
			jLabelNomClt.setSize(new Dimension(100, 20));
			jLabelNomClt.setLocation(new Point(16, 13));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelNomClt, null);
			jContentPane.add(getListCartes(), null);
			jContentPane.add(getJButtonAjouteCarte(), null);
			jContentPane.add(getJButtonAjouteCarte1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes listCartes
	 *
	 * @return java.awt.List
	 */
	private List getListCartes() {
		if (listCartes == null) {
			listCartes = new List();
			listCartes.setBounds(new Rectangle(19, 65, 402, 149));
		}
		return listCartes;
	}



	/**
	 * This method initializes jButtonAjouteCarte
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAjouteCarte() {
		if (jButtonAjouteCarte == null) {
			jButtonAjouteCarte = new JButton();
			jButtonAjouteCarte.setLocation(new Point(435, 140));
			jButtonAjouteCarte.setText("Ajouter une carte");
			jButtonAjouteCarte.setSize(new Dimension(160, 27));
		}
		return jButtonAjouteCarte;
	}

	public void setListCarte(Vector vect)
	{
		listCartes.removeAll();
		for(int i = 0 ; i < vect.size(); i++)
		{
			listCartes.addItem(vect.get(i).toString());
		}
	}
	public String getCarte()
	{
		return this.listCartes.getSelectedItem();
	}
	public void setLabelNomcli(String nom)
	{
		jLabelNomClt.setText(nom);
	}
	public void setControleurs( CtrlFenAjoutCarte ajout, CtrlSupprimeCarte supp)
	{
		jButtonAjouteCarte.addActionListener(ajout);
		jButtonSupprimerCarte.addActionListener(supp);
	}

	/**
	 * This method initializes jButtonAjouteCarte1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAjouteCarte1() {
		if (jButtonSupprimerCarte == null) {
			jButtonSupprimerCarte = new JButton();
			jButtonSupprimerCarte.setText("Supprimer une carte");
			jButtonSupprimerCarte.setSize(new Dimension(160, 27));
			jButtonSupprimerCarte.setLocation(new Point(435, 170));
		}
		return jButtonSupprimerCarte;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
