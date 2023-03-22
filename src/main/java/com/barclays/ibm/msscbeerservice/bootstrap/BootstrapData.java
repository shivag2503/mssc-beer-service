package com.barclays.ibm.msscbeerservice.bootstrap;

import com.barclays.ibm.msscbeerservice.domain.Beer;
import com.barclays.ibm.msscbeerservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BootstrapData(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                            .beerName("Mango Bobs")
                            .beerStyle("IPA")
                            .quantityOnHand(200)
                            .minOnHand(20)
                            .upc(123456L)
                            .price(BigDecimal.TEN)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cats")
                    .beerStyle("LAGER")
                    .quantityOnHand(150)
                    .minOnHand(20)
                    .upc(256976L)
                    .price(BigDecimal.TEN)
                    .build());
        }

        System.out.println("Count: " + beerRepository.count());
    }
}