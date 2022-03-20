package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.entity.Price;
import kg.neobis.cardealership.entity.Provider;
import kg.neobis.cardealership.model.CarModel;
import kg.neobis.cardealership.model.ProviderModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProviderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getProviders() throws Exception {
        mockMvc.perform(get("/api/v1/providers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getProviderById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/providers/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewProvider() throws Exception {
        Provider provider = new Provider(123L, "Company", "Official", "manager", "fksdlkfj",
                "Bishkek", "48579347", "57438", "cash");
        String content = mapper.writeValueAsString(provider);
        mockMvc.perform(
                        post("/api/v1/providers")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Provider was added successfully"));
    }

    @Test
    void replaceProvider() throws Exception {
        ProviderModel providerModel = new ProviderModel(123L, "Name of Company", "Official", "manager", "fksdlkfj",
                "Bishkek", "48579347", "57438", "cash");
        String content = mapper.writeValueAsString(providerModel);
        mockMvc.perform(
                        put("/api/v1/providers/{id}", 123L)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteProvider() throws Exception {
        mockMvc.perform(delete("/api/v1/providers/{id}", 123L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted provider with id = 123"));
    }
}