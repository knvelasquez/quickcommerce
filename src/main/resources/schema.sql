-- -----------------------------------------------------
-- Base de Datos maestrod01 ambiente Desarrollo 
-- Base de Datos maestroh01 ambiente Homologacion 
-- Base de Datos maestro01  ambiente Produccion 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `maestrodb` AUTHORIZATION sa;
CREATE SCHEMA IF NOT EXISTS `maestrodbinte` AUTHORIZATION sa;

USE `maestrodb`;

-- -----------------------------------------------------
-- Tabla `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(15) NOT NULL,
  `contrasenia` VARCHAR(129) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `apellido` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idusuario`));


-- -----------------------------------------------------
-- Tabla `privilegio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `privilegio` (
  `idprivilegio` INT NOT NULL AUTO_INCREMENT,
  `valor` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idprivilegio`));

-- -----------------------------------------------------
-- Tabla `usuario_privilegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario_privilegio` (
  `usuario_idusuario` INT NOT NULL,
  `privilegio_idprivilegio` INT NOT NULL,
  --INDEX `fk_usuario_privilegios_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  --INDEX `fk_usuario_privilegios_privilegio1_idx` (`privilegio_idprivilegio` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_privilegios_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_privilegios_privilegio1`
    FOREIGN KEY (`privilegio_idprivilegio`)
    REFERENCES `privilegio` (`idprivilegio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
   CREATE INDEX `fk_usuario_privilegio_usuario_idx` ON `usuario_privilegio`(`usuario_idusuario`);
   CREATE INDEX `fk_usuario_privilegio_privilegio1_idx` ON `usuario_privilegio` (`privilegio_idprivilegio`);

-- -----------------------------------------------------
-- Tabla `producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `cantidad` INT,
  PRIMARY KEY (`id`));