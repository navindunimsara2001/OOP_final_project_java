CREATE TABLE
    `customer`
(
    `id`       int unsigned NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) NOT NULL,
    `dob`      date         NOT NULL,
    `email`    varchar(30)  NOT NULL,
    `phone`    char(10)     NOT NULL,
    `password` varchar(64)  NOT NULL,
    `gender`   varchar(10)  NOT NULL,
    `district` varchar(20)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `fuel`
(
    `id`     int unsigned NOT NULL AUTO_INCREMENT,
    `type`   varchar(50)  NOT NULL,
    `amount` float        NOT NULL,
    `price`  double       NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fuel_amount_check` CHECK ((`amount` >= 0)),
    CONSTRAINT `fuel_price_check` CHECK ((`price` > 0))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `item`
(
    `id`       int unsigned NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) NOT NULL,
    `in_stock` tinyint(1) DEFAULT '1',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `staff`
(
    `id`       int unsigned NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) NOT NULL,
    `dob`      date         NOT NULL,
    `email`    varchar(30)  NOT NULL,
    `phone`    char(10)     NOT NULL,
    `password` varchar(64)  NOT NULL,
    `role`     int          NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `item_request`
(
    `id`       int unsigned NOT NULL AUTO_INCREMENT,
    `item_id`  int unsigned DEFAULT NULL,
    `staff_id` int unsigned DEFAULT NULL,
    `qty`      int          NOT NULL,
    PRIMARY KEY (`id`),
    KEY `req_staff_fk` (`staff_id`),
    KEY `req_item_fk` (`item_id`),
    CONSTRAINT `req_item_fk` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE
        SET
        NULL,
    CONSTRAINT `req_staff_fk` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`) ON DELETE
        SET
        NULL,
    CONSTRAINT `req_amount_check` CHECK ((`qty` > 0))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `appointment`
(
    `id`          int unsigned NOT NULL AUTO_INCREMENT,
    `brand`       varchar(50)  NOT NULL,
    `model`       varchar(50)  NOT NULL,
    `year`        varchar(255) NOT NULL,
    `type`        varchar(50)  NOT NULL,
    `date`        date         NOT NULL,
    `customer_id` int          NOT NULL,
    `status`      varchar(50)  DEFAULT NULL,
    `assigned`    int unsigned DEFAULT NULL,
    `comment`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `appt_staff_FK` (`assigned`),
    CONSTRAINT `appt_cus_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
    CONSTRAINT `appt_staff_FK` FOREIGN KEY (`assigned`) REFERENCES `staff` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci