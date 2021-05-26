package com.jerilok.countriesapp.application.controllers;

import com.jerilok.countriesapp.core.AbstractRestController;
import com.jerilok.countriesapp.core.countries.CountriesService;
import com.jerilok.countriesapp.model.Country;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/countries",
                produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesController extends AbstractRestController {

    private final CountriesService countriesService;

    public CountriesController(final CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping
    @ResponseBody
    public Map<String, List<Country>> getAllTheCountries() {
        return countriesService.getAllCountries();
    }

    @GetMapping(value = "/{name}")
    @ResponseBody
    public ResponseEntity<Country> getCountryByName(@PathVariable("name") @NotNull final String name) {

        Optional<Country> country = countriesService.getCountryByName(name);

        if (country.isPresent()) {
            return buildEntityHttpStatusOk(country.get());
        }

        return buildEntityHttpStatusNotFound();
    }
}
