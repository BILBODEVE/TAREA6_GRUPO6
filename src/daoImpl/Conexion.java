package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
	public static Conexion instancia;
	private Connection connection;

	private Conexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdpersonas","root","root");
			//No me borren esto porfa, comentelo porque sino no me funciona. Gracias.
			//this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/bdPersonas?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","rootpass");
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public static Conexion getConexion()
	{
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion()
	{
		return this.connection;
	}

	public void cerrarConexion()
	{
	    try
	    {
	        if (this.connection != null && !this.connection.isClosed()) {
	            this.connection.close();
	        }
	    }
	    catch (SQLException e)
	    {
	        e.printStackTrace();
	    }
	    finally {
	        instancia = null;
	    }
	}


}
