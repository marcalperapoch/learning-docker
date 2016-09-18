# quotes-api

The aim of this project is to build a **Java 8 REST API** using [fluent-http](https://github.com/CodeStory/fluent-http) that connects to a MySQL database in order to retrieve and serve some quotes.

You can perform the following calls to the **quotes-api**:

 * Getting a set of quotes

 ```bash
 curl "http://localhost:8080/quotes/?offset=10&limit=2"
 ```
 Which will return a set of ```limit``` quotes starting from the ```offset``` position.

 * Getting a concrete quote

 ```bash
 curl "http://localhost:8080/quotes/1"
 ```
 That will return you a specific quote by id.