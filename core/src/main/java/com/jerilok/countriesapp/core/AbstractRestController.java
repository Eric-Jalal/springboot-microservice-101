package com.jerilok.countriesapp.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractRestController {

    protected <K> ResponseEntity<K> buildEntityHttpStatusOk(final K dtoObject) {
        return new ResponseEntity<>(dtoObject, HttpStatus.OK);
    }

    protected <K> ResponseEntity<K> buildEntityHttpStatusNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
