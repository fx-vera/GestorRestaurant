package restaurante_sql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conexionMySQL.MySQL;
import restaurante_sql.RestApp;
/*
 * clase select, se recorreran las tablas mostrando los datos que nos interesan
 * en visualizacion
 */
public class Select {
	
	static Scanner teclado = new Scanner(System.in);
	//static ResultSet rs0;
	//static ResultSet rs1;
	
	// select para el Restaurante
	 static void SelectR() throws IOException{
		// Select

		ResultSet rs = MySQL.ejecutarSelect(RestApp.conexion,
				"select * from Restaurante");

		ResultSet rs2 = MySQL
				.ejecutarSelect(
						RestApp.conexion,
						"select * from localizacion"
								+ " inner join restaurante on localizacion.cd_posicion = restaurante.localizacion_cd_posicion");

		// Se recorre el ResultSet, mostrando por pantalla los resultados.

		System.out
				.println("cd_restaurante - ds_descripcion - it_fotos - ds_nombre - carta_cd_carta - ds_direccion ");

		try {
			while (rs.next() && rs2.next()) {
				System.out.println("	" + rs.getString("cd_restaurante")
						+ "   -   " + rs.getString("DS_descripcion") + " - "
						+ rs.getString("IT_fotos") + " - "
						+ rs.getString("DS_nombre") + " - "
						+ rs.getString("carta_cd_carta") + " - "
						+ rs2.getString("ds_direccion"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	 static void SelectL() throws IOException{

		// Select para Localizacion
		ResultSet rs = MySQL.ejecutarSelect(RestApp.conexion,
				"select * from Localizacion");

		// por pantalla se muestra en columnas lso atributos, para que el
		// cliente interprete los datos que se le muestran
		System.out.println("CD_posicion - DS_direccion - IT_mapa");

		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		try {
			while (rs.next()) {
				System.out.println("	" + rs.getInt("CD_posicion") + " - "
						+ rs.getString("DS_direccion") + " - "
						+ rs.getString("IT_mapa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	 static void SelectN() throws IOException{

		// Select para Noticias
		ResultSet rs = MySQL.ejecutarSelect(RestApp.conexion,
				"select * from Noticias");

		// por pantalla se muestra en columnas lso atributos, para que el
		// cliente interprete los datos que se le muestran
		System.out.println("cd_noticia - novedades_cd_novedad");
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		try {
			while (rs.next()) {

				System.out
						.println(" " + rs.getInt(1) + " - " + rs.getString(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	 static void SelectC() throws IOException, SQLException{

		// Select para Clientes

		System.out
				.println("Si desea ver una lista de todos los clientes marque 1.\n\nSi desea ver un cliente en concreto "
						+ "de la lista de clientes, marque 2.");
		int cliente=teclado.nextInt();
		if(cliente==1){
		 ResultSet rs = MySQL.ejecutarSelect(RestApp.conexion,
				"select * from clientes order by tl_aceptacion desc");

		// por pantalla se muestra en columnas lso atributos, para que el
		// usuario interprete los datos que se le muestran
		
			System.out
			.println("\ncd_dni - ds_nombre - ds_apellidos - ds_correo - fc_nacimiento - nm_contadorvisitas "
					+ "- ds_dirrenvio - ds_movil - ds_telefono fijo - tl_aceptacion - consumo_cd_habito - tl_activo");
		
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		try {
			while (rs.next()) {
				
				int activo=rs.getInt("tl_activo");
				
					if (activo == 0){
						
						System.out.println("El cliente con DNI "+ rs.getInt("cd_dni")+" esta dado de baja.");
						//si el cliente esta activo (tl=1) se muestra en casi contrario significa que se ha hecho un borrado logico;
					} else {
						System.out.println(+rs.getInt(1) + " - "
								+ rs.getString(2) + " - " + rs.getString(3)
								+ " - " + rs.getString(4) + " - "
								+ rs.getString(5) + " - " + rs.getInt(6)
								+ " - " + rs.getString(7) + " - "
								+ rs.getString(8) + " - " + rs.getString(9)
								+ " - " + rs.getString(10) + " - "
								+ rs.getInt(11));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		}

		else if (cliente == 2) {
			
			System.out
					.println("Marque el cd_dni del cliente que quiera ver. Tenga encuenta que se contara como una visita al restaurante de tal cliente.");
			int cd_dni = teclado.nextInt();

			ResultSet rs = MySQL.ejecutarSelect(RestApp.conexion,
					"select * from clientes where cd_dni = '" + cd_dni + "' "
							+ " order by cd_dni;");

			System.out
					.println("cd_dni - ds_nombre - ds_apellidos - ds_correo - fc_nacimiento - nm_contadorvisitas "
							+ "- ds_dirrenvio - ds_movil - ds_telefono fijo - tl_aceptacion - consumo_cd_habito - tl_activo");
			// Se recorre el ResultSet, mostrando por pantalla los resultados.
			try {

				while (rs.next()) {
					
					int activo=rs.getInt("tl_activo");
					//si el cliente esta activo (tl=1) se muestra en casi contrario significa que se ha hecho un borrado logico;
					if (activo == 0){
						
						System.out.println("Este cliente esta dado de baja, vaya al listado de clientes para ver los disponbles.");

					}
					else{
						String numVisitas = "update clientes set clientes.nm_contadorvisitas=clientes.nm_contadorvisitas+1 where cd_dni='"
								+ cd_dni + "'";

						RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
								numVisitas);

					System.out.println(+rs.getInt(1) + " - " + rs.getString(2)
							+ " - " + rs.getString(3) + " - " + rs.getString(4)
							+ " - " + rs.getString(5) + " - " + rs.getInt(6)
							+ " - " + rs.getString(7) + " - " + rs.getString(8)
							+ " - " + rs.getString(9) + " - " + rs.getString(10)
							+ " - " + rs.getInt(11));
										
		}
				}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		}	
	}	
}