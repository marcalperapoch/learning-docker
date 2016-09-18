USE random-names;
CREATE TABLE IF NOT EXISTS names (
  `name_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
LOCK TABLES names WRITE;
INSERT INTO names (value)
  VALUES
    ('pepe'),
    ('jordi'),
    ('pere'),
    ('miquel');
UNLOCK TABLES;
