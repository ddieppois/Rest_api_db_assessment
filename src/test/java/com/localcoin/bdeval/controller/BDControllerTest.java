package com.localcoin.bdeval.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BDControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchRanges() throws Exception {
        this.mockMvc.perform(get("/api/v1/search_ranges")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].atm", is("ATM2")))
                .andExpect(jsonPath("$[0].ranges[0].start_date", is("2019-05-20")))
                .andExpect(jsonPath("$[0].ranges[0].end_date", is("2019-05-23")))
                .andExpect(jsonPath("$[0].ranges[1].start_date", is("2019-05-10")))
                .andExpect(jsonPath("$[0].ranges[1].end_date", is("2019-05-16")))
                .andExpect(jsonPath("$[0].ranges[2].start_date", is("2019-02-20")))
                .andExpect(jsonPath("$[0].ranges[2].end_date", is("2019-03-13")))
                .andExpect(jsonPath("$[1].atm", is("ATM1")))
                .andExpect(jsonPath("$[1].ranges[0].start_date", is("2019-04-26")))
                .andExpect(jsonPath("$[1].ranges[0].end_date", is("2019-05-17")))
                .andExpect(jsonPath("$[1].ranges[1].start_date", is("2019-03-10")))
                .andExpect(jsonPath("$[1].ranges[1].end_date", is("2019-04-23")));
    }
}