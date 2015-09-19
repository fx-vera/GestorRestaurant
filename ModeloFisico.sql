SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- Hemos cambiado el valor que nos saca por defecto mysql (ON DELETE NO ACTION y ON UPDATE NO ACTION) por ON DELETE CASCADE y ON UPDATE CASCADE
-- en las tablas que fueran necesarias, para poder actualizar y borrar desde nuestro programa de gestión en java.

CREATE SCHEMA IF NOT EXISTS `practica` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `practica` ;

-- -----------------------------------------------------
-- Table `practica`.`Localizacion`
-- hemos incluido la posicion en donde va la latitud y la longitud. Tambien tenemos el mapa.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Localizacion` (
  `CD_posicion` INT NOT NULL,
  `DS_direccion` VARCHAR(100) NOT NULL,
  `IT_mapa` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`CD_posicion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Promociones`
--  Promociones de cada uno de los restaurantes con una imagen.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Promociones` (
  `CD_promocion` INT NOT NULL,
  `IT_imagen` VARCHAR(200) NULL,
  PRIMARY KEY (`CD_promocion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Consumo`
-- En esta tabla tendremos los habitos de comida de cada cliente.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Consumo` (
  `CD_habito` INT NOT NULL,
  `FC_fechaconsumo` DATETIME NULL,
  PRIMARY KEY (`CD_habito`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Carta`
-- La carta de cada restaurante. Desde aqui podremos relacionar que es lo que come cada cliente
-- e incluirlo a su consumo.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Carta` (
  `CD_carta` INT NOT NULL,
  `DS_carta` VARCHAR(100) NOT NULL,
  `TL_precio` VARCHAR(45) NOT NULL,
  `Consumo_CD_habito` INT NOT NULL,
  PRIMARY KEY (`CD_carta`),
  INDEX `fk_Carta_Consumo1_idx` (`Consumo_CD_habito` ASC),
  CONSTRAINT `fk_Carta_Consumo1`
    FOREIGN KEY (`Consumo_CD_habito`)
    REFERENCES `practica`.`Consumo` (`CD_habito`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Novedades`
-- Todas las novedades que salgan acerca del restaurante, hemos incluido la fecha de vigencia
-- para saber el tiempo que lleva publicada la novedad.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Novedades` (
  `CD_novedad` INT NOT NULL,
  `CD_contador` INT NOT NULL,
  `DS_titulo` VARCHAR(500) NOT NULL,
  `DS_entradilla` MEDIUMTEXT NOT NULL,
  `DS_estado` VARCHAR(100) NOT NULL,
  `FC_vigencia` DATETIME NOT NULL,
  `FC_publicacion` DATETIME NOT NULL,
  `IT_imagethumb` VARCHAR(100) NOT NULL,
  `IT_imagendetalle` VARCHAR(100) NOT NULL,
  `TL_enlace` VARCHAR(100) NULL,
  PRIMARY KEY (`CD_novedad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Restaurante`
-- La tabla restaurante, relacionada con localizacion, carta, promociones, novedades.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Restaurante` (
  `CD_restaurante` INT NOT NULL,
  `DS_descripcion` VARCHAR(200) NOT NULL,
  `IT_fotos` VARCHAR(400) NULL,
  `DS_nombre` VARCHAR(100) NOT NULL,
  `Localizacion_CD_posicion` INT NOT NULL,
  `Promociones_CD_promocion` INT NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  `Novedades_CD_novedad` INT NOT NULL,
  PRIMARY KEY (`CD_restaurante`, `Promociones_CD_promocion`),
  INDEX `fk_Restaurante_Localizacion1_idx` (`Localizacion_CD_posicion` ASC),
  INDEX `fk_Restaurante_Promociones1_idx` (`Promociones_CD_promocion` ASC),
  INDEX `fk_Restaurante_Carta1_idx` (`Carta_CD_carta` ASC),
  INDEX `fk_Restaurante_Novedades1_idx` (`Novedades_CD_novedad` ASC),
  CONSTRAINT `fk_Restaurante_Localizacion1`
    FOREIGN KEY (`Localizacion_CD_posicion`)
    REFERENCES `practica`.`Localizacion` (`CD_posicion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Restaurante_Promociones1`
    FOREIGN KEY (`Promociones_CD_promocion`)
    REFERENCES `practica`.`Promociones` (`CD_promocion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Restaurante_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Restaurante_Novedades1`
    FOREIGN KEY (`Novedades_CD_novedad`)
    REFERENCES `practica`.`Novedades` (`CD_novedad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`clientes`
-- la tabla clientes en el que hemos incluido el TL_activo para saber saber si
-- el cliente sigue siendolo de el restaurante en el que estemos. Tanto este como
-- el TL_aceptación los hemos puesto como booleanos. 
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`clientes` (
  `CD_dni` INT NOT NULL,
  `DS_nombre` VARCHAR(45) NOT NULL,
  `DS_apellidos` VARCHAR(100) NOT NULL,
  `DS_dircorreo` VARCHAR(45) NULL,
  `FC_nacimiento` DATETIME NULL,
  `NM_contadorvisitas` INT NULL,
  `DS_dirrenvio` VARCHAR(200) NULL,
  `DS_movil` VARCHAR(45) NULL,
  `DS_telefonofijo` VARCHAR(45) NULL,
  `TL_aceptacion` TINYINT(1) NULL,
  `TL_Activo` TINYINT(1) NULL,
  `Consumo_CD_habito` INT NOT NULL,
  PRIMARY KEY (`CD_dni`),
  INDEX `fk_clientes_Consumo1_idx` (`Consumo_CD_habito` ASC),
  CONSTRAINT `fk_clientes_Consumo1`
    FOREIGN KEY (`Consumo_CD_habito`)
    REFERENCES `practica`.`Consumo` (`CD_habito`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Noticias`
-- Subtipo de la tabla novedades, relacionada con esta misma con una relacion 1:1
-- Tiene los mismos campos que novedades y unicamente le incluimos un CD_noticia.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Noticias` (
  `CD_noticia` INT NOT NULL,
  `Novedades_CD_novedad` INT NOT NULL,
  PRIMARY KEY (`CD_noticia`),
  INDEX `fk_Noticias_Novedades1_idx` (`Novedades_CD_novedad` ASC),
  CONSTRAINT `fk_Noticias_Novedades1`
    FOREIGN KEY (`Novedades_CD_novedad`)
    REFERENCES `practica`.`Novedades` (`CD_novedad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`eventos`
-- Subtipo de la tabla novedades, relacionada con esta misma con una relacion 1:1
-- Tiene los mismos campos que novedades salvo que en los eventos vamos a incluir un mapa.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`eventos` (
  `CD_evento` INT NOT NULL,
  `IT_mapa` VARCHAR(200) NULL,
  `Novedades_CD_novedad` INT NOT NULL,
  PRIMARY KEY (`CD_evento`),
  INDEX `fk_eventos_Novedades1_idx` (`Novedades_CD_novedad` ASC),
  CONSTRAINT `fk_eventos_Novedades1`
    FOREIGN KEY (`Novedades_CD_novedad`)
    REFERENCES `practica`.`Novedades` (`CD_novedad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`entrantes`
-- Subtipo de la tabla Carta, relacionada con esta misma con una relacion 1:1.
-- Son los entrantes que ofrece el restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`entrantes` (
  `CD_entrante` INT NOT NULL,
  `DS_nombre` VARCHAR(45) NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  PRIMARY KEY (`CD_entrante`),
  INDEX `fk_entrantes_Carta1_idx` (`Carta_CD_carta` ASC),
  CONSTRAINT `fk_entrantes_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Paracompartir`
-- Subtipo de la tabla Carta, relacionada con esta misma con una relacion 1:1.
-- Son los platos para compartir que ofrece el restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Paracompartir` (
  `CD_compartir` INT NOT NULL,
  `DS_compartir` VARCHAR(45) NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  PRIMARY KEY (`CD_compartir`),
  INDEX `fk_Paracompartir_Carta1_idx` (`Carta_CD_carta` ASC),
  CONSTRAINT `fk_Paracompartir_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Bebidas`
-- Subtipo de la tabla Carta, relacionada con esta misma con una relacion 1:1.
-- Son las bebidas que ofrece el restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Bebidas` (
  `CD_bebida` INT NOT NULL,
  `DS_nombre` VARCHAR(45) NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  PRIMARY KEY (`CD_bebida`),
  INDEX `fk_Bebidas_Carta1_idx` (`Carta_CD_carta` ASC),
  CONSTRAINT `fk_Bebidas_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Postres`
-- Subtipo de la tabla Carta, relacionada con esta misma con una relacion 1:1.
-- Son los postres que ofrece el restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Postres` (
  `CD_postre` INT NOT NULL,
  `DS_postre` VARCHAR(45) NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  PRIMARY KEY (`CD_postre`),
  INDEX `fk_Postres_Carta1_idx` (`Carta_CD_carta` ASC),
  CONSTRAINT `fk_Postres_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`pescados`
-- Subtipo de la tabla Carta, relacionada con esta misma con una relacion 1:1.
-- Son los pescados que ofrece el restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`pescados` (
  `CD_pescado` INT NOT NULL,
  `DS_pescado` VARCHAR(45) NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  PRIMARY KEY (`CD_pescado`),
  INDEX `fk_pescados_Carta1_idx` (`Carta_CD_carta` ASC),
  CONSTRAINT `fk_pescados_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`carnes`
-- Subtipo de la tabla Carta, relacionada con esta misma con una relacion 1:1.
-- Son los diferentes tipos de carne que ofrece el restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`carnes` (
  `CD_carne` INT NOT NULL,
  `DS_nombre` VARCHAR(45) NOT NULL,
  `Carta_CD_carta` INT NOT NULL,
  PRIMARY KEY (`CD_carne`),
  INDEX `fk_carnes_Carta1_idx` (`Carta_CD_carta` ASC),
  CONSTRAINT `fk_carnes_Carta1`
    FOREIGN KEY (`Carta_CD_carta`)
    REFERENCES `practica`.`Carta` (`CD_carta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica`.`Restaurante_has_clientes`
-- Esta tabla representa la relación N:M que hay entre clientes y restaurante.
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica`.`Restaurante_has_clientes` (
  `Restaurante_CD_restaurante` INT NOT NULL,
  `clientes_CD_dni` INT NOT NULL,
  PRIMARY KEY (`Restaurante_CD_restaurante`, `clientes_CD_dni`),
  INDEX `fk_Restaurante_has_clientes_clientes1_idx` (`clientes_CD_dni` ASC),
  INDEX `fk_Restaurante_has_clientes_Restaurante1_idx` (`Restaurante_CD_restaurante` ASC),
  CONSTRAINT `fk_Restaurante_has_clientes_Restaurante1`
    FOREIGN KEY (`Restaurante_CD_restaurante`)
    REFERENCES `practica`.`Restaurante` (`CD_restaurante`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Restaurante_has_clientes_clientes1`
    FOREIGN KEY (`clientes_CD_dni`)
    REFERENCES `practica`.`clientes` (`CD_dni`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;