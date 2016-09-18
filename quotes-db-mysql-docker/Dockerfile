FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD "quotes2016"
ENV MYSQL_DATABASE "quotes-db"
ENV MYSQL_USER "quotes"
ENV MYSQL_PASSWORD "quotes2016"
ADD populate_table.sql /docker-entrypoint-initdb.d/populate_table.sql
