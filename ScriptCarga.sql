use practica;

/*insert into `clientes` (`CD_dni`, `DS_nombre`, `DS_apellidos`, `DS_dircorreo`, `FC_nacimiento`, `NM_contadorvisitas`, `DS_dirrenvio`, `DS_movil`, `DS_telefonofijo`, `TL_aceptacion`, `TL_Activo`, `Consumo_CD_habito`)
values (05456078, "Miguel", "Pinedo Fernández", "pine_basket_12@hotmail.com", "1994/07/27", 0,  "Calle orense 8", "669048259", "912151621", 1, 1,  0); /* IT aceptación esta a 1, ha acepptado el envio de propaganda*/


insert into `carta` (`CD_carta`, `DS_carta`, `TL_precio`, `Consumo_CD_habito`)
values (0, "Carta de Madrid", "15", 0);/* Todos los entrantes costaran 15€*/
INSERT INTO `practica`.`carta` (`CD_carta`, `DS_carta`, `TL_precio`, `Consumo_CD_habito`)
VALUES ('1', 'Carta de Barcelona', '19', '1');
INSERT INTO `practica`.`carta` (`CD_carta`, `DS_carta`, `TL_precio`, `Consumo_CD_habito`)
VALUES ('2', 'Carta de Paris', '20', '2');
INSERT INTO `practica`.`carta` (`CD_carta`, `DS_carta`, `TL_precio`, `Consumo_CD_habito`) 
VALUES ('3', 'Carta de Zaragoza', '10', '3');
INSERT INTO `practica`.`carta` (`CD_carta`, `DS_carta`, `TL_precio`, `Consumo_CD_habito`) 
VALUES ('4', 'Carta de Londres', '17', '4');



insert into `entrantes`(`CD_entrante`, `DS_nombre`, `Carta_CD_carta`)
values (0, "Pulpo", 0); 
insert into `entrantes`(`CD_entrante`, `DS_nombre`, `Carta_CD_carta`)
values (1, "Bacon cheese fries", 0); 
insert into `entrantes`(`CD_entrante`, `DS_nombre`, `Carta_CD_carta`)
values (2, "Aritos de cebolla", 0); 


insert into `carnes` (`CD_carne`, `DS_nombre`, `Carta_CD_carta`)
values (0, "Carne de buey", 0);
insert into `carnes` (`CD_carne`, `DS_nombre`, `Carta_CD_carta`)
values (1, "Ternera", 0);
insert into `carnes` (`CD_carne`, `DS_nombre`, `Carta_CD_carta`)
values (2, "Solomillo", 0);


insert into `Bebidas` (`CD_bebida`, `DS_nombre`, `Carta_CD_carta`)
values (0, "Agua", 0); 
insert into `Bebidas` (`CD_bebida`, `DS_nombre`, `Carta_CD_carta`)
values (1, "Refrescos", 0); 
insert into `Bebidas` (`CD_bebida`, `DS_nombre`, `Carta_CD_carta`)
values (2, "Vino", 0); 


insert into `Postres` (`CD_postre`, `DS_postre`, `Carta_CD_carta`)
values (0, "Helados", 0);
insert into `Postres` (`CD_postre`, `DS_postre`, `Carta_CD_carta`)
values (1, "Tiramisú", 0);
insert into `Postres` (`CD_postre`, `DS_postre`, `Carta_CD_carta`)
values (2, "Macedonia", 0);


insert into `pescados` (`CD_pescado`, `DS_pescado`, `Carta_CD_carta`)
values (0, "Merluza", 0);
insert into `pescados` (`CD_pescado`, `DS_pescado`, `Carta_CD_carta`)
values (1, "Pez espada", 0);
insert into `pescados` (`CD_pescado`, `DS_pescado`, `Carta_CD_carta`)
values (2, "Sardinas", 0);


insert into `Paracompartir` (`CD_compartir`, `DS_compartir`, `Carta_CD_carta`)
values (0, "Ensalada césar", 0);
insert into `Paracompartir` (`CD_compartir`, `DS_compartir`, `Carta_CD_carta`)
values (1, "Fingers de pollo", 0);
insert into `Paracompartir` (`CD_compartir`, `DS_compartir`, `Carta_CD_carta`)
values (2, "Pizza", 0);



insert into `Localizacion`(`CD_posicion`, `DS_direccion`, `IT_mapa`)
values (0, "Calle Maria de molina 8","C:\Users\Miguel\Desktop\Madrid.jpg"); /* Madrid*/

insert into `Localizacion`(`CD_posicion`, `DS_direccion`, `IT_mapa`)
values (1, "Carrer de Leiva","C:\Users\Miguel\Desktop\Barcelona.jpg"); /* Barcelona */

insert into `Localizacion`(`CD_posicion`, `DS_direccion`, `IT_mapa`)
values (2, "Calle Cortes de Aragón","C:\Users\Miguel\Desktop\Zaragoza.jpg"); /*Zaragoza*/

