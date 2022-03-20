package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.SaleDescription;
import kg.neobis.cardealership.model.SaleDescriptionModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SaleDescriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getSaleDescriptions() throws Exception {
        mockMvc.perform(get("/api/v1/saledescription"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getSaleDescriptionById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/saledescription/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewSaleDescription() throws Exception {
        SaleDescription saleDescription = new SaleDescription(123, "jkfds");
        String content = mapper.writeValueAsString(saleDescription);
        mockMvc.perform(
                        post("/api/v1/saledescription")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("SaleDescription was added successfully"));
    }

    @Test
    void replaceSaleDescription() throws Exception {
        SaleDescriptionModel saleDescription = new SaleDescriptionModel(3, "fdhdh");
        String content = mapper.writeValueAsString(saleDescription);
        mockMvc.perform(
                        put("/api/v1/saledescription/{id}", 3)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteSaleDescription() throws Exception {
        mockMvc.perform(delete("/api/v1/saledescription/{id}", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted sale description with id = 3"));
    }
}