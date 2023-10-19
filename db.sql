CREATE TABLE
    `customer`
(
    `id`       int unsigned NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) NOT NULL,
    `dob`      date         NOT NULL,
    `email`    varchar(30)  NOT NULL UNIQUE,
    `phone`    char(10)     NOT NULL,
    `password` varchar(64)  NOT NULL,
    `gender`   varchar(10)  NOT NULL,
    `district` varchar(20)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `staff`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) NOT NULL,
    `dob`        date         NOT NULL,
    `email`      varchar(30)  NOT NULL UNIQUE,
    `phone`      char(10)     NOT NULL,
    `password`   varchar(64)  NOT NULL,
    `is_manager` tinyint(1)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `item`
(
    `id`   int unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
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
    `date`        date         NOT NULL DEFAULT GETDATE(),
    `customer_id` int          NOT NULL REFERENCES customer (id) ON DELETE CASCADE,
    `status`      varchar(50)  NOT NULL,
    `assigned`    int          NOT NULL REFERENCES staff (id) ON DELETE SET NULL,
    `comment`     varchar(255),
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
    `fuel`
(
    `id`      int unsigned NOT NULL AUTO_INCREMENT,
    `type`    varchar(50)  NOT NULL,
    `subtype` varchar(50)  NOT NULL,
    `amount`  float        NOT NULL,
    `price`   double       NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fuel_amount_check` CHECK ((`amount` >= 0)),
    CONSTRAINT `fuel_price_check` CHECK ((`price` > 0))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE
    `staff`
(
    `id`         int unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) NOT NULL,
    `dob`        date         NOT NULL,
    `email`      varchar(30)  NOT NULL,
    `phone`      char(10)     NOT NULL,
    `password`   varchar(64)  NOT NULL,
    `is_manager` tinyint(1)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `item`
(
    `id`   int unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE
    `fuel`
(
    `id`      int unsigned NOT NULL AUTO_INCREMENT,
    `type`    varchar(50)  NOT NULL,
    `subtype` varchar(50)  NOT NULL,
    `amount`  int          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE
    `fuel`
    ADD
        CONSTRAINT amount_check CHECK (amount > 0);

CREATE TABLE
    `item_request`
(
    `id`       int unsigned NOT NULL AUTO_INCREMENT,
    `item_id`  int unsigned,
    `staff_id` int unsigned,
    `qty`      int          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE
    `item_request`
    ADD
        CONSTRAINT req_amount_check CHECK (qty > 0);

ALTER TABLE
    `item_request`
    ADD
        CONSTRAINT req_staff_fk FOREIGN KEY (staff_id) REFERENCES staff (id) ON DELETE
            SET
            NULL;

ALTER TABLE
    `item_request`
    ADD
        CONSTRAINT req_item_fk FOREIGN KEY (item_id) REFERENCES item (id) ON DELETE
            SET
            NULL;

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
    `appointment`
(
    `id`          int unsigned NOT NULL AUTO_INCREMENT,
    `brand`       varchar(50)  NOT NULL,
    `model`       varchar(50)  NOT NULL,
    `year`        varchar(255) NOT NULL,
    `type`        varchar(50)  NOT NULL,
    `date`        date         NOT NULL,
    `customer_id` int          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE
    `appointment`
    ADD
        CONSTRAINT appt_cus_fk FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE;
