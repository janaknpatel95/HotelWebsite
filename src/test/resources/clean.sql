delete from user;
delete from reservation;
delete from room;

INSERT INTO `user` VALUES (1,'janak','patel','jpate@some.com','6089638522','1013 8th street, baraboo, wi','has reservasion','jpatel','jpatel'),(2,'jackk','ptel','jate@some.com','6049638522','1014 8th street, baraboo, wi','has reseasion','jpatel1','jpatel2');
INSERT INTO `reservation` VALUES (1,1,'2019-10-21','2020-10-22',50.00),(2,2,'2019-10-21','2020-10-22',50.00);
INSERT INTO `room` VALUES (1,'kqueen','2 queen bed',60.00,2,'2020-12-06'),(2,'2queen','2 queen bed',60.00,2,'2020-12-07');
