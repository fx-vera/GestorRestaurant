package restaurante_sql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conexionMySQL.MySQL;
import restaurante_sql.RestApp;

/*Insert para añadir informacion*/
public class Insert {
	static Scanner teclado = new Scanner(System.in);

	public static void InsertR() throws IOException, SQLException { // este void
																	// para
																	// INSERT
																	// Restaurante

		String ds_descripcion, it_fotos, ds_nombre;
		int cd_restaurante, localizacion_cd_posicion, carta_cd_carta, promociones_cd_promocion, novedades_cd_novedad;

		// pedimos al usuario que ingrese la informacion que desea añadir
		System.out.println("Introduzca el CD_restaurante que quiera añadir: ");
		cd_restaurante = teclado.nextInt();
		System.out.println("Introduzca un DS_descripcion: ");
		teclado.next();
		ds_descripcion = teclado.nextLine();
		System.out.println("Introduzca un it_fotos: ");
		it_fotos = teclado.nextLine();
		System.out.println("Introduzca un DS_nombre: ");
		ds_nombre = teclado.nextLine();
		System.out.println("Introduzca un localizacion_cd_posicion: ");
		localizacion_cd_posicion = teclado.nextInt();
		System.out.println("Introduzca un promociones_cd_promocion: ");
		promociones_cd_promocion = teclado.nextInt();
		System.out.println("Introduzca un carta_cd_carta: ");
		carta_cd_carta = teclado.nextInt();
		System.out.println("Introduzca un novedades_cd_novedad: ");
		novedades_cd_novedad = teclado.nextInt();

		// Aqui se aplica al string AddREstaurante los datos introducidos
		// previamente
		String AddRestaurante = "insert into Restaurante values ('"
				+ cd_restaurante + "', '" + ds_descripcion + "', '" + it_fotos
				+ "', '" + ds_nombre + "', '" + localizacion_cd_posicion
				+ "' , '" + promociones_cd_promocion + "','" + carta_cd_carta
				+ "', '" + novedades_cd_novedad + "')";

		// INSERT
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				AddRestaurante);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se han insertado Restaurantes");
		else
			System.out.println("Insercion correcta");
	}

	public static void InsertL() throws IOException, SQLException { // este void
																	// para
																	// INSERT
																	// Localizacion
		int cd_posicion;
		String ds_direccion, it_mapa;

		// pedimos al usuario que ingrese la informacion que desea añadir
		System.out.println("Introduzca una posicion: ");
		cd_posicion = teclado.nextInt();

		System.out.println("Introduzca un direccion: ");
		teclado.next();
		ds_direccion = teclado.nextLine();

		System.out.println("Introduzca un mapa: ");
		it_mapa = teclado.nextLine();

		// Aqui se aplica al string AddREstaurante los datos introducidos
		// previamente
		String AddLocalizacion = "insert into Localizacion  values ('"
				+ cd_posicion + "'," + "'" + ds_direccion + "','" + it_mapa
				+ "')";

		// INSERT
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				AddLocalizacion);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se han insertado direcciones");
		else
			System.out.println("Insercion correcta");

	}

	public static void InsertNovedades() throws IOException { // este void para
																// INSERT
		// Noticia

		System.out
				.println("Primero insertará 'novedades' que luego derivarán a 'noticias' o a 'eventos' ");
		System.out
				.println("Introduzca una primary key para novedad cd_novedad:");
		int cd_novedad = teclado.nextInt();

		System.out
				.println("Inicializar el cd_contador a cero, ya que se empieza con cero visitas en una noticia o evento.");
		int cd_contador = teclado.nextInt();

		System.out.println("Introduzca un ds_titulo:");
		teclado.next();
		String ds_titulo = teclado.nextLine();

		System.out
				.println("Introduzca una ds_entradilla (será una breve descripción de la novedad):");
		String ds_entradilla = teclado.nextLine();

		System.out
				.println("Introduzca un ds_estado (se indica si la novedad está activa, espera, o desactivada:");
		String ds_estado = teclado.nextLine();

		System.out.println("Introduzca una fecha de vigencia: fc_vigencia: ");
		String fc_vigencia = teclado.nextLine();

		System.out
				.println("Introduzca una fecha de publicación fc_publicación: ");
		String fc_publicacion = teclado.nextLine();

		System.out
				.println("Introduzca la direccion donde se encuentra la imagen thumb en el disco duro, it_imagethumb:  ");
		String it_imagethumb = teclado.nextLine();

		System.out
				.println("Introduzca la direccion donde se encuentra la imagen detallada en el disco duro, it_imagendetalle:  ");
		String it_imagendetalle = teclado.nextLine();

		System.out.println("Introduzca un enlace de la novedad tl_enlace:  ");
		String tl_enlace = teclado.nextLine();

		String AddNovedades = "insert into novedades values( '" + cd_novedad
				+ "', '" + cd_contador + "','" + ds_titulo + "','"
				+ ds_entradilla + "'," + "'" + ds_estado + "','" + fc_vigencia
				+ "', '" + fc_publicacion + "','" + it_imagethumb + "','"
				+ it_imagendetalle + "'," + "'" + tl_enlace + "')";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				AddNovedades);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se han insertado novedades");
		else
			System.out.println("Insercion correcta.");
	}

	public static void InsertN() throws IOException {

		// se muestran las novedades disponibles para que el usuario las inserte
		// en noticias, ya se trata de supertipos y subtipos.
		ResultSet rs = MySQL.ejecutarSelect(RestApp.conexion,
				"select * from Novedades");
		System.out.println("Tiene disponibles las siguientes novedades: ");
		System.out.println("cd_novedad - ds_titulo");
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		try {
			while (rs.next()) {

				System.out.println(" " + rs.getInt("cd_novedad") + " - "
						+ rs.getString("ds_titulo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * aqui se decide si insertar novedad nueva para luego meterla en
		 * noticia, o directamente insertar noticias,
		 */
		System.out
				.println("\nDe las novedades anteriores inserte las noticias que desee, si no existen novedades o desea otra, puede insertar una nueva.");
		System.out
				.println("\nPulse 1 si desea insertar novedades nuevas para derivarlas a noticias.\nPulse 2 si desea insertar noticias de las ya existentes (asegurese que cd_novedad=cd_noticia");

		int insertarN = teclado.nextInt();

		if (insertarN == 1)
			InsertNovedades();

		else if (insertarN == 2) {

			System.out.println("Introduzca un CD_noticia: ");
			int cd_noticia = teclado.nextInt();
			System.out.println("Introduzca un novedades_cd_novedad: ");
			int novedades_cd_novedad = teclado.nextInt();
			// Aqui se aplica al string AddNoticia, los datos introducidos
			// previamente.
			String AddNoticia = "insert into Noticias values ( '" + cd_noticia
					+ "', '" + novedades_cd_novedad + "')";

			// INSERT
			RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
					AddNoticia);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se han insertado noticias");
			else
				System.out.println("Insercion correcta");
		}

	}

	public static void InsertC() throws IOException, SQLException { // este void
																	// para
																	// INSERT
		String cd_dniN, ds_nombre, ds_apellidos, ds_dircorreo, ds_direnvio, ds_movil, ds_fijo;
		int it_aceptacion;
		int tl_activo;
		String fc_nacimiento;
		int nm_contadorvisitas, consumo_cd_habito;
		// pedimos al usuario que ingrese la informacion que desea añadir
		
		System.out.println("Introduzca un CD_dni: ");
		cd_dniN = teclado.next();
		
		System.out.println("Introduzca un ds_nombre: ");
		teclado.next();
		ds_nombre = teclado.nextLine();

		System.out.println("Introduzca un ds_apellidos: ");
		ds_apellidos = teclado.nextLine();

		System.out.println("Introduzca un ds_dircorreo: ");
		ds_dircorreo = teclado.nextLine();

		System.out.println("Introduzca un fc_nacimiento: ");
		fc_nacimiento = teclado.nextLine();

		System.out
				.println("Introduzca un nm_contadorvisitas: ");
		nm_contadorvisitas = teclado.nextInt();

		System.out.println("Introduzca un ds_direnvio: ");
		teclado.next();
		ds_direnvio = teclado.nextLine();

		System.out.println("Introduzca un ds_movil: ");
		ds_movil = teclado.nextLine();

		System.out.println("Introduzca un ds_fijo: ");
		ds_fijo = teclado.nextLine();

		System.out
				.println("Introduzca un it_aceptacion de publicidad (0 = no acepta, 1 = si acepta): ");
		it_aceptacion = teclado.nextInt();

		System.out
				.println("Introduzca un tl_activo (0 = no activo, 1 = si activo): ");
		tl_activo = teclado.nextInt();

		System.out.println("Introduzca un consumo_cd_habito: ");
		consumo_cd_habito = teclado.nextInt();
		


						String AddCliente = "insert into clientes values ('"
								+ cd_dniN + "', '" + ds_nombre + "', '"
								+ ds_apellidos + "', '" + ds_dircorreo + "', '"
								+ fc_nacimiento + "', '" + nm_contadorvisitas
								+ "', '" + ds_direnvio + "', '" + ds_movil
								+ "', '" + ds_fijo + "', '" + it_aceptacion
								+ "','" + tl_activo + "', '"
								+ consumo_cd_habito + "' )";

						RestApp.registrosAfectados = MySQL.ejecutarIUD(
								RestApp.conexion, AddCliente);
					

					if (RestApp.registrosAfectados == 0)
						System.out.println("No se han insertado CLientes");
					else
						System.out.println("Insercion correcta");

	}
}