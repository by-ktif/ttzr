CREATE DATABASE `ttlz` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `ttlz`.`z_leagues` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `sport_cat` int(3) NOT NULL DEFAULT '1',
  `espn_id` varchar(15) DEFAULT NULL,
  `link1` varchar(95) DEFAULT NULL,
  `link2` varchar(95) DEFAULT NULL,
  `link3` varchar(95) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `ttlz`.`z_teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `city` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `details` varchar(45) DEFAULT NULL,
  `logo_url` varchar(95) DEFAULT NULL,
  `espn_id` varchar(15) DEFAULT NULL,
  `link1` varchar(95) DEFAULT NULL,
  `link2` varchar(95) DEFAULT NULL,
  `link3` varchar(95) DEFAULT NULL,
  `sport_cat` int(3) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `ttlz`.`z_games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `league_id` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  `teamA_id` int(11) NOT NULL,
  `teamB_id` int(11) NOT NULL,
  `scoreA` int(4) NOT NULL DEFAULT '-1',
  `scoreB` int(4) NOT NULL DEFAULT '-1',
  `location` varchar(45) DEFAULT NULL,
  `espn_id` varchar(15) DEFAULT NULL,
  `link1` varchar(95) DEFAULT NULL,
  `link2` varchar(95) DEFAULT NULL,
  `link3` varchar(95) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ttlz`.`z_bets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tournament_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `betA` int(4) NOT NULL DEFAULT '-1',
  `betB` int(4) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ttlz`.`z_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ttlz`.`z_tournaments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `league_id` int(11) NOT NULL,
  `point_system_code` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ttlz`.`z_users_tournaments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `tournament_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;