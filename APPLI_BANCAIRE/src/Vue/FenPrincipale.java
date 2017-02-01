package Vue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Controleur.CtrlAffichAgences;
import Controleur.CtrlAffichEmploye;
import Controleur.CtrlQuitter;

public class FenPrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuGestCli = null;
	private JMenuItem jMenuGestEmpl = null;
	
	private PanelAgence panAgen;
	private PanelEmploye panEmpl;
	
	
	private JMenuItem jMenuItemQuit = null;
	/**
	 * This is the default constructor
	 */
	public FenPrincipale() 
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
		this.setSize(465, 309);
		this.setJMenuBar(getJJMenuBar());
		this.setTitle("Fenetre Principale");
		panAgen = new PanelAgence();
		panEmpl = new PanelEmploye();
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new Dimension(0, 15));
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setPreferredSize(new Dimension(45, 19));
			jMenu.setSize(new Dimension(45, 13));
			jMenu.setText("Menu");
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getJMenuItem2());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuGestCli == null) {
			jMenuGestCli = new JMenuItem();
			jMenuGestCli.setText("Gestion des Clients");
		}
		return jMenuGestCli;
	}

	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuGestEmpl == null) {
			jMenuGestEmpl = new JMenuItem();
			jMenuGestEmpl.setText("Gestion des Employés");
		}
		return jMenuGestEmpl;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() 
	{
		if (jMenuItemQuit == null) {
			jMenuItemQuit = new JMenuItem();
			jMenuItemQuit.setText("Quitter");
		}
		return jMenuItemQuit;
	}
	
	public void setControleurs(CtrlQuitter quit, CtrlAffichAgences agenc, CtrlAffichEmploye empl)
	{
		this.jMenuItemQuit.addActionListener(quit);
		this.jMenuGestEmpl.addActionListener(empl);
		this.jMenuGestCli.addActionListener(agenc);
	}
	
	public PanelAgence getPanelAgence()
	{
		return this.panAgen;
	}
	public PanelEmploye getPanelEmploye()
	{
		return this.panEmpl;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
