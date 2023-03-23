package com.barclays.ibm.msscbeerservice.mapper;

import com.barclays.ibm.msscbeerservice.domain.Beer;
import com.barclays.ibm.msscbeerservice.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beertoBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
