CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `father_name` varchar(25) DEFAULT NULL,
  `mother_name` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `date_of_birth` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
); 
