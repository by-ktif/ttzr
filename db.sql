delimiter $$

CREATE DATABASE `ttlz` /*!40100 DEFAULT CHARACTER SET utf8 */$$

CREATE TABLE `z_tournaments` (
  `id` int(11) NOT NULL,
  `espn_id` varchar(15) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `sport_cat` int(11) NOT NULL DEFAULT '1',
  `link1` varchar(45) DEFAULT NULL,
  `link2` varchar(45) DEFAULT NULL,
  `link3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


CREATE TABLE `z_competitors` (
  `id` int(11) NOT NULL,
  `espn_id` varchar(15) NOT NULL,
  `name` varchar(25) NOT NULL,
  `city` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `details` varchar(45) DEFAULT NULL,
  `logo_url` varchar(95) DEFAULT NULL,
  `link1` varchar(95) DEFAULT NULL,
  `link2` varchar(95) DEFAULT NULL,
  `link3` varchar(95) DEFAULT NULL,
  `sport_cat` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


CREATE TABLE `z_games` (
  `id` int(11) NOT NULL,
  `espn_id` varchar(15) DEFAULT NULL,
  `tournament_id` int(11) NOT NULL,
  `competitorA_id` int(11) NOT NULL,
  `competitorB_id` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `link1` varchar(95) DEFAULT NULL,
  `link2` varchar(95) DEFAULT NULL,
  `link3` varchar(95) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

