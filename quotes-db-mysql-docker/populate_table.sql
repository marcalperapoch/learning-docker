USE quotes-db;
CREATE TABLE IF NOT EXISTS `quotes` (
  `quote_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL DEFAULT 'Unknown',
  `text` varchar(500) NOT NULL DEFAULT '',
  `votes` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`quote_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
LOCK TABLES quotes WRITE;
INSERT INTO `quotes` (`quote_id`, `author`, `text`, `votes`)
VALUES
	(1, 'Marçal Perapoch', 'Example of a quote', 0),
  (2, 'Marçal Perapoch', 'Example of a second quote', 5);
UNLOCK TABLES;
