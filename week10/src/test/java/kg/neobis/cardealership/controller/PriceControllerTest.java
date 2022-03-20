package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.Price;
import kg.neobis.cardealership.model.CarModel;
import kg.neobis.cardealership.model.PriceModel;
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
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getPrices() throws Exception {
        mockMvc.perform(get("/api/v1/prices"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getPriceById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/prices/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewPrice() throws Exception {
        Price price = new Price(123, 455);
        String content = mapper.writeValueAsString(price);
        mockMvc.perform(
                        post("/api/v1/prices")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Price was added successfully"));
    }

    @Test
    void replacePrice() throws Exception {
        PriceModel priceModel = new PriceModel(2, 466);
        String content = mapper.writeValueAsString(priceModel);
        mockMvc.perform(
                        put("/api/v1/prices/{id}", 2)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletePrice() throws Exception {
        mockMvc.perform(delete("/api/v1/prices/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted price with id = 2"));
    }
}