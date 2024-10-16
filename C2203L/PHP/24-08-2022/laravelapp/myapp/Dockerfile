FROM php:8.1-apache
RUN apt-get update && apt-get upgrade -y
RUN apt-get install python -y
RUN docker-php-ext-install mysqli && docker-php-ext-enable mysqli
RUN docker-php-ext-install pdo pdo_mysql && docker-php-ext-enable pdo_mysql

