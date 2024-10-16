services:
  sqlserver2022:
    image: mcr.microsoft.com/mssql/server:2022-latest
    container_name: sqlserver-2022
    environment:
      ACCEPT_EULA: 'Y'
      SA_PASSWORD: 'Abc123456789'
    ports:
      - "1433:1433"
    volumes:
      - ./sql_data:/var/opt/mssql
      - ./init-db.sh:/init-db.sh
      - ./init.sql:/init.sql
    #command:
      #- /bin/bash
      #- /init-db.sh
volumes:
  sql_data:
    driver: local

#/var/www/MyApp/