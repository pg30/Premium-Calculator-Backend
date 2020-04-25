create database if not exists `premiumcalculator`;
use premiumcalculator;

create table if not exists `Vehicle`(
	id int primary key,
    vehicle_name varchar(255)
);

delete from `Vehicle`;

insert into `Vehicle` (`id`,`vehicle_name`) values
(1,'Two Wheeler'),
(2,'Private Car'),
(3,'Goods Carrying Vehicle'),
(4,'Taxi upto 6 Passengers'),
(5,'Bus'),
(6,'School Bus'),
(7,'Three Wheeler GCV'),
(8,'Three Wheeler PCV'),
(9,'Miscellaneous Vehicle');

create table if not exists `Zone`(
	id int primary key,
    zone_name varchar(255)
);

delete from `Zone`;

insert into `Zone` (`id`,`zone_name`) values
(1,'A'),
(2,'B'),
(3,'C');

create table if not exists `Carrier`(
	id int primary key,
    carrier_name varchar(255)
);

delete from `Carrier`;

insert into `Carrier` (`id`,`carrier_name`) values
(1,'Public'),
(2,'Private');

create table if not exists `MiscType`(
	id int primary key,
    type_name varchar(255)
);

delete from `MiscType`;

insert into `MiscType` (`id`,`type_name`) values
(1,'Agricultural'),
(2,'Others');

create table if not exists `MiscUse`(
	id int primary key,
    use_name varchar(255)
);

delete from `MiscUse`;

insert into `MiscUse` (`id`,`use_name`) values
(1,'Tractor'),
(2,'Ambulance'),
(3,'Drilling Rigs'),
(4,'Trailer');

create table if not exists `ccRange`(
	id int primary key,
    start int,
    end int
);

delete from `ccRange`;

insert into `ccRange` (`id`,`start`,`end`) values
(1,0,75),
(2,76,150),
(3,151,350),
(4,351,5000),
(5,0,1000),
(6,1001,1500),
(7,1501,50000);

create table if not exists `passengerRange`(
	id int primary key,
    start int,
    end int
);

delete from `passengerRange`;

insert into `passengerRange` (`id`,`start`,`end`) values
(1,0,6),
(2,7,17),
(3,7,18),
(4,19,36),
(5,37,60),
(6,61,100);

create table if not exists `dayRange`(
	id int primary key,
    start int,
    end int
);

delete from `dayRange`;

insert into `dayRange` (`id`,`start`,`end`) values
(1,0,1800),
(2,1801,2520),
(3,2521,18250);

create table if not exists `weightRange`(
	id int primary key,
    start int,
    end int
);

delete from `weightRange`;

insert into `weightRange` (`id`,`start`,`end`) values
(1,0,7500),
(2,7501,12000),
(3,12001,20000),
(4,20001,40000),
(5,40001,60000);

create table if not exists `rate`(
	id int not null auto_increment,
	vehicleId int,
    zoneId int,
    carrierId int default null,
    ccId int default null,
    dayId int default null,
    passengerId int default null,
    weightId int default null,
	cost double default null,
    primary key (id),
    foreign key (vehicleId) references Vehicle(id),
    foreign key (zoneId) references Zone(id),
    foreign key (carrierId) references Carrier(id),
    foreign key (ccId) references ccRange(id),
    foreign key (dayId) references dayRange(id),
    foreign key (passengerId) references passengerRange(id),
    foreign key (weightId) references weightRange(id)
);

delete from `rate`;

# for two wheeler
insert into `rate`(`vehicleId`,`zoneId`,`ccId`,`dayId`,`cost`) values
(1,1,1,1,1.708),
(1,1,1,2,1.793),
(1,1,1,3,1.836),
(1,1,2,1,1.708),
(1,1,2,2,1.793),
(1,1,2,3,1.836),
(1,1,3,1,1.793),
(1,1,3,2,1.883),
(1,1,3,3,1.928),
(1,1,4,1,1.879),
(1,1,4,2,1.973),
(1,1,4,3,2.020),
(1,2,1,1,1.676),
(1,2,1,2,1.760),
(1,2,1,3,1.802),
(1,2,2,1,1.676),
(1,2,2,2,1.760),
(1,2,2,3,1.802),
(1,2,3,1,1.760),
(1,2,3,2,1.848),
(1,2,3,3,1.892),
(1,2,4,1,1.844),
(1,2,4,2,1.936),
(1,2,4,3,1.982);

