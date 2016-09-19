FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD "quotes2016"
ENV MYSQL_DATABASE "quotes-db"
ENV MYSQL_USER "quotesuser"
ENV MYSQL_PASSWORD "quotes2016"
COPY conf.d/ /etc/mysql/conf.d/
ADD populate_table.sql /docker-entrypoint-initdb.d/populate_table.sql
