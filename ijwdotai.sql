DROP SCHEMA IF EXISTS `ijwdotai`;
CREATE SCHEMA `ijwdotai`;

USE `ijwdotai`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `categories`(
`id` int NOT NULL auto_increment,
`title` varchar(55) DEFAULT NULL,
`description` varchar(256) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `components`(
`id` int NOT NULL auto_increment,
`title` varchar(55) DEFAULT NULL,
`description` varchar(455) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `tags` (
`id` int NOT NULL auto_increment,
`title` varchar(55) DEFAULT NULL,
`description` varchar(455) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `category_component`(
`category_id` int NOT NULL,
`component_id` int NOT NULL,

PRIMARY KEY (`category_id`, `component_id`),

KEY `FK_CATEGORY_idx` (`category_id`),

CONSTRAINT `FK_CATEGORY` foreign key (`category_id`)
references `category` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_COMPONENT` foreign key (`component_id`)
references `component` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION



) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;