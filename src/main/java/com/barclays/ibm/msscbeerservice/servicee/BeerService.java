package com.barclays.ibm.msscbeerservice.servicee;

import com.barclays.ibm.msscbeerservice.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto1);
}