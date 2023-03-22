package com.barclays.ibm.msscbeerservice;

import com.barclays.ibm.msscbeerservice.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class controllerBeerController {

    private static final String BEER_PATH = "/api/v1/beer";
    private static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    @GetMapping(BEER_PATH_ID)
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) {
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity<BeerDto> createNewBeer(@RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId,
                                                  @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}