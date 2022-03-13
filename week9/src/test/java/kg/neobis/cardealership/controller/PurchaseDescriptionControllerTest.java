package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.PurchaseDescription;
import kg.neobis.cardealership.model.PurchaseDescriptionModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseDescriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getPurchaseDescriptions() throws Exception {
        mockMvc.perform(get("/api/v1/purchasedescriptions"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getPurchaseDescriptionById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/purchasedescriptions/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewPurchaseDescription() throws Exception {
        PurchaseDescription purchaseDescription = new PurchaseDescription(123, "jdfsj");
        String content = mapper.writeValueAsString(purchaseDescription);
        mockMvc.perform(
                        post("/api/v1/purchasedescriptions")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("PurchaseDescription was added successfully"));
    }

    @Test
    void replacePurchaseDescription() throws Exception {
        PurchaseDescriptionModel purchaseDescription = new PurchaseDescriptionModel(123, "fgdshdfg");
        String content = mapper.writeValueAsString(purchaseDescription);
        mockMvc.perform(
                        put("/api/v1/purchasedescriptions/{id}", 123)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletePurchaseDescription() throws Exception {
        mockMvc.perform(delete("/api/v1/purchasedescriptions/{id}", 123))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted purchase description with id = 123"));
    }
}