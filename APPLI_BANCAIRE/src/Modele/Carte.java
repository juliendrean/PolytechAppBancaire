package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Carte
{
  	private Connection conn = null;

	private int codeClient;
	private String numCarte;
	private String dateExpiration ;
	private String typeCarte ;

	public Carte(int codeCli, String num, String dateExp, String type)
	{
		this.codeClient = codeCli;
		this.numCarte = num;
		this.dateExpiration = dateExp ;
		this.typeCarte = type ;

	}
	public String getTypeCarte() {
		return typeCarte;
	}
	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}
	public String getNumCarte()
	{
		return this.numCarte;
	}
	public String getDateExpiration()
	{
		return this.dateExpiration;
	}
	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}


	public void SupprimerCarte()
	{
		String update;
		try
		{
			getconnection();
			Statement stmt = conn.createStatement();
			update = new String("CALL supprimeUneCarte"+"("+codeClient +", \""+numCarte +"\")");
			System.out.println(update);
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