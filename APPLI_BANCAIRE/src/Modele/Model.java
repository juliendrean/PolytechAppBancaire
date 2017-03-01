package Modele;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

public class Model
{
  	private Connection conn = null;


	private Vector lesAgences;

	public Model()
	{
		lesAgences = new Vector();
		setAgences();
	}
	private void setAgences()
	{
		//on se connecte à la BD
		try
		{
			getconnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("Le nom de la base de donnees est " + dbmd.getDatabaseProductName());
			System.out.println("La version de la base de donnees est " + dbmd.getDatabaseProductVersion());
			System.out.println("Le nom du pilote est " + dbmd.getDriverName());
			System.out.println("La version du pilote est " + dbmd.getDriverVersion());


			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesAgences()");

			while (resSect.next())
			{
				Agence ag;
				ag = new Agence(resSect.getInt("codeAgence"), resSect.getString("villeAgence"), resSect.getInt("codedirecteur"));
				ag.récupérerClients();
				ag.récupérerEmploye();
				this.lesAgences.add(ag);
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public Vector getlesCodeAgence()
	{
		Vector StrAgences =new Vector();
		for (int i =0 ; i< this.lesAgences.size(); i++)
		{
			Agence uneAgence;
			uneAgence = (Agence)lesAgences.get(i);
			String num = new Integer(uneAgence.getCode()).toString()+ " "+ uneAgence.getVille()+" "+uneAgence.getNomDirecteur();
			StrAgences.add(num);
		}
		return StrAgences;
	}

	public Vector getlesAgences()
	{
		return this.lesAgences;
	}
	//+ Retourne une Agenge
	public Agence getAgence(int index)
	{
		return (Agence) lesAgences.get(index);
	}

	//+ Compte le nombre total de clients
	public int countClients()
	{
		int nbClients = 0;
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesClients()");


			resSect.last();
			nbClients = resSect.getInt("codeClient");

			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return nbClients;
	}

	public int countEmploye()
	{
		int nbEmploye = 0;
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesEmployes()");

			resSect.last();
			nbEmploye = resSect.getInt("codeEmploye");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return nbEmploye;
	}

	public Client getClient(String codeNomPrenom)
	{
		StringTokenizer str = new StringTokenizer(codeNomPrenom, " ");
		String code = str.nextToken();
		Client client = null;
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnClient("+ code+")");

			while (resSect.next())
			{
				client = new Client(resSect.getInt("codeClient"));
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return client;
	}

	public Client getInfosClient(String codeNomPrenom)
	{
		StringTokenizer str = new StringTokenizer(codeNomPrenom, " ");
		String code = str.nextToken();
		Client client = null;

		String societe = "";
		String civilite = "";
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnClient("+ code+")");

			while (resSect.next())
			{
				client = new Client(resSect.getInt("codeClient"), resSect.getString("nomClient") , resSect.getString("PNomClient"), resSect.getString("AdresseClient"), resSect.getString("CodePostalClient"), resSect.getString("VilleClient"));
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		civilite = this.getCivilite(code);
		societe = this.getSociete(code);

		boolean civiliteIsEmpty=civilite.equals("");
		boolean societeIsEmpty=civilite.equals("");

		if(civiliteIsEmpty)
		{
			client.setParticularite("Civilité : "+ civilite);
		}
		else if(societeIsEmpty)
		{
			client.setParticularite("Societe : "+ societe);
		}
		return client;
	}

	public String getvilleAgenceClient(String codeNomPrenom)
	{
		StringTokenizer str = new StringTokenizer(codeNomPrenom, " ");
		String code = str.nextToken();
		String villeAG = "";

		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("SELECT villeAgence FROM client , agence WHERE client.codeAgence = agence.codeAgence and client.codeClient = "+ code);

			while (resSect.next())
			{
				villeAG = resSect.getString("villeAgence");
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return villeAG;
	}
	public String getvilleAgenceEmploye(String codeNomPrenom)
	{
		StringTokenizer str = new StringTokenizer(codeNomPrenom, " ");
		String code = str.nextToken();
		String villeAG = "";

		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("SELECT villeAgence FROM employe , agence WHERE employe.codeAgence = agence.codeAgence and employe.codeEmploye = "+ code);

			while (resSect.next())
			{
				villeAG = resSect.getString("villeAgence");
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return villeAG;
	}
	public String getSociete(String code)
	{
		String societe = "";
		//on se connecte à la BD
		try
		{

			getconnection();
			Statement stmt = conn.createStatement();

			ResultSet resSectSte = stmt.executeQuery("CALL getUnClientSOciete("+ code+")");
			while (resSectSte.next())
			{
				societe = resSectSte.getString("nomSociete");
			}
			resSectSte.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return societe;
	}
	public String getCivilite(String code)
	{
		String civilite = "";
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();

			ResultSet resSectPart = stmt.executeQuery("CALL getUnClientParticulier("+ code+")");
			while (resSectPart.next())
			{
				civilite = resSectPart.getString("civiliteClient");
			}
			resSectPart.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return civilite;
	}

	public Employe getEmploye(String codeNomPrenom)
	{
		StringTokenizer str = new StringTokenizer(codeNomPrenom, " ");
		String code = str.nextToken();
		Employe employe = null;
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnEmploye("+ code+")");

			while (resSect.next())
			{
				employe = new Employe(resSect.getInt("codeEmploye"), resSect.getString("PrenomEmploye"), resSect.getString("NomEmploye"));
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return employe;
	}
	public Employe getInfosEmploye(String codeNomPrenom)
	{
		StringTokenizer str = new StringTokenizer(codeNomPrenom, " ");
		String code = str.nextToken();
		Employe employe = null;
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnEmploye("+ code+")");

			while (resSect.next())
			{
				employe = new Employe(resSect.getInt("codeEmploye"), resSect.getString("NomEmploye"), resSect.getString("PrenomEmploye"), resSect.getString("AdresseEmploye"), resSect.getString("CPEmploye"), resSect.getString("VilleEmploye"),resSect.getInt("codeCategorie"));
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return employe;
	}

	public Vector getCategorieEmploye()
	{
		Vector categ = new Vector();
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesCategories()");

			while (resSect.next())
			{
				String uneCategorie;
				uneCategorie = resSect.getString("libelleCategorie");
				categ.add(uneCategorie);
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return categ;
	}
	public void SupprimerClient(Client cli)
	{

		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			stmt.execute("CALL deleteUnClient( "+cli.getCodeClient() +")");
			stmt.execute("CALL deleteUneSte("+ cli.getCodeClient()+")");
			stmt.execute("CALL deleteUnParticulier("+ cli.getCodeClient()+")");
			stmt.execute("CALL deleteLesComptesClient("+ cli.getCodeClient()+")");
			setAgences();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	public void SupprimerEmploye(Employe emp)
	{

		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			stmt.execute("CALL deleteUnEmployé("+emp.getCodeEmploye()+")");
			setAgences();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	//+ Méthode permettant de se connecter à la base de données
	private void getconnection() throws SQLException
	{
		try
		{
			  Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e)
	  	{
			e.printStackTrace();
			System.out.println("Ca a planté");
		}
		String DBurl = "jdbc:mysql://127.0.0.1/banque?";
		conn = DriverManager.getConnection(DBurl, "root", "");
	}

}
