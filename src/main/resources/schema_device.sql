CREATE TABLE device (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    system_name VARCHAR(128) NOT NULL,
    type VARCHAR(128) DEFAULT 'WINDOWS_WORKSTATION' NOT NULL,
);CREATE UNIQUE INDEX device_id_index ON device (id);
