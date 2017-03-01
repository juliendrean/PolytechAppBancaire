package Vue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Controleur.CtrlDepotCmpt;
import Controleur.CtrlRetraitCmpt;

public class FenGestCmp extends JFrame {

	
	private JPanel jContentPane = null;
	private JButton jButtonDepot = null;
	private JButton jButtonRetrait = null;
	private JTextField jTextField = null;
	private JLabel jLabel = null;
	private JLabel jLabelNumCmpt = null;
	private JLabel jLabel1 = null;

	/**
	 * This is the default constructor
	 */
	public FenGestCmp() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(277, 181);
		this.setContentPane(getJContentPane());
		this.setTitle("Gérer un compte");
		this.setLocation(400, 200);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Compte");
			jLabel1.setSize(new Dimension(50, 20));
			jLabel1.setLocation(new Point(15, 15));
			jLabelNumCmpt = new JLabel();
			jLabelNumCmpt.setText("JLabel");
			jLabelNumCmpt.setSize(new Dimension(100, 20));
			jLabelNumCmpt.setLocation(new Point(75, 15));
			jLabel = new JLabel();
			jLabel.setText("Montant");
			jLabel.setSize(new Dimension(100, 20));
			jLabel.setLocation(new Point(44, 54));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabelNumCmpt, null);
			jContentPane.add(jLabel1, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButtonDepot == null) {
			jButtonDepot = new JButton();
			jButtonDepot.setText("Deposer");
			jButtonDepot.setSize(new Dimension(85, 29));
			jButtonDepot.setLocation(new Point(81, 114));
		}
		return jButtonDepot;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButtonRetrait == null) {
			jButtonRetrait = new JButton();
			jButtonRetrait.setPreferredSize(new Dimension(73, 23));
			jButtonRetrait.setLocation(new Point(169, 114));
			jButtonRetrait.setSize(new Dimension(85, 29));
			jButtonRetrait.setText("Retirer");
		}
		return jButtonRetrait;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(44, 78, 118, 30));
		}
		return jTextField;
	}
	public String getMontant()
	{
		return jTextField.getText().toString();
	}
	public void setLabelNumCompte(int num)
	{
		this.jLabelNumCmpt.setText(new Integer(num).toString());
	}

	public void setControleur(CtrlDepotCmpt depot, CtrlRetraitCmpt retr)
	{
		jButtonDepot.addActionListener(depot);
		jButtonRetrait.addActionListener(retr);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
