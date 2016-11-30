# Environment Varibles
QUOTES_DB_HOST=localhost:3306
QUOTES_DB_NAME=quotes-db
QUOTES_DB_USER=quotesuser
QUOTES_DB_PASSWORD=quotes2016

.PHONY: up

prep :
	mkdir -p \
		data/whisper \
		data/elasticsearch \
		data/grafana \
		log/graphite \
		log/graphite/webapp \
		log/elasticsearch

pull :
	docker-compose pull

up : prep pull
	docker-compose up -d

down :
	docker-compose down

shell :
	docker exec -ti $(CONTAINER) /bin/bash

tail :
	docker logs -f $(CONTAINER)