package com.barclays.ibm.msscbeerservice.mapper;

import com.barclays.ibm.msscbeerservice.domain.Beer;
import com.barclays.ibm.msscbeerservice.domain.Beer.BeerBuilder;
import com.barclays.ibm.msscbeerservice.model.BeerDto;
import com.barclays.ibm.msscbeerservice.model.BeerDto.BeerDtoBuilder;
import com.barclays.ibm.msscbeerservice.model.BeerStyle;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-23T18:56:02+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beertoBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        beerDto.version( beer.getVersion() );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( Enum.valueOf( BeerStyle.class, beer.getBeerStyle() ) );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.price( beer.getPrice() );
        beerDto.quantityOnHand( beer.getQuantityOnHand() );
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDto.getId() );
        beer.version( beerDto.getVersion() );
        beer.beerName( beerDto.getBeerName() );
        if ( beerDto.getBeerStyle() != null ) {
            beer.beerStyle( beerDto.getBeerStyle().name() );
        }
        beer.upc( beerDto.getUpc() );
        beer.price( beerDto.getPrice() );
        beer.quantityOnHand( beerDto.getQuantityOnHand() );
        beer.createdDate( dateMapper.asTimeStamp( beerDto.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimeStamp( beerDto.getLastModifiedDate() ) );

        return beer.build();
    }
}
