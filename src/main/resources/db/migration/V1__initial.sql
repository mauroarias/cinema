DROP TABLE IF EXISTS `films`;
DROP TABLE IF EXISTS `actors`;

CREATE TABLE films (
    id INT(11) NOT NULL AUTO_INCREMENT,
    titre VARCHAR(20) DEFAULT NULL,
    description VARCHAR(150) DEFAULT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE actors (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) DEFAULT NULL,
    last_name VARCHAR(40) DEFAULT NULL,
    film_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY `actor_film` (`id`, `film_id`),
    CONSTRAINT `film_fk` FOREIGN KEY (`film_id`) REFERENCES `films` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);
