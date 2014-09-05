USE FlightSupportSystem;


DELETE FROM Seat;

DELETE FROM ServiceClass;

DELETE FROM Bonus;

DELETE FROM ParticularFlight;

DELETE FROM Flight;

DELETE FROM Airport;

DELETE FROM Airline;

DELETE FROM Client;


INSERT INTO Client VALUES (Null, 'vasyapetr', 'qwerty@1', 'Vasiliy', 'Petrovich', 'Terescenko', NULL, '+79167247259', 'teres_vp@gmail.com');
INSERT INTO Client VALUES (Null, 'eagle_eye', 'cruelssd', 'Anna', 'Nicolaevna', 'Orlova', 'Moscow, Pivnaya street 25', '+79639359236', 'gloomy@ya.ru');
INSERT INTO Client VALUES (Null, 'chronos', 'dwell', 'Svetlana', 'Fillipovna', 'Hromova', NULL, '+79156299471', NULL);
INSERT INTO Client VALUES (Null, 'bobobo', 'rb-dash', 'Nicolai', 'Antonovich', 'Boboshko', NULL, NULL, 'boboshko.nicola@gmail.com');
INSERT INTO Client VALUES (Null, 'klimov.ia', 'qhostrider', 'Ilya', 'Andreevich', 'Klimov', NULL, NULL, NULL);
INSERT INTO Client VALUES (Null, 'stupinoleg', 'vodoley', 'Oleg', 'Victorovich', 'Stupin', 'Moscow, Moroseyka street 33', NULL, 'stupin@sed.mwh.ru');

INSERT INTO Airline VALUES (Null, 'AirBerlin');
INSERT INTO Airline VALUES (Null, 'Lufthansa');

INSERT INTO Airport VALUES (NULL, 'Domodedovo', 'Moscow', '+74952745619');
INSERT INTO Airport VALUES (NULL, 'Vnukovo', 'Moscow', '+74998255340');
INSERT INTO Airport VALUES (NULL, 'Tegel', 'Berlin', '+497359925401');
INSERT INTO Airport VALUES (NULL, 'Schonefeld', 'Berlin', '+497355644662');

INSERT INTO Flight VALUES (NULL, 'AJ8946', 1, 1, 3, 10665);
INSERT INTO Flight VALUES (NULL, 'FL7492', 1, 4, 2, 12046);
INSERT INTO Flight VALUES (NULL, 'KE1863', 2, 1, 3, 11300);

INSERT INTO ParticularFlight VALUES (NULL, 1, '2014-05-12 06:50:00', '2014-05-12 11:22:00');
INSERT INTO ParticularFlight VALUES (NULL, 1, '2014-05-12 17:32:00', '2014-05-12 22:04:00');
INSERT INTO ParticularFlight VALUES (NULL, 2, '2014-04-12 12:10:00', '2014-04-12 18:55:00');
INSERT INTO ParticularFlight VALUES (NULL, 2, '2014-05-12 21:04:00', '2014-05-13 03:00:00');
INSERT INTO ParticularFlight VALUES (NULL, 3, '2014-05-12 09:10:00', '2014-05-12 15:10:00');

INSERT INTO Bonus VALUES (NULL, '1240058474', 1, 1, 12500);
INSERT INTO Bonus VALUES (NULL, '1441124424', 1, 3, 22000);
INSERT INTO Bonus VALUES (NULL, '5123423134', 2, 1, DEFAULT);
INSERT INTO Bonus VALUES (NULL, '0946472552', 2, 5, 17940);

INSERT INTO ServiceClass VALUES (NULL, 1, 'buisness', 1.7, 8200.5);
INSERT INTO ServiceClass VALUES (NULL, 1, 'econom', 1.0, 4400.2);
INSERT INTO ServiceClass VALUES (NULL, 2, 'buisness', 1.7, 8500.0);
INSERT INTO ServiceClass VALUES (NULL, 2, 'econom', 1.0, 4710.2);
INSERT INTO ServiceClass VALUES (NULL, 3, 'econom', 1.0, 5100.5);
INSERT INTO ServiceClass VALUES (NULL, 4, 'econom', 1.0, 5100.5);
INSERT INTO ServiceClass VALUES (NULL, 5, 'econom', 1.0, 4700.5);

INSERT INTO Seat VALUES (NULL, 1, 12, 'A', DEFAULT, NULL);
INSERT INTO Seat VALUES (NULL, 1, 12, 'B', DEFAULT, NULL);
INSERT INTO Seat VALUES (NULL, 1, 15, 'B', 1, 1);
INSERT INTO Seat VALUES (NULL, 1, 15, 'E', 2, 3);
INSERT INTO Seat VALUES (NULL, 1, 03, 'C', 1, 2);
INSERT INTO Seat VALUES (NULL, 2, 11, 'A', DEFAULT, NULL);
INSERT INTO Seat VALUES (NULL, 2, 11, 'B', DEFAULT, NULL);
INSERT INTO Seat VALUES (NULL, 2, 15, 'A', 2, 6);
INSERT INTO Seat VALUES (NULL, 6, 02, 'C', DEFAULT, NULL);