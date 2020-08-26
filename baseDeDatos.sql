-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema intelaf_ipc2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema intelaf_ipc2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `intelaf_ipc2` ;
USE `intelaf_ipc2` ;

-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`tiendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`tiendas` (
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `telefono1` VARCHAR(11) NOT NULL,
  `telefono2` VARCHAR(11) NULL,
  `email` VARCHAR(100) NULL,
  `horario` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`empleados` (
  `codigo` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(11) NOT NULL,
  `nit` VARCHAR(10) NULL DEFAULT NULL,
  `dpi` VARCHAR(13) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`clientes` (
  `nit` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(11) NOT NULL,
  `dpi` VARCHAR(13) NULL DEFAULT NULL,
  `creditoCompra` DECIMAL(9,2) NULL DEFAULT 0.00,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`nit`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`productos` (
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `fabricante` VARCHAR(100) NOT NULL,
  `precio` DECIMAL(9,2) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `garantia` INT NULL DEFAULT 0,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`tiendasDestinos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`tiendasDestinos` (
  `tiendasCodigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tiendasCodigo`),
  CONSTRAINT `fk_tiendasDestinos_tiendas1`
    FOREIGN KEY (`tiendasCodigo`)
    REFERENCES `intelaf_ipc2`.`tiendas` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`tiempos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`tiempos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tiendasOrigen` VARCHAR(45) NOT NULL,
  `tiendasDestino` VARCHAR(45) NOT NULL,
  `tiempoDias` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tiempos_tiendas1`
    FOREIGN KEY (`tiendasOrigen`)
    REFERENCES `intelaf_ipc2`.`tiendas` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tiempos_tiendasDestinos1`
    FOREIGN KEY (`tiendasDestino`)
    REFERENCES `intelaf_ipc2`.`tiendasDestinos` (`tiendasCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
PACK_KEYS = DEFAULT;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`pedidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clientesNit` VARCHAR(10) NOT NULL,
  `tiemposId` INT NOT NULL,
  `fechaPedido` DATE NOT NULL,
  `totalPedido` DECIMAL(9,2) NOT NULL,
  `anticipo` DECIMAL(9,2) NOT NULL,
  `fechaLlegada` DATE NULL,
  `llegadaATiempo` TINYINT NULL DEFAULT 0,
  `entregado` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_pedidos_clientes1`
    FOREIGN KEY (`clientesNit`)
    REFERENCES `intelaf_ipc2`.`clientes` (`nit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_tiempos1`
    FOREIGN KEY (`tiemposId`)
    REFERENCES `intelaf_ipc2`.`tiempos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`tiendasProductos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`tiendasProductos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tiendasCodigo` VARCHAR(45) NOT NULL,
  `productosCodigo` VARCHAR(45) NOT NULL,
  `stockProductos` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tiendas_has_productos_tiendas1`
    FOREIGN KEY (`tiendasCodigo`)
    REFERENCES `intelaf_ipc2`.`tiendas` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tiendas_has_productos_productos1`
    FOREIGN KEY (`productosCodigo`)
    REFERENCES `intelaf_ipc2`.`productos` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`ventas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pedidos_id` INT NULL DEFAULT NULL,
  `clientesNit` VARCHAR(10) NOT NULL,
  `fechaVenta` DATE NOT NULL,
  `totalVenta` DECIMAL(9,2) NOT NULL,
  `descuentoPorCredito` DECIMAL(9,2) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ventas_pedidos1`
    FOREIGN KEY (`pedidos_id`)
    REFERENCES `intelaf_ipc2`.`pedidos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_ventas_clientes1`
    FOREIGN KEY (`clientesNit`)
    REFERENCES `intelaf_ipc2`.`clientes` (`nit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`detallesVentas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`detallesVentas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ventasId` INT NOT NULL,
  `tiendasProductosId` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precioVenta` DECIMAL(9,2) NOT NULL,
  `subTotal` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tiendas_has_productos_has_ventas_ventas1`
    FOREIGN KEY (`ventasId`)
    REFERENCES `intelaf_ipc2`.`ventas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tiendas_has_productos_has_ventas_tiendas_has_productos1`
    FOREIGN KEY (`tiendasProductosId`)
    REFERENCES `intelaf_ipc2`.`tiendasProductos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `intelaf_ipc2`.`detallesPedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `intelaf_ipc2`.`detallesPedidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pedidosId` INT NOT NULL,
  `productosCodigo` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `precioVentaPedido` DECIMAL(9,2) NULL,
  `subTotalPedido` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tiendas_has_productos_has_pedidos_pedidos1`
    FOREIGN KEY (`pedidosId`)
    REFERENCES `intelaf_ipc2`.`pedidos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detallesPedidos_productos1`
    FOREIGN KEY (`productosCodigo`)
    REFERENCES `intelaf_ipc2`.`productos` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
