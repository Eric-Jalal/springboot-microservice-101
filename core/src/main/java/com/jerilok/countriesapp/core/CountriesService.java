package com.jerilok.countriesapp.core;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jerilok.countriesapp.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public CountriesService(final CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public List<Country> getAllCountries() {
        ObjectNode allCountriesObjectNode = countriesRepository.fetchAllCountries();

        return null;
    }

    public Country getCountryByName(final String name) {
        ObjectNode countryObjectNode = countriesRepository.fetchCountryByName(name);

        return null;
    }
}
