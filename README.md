# learning-docker

This repository contains a small ```docker-compose``` example I made to discover how **Docker** works. The explanation of how all this work can be found [here](https://marcalperapoch.gitbooks.io/learning-docker/content/) where I've collected my learning notes about Docker so far

## Run

You can have the ```quotes-api``` and the ```quotes-db``` up and running using ```docker-compose```.

**First**, you should create the api ```.jar``` file:

```bash
$ cd quotes-api
$ mvn clean package
```

**Second** you need to create the corresponding Docker images for these two services. You can do it executing the attached script:

```bash
$ ./build_images.sh
```

This will create the following images:

* ```marcal.perapoch/quotes-db-mysql-docker```: which contains a MySQL database initialized with the script in ```quotes-db-mysql-docker/populate_table.sql```.

* ```marcal.perapoch/quotes-api```: that contains the Java ```.jar``` application representing the ```quotes-api```.

**Finally**, once both images have been created, you should be ready to execute:

```bash
$ docker-compose up
```
That will start up both Docker images connecting themselves as specified at the ```docker-compose.yml``` file.

If everything works fine, you should be able to call the ```quotes-api``` as follows:

```bash
$ curl "http://localhost:8090/quotes/?offset=0&limit=10"
```
> Note that we are using the ```8090``` port according to the ```docker-compose```file. Thus is to be able to run the development version in ```8080``` without port overlaping.

In a similar way, you can connect to the database hoster by our ```marcal.perapoch/quotes-db-mysql-docker``` image using the following options:

* Host:```0.0.0.0```
* Username:```quotesuser```
* Password:```quotes2016```
* Port:```3307```

> As we've done with the API port, now we are using the ```3307``` port for the database connection instead of the default one. This is also to avoid running multiple MySQL instances in the same port (which could happen if you have MySQL installed in your machine).