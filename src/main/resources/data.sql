-- -----------------------------------------------------
--Roles de Usuarios
-- -----------------------------------------------------
INSERT INTO `privilege` VALUES(1,'ROLE_ADMIN','Permite el acceso a todas las funcionalidades');
INSERT INTO `privilege` VALUES(2,'ROLE_CONSULTANT','Permite obtener acceso a la lista con información de todos los Súper Héroes encontrados.');
INSERT INTO `privilege` VALUES(3,'ROLE_CLIENT','Permite el acceso a todas las consultas y compras');
INSERT INTO `privilege` VALUES(4,'ROLE_ASSISTANT','Permite el acceso a todas las consultas y administración de los productos, no puede eliminar productos');

-- -----------------------------------------------------
--Alta de Usuarios automáticas
-- -----------------------------------------------------
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(1,'jhosy_admin','Jhosy','Velásquez','4d8b6288b56676d37c8608c175286d8c9f90ef362bf0dd8e481e42bfbc90d49058476228f5b7a752973eed28dcc85e33208a4efa35bd7dbd8cd69f6e4006b485');
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(2,'honni_consultant','Honni','Ochoa','f12891cefd838f73cf1adc4386632e428e3a638a344889b1fac7436c0b96f8b2fad8a012986bba85992c8e6744bf4972eac29cc3a1ffada2fc467c813c42d836');
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(3,'kev_client','Kev','Velásquez','747c0117f0744c3461121710db1c968398956218372c189d0c66985ba9a59bb2ae08e317b94448bfdf28f99f857bda3c80dd3386878ce665cd4ebde4d76226aa');
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(4,'fantastic_assistant','Fantastic','Project','e394db104771c1cca46f2926c84fe575e63f3fbbf7a6023752fdc3fa2202fe31857abed362fb5666990e4d68e605a7b5366dc74812907f4548eee02e74e0d810');

-- -----------------------------------------------------
--Asignación de roles a usuarios creados
-- -----------------------------------------------------
-- Usuario: ADMIN
INSERT INTO `users_privilege` VALUES(1,1);

-- Usuario: CONSULTANT
INSERT INTO `users_privilege` VALUES(2,2);

-- Usuario: CLIENT
INSERT INTO `users_privilege` VALUES(3,3);

-- Usuario: ASSISTANT
INSERT INTO `users_privilege` VALUES(4,4);

INSERT INTO `products` VALUES(NULL,'Arepitas','Comida Venezolana','DONIA TOTA',100.01,'ARS',15,'ACTIVE','2021-11-26 15:50:08.987');
INSERT INTO `products` VALUES(NULL,'Cafecito con Leche','Bebida Caliente','MARTINEZ',30.01,'ARS',20,'ACTIVE','2021-11-27 13:25:40.745');
