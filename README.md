### Country service

This application is providing two endpoint to fetch country names and respected information.

- ```GET /countries/``` is used to fetch the coutnries list.
- ```GET /countries/{name}``` is used to fetch the coutnries specific information.

### Used APIs

The underlying resource for fetching the records is located here https://restcountries.eu .

- Endpoint to fetch all the countries ```curl GET 'https://restcountries.eu/rest/v2/all'```
- Endpoint to fetch a specific country ```curl GET 'https://restcountries.eu/rest/v2/name/{name}'```


### Run instruction
The project is built by ```mvn``` . To run the application: 
- Install the application using mvnw withing root directory```./mvnw install```
- Start the application ```./mvnw spring-boot:run -pl application```

The application will be running on port ```8080```

### REST

- Endpoint to fetch all the countries ```curl GET 'localhost:8080/countries/'```
  
```json
[
  {
    "name": "Viet Nam",
    "country_code": "VN"
  },
  {
    "name": "Wallis and Futuna",
    "country_code": "WF"
  },
....
]
```

- Endpoint to fetch a specific country ```curl GET 'localhost:8080/countries/{name}'```
```json
[
  {
    "name": "Finland",
    "country_code": "FI",
    "capital": "Helsinki",
    "population": 5491817,
    "flag_file_url": "https://restcountries.eu/data/fin.svg"
  }
]
```


----------------------------------------------------------------------------------

###NOTE

Some parts are still left to be implemented such as:

- Name the Array list for ```/countries``` endpoint response
- Remove the unnecessary Array parsing for ```/countries/{name}``` endpoint response
- unit tests (This could go TDD in the first place :D)
- implement reactor
- possibly some enhancements in overall architecture
