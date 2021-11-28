-- -----------------------------------------------------
-- Base de Datos fantastic_desa ambiente Desarrollo 
-- Base de Datos fantastic_inte ambiente Integración 
-- Base de Datos fantastic_prod ambiente Producción 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fantastic_prod` AUTHORIZATION sa;
CREATE SCHEMA IF NOT EXISTS `fantastic_inte` AUTHORIZATION sa;

USE `fantastic_prod`;

-- -----------------------------------------------------
-- Tabla `users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `signpassword` VARCHAR(129) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `apellido` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`iduser`));


-- -----------------------------------------------------
-- Tabla `privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `privilege` (
  `id_privilege` INT NOT NULL AUTO_INCREMENT,
  `name_privilege` VARCHAR(45) NOT NULL,
  `description_privilege` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_privilege`));

-- -----------------------------------------------------
-- Tabla `users_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users_privilege` (
  `users_iduser` INT NOT NULL,
  `privilege_id_privilege` INT NOT NULL,
  CONSTRAINT `fk_users_role_username1`
    FOREIGN KEY (`users_iduser`)
    REFERENCES `users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_role_id_privilege1`
    FOREIGN KEY (`privilege_id_privilege`)
    REFERENCES `privilege` (`id_privilege`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
   CREATE INDEX `fk_fk_users_role_username_idx` ON `users_privilege`(`users_iduser`);
   CREATE INDEX `fk_users_role_privilegio1_idx` ON `users_privilege` (`privilege_id_privilege`);

-- -----------------------------------------------------
-- Tabla `products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `products` (
  `codeproduct` INT NOT NULL AUTO_INCREMENT,
  `nameproduct` VARCHAR(100) NOT NULL,
  `categoryproduct` VARCHAR(45) NOT NULL,
  `markproduct` VARCHAR(45) NOT NULL,
  `priceproduct` FLOAT NOT NULL,
  `currencyproduct` VARCHAR(5) NOT NULL,
  `stockproduct` INT NOT NULL,
  `statusproduct` VARCHAR(45) NOT NULL,
  `creationdateproduct` DATETIME NOT NULL,
  PRIMARY KEY (`codeproduct`));

