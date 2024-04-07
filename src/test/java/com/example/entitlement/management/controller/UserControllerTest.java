package com.example.entitlement.management.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetUserByFirstName() throws Exception{
         mockMvc.perform(MockMvcRequestBuilders
                 .get("/users/{firstName}","manish")
                 .accept(MediaType.APPLICATION_JSON))
             .andDo(print())
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.firstName").value("Manish"));
        
    }

    @Test
    void testGetUsers() throws Exception {
          this.mockMvc.perform( MockMvcRequestBuilders
                 .get("/users")
                 .accept(MediaType.APPLICATION_JSON))
             .andDo(print())
             .andExpect(status().isOk())
             .andExpect(jsonPath("$").isArray())
             .andExpect(jsonPath("$",hasSize(3)));
    }
}
