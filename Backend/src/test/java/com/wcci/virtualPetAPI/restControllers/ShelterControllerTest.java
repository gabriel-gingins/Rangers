package com.wcci.virtualPetAPI.restControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.virtualPetAPI.entities.Shelter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // reset the database for each test
@AutoConfigureMockMvc
class ShelterControllerTest {
    @Autowired
    private MockMvc mvc;

    //test zero shelters equals "[]"
    @Test
    public void getShelters() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/shelters").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    //test adding 1 shelter
    @Test
    public void addShelter() throws Exception {
        final Shelter tester = new Shelter("Test Shelter");
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(tester)))
                .andExpect(status().isOk());
    }

    //test adding 2 shelters
    @Test
    public void addShelters() throws Exception {
        final Shelter tester1 = new Shelter("Test Shelter 1");
        final Shelter tester2 = new Shelter("Test Shelter 2");

        // POST to /api/shelter & check content (Test Shelter 1)
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(tester1)))
                .andExpect(status().isOk());

        // POST to /api/shelter & check content (Test Shelter 2)
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(tester2)))
                .andExpect(status().isOk());

        //DELETE 1st shelter
        mvc.perform(MockMvcRequestBuilders.delete("/api/shelters/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Check shelter 2 is still there
        mvc.perform(MockMvcRequestBuilders.get("/api/shelters/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    private static String getJsonContent(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}