# for private car
insert into `rate`(`vehicleId`,`zoneId`,`ccId`,`dayId`,`cost`) values
(2,1,5,1,3.127),
(2,1,5,2,3.283),
(2,1,5,3,3.362),
(2,1,6,1,3.283),
(2,1,6,2,3.447),
(2,1,6,3,3.529),
(2,1,7,1,3.440),
(2,1,7,2,3.612),
(2,1,7,3,3.698),
(2,2,5,1,3.039),
(2,2,5,2,3.191),
(2,2,5,3,3.267),
(2,2,6,1,3.191),
(2,2,6,2,3.351),
(2,2,6,3,3.430),
(2,2,7,1,3.343),
(2,2,7,2,3.510),
(2,2,7,3,3.594);

# for goods carrying vehicle
insert into `rate`(`vehicleId`,`zoneId`,`dayId`,`carrierId`,`cost`) values
(3,1,1,1,1.751),
(3,1,1,2,1.226),
(3,1,2,1,1.795),
(3,1,2,2,1.257),
(3,1,3,1,1.839),
(3,1,3,2,1.287),

(3,2,1,1,1.743),
(3,2,1,2,1.220),
(3,2,2,1,1.787),
(3,2,2,2,1.251),
(3,2,3,1,1.830),
(3,2,3,2,1.281),

(3,3,1,1,1.726),
(3,3,1,2,1.208),
(3,3,2,1,1.770),
(3,3,2,2,1.239),
(3,3,3,1,1.812),
(3,3,3,2,1.268);

# for taxi upto 6 passenger
insert into `rate`(`vehicleId`,`zoneId`,`ccId`,`dayId`,`cost`) values
(4,1,5,1,3.284),
(4,1,5,2,3.366),
(4,1,5,3,3.448),
(4,1,6,1,3.448),
(4,1,6,2,3.534),
(4,1,6,3,3.620),
(4,1,7,1,3.612),
(4,1,7,2,3.703),
(4,1,7,3,3.793),
(4,2,5,1,3.191),
(4,2,5,2,3.271),
(4,2,5,3,3.351),
(4,2,6,1,3.351),
(4,2,6,2,3.435),
(4,2,6,3,3.519),
(4,2,7,1,3.510),
(4,2,7,2,3.598),
(4,2,7,3,3.686);

# for bus
insert into `rate`(`vehicleId`,`zoneId`,`dayId`,`cost`) values
(5,1,1,1.680),
(5,1,2,1.722),
(5,1,3,1.764),
(5,2,1,1.672),
(5,2,2,1.714),
(5,2,3,1.756),
(5,3,1,1.656),
(5,3,2,1.697),
(5,3,3,1.739);

# for school bus
insert into `rate`(`vehicleId`,`zoneId`,`dayId`,`cost`) values
(6,1,1,1.680),
(6,1,2,1.722),
(6,1,3,1.764),
(6,2,1,1.672),
(6,2,2,1.714),
(6,2,3,1.756),
(6,3,1,1.656),
(6,3,2,1.697),
(6,3,3,1.739);

# for three wheeler gcv
insert into `rate`(`vehicleId`,`zoneId`,`carrierId`,`dayId`,`cost`) values
(7,1,1,1,1.664),
(7,1,1,2,1.706),
(7,1,1,3,1.747),
(7,1,2,1,1.165),
(7,1,2,2,1.194),
(7,1,2,3,1.223),
(7,2,1,1,1.656),
(7,2,1,2,1.697),
(7,2,1,3,1.739),
(7,2,2,1,1.159),
(7,2,2,2,1.188),
(7,2,2,3,1.217),
(7,3,1,1,1.640),
(7,3,1,2,1.681),
(7,3,1,3,1.722),
(7,3,2,1,1.148),
(7,3,2,2,1.177),
(7,3,2,3,1.205);

