-- item
INSERT INTO item (`id`, `name`, `in_stock`)
VALUES ('V001', 'Car Battery (Exide)', 100.00),
       ('V002', 'Engine Oil (Castrol)', 25.00),
       ('V003', 'Brake Pads (Brembo)', 35.00),
       ('V004', 'Spark Plugs (NGK)', 5.00),
       ('V005', 'Air Filter (Fram)', 15.00),
       ('V006', 'Transmission Fluid (Mobil 1)', 20.00),
       ('V007', 'Tires (Set of 4, Michelin)', 400.00),
       ('V008', 'Radiator Coolant (Prestone)', 10.00),
       ('V009', 'Windshield Wipers (Bosch)', 12.00),
       ('V010', 'Alternator (Denso)', 120.00),
       ('V011', 'Car Battery (ACDelco)', 95.00),
       ('V012', 'Engine Oil (Valvoline)', 28.00),
       ('V013', 'Brake Pads (Wagner)', 40.00),
       ('V014', 'Spark Plugs (Bosch)', 6.00),
       ('V015', 'Air Filter (Purolator)', 14.00),
       ('V016', 'Transmission Fluid (Pennzoil)', 22.00),
       ('V017', 'Tires (Set of 4, Goodyear)', 420.00),
       ('V018', 'Radiator Coolant (Zerex)', 11.00),
       ('V019', 'Windshield Wipers (Rain-X)', 13.00),
       ('V020', 'Alternator (ACDelco)', 125.00);
--fuel
insert into `fuel` (`amount`, `id`, `price`, `type`) values (1110, 1, 180, 'Petrol 92');
insert into `fuel` (`amount`, `id`, `price`, `type`) values (1230, 2, 210, 'Petrol 95');
insert into `fuel` (`amount`, `id`, `price`, `type`) values (999.89, 3, 200, 'Diesel');