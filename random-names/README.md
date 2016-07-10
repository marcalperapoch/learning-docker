#Playing with Docker & Java

1) Generate the java JAR file
```maven
$> cd random-names/
$> mvn clean package
```

2) Build the Docker Image

```docker
$> docker build -t marcal.perapoch/random-names .
```

3) Run a Docker container on port 8080
```docker
$> docker run -d --name random-names -p 8080:8080 marcal.perapoch/random-names
```

4) Verify that the container is running
```docker
$> docker ps
```

5) Call example
```bash
$> curl -0 http://localhost:8080/random_names/generate/10
```
