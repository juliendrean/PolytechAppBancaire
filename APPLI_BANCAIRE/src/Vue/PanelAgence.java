package Vue;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.util.Vector;

import Controleur.CtrlCmptCli;
import Controleur.CtrlFenAjoutClientParticulier;
import Controleur.CtrlFenAjoutClientSociete;
import Controleur.CtrlFenInfosClient;
import Controleur.CtrlListClt;
import Controleur.CtrlSupprimerClient;
import Controleur.CtrlCrtCli;

import java.awt.List;
import java.awt.Color;
import java.awt.Point;

public class PanelAgence extends JPanel {

	
	private JButton jButtonGestCrt = null;
	private JButton jButtonGestCmpt = null;
	private JButton jButtonSupprimerCli = null;
	private JButton jButtonAjoutCliPart = null;
	private JComboBox jComboBox = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButtonVoirCli = null;
	private List list = null;
	private JButton jButtonAjoutCliSte = null;
	private JButton jButtonInfosCli = null;
	/**
	 * This is the default constructor
	 */
	public PanelAgence()
	{
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(11, 5, 121, 14));
		jLabel1.setText("Choix de l'agence");
		jLabel = new JLabel();
		jLabel.setText("Choix du client");
		jLabel.setLocation(new Point(12, 70));
		jLabel.setSize(new Dimension(121, 20));
		this.setSize(400, 255);
		this.setLayout(null);
		this.add(getJButton(), null);
		this.add(getJButtonCarte(), null);
		this.add(getJButtonAjout(), null);
		this.add(getJButtonSupprimer(), null);
		this.add(getList(), null);
		this.add(getJComboBox(), null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getJButtonVoirCli(), null);
		this.add(getJButton2(), null);
		this.add(getJButtonAjoutCliSte1(), null);
	}

	private JButton getJButtonSupprimer()
	{
		if (jButtonSupprimerCli == null) {
			jButtonSupprimerCli = new JButton();
			jButtonSupprimerCli.setText("Supprimer le Client");
			jButtonSupprimerCli.setLocation(new Point(225, 130));
			jButtonSupprimerCli.setSize(new Dimension(150, 23));
		}
		return jButtonSupprimerCli;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButtonGestCmpt == null) {
			jButtonGestCmpt = new JButton();
			jButtonGestCmpt.setText("Gérer les comptes");
			jButtonGestCmpt.setLocation(new Point(225, 155));
			jButtonGestCmpt.setSize(new Dimension(150, 23));
		}
		return jButtonGestCmpt;
	}

	private JButton getJButtonCarte() {
		if (jButtonGestCrt == null) {
			jButtonGestCrt = new JButton();
			jButtonGestCrt.setText("Gérer les cartes");
			jButtonGestCrt.setLocation(new Point(225, 105));
			jButtonGestCrt.setSize(new Dimension(150, 23));
		}
		return jButtonGestCrt;
	}
	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAjout() {
		if (jButtonAjoutCliPart == null) {
			jButtonAjoutCliPart = new JButton();
			jButtonAjoutCliPart.setText("Ajouter un Client");
			jButtonAjoutCliPart.setLocation(new Point(225, 180));
			jButtonAjoutCliPart.setSize(new Dimension(150, 23));
		}
		return jButtonAjoutCliPart;
	}



	/**
	 * This method initializes jList
	 *
	 * @return javax.swing.JList
	 */

	/**
	 * This method initializes jComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox()
	{
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setLocation(new Point(10, 25));
			jComboBox.setSize(new Dimension(150, 20));
		}
		return jComboBox;
	}


	/**
	 * This method initializes jButtonVoirCli
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonVoirCli()
	{
		if (jButtonVoirCli == null) {
			jButtonVoirCli = new JButton();
			jButtonVoirCli.setText("Voir les clients de l'agence");
			jButtonVoirCli.setLocation(new Point(200, 25));
			jButtonVoirCli.setSize(new Dimension(190, 23));
		}
		return jButtonVoirCli;
	}

	public void setListAgence(Vector vect)
	{
		jComboBox.removeAllItems();
		for (int i = 0; i < vect.size(); i++)
		{
			jComboBox.addItem(vect.get(i));
			System.out.println(vect.get(i));
		}
	}


	public void setListClientsAgence(Vector vect)
	{
		//list.clear();
		list.removeAll();
		for(int i = 0 ; i < vect.size(); i++)
		{
			list.add(vect.get(i).toString());
		}
	}

	/**
	 * This method initializes list
	 *
	 * @return java.awt.List
	 */
	private List getList() {
		if (list == null) {
			list = new List();
			list.setForeground(Color.black);
			list.setSize(new Dimension(200, 130));
			list.setLocation(new Point(11, 100));
		}
		return list;
	}

	public int getnumAgneceSelect()
	{
		return this.jComboBox.getSelectedIndex();
	}

	public String getclient()
	{
		return this.list.getSelectedItem();
	}

	public void setControleurs(CtrlListClt clt, CtrlFenAjoutClientParticulier part, CtrlFenAjoutClientSociete ste, CtrlCmptCli cli, CtrlCrtCli crtCli, CtrlSupprimerClient supp, CtrlFenInfosClient infos)
	{
		jButtonAjoutCliPart.addActionListener(part);
		jButtonAjoutCliSte.addActionListener(ste);
		jButtonVoirCli.addActionListener(clt);
		jButtonGestCmpt.addActionListener(cli);
		jButtonSupprimerCli.addActionListener(supp);
		jButtonInfosCli.addActionListener(infos);
		jButtonGestCrt.addActionListener(crtCli);
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButtonAjoutCliSte == null) {
			jButtonAjoutCliSte = new JButton();
			jButtonAjoutCliSte.setSize(new Dimension(150, 23));
			jButtonAjoutCliSte.setText("Ajouter une société");
			jButtonAjoutCliSte.setLocation(new Point(225, 205));
		}
		return jButtonAjoutCliSte;
	}

	/**
	 * This method initializes jButtonAjoutCliSte1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAjoutCliSte1() {
		if (jButtonInfosCli == null) {
			jButtonInfosCli = new JButton();
			jButtonInfosCli.setText("Voir infos Client");
			jButtonInfosCli.setSize(new Dimension(150, 23));
			jButtonInfosCli.setLocation(new Point(225, 230));
		}
		return jButtonInfosCli;
	}

}  //  @jve:decl-index=0:visual-constraint="12,10"
