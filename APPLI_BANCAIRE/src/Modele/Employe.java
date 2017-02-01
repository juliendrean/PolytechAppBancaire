package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employe
{
  	private Connection conn = null; 
  	
  	
	private int codeEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private String adressEmploye;
	private String CPEmploye;
	private String VilleEmploye;
	private int codeCategorie;
	
	public Employe(int code, String nom, String prenom, String adress, String CP, String ville, int categ)
	{
		this.codeEmploye = code;
		this.nomEmploye = nom;
		this.prenomEmploye = prenom;
		this.adressEmploye = adress;
		this.CPEmploye = CP;
		this.VilleEmploye = ville;
		this.codeCategorie = categ;
	}
	public Employe(int code)
	{
		this.codeEmploye = code;
	}
	public Employe(int code, String prenom, String nom)
	{
		this.codeEmploye = code;
		this.prenomEmploye=prenom;
		this.nomEmploye = nom;
	}
	
	public int getCodeEmploye()
	{
		return this.codeEmploye;
	}
	public String getNomEmploye()
	{
		return this.nomEmploye;
	}
	public String getPnomEmploye()
	{
		return this.prenomEmploye;
	}
	public String getAdresseEmploye()
	{
		return this.adressEmploye;
	}
	public String getCpEmploye()
	{
		return this.CPEmploye;
	}
	public String getVilleEmploye()
	{
		return this.VilleEmploye;
	}
	
	public String getLibelleCategorie()
	{
		String libelleCategorie = "";
		//on se connecte à la BD
		try 
		{
			getconnection();
			Statement stmt = conn.createStatement(); 
			
			ResultSet resSectPart = stmt.executeQuery("SELECT * FROM CATEGORIE WHERE codeCategorie = "+ codeCategorie);
			while (resSectPart.next())
			{
				libelleCategorie = resSectPart.getString("libelleCategorie");
			}
			resSectPart.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return libelleCategorie;
	}
	
	public void modifierEmploye(int codeAgence , int codeCateg)
	{
		try 
		{
			if(codeCateg == 5)
			{
				modifierCategDirecteur(codeAgence);
			}
			getconnection();
			Statement stmt = conn.createStatement();
			System.out.println("CALL ModifEmploye("+this.codeEmploye+", "+codeCateg+ ", "+codeAgence+ ")");
			stmt.execute("CALL ModifEmploye("+this.codeEmploye+", "+codeCateg+ ", "+codeAgence+ ")");	
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
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
