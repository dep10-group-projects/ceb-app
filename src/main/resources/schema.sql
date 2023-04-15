CREATE TABLE IF NOT EXISTS User(
    pf_number INT PRIMARY KEY ,
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


