FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD "testingDocker2016"
ENV MYSQL_DATABASE "random-names"
ENV MYSQL_USER "testingDocker"
ENV MYSQL_PASSWORD "randomNames2016"
ADD populate_table.sql /docker-entrypoint-initdb.d/populate_table.sql
