package Vue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Controleur.CtrlModifEmployé;

import java.awt.Point;
import java.awt.Dimension;
import java.util.Vector;

public class FenGestionEmploye extends JFrame 
{

	
	private JPanel jContentPane = null;
	private JLabel jLabelNomEmploye = null;
	private JButton jButtonValider = null;
	private JComboBox jComboBoxAgence = null;
	private JComboBox jComboBoxPoste = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	/**
	 * This is the default constructor
	 */
	public FenGestionEmploye() 
	{
		super();
		initialize();
		this.setLocation(400, 200);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() 
	{
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Modifier un Employé");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Poste occupé");
			jLabel1.setSize(new Dimension(100, 20));
			jLabel1.setLocation(new Point(20, 95));
			jLabel = new JLabel();
			jLabel.setText("Agence");
			jLabel.setSize(new Dimension(100, 20));
			jLabel.setLocation(new Point(20, 40));
			jLabelNomEmploye = new JLabel();
			jLabelNomEmploye.setText("JLabel");
			jLabelNomEmploye.setSize(new Dimension(100, 20));
			jLabelNomEmploye.setLocation(new Point(60, 14));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelNomEmploye, null);
			jContentPane.add(getJButtonValider(), null);
			jContentPane.add(getJComboBoxAgence(), null);
			jContentPane.add(getJComboBoxPoste(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonValider	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonValider() {
		if (jButtonValider == null) {
			jButtonValider = new JButton();
			jButtonValider.setBounds(new Rectangle(192, 138, 88, 20));
			jButtonValider.setText("Valider");
		}
		return jButtonValider;
	}

	/**
	 * This method initializes jComboBoxAgence	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxAgence() {
		if (jComboBoxAgence == null) {
			jComboBoxAgence = new JComboBox();
			jComboBoxAgence.setSize(new Dimension(101, 20));
			jComboBoxAgence.setLocation(new Point(20, 65));
		}
		return jComboBoxAgence;
	}

	/**
	 * This method initializes jComboBoxPoste	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxPoste() 
	{
		if (jComboBoxPoste == null) {
			jComboBoxPoste = new JComboBox();
			jComboBoxPoste.setSize(new Dimension(98, 19));
			jComboBoxPoste.setLocation(new Point(20, 120));
		}
		return jComboBoxPoste;
	}
	
	
	public int getIndexAgence()
	{
		return this.jComboBoxAgence.getSelectedIndex()+1;
	}
	
	public int getIndexPoste()
	{
		return this.jComboBoxPoste.getSelectedIndex()+1;
	}
	
	
	public void setListAgences(Vector LesAgences)
	{
		jComboBoxAgence.removeAllItems();
		for(int i = 0; i < LesAgences.size();i++)
		{
			jComboBoxAgence.addItem(LesAgences.get(i).toString());
		}
	}
	
	public void setListPostes(Vector LesPostes)
	{
		jComboBoxPoste.removeAllItems();
		for(int i = 0; i < LesPostes.size();i++)
		{
			jComboBoxPoste.addItem(LesPostes.get(i).toString());
		}
	}
	public void setLabel(String nom)
	{
		jLabelNomEmploye.setText(nom);
	}
	public void setControleurs(CtrlModifEmployé modif)
	{
		jButtonValider.addActionListener(modif);
	}
}
