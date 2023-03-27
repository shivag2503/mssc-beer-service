package com.barclays.ibm.msscbeerservice.controller;

import com.barclays.ibm.msscbeerservice.model.BeerDto;
import com.barclays.ibm.msscbeerservice.servicee.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    @GetMapping(BEER_PATH_ID)
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity<BeerDto> createNewBeer(@Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.createBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId,
                                                  @Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeerById(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}