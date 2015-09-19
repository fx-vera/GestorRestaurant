package restaurante_sql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conexionMySQL.MySQL;

public class JSONNoticias {
	static Scanner teclado = new Scanner(System.in);

	/*
	 * aqui un usuario podra ver el listado de noticias para posteriormente
	 * visitar una de ellas.
	 */
	public static void ListaN() {

		/*
		 * Select para listado de Noticias, utilizando un inner join 
		 */

		ResultSet rs = MySQL
				.ejecutarSelect(
						RestApp.conexion,

						"select * from novedades inner join noticias"
								+ " on noticias.novedades_cd_novedad = novedades.cd_novedad order by cd_noticia");
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		try {
			System.out.println("{");
			System.out.println("\"Noticias\": ");
			while (rs.next()) {
				System.out.println("      {");
				System.out.println("      \"numero noticia\": " + rs.getString("cd_noticia") +"\n      \"Titulo\": "
						+ rs.getString("ds_titulo")
						+ "\n      \"Numero de visitas\": " + rs.getString("cd_contador"));
				System.out.println("      }");
			}
			System.out.println("}");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * que un usuario visite una noticia significa que accede al punto 6.
	 * Detalle de noticias, por lo tanto se cuenta como visita esta seccion
	 */
	public static void DetalleN() throws IOException {

		/*
		 * Select para Noticias, tambien con inner join porque novedades es
		 * supertipo de noticias
		 */

		
		System.out
				.println("¿Que noticia desea ver detallada? Introduzca la \"cd_noticia\", puede ver"
						+ " los titulos en la seccion 5. Listado de Noticias");
		int cd_noticia=teclado.nextInt();

		int cd_novedad = cd_noticia;
		String numVisitas = "update novedades set novedades.cd_contador=novedades.cd_contador+1 where cd_novedad= '"
				+ cd_novedad + "' ";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion,
				numVisitas);

		ResultSet rs = MySQL
				.ejecutarSelect(
					RestApp.conexion,
						"select * from novedades inner join noticias "
								+ "on noticias.novedades_cd_novedad = novedades.cd_novedad where cd_noticia = '"
								+ cd_noticia + "' "
								+ " order by cd_noticia;");
		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		try {
			System.out.println("{");
			System.out.println("\"Noticia\": ");
			while (rs.next()) {
				System.out.println("      {");
				System.out.println("\"numero noticia\": " + rs.getString("cd_noticia") +"\n      \"Titulo\": "
						+ rs.getString("ds_titulo") +"\n      \"Entradilla\": "
						+ rs.getString("ds_entradilla") +"\n      \"Numero de visitas\": "
						+ rs.getString("cd_contador") +"\n      \"Estado\": "
						+ rs.getString("ds_estado") +"\n      \"Fecha de publicacion\": "
						+ rs.getString("fc_publicacion") +"\n      \"Fecha de vigencia\": "
						+ rs.getString("fc_vigencia") +"\n      \"Imagen thumbnail\": "
						+ rs.getString("it_imagethumb") +"\n      \"Imagen en detalle\": "
						+ rs.getString("it_imagendetalle") +"\n      \"Enlace\": "
						+ rs.getString("tl_enlace"));
				System.out.println("      }");
			}
			System.out.println("}");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void RankingN() {

		// Select para Noticias, tambien con inner join
		ResultSet rs = MySQL
				.ejecutarSelect(
						RestApp.conexion,
						"select * from novedades inner join noticias "
								+ "on noticias.Novedades_CD_novedad=novedades.cd_novedad order by cd_contador desc");

		// Se recorre el ResultSet, mostrando por pantalla los resultados.
		// Para el ranking de Noticias más visitadas unicamente mostramos
		// el contador de visitas (descendentemente) y el titulo de la noticia. 
		try {
			while (rs.next()) {
				System.out.println(rs.getString("cd_contador") + " - "
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
	}
}