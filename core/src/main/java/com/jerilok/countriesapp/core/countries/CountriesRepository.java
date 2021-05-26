package com.jerilok.countriesapp.core.countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class CountriesRepository {

    private static final Logger logger = LoggerFactory.getLogger(CountriesRepository.class);

    @Value("${rest.countries.api.url}")
    private String countriesApiUrl;

    private final RestTemplate restTemplate;

    public CountriesRepository() {
        this.restTemplate = new RestTemplate();
    }

    public Object fetchAllCountries() {
        logger.info("fetching all countries list from the endpoint");
        final String countriesListEndpoint = countriesApiUrl + "/v2/all";

        return getForObject(countriesListEndpoint, Object.class);
    }

    public Object fetchCountryByName(final String name) {
        logger.info("fetching specific country by name");
        final String countriesListEndpoint = countriesApiUrl + "/v2/name/" + name;

        return getForObject(countriesListEndpoint, Object.class);
    }

    private <T> T getForObject(final String url,
                               Class<T> cls,
                               final Object... params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<T> products = restTemplate.exchange(url, HttpMethod.GET, entity, cls, params);
            return products.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            }
            throw e;
        }
    }
}
