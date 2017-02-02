package Vue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JButton;

import Controleur.CtrlAjoutCarte;

public class FenAjoutCarte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox jComboBox = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JButton jButton = null;

	/**
	 * This is the default constructor
	 */
	public FenAjoutCarte() {
		super();
		initialize();
		this.setLocation(400, 200);
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(279, 300);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			jLabel1 = new JLabel();
			jLabel1.setText("Type de carte");
			jLabel1.setSize(new Dimension(100, 20));
			jLabel1.setLocation(new Point(31, 125));
			
			jLabel = new JLabel();
			jLabel.setPreferredSize(new Dimension(100, 20));
			jLabel.setLocation(new Point(31, 17));
			jLabel.setSize(new Dimension(100, 20));
			jLabel.setText("Date Expiration");
			
			jLabel2 = new JLabel();
			jLabel2.setPreferredSize(new Dimension(100, 20));
			jLabel2.setLocation(new Point(31, 66));
			jLabel2.setSize(new Dimension(120, 20));
			jLabel2.setText("Numéros de carte");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBox
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setLocation(new Point(31, 150));
			jComboBox.setSize(new Dimension(150, 20));
		}
		return jComboBox;
	}

	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setLocation(new Point(31, 41));
			jTextField.setSize(new Dimension(150, 20));
		}
		return jTextField;
	}
	
	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setLocation(new Point(31, 100));
			jTextField1.setSize(new Dimension(150, 20));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(183, 190, 75, 27));
			jButton.setText("Valider");
		}
		return jButton;
	}
	public void setCombo(Vector typCarte)
	{
		jComboBox.removeAllItems();
		for(int i = 0; i < typCarte.size();i++)
		{
			jComboBox.addItem(typCarte.get(i).toString());
		}
	}
	public String getDateExpiration()
	{
		return jTextField.getText().toString();
	}
	
	public String getNumCarte()
	{
		return jTextField1.getText().toString();
	}
	
	public void setControleur(CtrlAjoutCarte ajout)
	{
		jButton.addActionListener(ajout);
	}
	public int getIndexCombo()
	{
		return this.jComboBox.getSelectedIndex();
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
