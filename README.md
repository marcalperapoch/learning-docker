# learning-docker

This repository contains a small ```docker-compose``` example I made to discover how **Docker** works. The explanation of how all this work can be found [here](https://marcalperapoch.gitbooks.io/learning-docker/content/) where I've collected my learning notes about Docker so far.

## Configuration

In order to have this project up and running you'll need to set up the following **environment variables** according on the environment you want them.

Remember that you can set up environment variables by editing the following file:

```bash
$ vim ~/.bash_profile
```
Adding one line for each variable that you want as:

```bash
export VAR_NAME=VAR_VALUE
```

### Quotes-api

To properly run the Java **quotes-api** you'll need to set up the following _env vars_:

* ```QUOTES_DB_HOST```: the _host_ and _port_ where the database is
* ```QUOTES_DB_NAME```: the name of the database schema
* ```QUOTES_DB_USER```: the username needed to connect to the database
* ```QUOTES_DB_PASSWORD```: the password needed to connect to the database

Example of my **development configuration**:

```bash
export QUOTES_DB_HOST=localhost:3306
export QUOTES_DB_NAME=quotes-db
export QUOTES_DB_USER=quotesuser
export QUOTES_DB_PASSWORD=quotes2016
```
