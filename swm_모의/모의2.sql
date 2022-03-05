CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `birthday` DATE,
  `mileage` INT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
