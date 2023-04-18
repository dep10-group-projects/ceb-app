# DROP TABLE IF EXISTS User, Ceb_Vehicle, Private_Vehicle,
#     Ceb_Assignment_History,  Repair_History, Payment_History, Private_Assignment_History;
#
# DROP TABLE IF EXISTS Vehicle;

CREATE TABLE IF NOT EXISTS User(
    pf_number INT PRIMARY KEY ,
    password VARCHAR(15) NOT NULL ,
    role ENUM('ADMIN', 'USER') NOT NULL
);

CREATE TABLE IF NOT EXISTS Vehicle(
    registration_number VARCHAR(15) PRIMARY KEY ,
    owner ENUM ('CEB', 'PRIVATE') NOT NULL ,
    type VARCHAR(15) NOT NULL ,
    assigned_date DATE NOT NULL,
    comments VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS Ceb_Vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ceb_registration_number VARCHAR(15) NOT NULL ,
    location VARCHAR(20) NOT NULL,
    chassis_number VARCHAR(30) NOT NULL ,
    engine_number VARCHAR(30) NOT NULL ,
    manufacture_year INT NOT NULL,
    FOREIGN KEY (ceb_registration_number) REFERENCES Vehicle(registration_number)
);

CREATE TABLE IF NOT EXISTS Private_Vehicle(
    id INT PRIMARY KEY AUTO_INCREMENT,
    private_registration_number VARCHAR(15) NOT NULL,
    person VARCHAR(50) NOT NULL,
    contractor_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (private_registration_number) REFERENCES Vehicle(registration_number)
);


CREATE TABLE IF NOT EXISTS Ceb_Assignment_History(
    id INT AUTO_INCREMENT,
    reg_num VARCHAR(50) NOT NULL ,
    assigned_location VARCHAR(50) NOT NULL ,
    vehicle_type VARCHAR(15) NOT NULL ,
    assigned_date DATE NOT NULL,
    comments VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (reg_num) REFERENCES Vehicle(registration_number)
);

CREATE TABLE IF NOT EXISTS Repair_History(
    id INT AUTO_INCREMENT,
    reg_num VARCHAR(50) NOT NULL ,
    repair_date DATE,
    description VARCHAR(500),
    cost DECIMAL(10,2) NOT NULL,
    payment_slip_no VARCHAR(25),
    PRIMARY KEY(id),
    FOREIGN KEY (reg_num) REFERENCES Vehicle(registration_number)
);

CREATE TABLE IF NOT EXISTS Private_Assignment_History(
     id INT AUTO_INCREMENT,
     reg_num VARCHAR(50) NOT NULL ,
     person VARCHAR(50) NOT NULL ,
     vehicle_type VARCHAR(15) NOT NULL ,
     date DATE NOT NULL,
     comments VARCHAR(500),
     PRIMARY KEY (id),
     FOREIGN KEY (reg_num) REFERENCES Vehicle(registration_number)
);

CREATE TABLE IF NOT EXISTS Payment_History(
     id INT AUTO_INCREMENT,
     reg_num VARCHAR(50) NOT NULL ,
     date DATE NOT NULL,
     description VARCHAR(500) NOT NULL,
     amount DECIMAL(10,2) NOT NULL,
     distance INT NOT NULL,
     PRIMARY KEY(id),
     FOREIGN KEY (reg_num) REFERENCES Vehicle(registration_number)
);

# # mock data
# INSERT INTO User (pf_number, password, role)
# VALUES
# (265165, 'iamadmin', 'ADMIN'),
# (22222,'amauser' , 'USER');
#
# INSERT INTO Vehicle (registration_number, owner, type, comments, assigned_date)
# VALUES
# ('ABC-111','CEB', 'Van', '-' , DATE('2001-02-22')),
# ('xxx-3222','CEB', 'Lorry', 'Aluten gattata kabalak' , DATE('2003-03-22') ),
# ('BBB-2222', 'PRIVATE' , 'Car', 'It Was a cool car', DATE('2003-03-22')),
# ('WWW-3324', 'PRIVATE' , 'Car', 'Ganan yanna kalin gatte', DATE('2003-03-22'));
#
# INSERT INTO Ceb_Vehicle (ceb_registration_number, location, chassis_number, engine_number, manufacture_year)
# VALUES
# ('ABC-111', 'Area Office', '338924983498', '383948394', 2004 ),
# ('xxx-3222', 'Baddegama CSC', '338924983498', '383948394', 2000);
#
# INSERT INTO Private_Vehicle (private_registration_number, person, contractor_name)
# VALUES
# ('BBB-2222', 'EE-Area Office', 'Sirimal'),
# ('xxx-3222', 'EA-Baddegama CSC', 'Baappage putha');
#
#
# INSERT INTO Ceb_Assignment_History (reg_num, assigned_location, vehicle_type, assigned_date, comments)
# VALUES
# ('ABC-111','Area Office', 'Van', DATE('2023-03-27') , 'none'),
# ('xxx-3222', 'Baddegama CSC' , 'Lorry' , DATE('2023-03-27'), 'first assignment');
#
# INSERT INTO Private_Assignment_History (reg_num, person, vehicle_type, date, comments)
# VALUES
# ('BBB-2222','EE-Area Office', 'Car', DATE('2017-03-02'), 'Assigned due to immediate requirement' ),
# ('xxx-3222','EA-Baddegama CSC', 'Car', DATE('2017-03-02'), 'Assigned due to immediate requirement' );
#
#
# INSERT INTO Repair_History ( reg_num, repair_date, description, cost, payment_slip_no)
# VALUES
# ('ABC-111', DATE('2023-03-27') ,'something related to the engine', 33435, '4345345234423' ),
# ('xxx-3222',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
# ('ABC-111',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
# ('xxx-3222',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
# ('ABC-111',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
# ('xxx-3222',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' );
#
# INSERT INTO Payment_History (reg_num, date, description, amount, distance)
# VALUES
# ('BBB-2222',DATE('2023-03-27'), 'nothing to say', 3332.33, 323 ),
# ('WWW-3324',DATE('2023-03-27'), 'nothing to say', 3332.33, 323 ),
# ('BBB-2222',DATE('2023-04-27'), 'nothing to say', 3332.33, 323 ),
# ('WWW-3324',DATE('2023-04-27'), 'nothing to say', 3332.33, 323 );