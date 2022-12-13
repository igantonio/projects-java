package com.example.school.integration.controllers;

import com.example.school.AbstractTest;
import com.example.school.entity.SchoolEntity;
import com.example.school.repository.SchoolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


public class SchoolControllerTest extends AbstractTest {

    @Autowired
    private SchoolRepository schoolRepository;

    @BeforeEach
    void setUp() {
        schoolRepository.deleteAll();
    }


    @Test
    void when_find_by_id_with_success() throws Exception {
        schoolRepository.save(SchoolEntity.builder().name("Teste").build());

        this.mockMvc.perform(MockMvcRequestBuilders.get("/school/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Teste"));

    }

    @Test
    void when_find_by_id_return_not_found() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/school/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorTitle").value("Recurso não cadastrado"));

    }

    @Test
    void findAll() throws Exception {
        final List<SchoolEntity> schoolRequestList = List.of(
                SchoolEntity.builder().name("Teste").build(),
                SchoolEntity.builder().name("Teste1").build()
        );

        schoolRepository.saveAll(schoolRequestList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/school"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Teste"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Teste1"));
    }

}
