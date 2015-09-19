package restaurante_sql;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


import conexionMySQL.MySQL;
import restaurante_sql.RestApp;

public class Update {

	static Scanner teclado = new Scanner(System.in);

	
	// damos opcion a modificar las foreing y los atributos de rest pero no la clave.
	public static void UpdateR() throws IOException {
		String  nuevo;
		int CD_rest, otro;
		char resul;
		do {
			System.out.println("introduce el codigo del restaurante que quieres modificar");
			CD_rest=teclado.nextInt();
			resul = llegarMenuUpdateR();
			switch (resul) {
			case '1': {
				System.out.println(" Introduce la nueva descripcion'. ");
				teclado.next();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.restaurante SET DS_descripcion = '"+ nuevo+ "' WHERE CD_restaurante = '"+ CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
	 	
			case '2': {
				System.out.println(" Introduce la nueva direccion de la foto'. ");
				nuevo = teclado.next();
				String UpDateRestaurante = "UPDATE practica.restaurante SET IT_fotos = '"+ nuevo+ "' WHERE CD_restaurante = '"+ CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;

			}

			case '3': {
				System.out.println(" Introduce el nuevo nombre'. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.restaurante SET DS_nombre = '"+ nuevo + "' WHERE CD_restaurante = '" + CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;

			}
			case '4': {
				System.out.println(" Introduce la localizacion correcta'. ");
				otro = teclado.nextInt();
				String UpDateRestaurante = "UPDATE practica.restaurante SET Localizacion_CD_posicion = '"+ otro+ "' WHERE CD_restaurante = '"+ CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			case '5': {
				System.out.println(" Introduce la promoción correcta'. ");
				otro = teclado.nextInt();
				String UpDateRestaurante = "UPDATE practica.restaurante SET promociones_CD_promocion = '"+ otro+ "' WHERE CD_restaurante = '"+ CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			 
			 
			case '6': {
				System.out.println(" Introduce la carta correcta'. ");
				otro = teclado.nextInt();
				String UpDateRestaurante = "UPDATE practica.restaurante SET carta_CD_carta = '"+ otro+ "' WHERE CD_restaurante = '"+ CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			 
			 
			case '7': {
				System.out.println(" Introduce la novedad correcta'. ");
				otro = teclado.nextInt();
				String UpDateRestaurante = "UPDATE practica.restaurante SET Novedades_CD_novedad = '"+ otro+ "' WHERE CD_restaurante = '"+ CD_rest + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			 
			 

			}

		} while (resul != '0');
		
	}
	
	public static void UpdateC() throws IOException, SQLException{
		String   varchar;
		int DNI,DNIN,otro;
		char resul;
	
		
		do{
			System.out.println(" Introduce el DNI que quieres modificar'. ");
			DNI = teclado.nextInt();
			resul=llegarMenuUpdateC();
			switch(resul)
			{
		case '1': {
			System.out.println(" Por el que quieres modificar'. ");
			DNIN = teclado.nextInt();
			
			String UpDateRestaurante = "UPDATE practica.clientes SET CD_DNI = '"+DNIN+ "' WHERE CD_DNI = '"+ DNI + "'";
			//String UpDaterestaurante_has_clientes = "UPDATE practica.restaurante_has_clientes SET clientes_CD_dni = '"+DNIN+ "' WHERE clientes_CD_dni = '"+ DNI + "'";
			
			RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
				
			break;
		}

		
		case '2': {

		
			System.out.println(" Por el nombre que quieres modificar'. ");
			// necesario poner teclado.nextLine() para limpiar el buffer sino no lee y borra lo anterior. 
			teclado.nextLine();
			varchar = teclado.nextLine();
			String UpDateRestaurante = "UPDATE practica.clientes SET DS_nombre = '"+ varchar + "' WHERE CD_DNI = '" + DNI + "'";
			RestApp.registrosAfectados = MySQL.ejecutarIUD(
					RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
			break; //

		}
		
		
		case '3': {
			System.out.println(" Por los apellidos que quieres modificar'. ");
			teclado.nextLine();
			varchar = teclado.nextLine();
			String UpDateRestaurante = "UPDATE practica.clientes SET DS_apellidos = '"+ varchar + "' WHERE CD_DNI = '" + DNI + "'";
			RestApp.registrosAfectados = MySQL.ejecutarIUD(
					RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
			break;
			
		}
		 
		case '4': {
		System.out.println(" La nueva direccion de correo'. ");
		teclado.nextLine();
		varchar = teclado.nextLine();
		String UpDateRestaurante = "UPDATE practica.clientes SET DS_dircorreo = '"+ varchar + "' WHERE CD_DNI = '" + DNI + "'";
		RestApp.registrosAfectados = MySQL.ejecutarIUD(
				RestApp.conexion, UpDateRestaurante);

		if (RestApp.registrosAfectados == 0)
			System.out.println("No se ha podido modificar");
		else
			System.out.println("Modificacion correcta");
		break;
		
	}
		
		case '5': {
			System.out.println(" Fecha de nacimiento. ");
			teclado.nextLine();
			varchar = teclado.nextLine();
			String UpDateRestaurante = "UPDATE practica.clientes SET FC_nacimiento = '"+ varchar + "' WHERE CD_DNI = '" + DNI + "'";
			RestApp.registrosAfectados = MySQL.ejecutarIUD(
					RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
			break;
			}
		case '6': {
			System.out.println(" La nueva direccion de envio'. ");
			teclado.nextLine();
			varchar = teclado.nextLine();
			String UpDateRestaurante = "UPDATE practica.clientes SET DS_dirrenvio = '"+ varchar + "' WHERE CD_DNI = '" + DNI + "'";
			RestApp.registrosAfectados = MySQL.ejecutarIUD(
					RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
			break;
			}
		case '7': {
			System.out.println(" Por el movil que quieres modificar'. ");
			otro = teclado.nextInt();
			
			String UpDateRestaurante = "UPDATE practica.clientes SET DS_movil = '"+otro+ "' WHERE CD_DNI = '"+ DNI + "'";
			RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
			break;
		}
		case '8': {
			System.out.println(" Por el telefono fijo que quieres modificar'. ");
			otro = teclado.nextInt();
			
			String UpDateRestaurante = "UPDATE practica.clientes SET DS_telefono fijo = '"+otro+ "' WHERE CD_DNI = '"+ DNI + "'";
			RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

			if (RestApp.registrosAfectados == 0)
				System.out.println("No se ha podido modificar");
			else
				System.out.println("Modificacion correcta");
			break;
		}
		
			}
	} while (resul != '0');

	}
	

	public static void UpdateL() throws IOException {
		String nuevo;
		int codigo, codigoN;
		char resul;
		do {
			System.out.println(" Introduce el codigo de la localizacion que quieres modificar'. ");
			codigo=teclado.nextInt();
			resul = llegarMenuUpdateL();
			switch (resul) {
			case '1': {
				
				System.out.println(" Por el nuevo codigo'. ");
				codigoN = teclado.nextInt();
				//String UpdateLocalizacion1="UPDATE practica.restaurante SET Lozalizacion_CD_posicion = '"+ codigoN+ "' WHERE Lozalizacion_CD_posicion = '"+ codigo + "'";
				String UpDateRestaurante = "UPDATE practica.localizacion SET CD_posicion = '"+ codigoN+ "' WHERE CD_posicion = '"+ codigo + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);
				

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se han eliminado Restaurantes");
				else
					System.out.println("Modificacion correcta");
				break;
			}

			case '2': {
				System.out.println(" Introduce la nueva descripcion'. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.localizacion SET DS_direccion = '"+ nuevo+ "' WHERE CD_posicion = '"+ codigo + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;

			}

			case '3': {

			
				System.out.println(" Introduce el nuevo IT mapa'. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.localizacion SET IT_mapa = '"+ nuevo + "' WHERE CD_posicion = '" + codigo + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;

			}

			}

		} while (resul != '0');

	}
	//trabajamos con novedades ya es el supertipo de noticia.
	public static void UpdateN() throws IOException {
		String nuevo;
		char resul;
		int CD_noticia,CD_noticiaN ;
		do {
			System.out.println(" Introduce el cd_notica que quieres modificar'. ");
			CD_noticia = teclado.nextInt();
			resul = llegarMenuUpdateN();
			switch (resul) {
			case '1': {
				System.out.println(" Introduce el nuevo codigo de noticia. ");
				CD_noticiaN = teclado.nextInt();
				//String UpdateLocalizacion1="UPDATE practica.restaurante SET Novedades_CD_novedad = '"+ CD_noticiaN+ "' WHERE Lozalizacion_CD_posicion = '"+ CD_noticia + "'";
				String UpDateRestaurante = "UPDATE practica.noticias SET CD_noticia ='"+CD_noticiaN+ "' WHERE cd_noticia = '" + CD_noticia + "' ";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			
			case '2': {
				System.out.println(" Introduce el nuevo titulo'. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET DS_titulo= '"+ nuevo + "' WHERE CD_novedad = '" + CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;

			}
			case '3': {
				System.out.println(" Introduce la nueva entradilla'. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET DS_entradilla = '"+ nuevo+ "' WHERE CD_novedad = '"+ CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			
			case '4': {
				
				System.out.println(" Introduce el estado '. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET DS_estado = '"+ nuevo+ "' WHERE CD_novedad = '"+ CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			//No dejamos que se cambie la fecha de publicacion
			case '5': {
				
				System.out.println(" Introduce la fecha de vigencia '. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET FC_vigencia = '"+ nuevo+ "' WHERE CD_novedad = '"+ CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			case '6': {
				
				System.out.println(" Introduce la imagen Thumbnail '. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET IT_imagethumb = '"+ nuevo+ "' WHERE CD_novedad = '"+ CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			case '7': {
				
				System.out.println(" Introduce la imagen detalle '. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET IT_imagendetalle  = '"+ nuevo+ "' WHERE CD_novedad = '"+ CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(
						RestApp.conexion, UpDateRestaurante);

				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			case '8': {
				
				System.out.println(" Introduce el enlace '. ");
				teclado.nextLine();
				nuevo = teclado.nextLine();
				String UpDateRestaurante = "UPDATE practica.novedades SET TL_enlace = '"+ nuevo+ "' WHERE CD_novedad = '"+ CD_noticia + "'";
				RestApp.registrosAfectados = MySQL.ejecutarIUD(RestApp.conexion, UpDateRestaurante);
				if (RestApp.registrosAfectados == 0)
					System.out.println("No se ha podido modificar");
				else
					System.out.println("Modificacion correcta");
				break;
			}
			
			}
		} while (resul != '0');
	}
	
	public static char llegarMenuUpdateC() throws IOException{
		BufferedReader linea = new BufferedReader(new InputStreamReader(
				System.in));
		char resul;
		System.out.println("¿que quiere modificar");
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  DNI.");
		System.out.println("    2.-  Nombre.");
		System.out.println("    3.-  Apellidos .");
		System.out.println("    4.-  Direccion de correo .");
		System.out.println("    5.-  Fecha de nacimiento .");
		System.out.println("    6.-  Direccion de envio .");
		System.out.println("    7.-  Numero del movil .");
		System.out.println("    8.-  Numero del telefono fijo .");
		System.out.println("    0.-  Para salir.");
		resul = (char) linea.read();
		
		return resul;
		
	}
	
	public static char llegarMenuUpdateR() throws IOException {
		BufferedReader linea = new BufferedReader(new InputStreamReader(
				System.in));
		char resul;
		System.out.println("¿que quiere modificar");
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Descripcion del restaurante.");
		System.out.println("    2.-  Fotos.");
		System.out.println("    3.-  Nombre .");
		System.out.println("    4.-  La localizacion.");
		System.out.println("    5.-  Promocion.");
		System.out.println("    6.-  Carta .");
		System.out.println("    7.-  Novedad .");
		System.out.println("    0.-  Para salir.");
		resul = (char) linea.read();
		
		return resul;
	}
	public static char llegarMenuUpdateL() throws IOException {
		BufferedReader linea = new BufferedReader(new InputStreamReader(
				System.in));
		char resul;
		System.out.println("¿que quiere modificar");
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Codigo de localizacion.");
		System.out.println("    2.-  Descripcion de localizacion.");
		System.out.println("    3.-  Mapa de localizacion .");
		System.out.println("    0.-  Para salir.");
		resul = (char) linea.read();
		
		return resul;
	}

	public static char llegarMenuUpdateN() throws IOException {
		BufferedReader linea = new BufferedReader(new InputStreamReader(
				System.in));
		char resul;
		System.out.println("¿que quiere modificar");
		System.out.println("Elija Opcion: ");
		System.out.println("    1.-  Código de la noticia.");
		System.out.println("    2.-  Título.");
		System.out.println("    3.-  Entradilla.");
		System.out.println("    4.-  Estado .");
		System.out.println("    5.-  Fecha de vigencia.");
		System.out.println("    6.-  Imagen Thum....");
		System.out.println("    7.-  Imagen detalle.");
		System.out.println("    8.-  Enlace.");
		System.out.println("    0.-  Para salir .");
		resul = (char) linea.read();
		
		return resul;
	}
}