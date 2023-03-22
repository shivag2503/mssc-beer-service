package com.barclays.ibm.msscbeerservice.controller;

import com.barclays.ibm.msscbeerservice.model.BeerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get(BeerController.BEER_PATH + "/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createNewBeer() throws Exception {
        BeerDto testBeer = BeerDto.builder().build();
        String testBeerToJson = objectMapper.writeValueAsString(testBeer);

        mockMvc.perform(post(BeerController.BEER_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(testBeerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto testBeer = BeerDto.builder().build();
        String testBeerToJson = objectMapper.writeValueAsString(testBeer);

        mockMvc.perform(put(BeerController.BEER_PATH + "/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testBeerToJson))
                .andExpect(status().isNoContent());
    }

}