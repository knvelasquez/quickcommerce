-- -----------------------------------------------------
--Roles de Usuarios
-- -----------------------------------------------------
INSERT INTO `privilege` VALUES(1,'ADMIN','Permite el acceso a todas las funcionalidades');
INSERT INTO `privilege` VALUES(2,'CONSULTANT','Permite obtener acceso a la lista con información de todos los Súper Héroes encontrados.');
INSERT INTO `privilege` VALUES(3,'CLIENT','Permite el acceso a todas las consultas y compras');
INSERT INTO `privilege` VALUES(4,'ASSISTANT','Permite el acceso a todas las consultas y administración de los productos, no puede eliminar productos');

-- -----------------------------------------------------
--Alta de Usuarios automáticas
-- -----------------------------------------------------
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(1,'jhosy_admin','Jhosy','Velásquez','d1492f52432ed97d3b696bc8a229ecf53e9929813bce704aa5ae40b5fd950acf432b513c135d81b4809c853d6e5dcfd0707790683f890c4e2ff9b573a7b6ccef');
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(2,'honni_consultant','Honni','Ochoa','2061b7cb89b47b5cb5d5438fe1ef199bbdf9bf16f58b7e9e2415c563ef997b4f3939321aecb29bd8f68646e6b4403259b78309d0651e5d7c1fe6bc3365bb295d');
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(3,'kev_client','Kev','Velásquez','1085591ec5950d5312ecf1c5d06af2fae94339a64286e1b20207a4ddade6402d677afaf09cf560c710411b1b80308b767ac58a87240cc994e64e0ba89150591f');
INSERT INTO `users` (iduser,username,nombre,apellido,signpassword) VALUES(4,'fantastic_assistant','Fantastic','Project','aee2c7f16a49a8dd738beddc0df418f2e5162ec2f3c43d616af8bd217b24f2f571c4f1c2721bd9df1181c0b0acca69f0052e41009f24f1f5ad7c7f995d775c12');

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

INSERT INTO `products` VALUES(NULL,'Arepitas','Comida Venezolana',100,'ARS',15,'Active','2021-11-26 00:00:00');
INSERT INTO `products` VALUES(NULL,'Cafecito con Leche','Bebida Caliente',30,'ARS',20,'Active','2021-11-27 00:00:00');
