package com.jerilok.countriesapp.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractRestController {

    <K> ResponseEntity<K> buildEntityHttpStatusOk(final K dtoObject) {
        return new ResponseEntity<>(dtoObject, HttpStatus.OK);
    }
}
