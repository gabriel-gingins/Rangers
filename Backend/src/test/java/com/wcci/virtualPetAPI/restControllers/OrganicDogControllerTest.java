package com.wcci.virtualPetAPI.restControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.virtualPetAPI.entities.OrganicDog;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // reset the database for each test
@AutoConfigureMockMvc
class OrganicDogControllerTest {
    @Autowired
    private MockMvc mvc;

    //test adding 1 organic dog
    @Test
    public void addOneOrgDog() throws Exception {
        final Shelter shelter = new Shelter("Columbus");
        shelter.setId(1);
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(shelter)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(shelter)))
                .andDo(MockMvcResultHandlers.print());


        final OrganicDog testPet = new OrganicDog("Fido");
        testPet.setId(1);
        String jsonContent = getJsonContent(testPet);
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters/1/organicDog")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(testPet)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testOrgDog() throws Exception {
        final Shelter shelter = new Shelter("Columbus");
        shelter.setId(1);
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getJsonContent(shelter)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(shelter)))
                .andDo(MockMvcResultHandlers.print());


        final OrganicDog testPet = new OrganicDog("Fido");
        testPet.setId(1);
        String jsonContent = getJsonContent(testPet);
        mvc.perform(MockMvcRequestBuilders.post("/api/shelters/1/organicDog")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(getJsonContent(testPet)))
                .andDo(MockMvcResultHandlers.print());

        mvc.perform(MockMvcRequestBuilders.put("/api/shelters/1/organicDog/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        mvc.perform(MockMvcRequestBuilders.delete("/api/organicDog/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    private static String getJsonContent(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }
}