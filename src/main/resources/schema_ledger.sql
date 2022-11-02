CREATE TABLE ledger
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_service INTEGER DEFAULT 0 NOT NULL,
    unit_price DOUBLE(10,2) DEFAULT 0 NOT NULL,
    total_price DOUBLE(10,2) DEFAULT 0 NOT NULL,
    quantity INTEGER DEFAULT 0 NOT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) ENGINE=INNODB;
CREATE UNIQUE INDEX ledger_id_index ON ledger (id);
