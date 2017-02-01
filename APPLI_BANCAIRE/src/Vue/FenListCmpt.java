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

import Controleur.CtrlFenAjoutCompte;
import Controleur.CtrlGestCmpt;
import Controleur.CtrlSupprimeCompte;

public class FenListCmpt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNomClt = null;
	private List listComptes = null;
	private JButton jButtonGestCompte = null;
	private JButton jButtonAjouteCmpte = null;
	private JButton jButtonSupprimerCompte = null;

	/**
	 * This is the default constructor
	 */
	public FenListCmpt() {
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
		this.setTitle("Comptes du client");
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
			jContentPane.add(getListComptes(), null);
			jContentPane.add(getJButtonGestCompte(), null);
			jContentPane.add(getJButtonAjouteCmpte(), null);
			jContentPane.add(getJButtonAjouteCmpte1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes listComptes	
	 * 	
	 * @return java.awt.List	
	 */
	private List getListComptes() {
		if (listComptes == null) {
			listComptes = new List();
			listComptes.setBounds(new Rectangle(19, 65, 402, 149));
		}
		return listComptes;
	}

	/**
	 * This method initializes jButtonGestCompte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonGestCompte() {
		if (jButtonGestCompte == null) {
			jButtonGestCompte = new JButton();
			jButtonGestCompte.setText("Gérer compte");
			jButtonGestCompte.setSize(new Dimension(160, 27));
			jButtonGestCompte.setLocation(new Point(435, 110));
		}
		return jButtonGestCompte;
	}

	/**
	 * This method initializes jButtonAjouteCmpte	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAjouteCmpte() {
		if (jButtonAjouteCmpte == null) {
			jButtonAjouteCmpte = new JButton();
			jButtonAjouteCmpte.setLocation(new Point(435, 140));
			jButtonAjouteCmpte.setText("Ajouter un Compte");
			jButtonAjouteCmpte.setSize(new Dimension(160, 27));
		}
		return jButtonAjouteCmpte;
	}
	
	public void setListCompte(Vector vect)
	{
		listComptes.removeAll();
		for(int i = 0 ; i < vect.size(); i++)
		{
			listComptes.addItem(vect.get(i).toString());
		}
	}
	public String getCompte()
	{
		return this.listComptes.getSelectedItem();
	}
	public void setLabelNomcli(String nom)
	{
		jLabelNomClt.setText(nom);
	}
	public void setControleurs(CtrlGestCmpt gest, CtrlFenAjoutCompte ajout, CtrlSupprimeCompte supp)
	{
		jButtonGestCompte.addActionListener(gest);
		jButtonAjouteCmpte.addActionListener(ajout);
		jButtonSupprimerCompte.addActionListener(supp);
	}

	/**
	 * This method initializes jButtonAjouteCmpte1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAjouteCmpte1() {
		if (jButtonSupprimerCompte == null) {
			jButtonSupprimerCompte = new JButton();
			jButtonSupprimerCompte.setText("Supprimer un compte");
			jButtonSupprimerCompte.setSize(new Dimension(160, 27));
			jButtonSupprimerCompte.setLocation(new Point(435, 170));
		}
		return jButtonSupprimerCompte;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
