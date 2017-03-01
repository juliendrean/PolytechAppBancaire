package Vue;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import Controleur.CtrlFenAjoutEmploye;
import Controleur.CtrlFenGestEmp;
import Controleur.CtrlFenInfosEmploye;
import Controleur.CtrlListEmp;
import Controleur.CtrlSupprimerEmploye;

import java.awt.List;
import java.util.Vector;
import java.awt.Point;

public class PanelEmploye extends JPanel 
{

	
	private JButton jButtonVoirEmp = null;
	private JLabel jLabel = null;
	private JComboBox jComboBox = null;
	private JButton jButtonAjouteEmploye = null;
	private JButton jButtonModifEmpl = null;
	private JButton jButtonSupprimerEmploye = null;
	private JLabel jLabel1 = null;
	private List list = null;
	private JButton jButtonInfosEmploye = null;
	/**
	 * This is the default constructor
	 */
	public PanelEmploye() 
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
		jLabel.setBounds(new Rectangle(12, 70, 121, 20));
		jLabel.setText("Choix de l'employé");
		this.setSize(400, 255);
		this.setLayout(null);
		this.add(getJButtonVoirEmp(), null);
		this.add(jLabel, null);
		this.add(getList(), null);
		this.add(getJComboBox(), null);
		this.add(getJButtonAjouteEmploye(), null);
		this.add(getJButtonSupprimerEmploye(), null);
		this.add(getJButtonModifEmpl(), null);
		this.add(jLabel1, null);
		this.add(getJButtonAjouteEmploye1(), null);
		
	}

	/**
	 * This method initializes jButtonVoirEmp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVoirEmp() {
		if (jButtonVoirEmp == null) {
			jButtonVoirEmp = new JButton();
			jButtonVoirEmp.setText("Voir les employés");
			jButtonVoirEmp.setLocation(new Point(200, 25));
			jButtonVoirEmp.setSize(new Dimension(190, 23));
		}
		return jButtonVoirEmp;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setLocation(new Point(10, 25));
			jComboBox.setSize(new Dimension(160, 20));
		}
		return jComboBox;
	}

	private JButton getJButtonSupprimerEmploye() 
	{
		if (jButtonSupprimerEmploye == null) {
			jButtonSupprimerEmploye = new JButton();
			jButtonSupprimerEmploye.setText("Supprimer Employe");
			jButtonSupprimerEmploye.setLocation(new Point(225, 130));
			jButtonSupprimerEmploye.setSize(new Dimension(145, 23));
		}
		return jButtonSupprimerEmploye;
	}
	/**
	 * This method initializes jButtonAjouteEmploye	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAjouteEmploye() {
		if (jButtonAjouteEmploye == null) {
			jButtonAjouteEmploye = new JButton();
			jButtonAjouteEmploye.setText("Ajouter Employe");
			jButtonAjouteEmploye.setLocation(new Point(225, 180));
			jButtonAjouteEmploye.setSize(new Dimension(145, 23));
		}
		return jButtonAjouteEmploye;
	}

	/**
	 * This method initializes jButtonModifEmpl	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonModifEmpl() {
		if (jButtonModifEmpl == null) {
			jButtonModifEmpl = new JButton();
			jButtonModifEmpl.setText("Modifier Employer");
			jButtonModifEmpl.setLocation(new Point(225, 155));
			jButtonModifEmpl.setSize(new Dimension(145, 23));
		}
		return jButtonModifEmpl;
	}

	/**
	 * This method initializes list	
	 * 	
	 * @return java.awt.List	
	 */
	private List getList() {
		if (list == null) {
			list = new List();
			list.setLocation(new Point(11, 100));
			list.setSize(new Dimension(200, 130));
		}
		return list;
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
	public void setListEmployeAgence(Vector vect)
	{
		list.removeAll();
		for(int i = 0 ; i < vect.size(); i++)
		{
			list.addItem(vect.get(i).toString());
		}
	}
	public int getnumAgneceSelect()
	{
		return this.jComboBox.getSelectedIndex();
	}
	public String getEmploye()
	{
		return this.list.getSelectedItem();
	}
	
	public void setControleur(CtrlListEmp empl, CtrlFenAjoutEmploye ajout, CtrlSupprimerEmploye supp, CtrlFenGestEmp gestionEmpl, CtrlFenInfosEmploye info)
	{
		jButtonVoirEmp.addActionListener(empl);
		jButtonAjouteEmploye.addActionListener(ajout);
		jButtonModifEmpl.addActionListener(gestionEmpl);
		jButtonSupprimerEmploye.addActionListener(supp);
		jButtonInfosEmploye.addActionListener(info);
	}

	/**
	 * This method initializes jButtonAjouteEmploye1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAjouteEmploye1() {
		if (jButtonInfosEmploye == null) {
			jButtonInfosEmploye = new JButton();
			jButtonInfosEmploye.setText("Voir infos employe");
			jButtonInfosEmploye.setSize(new Dimension(145, 23));
			jButtonInfosEmploye.setLocation(new Point(225, 205));
		}
		return jButtonInfosEmploye;
	}
}  //  @jve:decl-index=0:visual-constraint="11,13"
