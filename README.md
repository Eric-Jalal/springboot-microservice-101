### Country service

This application is providing two endpoint to fetch country names and respected information.

- ```GET /countries/ ``` is used to fetch the coutnries list.
- ```GET /countries/{name} ``` is used to fetch the coutnries specific information.

### Used APIs

The underlying resource for fetching the records is located here https://restcountries.eu .

- Endpoint to fetch all the countries ```curl GET 'https://restcountries.eu/rest/v2/all'```
- Endpoint to fetch a specific country ```curl GET 'https://restcountries.eu/rest/v2/name/{name}'```


### Maven
The project is built by ```mvn``` .

- For cleaning and running the tests ```mvn clean test```
- For running the application ```mvn deploy```

The application will be running on port ```8080```

### REST

- Endpoint to fetch all the countries ```curl GET 'localhost:8080/countries/'```
- Endpoint to fetch a specific country ```curl GET 'localhost:8080/countries/{name}'```
