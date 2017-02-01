package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Compte 
{
  	private Connection conn = null;
	
	private int codeClient;
	private int numCompte;
	
	public Compte(int codeCli, int num)
	{
		this.codeClient = codeCli;
		this.numCompte = num;
	}
	public int getNumCompte()
	{
		return this.numCompte;
	}
	public void ajoutArgent(String montant)
	{
		try 
		{
			String update;
			getconnection();
			Statement stmt = conn.createStatement(); 
			update = new String(" CALL depotCompte"+"("+montant +", "+codeClient +", "+numCompte +")");
			System.out.println(update);
			stmt.execute(update);
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void retraitargent(String montant)
	{
		String update;
		try 
		{
			getconnection();
			Statement stmt = conn.createStatement(); 
			update = new String("CALL retraitCompte"+"("+montant +", "+codeClient +", "+numCompte +")");
			System.out.println(update);
			stmt.execute(update);
			conn.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void SupprimerCompte()
	{
		String update;
		try 
		{
			getconnection();
			Statement stmt = conn.createStatement(); 
			update = new String("CALL supprimeUnCompte"+"("+codeClient +", "+numCompte +")");
			stmt.execute(update);
			conn.close();
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
