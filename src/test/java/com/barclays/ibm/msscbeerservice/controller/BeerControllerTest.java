package com.barclays.ibm.msscbeerservice.controller;

import com.barclays.ibm.msscbeerservice.bootstrap.BootstrapData;
import com.barclays.ibm.msscbeerservice.model.BeerDto;
import com.barclays.ibm.msscbeerservice.model.BeerStyle;
import com.barclays.ibm.msscbeerservice.servicee.BeerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getValidatedBeerDto());

        mockMvc.perform(get(BeerController.BEER_PATH + "/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createNewBeer() throws Exception {
        BeerDto testBeer = getValidatedBeerDto();
        String testBeerToJson = objectMapper.writeValueAsString(testBeer);

        given(beerService.createBeer(any())).willReturn(getValidatedBeerDto());

        mockMvc.perform(post(BeerController.BEER_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(testBeerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto testBeer = getValidatedBeerDto();
        String testBeerToJson = objectMapper.writeValueAsString(testBeer);

        given(beerService.updateBeerById(any(), any())).willReturn(getValidatedBeerDto());

        mockMvc.perform(put(BeerController.BEER_PATH + "/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBeerToJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getValidatedBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyle.ALE)
                .price(new BigDecimal("12.50"))
                .upc(BootstrapData.BEER_1_UPC)
                .build();
    }
}