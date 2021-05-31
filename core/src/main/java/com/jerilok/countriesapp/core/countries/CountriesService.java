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
        List<Map<String, Object>> countriesMap =
                (List<Map<String, Object>>) countriesRepository.fetchAllCountries();
        return countriesProcessor.getAllCountries(countriesMap);
    }

    public Optional<Country> getCountryByName(final String name) {
        List<Map<String, Object>> countryList =
                (List<Map<String, Object>>) countriesRepository.fetchCountryByName(name);
        return countriesProcessor.getCountryForName(Optional.ofNullable(countryList));
    }
}
