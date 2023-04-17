DROP TABLE User,
    Ceb_Assignment_History, Ceb_Vehicle_Info, Repair_History,
    Private_Vehicle_Info, Payment_History, Private_Assignment_History;

CREATE TABLE IF NOT EXISTS User(
    pf_number INT PRIMARY KEY ,
    password VARCHAR(15) NOT NULL ,
    role ENUM('ADMIN', 'USER') NOT NULL
);

CREATE TABLE IF NOT EXISTS Ceb_Vehicle_Info(
    ceb_registration_number VARCHAR(15) PRIMARY KEY,
    location VARCHAR(20) NOT NULL,
    type VARCHAR(15) NOT NULL ,
    chassis_number VARCHAR(30) NOT NULL ,
    engine_number VARCHAR(30) NOT NULL ,
    manufacture_year INT NOT NULL,
    comments VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS Ceb_Assignment_History(
    id INT AUTO_INCREMENT,
    reg_num VARCHAR(50) NOT NULL ,
    assigned_location VARCHAR(50) NOT NULL ,
    vehicle_type VARCHAR(15) NOT NULL ,
    assigned_date DATE NOT NULL,
    comments VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (reg_num) REFERENCES Ceb_Vehicle_Info(ceb_registration_number)
);

CREATE TABLE IF NOT EXISTS Repair_History(
    id INT AUTO_INCREMENT,
    reg_num VARCHAR(50) NOT NULL ,
    repair_date DATE,
    description VARCHAR(500),
    cost DECIMAL(10,2) NOT NULL,
    payment_slip_no VARCHAR(25),
    PRIMARY KEY(id),
    FOREIGN KEY (reg_num) REFERENCES Ceb_Vehicle_Info(ceb_registration_number)
);

CREATE TABLE IF NOT EXISTS Private_Vehicle_Info(
   private_registration_number VARCHAR(15) PRIMARY KEY,
   person VARCHAR(50) NOT NULL,
   type VARCHAR(15) NOT NULL ,
   contractor_name VARCHAR(50) NOT NULL,
   comments VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS Private_Assignment_History(
     id INT AUTO_INCREMENT,
     reg_num VARCHAR(50) NOT NULL ,
     person VARCHAR(50) NOT NULL ,
     vehicle_type VARCHAR(15) NOT NULL ,
     date DATE NOT NULL,
     comments VARCHAR(500),
     PRIMARY KEY (id),
     FOREIGN KEY (reg_num) REFERENCES Private_Vehicle_Info(private_registration_number)
);

CREATE TABLE IF NOT EXISTS Payment_History(
     id INT AUTO_INCREMENT,
     reg_num VARCHAR(50) NOT NULL ,
     date DATE NOT NULL,
     description VARCHAR(500) NOT NULL,
     amount DECIMAL(10,2) NOT NULL,
     distance INT NOT NULL,
     PRIMARY KEY(id),
     FOREIGN KEY (reg_num) REFERENCES Private_Vehicle_Info(private_registration_number)
);

# mock data
INSERT INTO User (pf_number, password, role)
VALUES
(265165, 'iamadmin', 'ADMIN'),
(22222,'amauser' , 'USER');

INSERT INTO Ceb_Vehicle_Info (ceb_registration_number, location, type, chassis_number, engine_number, manufacture_year, comments)
VALUES
('BCM-2234', 'Area Office', 'Van', '338924983498', '383948394',2003, 'none' ),
('BCM-1111', 'Baddegama CSC', 'Van', '338924983498', '383948394',2004, 'Kabalak gaththe' );

INSERT INTO Ceb_Assignment_History (reg_num, assigned_location, vehicle_type, assigned_date, comments)
VALUES
('BCM-2234','Area Office', 'Van', DATE('2023-03-27'), 'none'),
('BCM-1111', 'Baddegama CSC' , 'Van' , DATE('2023-03-27'), 'first assignment');

INSERT INTO Repair_History ( reg_num, repair_date, description, cost, payment_slip_no)
VALUES
('BCM-2234', DATE('2023-03-27') ,'something related to the engine', 33435, '4345345234423' ),
('BCM-2234',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
('BCM-1111',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
('BCM-1111',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
('BCM-2234',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
('BCM-2234',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' );