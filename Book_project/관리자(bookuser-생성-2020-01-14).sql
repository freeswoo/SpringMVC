create TABLESPACE bookuser_db
DATAFILE '/bizwork/oracle/data/bookuser.dbf'
size 10M AUTOEXTEND on next 10K;

CREATE user bookuser IDENTIFIED by bookuser
DEFAULT TABLESPACE bookuser_db;

GRANT DBA to bookuser;
