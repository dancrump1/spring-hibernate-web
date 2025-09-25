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

SET FOREIGN_KEY_CHECKS = 1;