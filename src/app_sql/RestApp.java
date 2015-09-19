package restaurante_sql;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import conexionMySQL.MySQL;
import restaurante_sql.Select;
import restaurante_sql.Insert;
import restaurante_sql.Delete;
import restaurante_sql.Update;
import restaurante_sql.JSONNoticias;

public class RestApp {
	
	static Scanner teclado = new Scanner(System.in);
	
	// Aqui comienza la conexion con la database practica
	static Connection conexion = MySQL.Conexion(
			"jdbc:mysql://localhost/practica", "fx.vera", "6894FxVc-");
	static int registrosAfectados = 0;
	static int elegir;
	static int menuPrincipal() throws IOException {
		int resul;
		
		 /*
		 * Se debera seleccionar con un caracter numerico entre las 7 opciones
		 * disponibles, cada opcion te introducira en un submenu (se vera
		 * posteriormente), si quieres finalizar las operaciones con el menu
		 * debes marcar 0(cero)
		 */
		System.out.println();
		System.out.println(" Seleccione una opcion:");
		System.out.println(" ------------------------------- ");
		System.out.println("    1.-  Gestión de 'El Restaurante'. ");
		System.out.println("    2.-  Gestión de 'Cómo llegar'. ");
		System.out.println("    3.-  Gestión de 'Noticias'. ");
		System.out.println("    4.-  Gestión de 'Clientes'. ");
		System.out.println("    5.-  Listado de Noticias. ");
		System.out.println("    6.-  Detalle de noticias. ");
		System.out.println("    7.-  Ranking de noticias. ");
		System.out.println();
		System.out.println("    0.-  Terminar. ");
		System.out.println(" --------------------------------- ");
		resul=teclado.nextInt();
		// si el usuario por error marca una opcion distinta a las ofertadas, se
		// devuelve un mensaje de error
		if (resul != 0 && resul != 1 && resul != 2 && resul != 3
				&& resul != 4 && resul != 5 && resul != 6 && resul != 7)
			System.out.println(" Por favor selecciones una opción correcta");
		return resul;

	}

	/*
	 * en este submenu estan las opciones de gestion de restaurante, para salir
	 * y volver al menu principal se marca 0
	 */
	static int RestMenu() throws IOException {
		
		int resul;
		
		System.out.println();
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Visualización de un Restaurante.");
		System.out.println("    2.-  Inserción de un Restaurante.");
		System.out.println("    3.-  Modificación de un Restaurante ");
		System.out.println("    4.-  Borrado de un Restaurante");
		System.out.println();
		System.out.println("    0.-  Salir.");
		
		resul = teclado.nextInt();
		if (resul != 0 && resul != 1 && resul != 2 && resul != 3
				&& resul != 4)
			System.out.println(" Por favor selecciones una opción correcta");
		return resul;
	}

	/*
	 * en este submenu estan las opciones de gestion de como llegar, para salir
	 * y volver al menu principal se marca 0
	 */
	static int LlegarMenu() throws IOException {
		
		int resul;
		System.out.println();
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Visualización de ruta propuesta.");
		System.out.println("    2.-  Inserción de un ruta.");
		System.out.println("    3.-  Modificación de ruta ");
		System.out.println("    4.-  Borrado de un ruta");
		System.out.println();
		System.out.println("    0.-  Salir.");
	
		resul = teclado.nextInt();
		if (resul != 0 && resul != 1 && resul != 2 && resul != 3
				&& resul != 4)
			System.out.println(" Por favor selecciones una opción correcta");
		return resul;
	}

	/*
	 * en este submenu estan las opciones de gestion de noticias, para salir y
	 * volver al menu principal se marca 0(cero)
	 */

	static int NoticiasMenu() throws IOException {
		
		int resul;
		System.out.println();
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Visualización de noticia.");
		System.out.println("    2.-  Inserción de un noticia.");
		System.out.println("    3.-  Modificación de noticia. ");
		System.out.println("    4.-  Borrado de un noticia.");
		System.out.println();
		System.out.println("    0.-  Salir. ");

		resul = teclado.nextInt();
		if (resul != 0 && resul != 1 && resul != 2 && resul != 3
				&& resul != 4)
			System.out.println(" Por favor selecciones una opción correcta");

		return resul;
	}