# for three wheeler pcv
insert into `rate`(`vehicleId`,`zoneId`,`passengerId`,`dayId`,`cost`) values
(8,1,1,1,1.278),
(8,1,1,2,1.310),
(8,1,1,3,1.342),
(8,1,2,1,1.785),
(8,1,2,2,1.830),
(8,1,2,3,1.874),
(8,2,1,1,1.272),
(8,2,1,2,1.304),
(8,2,1,3,1.336),
(8,2,2,1,1.777),
(8,2,2,2,1.821),
(8,2,2,3,1.866),
(8,3,1,1,1.260),
(8,3,1,2,1.292),
(8,3,1,3,1.323),
(8,3,2,1,1.759),
(8,3,2,2,1.803),
(8,3,2,3,1.847);

# for miscellaneous vehicle
insert into `rate`(`vehicleId`,`zoneId`,`dayId`,`cost`) values
(9,1,1,1.208),
(9,1,2,1.238),
(9,1,3,1.268),
(9,2,1,1.202),
(9,2,2,1.232),
(9,2,3,1.262),
(9,3,1,1.190),
(9,3,2,1.220),
(9,3,3,1.250);

create table if not exists `Tp` (
	id int not null auto_increment,
	vehicleId int,
    ccId int,
    weightId int,
    passengerId int,
    carrierId int,
    miscUseId int,
    miscTypeId int,
    cost int,
    primary key (id),
    foreign key (vehicleId) references Vehicle(id),
    foreign key (weightId) references weightRange(id),
    foreign key (carrierId) references Carrier(id),
    foreign key (ccId) references ccRange(id),
    foreign key (passengerId) references passengerRange(id),
    foreign key (miscUseId) references MiscUse(id),
    foreign key (miscTypeId) references MiscType(id)
);

delete from `Tp`;

#for two wheeler
insert into `Tp`(`vehicleId`,`ccId`,`cost`) values
(1,1,482),
(1,2,752),
(1,3,1193),
(1,4,2323);

#for private car
insert into `Tp`(`vehicleId`,`ccId`,`cost`) values
(2,5,2072),
(2,6,3221),
(2,7,7890);

#for goods carrying vehicle
insert into `Tp`(`vehicleId`,`weightId`,`carrierId`,`cost`) values
(3,1,1,15746),
(3,1,2,8438),
(3,2,1,26935),
(3,2,2,17204),
(3,3,1,33418),
(3,3,2,10876),
(3,4,1,43037),
(3,4,2,17476),
(3,5,1,41561),
(3,5,2,24825);

#for taxi upto 6 passengers
insert into `Tp`(`vehicleId`,`ccId`,`cost`) values
(4,5,5769),
(4,6,7584),
(4,7,10051);

#for bus
insert into `Tp`(`vehicleId`,`cost`) values
(5,14494);

#for school bus
insert into `Tp`(`vehicleId`,`cost`) values
(6,13874);

#for three wheeler gcv
insert into `Tp`(`vehicleId`,`carrierId`,`cost`) values
(7,1,4092),
(7,2,3914);

#for three wheeler pcv
insert into `Tp`(`vehicleId`,`passengerId`,`cost`) values
(8,1,2595),
(8,2,6913);

#for miscellaneous vehicle
insert into `Tp`(`vehicleId`,`miscUseId`,`miscTypeId`,`cost`) values
(9,1,1,6847),
(9,1,2,6847),
(9,2,1,6847),
(9,2,2,6847),
(9,3,1,6847),
(9,3,2,6847),
(9,4,1,857),
(9,4,2,2341);

create table if not exists `TpPerPassenger`(
	id int not null auto_increment,
	vehicleId int,
    ccId int,
    passengerId int,
    cost int,
    primary key (id),
    foreign key (vehicleId) references Vehicle(id),
    foreign key (ccId) references ccRange(id),
    foreign key (passengerId) references passengerRange(id)
);

delete from `TpPerPassenger`;

#for taxi upto 6 passenger
insert into `TpPerPassenger`(`vehicleId`,`ccId`,`cost`) values
(4,5,1110),
(4,6,934),
(4,7,1067);

#for three wheeler pcv
insert into `TpPerPassenger`(`vehicleId`,`passengerId`,`cost`) values
(8,1,1241),
(8,2,1379);

#for bus
insert into `TpPerPassenger`(`vehicleId`,`cost`) values
(5,886);

#for school bus
insert into `TpPerPassenger`(`vehicleId`,`cost`) values
(6,848);