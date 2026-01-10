package com.example.backend_apis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;







@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void numberToWords_validRequest() throws Exception {

        String json = "{ \"number\": \"36.40\" }";


        mockMvc.perform(post("/api/number-to-words").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andExpect(jsonPath("$.result").value("thirty six point four zero"));
    }





    @Test
    void numberToWords_invalidNumber() throws Exception {

        String json = "{ \"number\": \"1000.00\" }";


        mockMvc.perform(post("/api/number-to-words").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest()).andExpect(jsonPath("$.message")
                .value("Invalid number. Must be < 1000 with max 2 decimals"));
    }





    @Test
    void numberOfDays_invalidDate() throws Exception {
        
        String json = "{ \"startDate\": \"01-01-2024\", \"endDate\": \"2024-01-10\" }";
        

        mockMvc.perform(post("/api/number-of-days").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isBadRequest()).andExpect(jsonPath("$.error").value("Bad Request"));
    }
}
