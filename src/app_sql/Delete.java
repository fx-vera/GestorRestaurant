//coment
package restaurante_sql;

import java.io.IOException;
import java.util.Scanner;

import conexionMySQL.MySQL;
import restaurante_sql.RestApp;

public class Delete {
	// no puedes eliminar localizaciones, noticias que pertenezcan al
	// restaurante, para ello se modifican;
	static Scanner teclado = new Scanner(System.in);

	public static void DeleteR() throws IOException {
		int cd_restaurante;
		System.out
				.println("Introduzca el CD_restaurante que quiera eliminar: ");
		cd_restaurante = teclado.nextInt();
		String DelRestaurante = "delete from  practica.Restaurante where CD_restaurante= '"
				+ cd_restaurante + "'";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				DelRestaurante);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se ha podido eliminar");
		else
			System.out.println("Eliminacion correcta");
	}

	public static void DeleteL() throws IOException {
		int cd_posicion;
		System.out
				.println("Introduzca la posicion del restaurante que quiera eliminar: ");
		cd_posicion = teclado.nextInt();

		String DelRestaurante = "delete from practica.localizacion where CD_posicion= '"
				+ cd_posicion + "'";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				DelRestaurante);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se ha podido eliminar");
		else
			System.out.println("Eliminacion correcta");
	}

	public static void DeleteN() throws IOException {
		int cd_noticia;
		System.out
				.println("Introduzca el codigo de la noticia que quiera eliminar: ");
		cd_noticia = teclado.nextInt();
		String DelRestaurante = "delete from  practica.noticias where CD_noticia= '"
				+ cd_noticia + "'";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				DelRestaurante);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se han eliminado Restaurantes");
		else
			System.out.println("Eliminacion correcta");

	}

	// hay que hacer el atributo de booleano;
	public static void DeleteC() throws IOException {
		String cd_dni;
		System.out.println("Introduzca el DNI de la persona que quiera eliminar: ");
		cd_dni = teclado.next();
		String DelRestaurante = "UPDATE practica.clientes set TL_aceptacion=0, TL_Activo = 0  WHERE cd_dni = '" +cd_dni+"' ";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,DelRestaurante);
		if (RestApp.registrosAfectados == 0)
			System.out.println("No se ha eliminado el Cliente porque no existe.");
		else
			System.out.println("Cliente eliminado.");

	}

	
	
}