-- MySQL Script generated by MySQL Workbench
-- Sun May 22 20:05:49 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Litografia
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Litografia` ;

-- -----------------------------------------------------
-- Schema Litografia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Litografia` ;
USE `Litografia` ;

-- -----------------------------------------------------
-- Table `Litografia`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Producto` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Producto` (
  `idProducto` VARCHAR(70) NOT NULL,
  `tipo` VARCHAR(56) NULL,
  `precio` DOUBLE NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Factura` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Factura` (
  `idFactura` VARCHAR(30) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `precio` VARCHAR(45) NULL,
  PRIMARY KEY (`idFactura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Diseno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Diseno` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Diseno` (
  `idDiseno` VARCHAR(70) NOT NULL,
  `tipo` VARCHAR(60) NULL,
  `tamano` VARCHAR(45) NULL,
  PRIMARY KEY (`idDiseno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Litografia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Litografia` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Litografia` (
  `idLitografia` VARCHAR(70) NOT NULL,
  `tipoTroquelado` VARCHAR(100) NULL,
  `tipoPapel` VARCHAR(45) NULL,
  `barnizado` TINYINT NULL,
  `tamano` VARCHAR(45) NULL,
  PRIMARY KEY (`idLitografia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Cliente` (
  `cedulaCliente` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `correoElectronico` VARCHAR(100) NULL,
  PRIMARY KEY (`cedulaCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Empleado` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Empleado` (
  `cedulaEmpleado` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `eps` VARCHAR(200) NULL,
  `titulo` VARCHAR(105) NULL,
  `sueldo` DOUBLE NULL,
  `tipo` VARCHAR(100) NULL,
  `direccion` VARCHAR(200) NULL,
  `usuario` VARCHAR(70) NULL,
  `contrasena` VARCHAR(75) NULL,
  `inicioSesion` TINYINT NULL,
  PRIMARY KEY (`cedulaEmpleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Pedido` (
  `idPedido` VARCHAR(70) NOT NULL,
  `fecha` DATETIME NULL,
  `precio` DOUBLE NULL,
  `Empleado_cedulaEmpleado` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Empleado1_idx` (`Empleado_cedulaEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Empleado1`
    FOREIGN KEY (`Empleado_cedulaEmpleado`)
    REFERENCES `Litografia`.`Empleado` (`cedulaEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`EspecificacionLitografica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`EspecificacionLitografica` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`EspecificacionLitografica` (
  `idEspecificacionLitografica` VARCHAR(70) NOT NULL,
  `tipoPapel` VARCHAR(45) NULL,
  `tamano` VARCHAR(45) NULL,
  `Litografia_idLitografia` VARCHAR(70) NOT NULL,
  `Empleado_cedulaEmpleado` INT NOT NULL,
  `Cliente_cedulaCliente` INT NOT NULL,
  PRIMARY KEY (`idEspecificacionLitografica`),
  INDEX `fk_EspecificacionLitografica_Litografia1_idx` (`Litografia_idLitografia` ASC) VISIBLE,
  INDEX `fk_EspecificacionLitografica_Empleado1_idx` (`Empleado_cedulaEmpleado` ASC) VISIBLE,
  INDEX `fk_EspecificacionLitografica_Cliente1_idx` (`Cliente_cedulaCliente` ASC) VISIBLE,
  CONSTRAINT `fk_EspecificacionLitografica_Litografia1`
    FOREIGN KEY (`Litografia_idLitografia`)
    REFERENCES `Litografia`.`Litografia` (`idLitografia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EspecificacionLitografica_Empleado1`
    FOREIGN KEY (`Empleado_cedulaEmpleado`)
    REFERENCES `Litografia`.`Empleado` (`cedulaEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EspecificacionLitografica_Cliente1`
    FOREIGN KEY (`Cliente_cedulaCliente`)
    REFERENCES `Litografia`.`Cliente` (`cedulaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Devolucion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Devolucion` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Devolucion` (
  `idDevolucion` VARCHAR(70) NOT NULL,
  `fecha` DATETIME NULL,
  `descripcion` VARCHAR(1000) NULL,
  `tipo` VARCHAR(75) NULL,
  `Empleado_cedulaEmpleado` INT NOT NULL,
  PRIMARY KEY (`idDevolucion`),
  INDEX `fk_Devolucion_Empleado1_idx` (`Empleado_cedulaEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Devolucion_Empleado1`
    FOREIGN KEY (`Empleado_cedulaEmpleado`)
    REFERENCES `Litografia`.`Empleado` (`cedulaEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`MateriaPrima`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`MateriaPrima` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`MateriaPrima` (
  `idMateriaPrima` VARCHAR(70) NOT NULL,
  `tipo` VARCHAR(75) NULL,
  `cantidad` INT NULL,
  `descripcion` VARCHAR(500) NULL,
  PRIMARY KEY (`idMateriaPrima`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`Proveedor` (
  `idProveedor` INT NOT NULL,
  `rut` VARCHAR(95) NULL,
  `nombre` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`FacturaProducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`FacturaProducto` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`FacturaProducto` (
  `Producto_idProducto` VARCHAR(70) NOT NULL,
  `Factura_idFactura` VARCHAR(30) NOT NULL,
  `descripcion` VARCHAR(1000) NULL,
  PRIMARY KEY (`Producto_idProducto`, `Factura_idFactura`),
  INDEX `fk_Producto_has_Factura_Factura1_idx` (`Factura_idFactura` ASC) VISIBLE,
  INDEX `fk_Producto_has_Factura_Producto_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Factura_Producto`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `Litografia`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Factura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `Litografia`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`FacturaDiseno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`FacturaDiseno` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`FacturaDiseno` (
  `Factura_idFactura` VARCHAR(30) NOT NULL,
  `Diseno_idDiseno` VARCHAR(70) NOT NULL,
  `descripcion` VARCHAR(1000) NULL,
  PRIMARY KEY (`Factura_idFactura`, `Diseno_idDiseno`),
  INDEX `fk_Factura_has_Diseno_Diseno1_idx` (`Diseno_idDiseno` ASC) VISIBLE,
  INDEX `fk_Factura_has_Diseno_Factura1_idx` (`Factura_idFactura` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_has_Diseno_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `Litografia`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_has_Diseno_Diseno1`
    FOREIGN KEY (`Diseno_idDiseno`)
    REFERENCES `Litografia`.`Diseno` (`idDiseno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`FacturaLitografia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`FacturaLitografia` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`FacturaLitografia` (
  `Litografia_idLitografia` VARCHAR(70) NOT NULL,
  `Factura_idFactura` VARCHAR(30) NOT NULL,
  `descripcion` VARCHAR(1000) NULL,
  PRIMARY KEY (`Litografia_idLitografia`, `Factura_idFactura`),
  INDEX `fk_Litografia_has_Factura_Factura1_idx` (`Factura_idFactura` ASC) VISIBLE,
  INDEX `fk_Litografia_has_Factura_Litografia1_idx` (`Litografia_idLitografia` ASC) VISIBLE,
  CONSTRAINT `fk_Litografia_has_Factura_Litografia1`
    FOREIGN KEY (`Litografia_idLitografia`)
    REFERENCES `Litografia`.`Litografia` (`idLitografia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Litografia_has_Factura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `Litografia`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`EspecificacionDiseno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`EspecificacionDiseno` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`EspecificacionDiseno` (
  `idEspecificacionDiseno` VARCHAR(70) NOT NULL,
  `tipo` VARCHAR(100) NULL,
  `tamano` VARCHAR(45) NULL,
  `descripcion` VARCHAR(1000) NULL,
  `EspecificacionDisenocol` VARCHAR(45) NULL,
  `Diseno_idDiseno` VARCHAR(70) NOT NULL,
  `Cliente_cedulaCliente` INT NOT NULL,
  `Empleado_cedulaEmpleado` INT NOT NULL,
  PRIMARY KEY (`idEspecificacionDiseno`),
  INDEX `fk_EspecificacionDiseno_Diseno1_idx` (`Diseno_idDiseno` ASC) VISIBLE,
  INDEX `fk_EspecificacionDiseno_Cliente1_idx` (`Cliente_cedulaCliente` ASC) VISIBLE,
  INDEX `fk_EspecificacionDiseno_Empleado1_idx` (`Empleado_cedulaEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_EspecificacionDiseno_Diseno1`
    FOREIGN KEY (`Diseno_idDiseno`)
    REFERENCES `Litografia`.`Diseno` (`idDiseno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EspecificacionDiseno_Cliente1`
    FOREIGN KEY (`Cliente_cedulaCliente`)
    REFERENCES `Litografia`.`Cliente` (`cedulaCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EspecificacionDiseno_Empleado1`
    FOREIGN KEY (`Empleado_cedulaEmpleado`)
    REFERENCES `Litografia`.`Empleado` (`cedulaEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`FacturaEmpleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`FacturaEmpleado` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`FacturaEmpleado` (
  `Empleado_cedulaEmpleado` INT NOT NULL,
  `Factura_idFactura` VARCHAR(30) NOT NULL,
  `descripcion` VARCHAR(1000) NULL,
  PRIMARY KEY (`Empleado_cedulaEmpleado`, `Factura_idFactura`),
  INDEX `fk_Empleado_has_Factura_Factura1_idx` (`Factura_idFactura` ASC) VISIBLE,
  INDEX `fk_Empleado_has_Factura_Empleado1_idx` (`Empleado_cedulaEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_has_Factura_Empleado1`
    FOREIGN KEY (`Empleado_cedulaEmpleado`)
    REFERENCES `Litografia`.`Empleado` (`cedulaEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_has_Factura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `Litografia`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`ProveedorMateriaPrima`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`ProveedorMateriaPrima` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`ProveedorMateriaPrima` (
  `MateriaPrima_idMateriaPrima` VARCHAR(70) NOT NULL,
  `Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`MateriaPrima_idMateriaPrima`, `Proveedor_idProveedor`),
  INDEX `fk_MateriaPrima_has_Proveedor_Proveedor1_idx` (`Proveedor_idProveedor` ASC) VISIBLE,
  INDEX `fk_MateriaPrima_has_Proveedor_MateriaPrima1_idx` (`MateriaPrima_idMateriaPrima` ASC) VISIBLE,
  CONSTRAINT `fk_MateriaPrima_has_Proveedor_MateriaPrima1`
    FOREIGN KEY (`MateriaPrima_idMateriaPrima`)
    REFERENCES `Litografia`.`MateriaPrima` (`idMateriaPrima`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MateriaPrima_has_Proveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `Litografia`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`PedidoMateriaPrima`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`PedidoMateriaPrima` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`PedidoMateriaPrima` (
  `Pedido_idPedido` VARCHAR(70) NOT NULL,
  `MateriaPrima_idMateriaPrima` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`Pedido_idPedido`, `MateriaPrima_idMateriaPrima`),
  INDEX `fk_Pedido_has_MateriaPrima_MateriaPrima1_idx` (`MateriaPrima_idMateriaPrima` ASC) VISIBLE,
  INDEX `fk_Pedido_has_MateriaPrima_Pedido1_idx` (`Pedido_idPedido` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_MateriaPrima_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `Litografia`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_MateriaPrima_MateriaPrima1`
    FOREIGN KEY (`MateriaPrima_idMateriaPrima`)
    REFERENCES `Litografia`.`MateriaPrima` (`idMateriaPrima`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Litografia`.`DevolucionProducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Litografia`.`DevolucionProducto` ;

CREATE TABLE IF NOT EXISTS `Litografia`.`DevolucionProducto` (
  `Devolucion_idDevolucion` VARCHAR(70) NOT NULL,
  `PedidoMateriaPrima_Pedido_idPedido` VARCHAR(70) NOT NULL,
  `PedidoMateriaPrima_MateriaPrima_idMateriaPrima` VARCHAR(70) NOT NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`Devolucion_idDevolucion`, `PedidoMateriaPrima_Pedido_idPedido`, `PedidoMateriaPrima_MateriaPrima_idMateriaPrima`),
  INDEX `fk_Devolucion_has_PedidoMateriaPrima_PedidoMateriaPrima1_idx` (`PedidoMateriaPrima_Pedido_idPedido` ASC, `PedidoMateriaPrima_MateriaPrima_idMateriaPrima` ASC) VISIBLE,
  INDEX `fk_Devolucion_has_PedidoMateriaPrima_Devolucion1_idx` (`Devolucion_idDevolucion` ASC) VISIBLE,
  CONSTRAINT `fk_Devolucion_has_PedidoMateriaPrima_Devolucion1`
    FOREIGN KEY (`Devolucion_idDevolucion`)
    REFERENCES `Litografia`.`Devolucion` (`idDevolucion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Devolucion_has_PedidoMateriaPrima_PedidoMateriaPrima1`
    FOREIGN KEY (`PedidoMateriaPrima_Pedido_idPedido` , `PedidoMateriaPrima_MateriaPrima_idMateriaPrima`)
    REFERENCES `Litografia`.`PedidoMateriaPrima` (`Pedido_idPedido` , `MateriaPrima_idMateriaPrima`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
