package com.barclays.ibm.msscbeerservice.servicee;

import com.barclays.ibm.msscbeerservice.controller.NotFoundException;
import com.barclays.ibm.msscbeerservice.domain.Beer;
import com.barclays.ibm.msscbeerservice.mapper.BeerMapper;
import com.barclays.ibm.msscbeerservice.model.BeerDto;
import com.barclays.ibm.msscbeerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beertoBeerDto(beerRepository.findById(beerId)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return beerMapper.beertoBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto1) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto1.getBeerName());
        beer.setBeerStyle(beerDto1.getBeerStyle().name());
        beer.setPrice(beerDto1.getPrice());
        beer.setUpc(beerDto1.getUpc());

        return beerMapper.beertoBeerDto(beerRepository.save(beer));
    }
}