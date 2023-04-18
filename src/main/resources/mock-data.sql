# mock data
INSERT INTO User (pf_number, password, role)
VALUES
(265165, 'iamadmin', 'ADMIN'),
(22222,'amauser' , 'USER');

INSERT INTO Vehicle (registration_number, owner, type, comments, assigned_date)
VALUES
    ('ABC-111','CEB', 'Van', '-' , DATE('2001-02-22')),
    ('xxx-3222','CEB', 'Lorry', 'Aluten gattata kabalak' , DATE('2003-03-22') ),
    ('BBB-2222', 'PRIVATE' , 'Car', 'It Was a cool car', DATE('2003-03-22')),
    ('WWW-3324', 'PRIVATE' , 'Car', 'Ganan yanna kalin gatte', DATE('2003-03-22'));

INSERT INTO Ceb_Vehicle (ceb_registration_number, location, chassis_number, engine_number, manufacture_year)
VALUES
    ('ABC-111', 'Area Office', '338924983498', '383948394', 2004 ),
    ('xxx-3222', 'Baddegama CSC', '338924983498', '383948394', 2000);

INSERT INTO Private_Vehicle (private_registration_number, person, contractor_name)
VALUES
    ('BBB-2222', 'EE-Area Office', 'Sirimal'),
    ('xxx-3222', 'EA-Baddegama CSC', 'Baappage putha');


INSERT INTO Ceb_Assignment_History (reg_num, assigned_location, vehicle_type, assigned_date, comments)
VALUES
    ('ABC-111','Area Office', 'Van', DATE('2023-03-27') , 'none'),
    ('xxx-3222', 'Baddegama CSC' , 'Lorry' , DATE('2023-03-27'), 'first assignment');

INSERT INTO Private_Assignment_History (reg_num, person, vehicle_type, date, comments)
VALUES
    ('BBB-2222','EE-Area Office', 'Car', DATE('2017-03-02'), 'Assigned due to immediate requirement' ),
    ('xxx-3222','EA-Baddegama CSC', 'Car', DATE('2017-03-02'), 'Assigned due to immediate requirement' );


INSERT INTO Repair_History ( reg_num, repair_date, description, cost, payment_slip_no)
VALUES
    ('ABC-111', DATE('2023-03-27') ,'something related to the engine', 33435, '4345345234423' ),
    ('xxx-3222',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
    ('ABC-111',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
    ('xxx-3222',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
    ('ABC-111',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' ),
    ('xxx-3222',DATE('2023-03-27'),'something related to the engine', 33435, '4345345234423' );

INSERT INTO Payment_History (reg_num, date, description, amount, distance)
VALUES
    ('BBB-2222',DATE('2023-03-27'), 'nothing to say', 3332.33, 323 ),
    ('WWW-3324',DATE('2023-03-27'), 'nothing to say', 3332.33, 323 ),
    ('BBB-2222',DATE('2023-04-27'), 'nothing to say', 3332.33, 323 ),
    ('WWW-3324',DATE('2023-04-27'), 'nothing to say', 3332.33, 323 );