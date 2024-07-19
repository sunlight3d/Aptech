#!/bin/bash
# Wait for SQL Server to start
for i in {1..50};
do
    /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'Abc123456789' -Q "SELECT 1" && break
    sleep 1
done

# Run the SQL script
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'Abc123456789' -i /init.sql