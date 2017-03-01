package Vue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Point;

public class FenInfos extends JFrame {

	
	private JPanel jContentPane = null;
	private JLabel jLabelNom = null;
	private JLabel jLabelPnom = null;
	private JButton jButton = null;
	private JLabel jLabelAdress = null;
	private JLabel jLabelCodePostal = null;
	private JLabel jLabelVille = null;
	private JLabel jLabelAgence = null;
	private JLabel jLabelParti = null;
	/**
	 * This is the default constructor
	 */
	public FenInfos() {
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
		this.setSize(300, 241);
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
			jLabelParti = new JLabel();
			jLabelParti.setText("JLabel");
			jLabelParti.setSize(new Dimension(250, 15));
			jLabelParti.setLocation(new Point(15, 140));
			jLabelAgence = new JLabel();
			jLabelAgence.setText("JLabel");
			jLabelAgence.setSize(new Dimension(250, 15));
			jLabelAgence.setLocation(new Point(15, 120));
			jLabelVille = new JLabel();
			jLabelVille.setText("JLabel");
			jLabelVille.setSize(new Dimension(250, 15));
			jLabelVille.setLocation(new Point(15, 100));
			jLabelCodePostal = new JLabel();
			jLabelCodePostal.setText("JLabel");
			jLabelCodePostal.setSize(new Dimension(250, 15));
			jLabelCodePostal.setLocation(new Point(15, 80));
			jLabelAdress = new JLabel();
			jLabelAdress.setText("JLabel");
			jLabelAdress.setSize(new Dimension(250, 15));
			jLabelAdress.setLocation(new Point(15, 60));
			jLabelPnom = new JLabel();
			jLabelPnom.setText("JLabel");
			jLabelPnom.setSize(new Dimension(250, 15));
			jLabelPnom.setLocation(new Point(15, 40));
			jLabelNom = new JLabel();
			jLabelNom.setText("JLabel");
			jLabelNom.setSize(new Dimension(250, 15));
			jLabelNom.setLocation(new Point(15, 20));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelNom, null);
			jContentPane.add(jLabelPnom, null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabelAdress, null);
			jContentPane.add(jLabelCodePostal, null);
			jContentPane.add(jLabelVille, null);
			jContentPane.add(jLabelAgence, null);
			jContentPane.add(jLabelParti, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(220, 177, 60, 26));
			jButton.setText("OK");
		}
		jButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
			
		});
		return jButton;
	}
	
	public void setLabels(String nom, String prenom, String adresse, String codePostal, String ville, String Agence, String part)
	{
		this.jLabelNom.setText("Nom : "+ nom);
		this.jLabelPnom.setText("Prénom : "+ prenom);
		this.jLabelAdress.setText("Adresse : "+ adresse);
		this.jLabelCodePostal.setText("Code postal : "+ codePostal);
		this.jLabelVille.setText("Ville : "+ ville);
		this.jLabelAgence.setText("Agence : "+ Agence);
		this.jLabelParti.setText(part);
	}
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
