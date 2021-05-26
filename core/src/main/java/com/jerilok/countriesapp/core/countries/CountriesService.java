package com.jerilok.countriesapp.core.countries;

import com.jerilok.countriesapp.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CountriesService {

    private final CountriesRepository countriesRepository;

    private final CountriesProcessor countriesProcessor;

    public CountriesService(final CountriesRepository countriesRepository,
                            final CountriesProcessor countriesProcessor) {
        this.countriesRepository = countriesRepository;
        this.countriesProcessor = countriesProcessor;
    }

    public Map<String, List<Country>> getAllCountries() {
        Object allCountriesObjectNode = countriesRepository.fetchAllCountries();
        return countriesProcessor.getCountries(allCountriesObjectNode);
    }

    public Optional<Country> getCountryByName(final String name) {
        Object countryObjectNode = countriesRepository.fetchCountryByName(name);
        return countriesProcessor.getCountryForName(Optional.ofNullable(countryObjectNode));
    }
}
