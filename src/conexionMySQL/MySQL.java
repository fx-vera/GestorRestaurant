
package conexionMySQL;
import java.sql.*;
/*
 *  clase que conecta con MySQL.
 *  JRM. Comentario para test de GIT. 
 */
import java.util.ArrayList;

@SuppressWarnings("unused")
public class MySQL {


    // Obtencion de una conexion
     
    public static Connection Conexion(String servidor, String usuario, String contrasenna) 
    {
    	
    	Connection conexion = null;
        try
        {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            conexion = DriverManager.getConnection (servidor, usuario, contrasenna);  
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		return conexion;
    }

	public static ResultSet ejecutarSelect(Connection conexion, String sentenciaSelect)
	{
		ResultSet rs = null;
		try
		{
		   Statement st = conexion.createStatement();
		   rs = st.executeQuery(sentenciaSelect); 
		}
		catch (Exception e)
		{
		   e.printStackTrace();
		}		
		return rs;
	}

	public static int ejecutarIUD(Connection conexion, String sentenciaIUD)
	{
		int registrosAfectados = 0;
		try
		{
		   Statement st = conexion.createStatement();
		   registrosAfectados = st.executeUpdate(sentenciaIUD);
		}
		
		catch (Exception e)
		{
		   e.printStackTrace();
		}
		return registrosAfectados;
	}

	public static void main(String[] args) 
	{
		
	}
	
} // MySQL
