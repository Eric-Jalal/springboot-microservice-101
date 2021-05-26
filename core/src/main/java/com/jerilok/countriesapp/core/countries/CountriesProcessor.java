package com.jerilok.countriesapp.core.countries;

import com.jerilok.countriesapp.model.Country;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CountriesProcessor {

    public Map<String, List<Country>> getCountries(Object countriesObject) {
        List<Map<String, Object>> countriesMap = (List<Map<String, Object>>) countriesObject;
        List<Country> countriesList = countriesMap.stream().map(this::mapCountry).collect(Collectors.toList());
        Map<String, List<Country>> objectMap = new HashMap<>();
        objectMap.put("countries", countriesList);
        return objectMap;
    }

    public Optional<Country> getCountryForName(Optional<Object> countriesObject) {
        List<Map<String, Object>> countriesList;
        if (countriesObject.isPresent()) {
           countriesList = (List<Map<String, Object>>) countriesObject.get();
           return countriesList.stream().map(this::mapCountryByName).findAny();
        }

        return Optional.empty();
    }

    private Country mapCountry(Map<String, Object> objectMap) {
        String name = (String) objectMap.get("name");
        String countryCode = (String) objectMap.get("alpha2Code");
        return new Country(name, countryCode);
    }

    private Country mapCountryByName(Map<String, Object> objectMap) {
        String name = (String) objectMap.get("name");
        String countryCode = (String) objectMap.get("alpha2Code");
        String capital = (String) objectMap.get("capital");
        Integer population = (Integer) objectMap.get("population");
        String flagUrl = (String) objectMap.get("flag");

        return new Country(name, countryCode, capital, population, flagUrl);
    }

}