insert into `Localizacion`(`CD_posicion`, `DS_direccion`, `IT_mapa`)
values (3, "Gunthorpe St","C:\Users\Miguel\Desktop\Londres.jpg"); /* Londres */

insert into `Localizacion`(`CD_posicion`, `DS_direccion`, `IT_mapa`)
values (4, "Rue de Vaugirard","C:\Users\Miguel\Desktop\Paris.jpg"); /* Paris */


insert into `Novedades`(`CD_novedad`, `CD_contador`, `DS_titulo`, `DS_entradilla`, `DS_estado`, `FC_vigencia`, `FC_publicacion` ,`IT_imagethumb`, `IT_imagendetalle`, `TL_enlace`)
values (0, 0, "Inauguración de nuestro restaurante, 3 tapas + bebida con invitados como Dj Splash, Noisecontrollers y Showtek entre otros ", "Gran celebración con música y tapas gratis. Abrimos el dia 31 de Octubre del 2013, os esperamos a todos en Calle Maria de molina 8 a las 17:30 ", "Pasada", "2013/10/31", "2013/11/01",  "C:\Users\Miguel\Desktop\Inauguración1.jpg", "C:\Users\Miguel\Desktop\Inauguración2.jpg", "GRAND OPENING PARTY");

insert into `Novedades`(`CD_novedad`, `CD_contador`, `DS_titulo`, `DS_entradilla`, `DS_estado`, `FC_vigencia`, `FC_publicacion` ,`IT_imagethumb`, `IT_imagendetalle`, `TL_enlace`)
values (1, 0, "¡Oferta en todos nuestros platos! precios rebajados un 35% durante una semana, ¡No lo desaprovecheis!", "¡Después de la gran inauguración, no paramos!", "Presente", "2013/12/15", "2013/12/22",  "C:\Users\Miguel\Desktop\Oferta1.jpg", "C:\Users\Miguel\Desktop\Oferta11.jpg", "Oferta de diciembre");

insert into `Novedades`(`CD_novedad`, `CD_contador`, `DS_titulo`, `DS_entradilla`, `DS_estado`, `FC_vigencia`, `FC_publicacion` ,`IT_imagethumb`, `IT_imagendetalle`, `TL_enlace`)
values (2, 0, "Promoción navidades. ¡Por cada tres platos pedidos el cuarto es gratis! Contaremos tambien con música clásica para poder disfrutar de la cena y la compañía", "Perfecto para pasar un rato agradable y disfrutar de la comida", "Futura", "2013/12/25", "2014/01/04",  "C:\Users\Miguel\Desktop\Navidad1.jpg", "C:\Users\Miguel\Desktop\Navidad11.jpg", "Celebración de Navidades");
insert into `Novedades`(`CD_novedad`, `CD_contador`, `DS_titulo`, `DS_entradilla`, `DS_estado`, `FC_vigencia`, `FC_publicacion` ,`IT_imagethumb`, `IT_imagendetalle`, `TL_enlace`)
values (3, 0, "Oferta de Reyes. ¡Bebidas gratis y 2 entrantes a elegir! En este día especial vendrán prestigiosos humoristas como Goyo jimenez y Luis piedrahita", "Un día lleno de diversión y sorpresas", "Futura", "2014/01/05", "2014/01/06",  "C:\Users\Miguel\Desktop\Reyes1.jpg", "C:\Users\Miguel\Desktop\Reyes11.jpg", "También habrá sorpresas en el restaurante");

insert into `Noticias` (`CD_noticia`, `Novedades_CD_novedad`)
values(0,0); /*Esta noticia pertenece a la Novedad restaurante madrid */
INSERT INTO `practica`.`noticias` (`CD_noticia`, `Novedades_CD_novedad`) 
VALUES (1, 1);
INSERT INTO `practica`.`noticias` (`CD_noticia`, `Novedades_CD_novedad`) 
VALUES (2, 2);


insert into `eventos`(`CD_evento`, `IT_mapa`, `Novedades_CD_novedad`)
values(10,"C:\Users\Miguel\Desktop\Evento1.jpg", 0); /* Este evento pertenece a la Novedad restaurante madrid*/


insert into `Promociones` (`CD_promocion`, `IT_imagen`)
values (0,"C:\Users\Miguel\Desktop\Promocion1.jp");
insert into `Promociones` (`CD_promocion`, `IT_imagen`)
values (1,"C:\Users\Miguel\Desktop\Promocion2.jp");
insert into `Promociones` (`CD_promocion`, `IT_imagen`)
values (2,"C:\Users\Miguel\Desktop\Promocion3.jp");
/*insert into `Restaurante` (`CD_restaurante`, `DS_descripcion`, `IT_fotos`, `DS_nombre`, `Localizacion_CD_posicion`, `Promociones_CD_promocion`, `Carta_CD_plato`, `Novedades_CD_novedad`)
values (0,"Este es el restaurante de madrid", "C:\Users\Miguel\Desktop\Restaurante1.jpg , C:\Users\Miguel\Desktop\Restaurante2.jpg", "Madrid", 0, 0, 0, 0);