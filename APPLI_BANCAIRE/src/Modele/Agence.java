package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Agence 
{
	private Connection conn = null; 
   
	
	private int codeAgence;
	private String adresseAgence;
	private String CPAgence;
	private String villeAgence;
	private int codeDirecteur;
	private Vector lesEmploye;
	private Vector lesClients;
	
	public Agence(int code, String ville, int codeDir)
	{
		this.codeAgence = code;
		this.codeDirecteur = codeDir;
		lesClients = new Vector();
		lesEmploye = new Vector();
		this.villeAgence = ville;
	}
	
	public void récupérerClients()
	{
		lesClients = new  Vector();
		//on se connecte à la BD
		try 
		{
			getconnection();
					 
			Statement stmt = conn.createStatement(); 
			ResultSet resSect = stmt.executeQuery("CALL getLesClientsAgence("+ this.codeAgence+")");
			
			while (resSect.next())
			{
				Client cli;
				cli = new Client(resSect.getInt("codeClient"),resSect.getString("nomClient"),resSect.getString("PNomClient"), resSect.getString("AdresseClient"),resSect.getString("codePostalClient"),resSect.getString("VilleClient"));
				this.lesClients.add(cli);
			}
			resSect.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}
	}
	public Vector getClients()
	{
		return this.lesClients;
	}
	public int getCode()
	{
		return this.codeAgence;
	}
	
	public String getVille()
	{
		return this.villeAgence;
	}
	public String getAdresseAgence()
	{
		return this.adresseAgence;
	}
	public String getCP()
	{
		return this.CPAgence;
	}
	
	public String getNomDirecteur()
	{
		String nom;
		nom = new String();
		try 
		{
			getconnection();
			
					 
			Statement stmt = conn.createStatement(); 
			ResultSet resSect = stmt.executeQuery("CALL getNomDirecteur("+ this.codeDirecteur+")");
			
			while (resSect.next())
			{
				nom = resSect.getString("nomEmploye");
				
			}
			resSect.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return nom;
	}
	
	public Vector getNomPnomClients()
	{
		Vector PnomNom = new Vector();
		try 
		{
			getconnection();
					 
			Statement stmt = conn.createStatement(); 
			ResultSet resSect = stmt.executeQuery("CALL getLesClientsAgence("+ this.codeAgence+")");
			
			while (resSect.next())
			{
				String nompn = resSect.getInt("codeClient") +" "+resSect.getString("nomClient")+" "+resSect.getString("PNomClient");
				PnomNom.add(nompn);
			}
			resSect.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println(this.codeAgence);
		for (int i = 0; i< PnomNom.size();i++)
		{
			System.out.println(PnomNom.get(i).toString());
		}
		return PnomNom;
	}
	
	
	public void récupérerEmploye()
	{
		lesEmploye = new  Vector();
		//on se connecte à la BD
		try 
		{
			getconnection();			
					 
			Statement stmt = conn.createStatement(); 
			ResultSet resSect = stmt.executeQuery("CALL getLesEmployeAgence("+ this.codeAgence+")");
			
			while (resSect.next())
			{
				Employe emp;
				emp = new Employe(resSect.getInt("codeEmploye"), resSect.getString("nomEmploye"), resSect.getString("PrenomEmploye"), resSect.getString("AdresseEmploye"), resSect.getString("CPEmploye"), resSect.getString("VilleEmploye"), resSect.getInt("codeCategorie"));
				lesEmploye.add(emp);
			}
			resSect.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}
	}
	
	public Vector getNomPnomEmploye()
	{
		Vector PnomNom = new Vector();
		try 
		{
			getconnection();				 
			Statement stmt = conn.createStatement(); 
			ResultSet resSect = stmt.executeQuery("CALL getLesEmployeAgence("+ this.codeAgence+")");
			
			while (resSect.next())
			{
				String nompn = resSect.getInt("codeEmploye") +" "+resSect.getString("nomEmploye")+" "+resSect.getString("PrenomEmploye");
				PnomNom.add(nompn);
			}
			resSect.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return PnomNom;
	} 
	
	
	public void ajoutClient(int code, String nom, String prenom, String adress, String CP, String ville)
	{
		try 
		{
			String insert;
			getconnection();
			Statement stmt = conn.createStatement(); 
			insert = new String("CALL addClient("+
						code+", '"+ nom+"', '"+prenom+"', '"+ adress+"', '"+
						CP+ "', '"+ ville+"',"+ this.codeAgence+")");
			System.out.println(insert);
			stmt.execute(insert);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}
	}
	public void ajoutParticulier(int code, String civilite)
	{
		try 
		{
			String insert;
			getconnection();
			Statement stmt = conn.createStatement(); 
			insert = new String("CALL addClientParticulier("+code+", '"+civilite+"' )");
			System.out.println(insert);
			stmt.execute(insert);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}
	}
	public void ajoutSociete(int code, String societe)
	{
		try
		{
			String insert;
			getconnection();
			Statement stmt = conn.createStatement(); 
			insert = new String(" CALL addClientSociete("+
						code+", '"+ societe+"')");
			System.out.println(insert);
			stmt.execute(insert);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}
	}
	public void ajoutEmploye(int code, String nom, String prenom, String adress, String CP, String ville, int codeCategorie)
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
		try 
		{
			if(codeCategorie == 5)
			{
				modifierCategDirecteur(codeAgence);
			}
			String insert;
			String DBurl = "jdbc:mysql://127.0.0.1/banque?";
			conn = DriverManager.getConnection(DBurl, "root", "");
			Statement stmt = conn.createStatement(); 
			insert = new String("CALL addEmploye("+
						code+", '"+ nom+"', '"+prenom+"', '"+ adress+"', '"+
						CP+ "', '"+ ville+"',"+ codeCategorie+", "+ this.codeAgence+")");
			System.out.println(insert);
			stmt.execute(insert);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
		}
	}
	
	public void modifierCategDirecteur(int codeAgence)
	{
		int codeDir = 0;
		try 
		{
			getconnection();
			Statement stmt = conn.createStatement();
			ResultSet resSect = stmt.executeQuery("CALL getDirecteur("+codeAgence+")");
			while (resSect.next())
			{
				codeDir = (resSect.getInt("codeEmploye"));
			}
			resSect.close();
			stmt.execute("CALL ModifEmploye("+codeDir+", 1, "+codeAgence+ ")");
			System.out.println("CALL ModifEmploye("+codeDir+", 1, "+codeAgence+ ")");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
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