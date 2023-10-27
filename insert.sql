-- item
INSERT INTO item (`id`, `name`, `in_stock`)
VALUES (01, 'Car Battery (Exide)', 100.00),
       (02, 'Engine Oil (Castrol)', 25.00),
       (03, 'Brake Pads (Brembo)', 35.00),
       (04, 'Spark Plugs (NGK)', 5.00),
       (05, 'Air Filter (Fram)', 15.00),
       (06, 'Transmission Fluid (Mobil 1)', 20.00),
       (07, 'Tires (Set of 4, Michelin)', 400.00),
       (08, 'Radiator Coolant (Prestone)', 10.00),
       (09, 'Windshield Wipers (Bosch)', 12.00),
       (10, 'Alternator (Denso)', 120.00),
       (11, 'Car Battery (ACDelco)', 95.00),
       (12, 'Engine Oil (Valvoline)', 28.00),
       (13, 'Brake Pads (Wagner)', 40.00),
       (14, 'Spark Plugs (Bosch)', 6.00),
       (15, 'Air Filter (Purolator)', 14.00),
       (16, 'Transmission Fluid (Pennzoil)', 22.00),
       (17, 'Tires (Set of 4, Goodyear)', 420.00),
       (18, 'Radiator Coolant (Zerex)', 11.00),
       (19, 'Windshield Wipers (Rain-X)', 13.00),
       (20, 'Alternator (ACDelco)', 125.00);
-- fuel
insert into `fuel` (`amount`, `id`, `price`, `type`) values (1110, 1, 180, 'Petrol 92');
insert into `fuel` (`amount`, `id`, `price`, `type`) values (1230, 2, 210, 'Petrol 95');
insert into `fuel` (`amount`, `id`, `price`, `type`) values (999.89, 3, 200, 'Diesel');
<<<<<<< HEAD
=======

INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (1,'admin1234','2001-02-02','admin@gmail.com','0771234567','admin',2);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (2,'Ayomal Weerasinghe','2001-09-12','ayamal@gmail.com','0771237650','changeThis',1);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (3,'Yehan Jayasundara','2002-08-14','yehan@gmail.com','0773458712','changeThis',1);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (4,'Vidsara Shahara','2001-07-06','vidsara@gmail.com','0716582019','changeThis',1);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (5,'Savinda Gamage','2000-10-18','save@gmail.com','0712132543','changeThis',1);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (6,'Nimnada Kularathne','2002-11-18','nimnada@gmail.com','0776736543','changeThis',1);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (7,'Kamal Gunarathne','1974-12-04','kg@gmail.com','0766746532','changeThis',0);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (8,'Mahinda Rajapaksa','1959-10-14','mahi@gmail.com','0412343543','changeThis',0);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (9,'Sajith Premadasa','1968-05-15','sajiya@gmail.com','0763242534','changeThis',0);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (10,'Anura Dissanayake','1970-01-21','anura@gmail.com','0112343678','changeThis',0);
INSERT INTO `staff` (`id`,`name`,`dob`,`email`,`phone`,`password`,`role`) VALUES (11,'Diana Kumarasinghe','1986-11-05','diana@gmail.com','0714352678','changeThis',0);

INSERT INTO `customer` (`id`,`name`,`dob`,`email`,`phone`,`password`,`gender`,`district`) VALUES (1,'Hemal Perera','1987-05-20','hemal@gmail.com','0912348640','hemal123','male','Galle');
>>>>>>> d6ea2fc32d84bca8df92558952a8122026a1b1db
