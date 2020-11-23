import java.sql.*;

public class Data
{
	//Erstellen der Datenbank
	public static void main(String[] args)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:Benutzer.db;create=true");
			statement = connection.createStatement();
			//statement.executeUpdate("CREATE TABLE Benutzer(Benutzername VARCHAR(64), Anzeigename VARCHAR(64), Passwort VARCHAR(64))");
			ResultSet rs=statement.executeQuery("SELECT * FROM Benutzer");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error: SQLException: " + e.getMessage());
			}
		}
	}
	
	//Testet, ob eingegebener Login in der Datenbank vorhanden ist
	public boolean correctLoginData(String username, String password)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:Benutzer.db");
			statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM Benutzer WHERE Benutzername='" + username + "'");
			
			while(rs.next())
			{
				if(password.equals(rs.getString(3)))
				{
					return true;
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error: SQLException: " + e.getMessage());
			}
		}
		return false;
	}
	
	//Fügt eingegebenen Werte in die Datenbank ein
	public void registerData(String username, String displayedName, String password)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager.getConnection("jdbc:derby:Benutzer.db");
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Benutzer(Benutzername, Anzeigename, Passwort) VALUES('"+username+"','"+displayedName+"','"+password+"')");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error: SQLException: " + e.getMessage());
			}
		}
	}
}