	/*
	 * en este submenu estan las opciones de gestion de clientes, para salir y
	 * volver al menu principal se marca 0
	 */
	static int ClientesMenu() throws IOException {

		int resul;
		System.out.println();
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Visualización de cliente.");
		System.out.println("    2.-  Inserción de un cliente.");
		System.out.println("    3.-  Modificación de cliente.");
		System.out.println("    4.-  Borrado de un cliente.");
		System.out.println();
		System.out.println("    0.-  Salir. ");

		resul = teclado.nextInt();
		if (resul != 0 && resul != 1 && resul != 2 && resul != 3
				&& resul != 4)
			System.out.println(" Por favor selecciones una opción correcta");
		return resul;
	}

	/*
	 * llamadas a las funciones anteriores,
	 * switch para gestionar cada opcion del menu, en cada "case" se ve
	 * claramente el menu que gestiona (si hay dudas, ver lo que imprime por
	 * pantalla en cada caso).
	 */

	public static void main(String[] args) throws IOException, SQLException {

		int resul;
		int car;

		/*
		 * del case:'2' al case '4' se ha optado por un do{}while() para que el
		 * usuario gestione lo que necesite de cada submenu, y cuando termine
		 * pueda cambiar a otro, sin tener que entrar otra vez al menu que desea
		 * cada vez que termine de añadir, modificar, consultar, o borrar algo.
		 */

		do {
			resul = menuPrincipal();

			switch (resul) {
			case 1: {

				System.out.println("1.-  Gestión de 'El Restaurante'. ");
				do {
					car = RestMenu();
					switch (car) {
					case 1:
						Select.SelectR();
						RestMenu();
						break;
					case 2:
						Insert.InsertR();
						RestMenu();
						break;
					case 3:
						Update.UpdateR();
						RestMenu();
						break;
					case 4:
						Delete.DeleteR();
						RestMenu();
						break;
					}
				} while (car != 0);
			}

				break;
			case 2: {

				System.out.println("2.-  Gestión de 'Como llegar'. ");

				do {
					car = LlegarMenu();
					switch (car) {
					case 1:
						Select.SelectL();
						break;
					case 2:
						Insert.InsertL();
						break;

					case 3:
						Update.UpdateL();

						break;

					case 4:
						Delete.DeleteL();
						break;
					}

				} while (car != 0);
			}

				break;
			case 3: {
				System.out.println("3.-  Gestión de 'Noticias'. ");
				do {
					car = NoticiasMenu();
					switch (car) {
					case 1:
						Select.SelectN();
						break;
					case 2:
						Insert.InsertN();
						break;

					case 3:
						Update.UpdateN();
						break;

					case 4:
						Delete.DeleteN();
						break;
					}
				} while (car != 0);

			}

				break;
			case 4: {
				System.out.println("4.-  Gestión de 'Clientes'. ");
				do {
					car = ClientesMenu();
					switch (car) {
					case 1:
						Select.SelectC();
						break;
					case 2:
						Insert.InsertC();
						break;

					case 3:
						Update.UpdateC();
						break;

					case 4:
						Delete.DeleteC();
						break;
					}
				} while (car != 0);
			}
				break;
			case 5: {
				System.out.println("5.-  Listado de 'Noticias'. ");
				System.out
						.println("Este es un listado de las noticias.");
				JSONNoticias.ListaN();

			}
				break;

			case 6: {
				System.out.println("6.-  Detalle de 'Noticias'. ");
				System.out
						.println("Se muestra los DETALLES de la noticia que usted desee ver.");

				JSONNoticias.DetalleN();

			}
				break;

			case 7: {
				System.out.println("6.-  Ranking de 'Noticias'. ");
				System.out
						.println("El RANKING de las noticias mas visitadas.");

				JSONNoticias.RankingN();
			}
			}

		} while (resul != 0);
		// cerrar conexion con la database
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}