package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

public class Client
{
  	private Connection conn = null;


  	private int codeClient;
	private String nomClient;
	private String prenomClient;
	private String adressClient;
	private String CPClient;
	private String VilleClient;
	private String particularite;

	public Client(int code, String nom, String prenom, String adress, String CP, String ville)
	{
		this.codeClient = code;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.adressClient = adress;
		this.CPClient = CP;
		this.VilleClient = ville;
		this.particularite = "";
	}
	public Client(int code)
	{
		this.codeClient = code;
	}
	public int getCodeClient()
	{
		return this.codeClient;
	}
	public String getNomClient()
	{
		return this.nomClient;
	}
	public String getPnomClients()
	{
		return this.prenomClient;
	}
	public String getAdresseClient()
	{
		return this.adressClient;
	}
	public String getCodePostalClient()
	{
		return this.CPClient;
	}
	public String getVilleClient()
	{
		return this.VilleClient;
	}

	public String getParticularite()
	{
		return this.particularite;
	}
	public void setParticularite(String part)
	{
		this.particularite = part;
	}

	public Vector getlescomptesclient()
	{
		Vector compte = new Vector();
		System.out.println(this.codeClient);
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesComptesClient("+ this.codeClient+")");

			while (resSect.next())
			{
				String unCompte = "Num : "+resSect.getInt("numCompte")+" "+ "Type : "+this.getUnTypeComptes(resSect.getInt("typCompte"))+  "   Montant : " + resSect.getFloat("montantCompte")+" €";
				compte.add(unCompte);
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return compte;
	}
	public Vector getlescartesclient()
	{
		Vector carte = new Vector();
		System.out.println(this.codeClient);
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesCartesClient("+ this.codeClient+")");

			while (resSect.next())
			{
				String uneCarte = "Num : "+resSect.getString("numCarte")+" "+ "Type : "+this.getUnTypeCarte(resSect.getString("typCarte"))+  "   Date d'expiration : " + resSect.getString("dateExpi");
				carte.add(uneCarte);
			}
			resSect.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return carte;
	}

	public int countComptes()
	{
		int nbComptes = 0;
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesComptesClient("+ this.codeClient+")");

			resSect.last();
			nbComptes = resSect.getInt("numCompte");
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return nbComptes;
	}
	public int countCartes()
	{
		int nbCartes = 0;
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesCartesClient("+ this.codeClient+")");

			resSect.last();
			nbCartes = resSect.getInt("numCarte");
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return nbCartes;
	}

	public void ajoutCompte(String montant , int typeCompte)
	{
		System.out.println("type de compte : "+ typeCompte);
		try
		{
			String insert;
			getconnection();
			Statement stmt = conn.createStatement();

			int nbComptes = this.countComptes();
			int numcompte;
			if(nbComptes == 0)
			{
				 numcompte = 1000001;
			}
			else
			{
				numcompte = nbComptes+1;
			}
			insert = new String("CALL insertCompte("+numcompte+", "+
					             this.codeClient+", "+typeCompte+", "+montant+")");
			System.out.println(insert);
			stmt.execute(insert);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void ajoutCarte(String dateExpiration , int typeCarte, String numCarte)
	{
		System.out.println("type de carte : "+ typeCarte);
		try
		{
			String insert;
			getconnection();
			Statement stmt = conn.createStatement();
	
			insert = new String("CALL insertCarte("+numCarte+", "+
					             this.codeClient+", "+typeCarte+", "+dateExpiration+")");
			System.out.println(insert);
			stmt.execute(insert);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Vector getTypeComptes()
	{
		Vector typ = new Vector();
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesTypesComptes()");

			while (resSect.next())
			{
				String unType = resSect.getString("libelleType");
				typ.add(unType);
			}
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return typ;
	}
	public Vector getTypeCartes()
	{
		Vector type = new Vector();
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getLesTypesCartes()");

			while (resSect.next())
			{
				String unType = resSect.getString("libelleType");
				type.add(unType);
			}
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return type;
	}

	public String getUnTypeComptes(int code)
	{
		String typ = new String();
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnTypeComptes("+ code +")");

			while (resSect.next())
			{
				typ = resSect.getString("libelleType");
			}
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return typ;
	}
	public String getUnTypeCarte(String type)
	{
		String typ = new String();
		//on se connecte à la BD
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnTypeCartes("+ type+")");

			while (resSect.next())
			{
				typ = resSect.getString("libelleType");
			}
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return typ;
	}

	public Compte getCompte(String compte)
	{
		Compte cmpt = null;
		String num;
		StringTokenizer str = new StringTokenizer(compte, " ");
		str.nextElement();
		str.nextElement();
		num = str.nextElement().toString();

		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUnCompteClient("+this.codeClient+", "+num+")");
			while (resSect.next())
			{
				cmpt = new Compte(resSect.getInt("codeCli"), resSect.getInt("numCompte"));
			}
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return cmpt;
	}
	public Carte getCarte(String carte)
	{
		Carte crt = null;
		String num;
		StringTokenizer str = new StringTokenizer(carte, " ");
		str.nextElement();
		str.nextElement();
		num = str.nextElement().toString();

		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getUneCarteClient("+this.codeClient+", "+num+")");
			while (resSect.next())
			{
				crt = new Carte(resSect.getInt("codeCli"), resSect.getString(""), resSect.getString(""), resSect.getString(""));
			}
			resSect.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return crt;
	}

	private void getconnection()
	throws SQLException
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
