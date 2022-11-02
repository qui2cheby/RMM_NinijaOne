RMM_NINJA_ONE: CRUD OF DEVICE, CREATE AND DELETE SERVICE, Calculate Monthly Services.
====================================================

RMM API to provide functionality related to business domain for Devices, Services.
## Build project:

```mvn clean package```

## Running the tests:

```mvn test```

### SQL initial setup

```sql
INSERT INTO device (id, system_name, type) VALUES (1, 'Windows 10', 'Windows Workstation');
INSERT INTO device (id, system_name, type) VALUES (2, 'Windows Server 2022', 'Windows Server');
INSERT INTO device (id, system_name, type) VALUES (3, 'macOs Monterrey', 'Mac');

INSERT INTO service (id, service_name, price, id_device) VALUES (1, 'Device', 4.0, 1);
INSERT INTO service (id, service_name, price, id_device) VALUES (2, 'Antivirus Windows', 5.0, 1);
INSERT INTO service (id, service_name, price, id_device) VALUES (3, 'Antivirus Mac', 7.0, 3);
INSERT INTO service (id, service_name, price, id_device) VALUES (4, 'Backup', 3.0, 1);
INSERT INTO service (id, service_name, price, id_device) VALUES (5, 'PSA', 2.0, 2);
INSERT INTO service (id, service_name, price, id_device) VALUES (6, 'Screen Share', 1.0, 2);

INSERT INTO ledger (id, id_service, unit_price, total_price, quantity, created) 
VALUES (1, 1, 4, 20, 5, '2022-11-01 23:22:46');
INSERT INTO ledger (id, id_service, unit_price, total_price, quantity, created)
VALUES (2, 2, 5, 10, 2, '2022-11-01 23:22:46');
INSERT INTO ledger (id, id_service, unit_price, total_price, quantity, created)
VALUES (3, 3, 7, 21, 3, '2022-11-01 23:22:46');
INSERT INTO ledger (id, id_service, unit_price, total_price, quantity, created)
VALUES (4, 4, 3, 15, 5, '2022-11-01 23:22:46');
INSERT INTO ledger (id, id_service, unit_price, total_price, quantity, created)
VALUES (5, 6, 1, 5, 5, '2022-11-01 23:22:46');

```





