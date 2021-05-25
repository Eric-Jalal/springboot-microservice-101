package com.jerilok.countriesapp.application.controllers;

import com.jerilok.countriesapp.core.AbstractRestController;
import com.jerilok.countriesapp.core.CountriesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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
    public ResponseEntity<?> getAllTheCountries() {

        return null;
    }

    @GetMapping(value = "/{name}")
    @ResponseBody
    public ResponseEntity<?> getCountryByName(@PathVariable("name") @NotNull final String name) {
        return null;
    }
}
