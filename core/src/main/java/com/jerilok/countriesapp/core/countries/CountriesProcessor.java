package com.jerilok.countriesapp.core.countries;

import com.jerilok.countriesapp.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CountriesProcessor {

    public List<Country> getCountries(Object countriesObject) {
        List<Map<String, Object>> countriesList = (List<Map<String, Object>>) countriesObject;
        return countriesList.stream().map(this::mapCountry).collect(Collectors.toList());
    }

    public List<Country> getCountryForName(Object countriesObject) {
        List<Map<String, Object>> countriesList = (List<Map<String, Object>>) countriesObject;
        return countriesList.stream().map(this::mapCountryByName).collect(Collectors.toList());
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
