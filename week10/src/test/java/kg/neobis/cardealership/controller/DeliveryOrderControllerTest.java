package kg.neobis.cardealership.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.DeliveryOrder;
import kg.neobis.cardealership.entity.Provider;
import kg.neobis.cardealership.entity.PurchaseDescription;
import kg.neobis.cardealership.entity.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class DeliveryOrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testAddNewDeliveryOrder() throws Exception {
        Provider provider1 = new Provider();
        provider1.setAddress("42 Main St");
        provider1.setCity("Oxford");
        provider1.setCompanyName("Company Name");
        provider1.setCompanyOfficialName("Company Official Name");
        provider1.setFax("Fax");
        provider1.setPaymentTerm("Payment Term");
        provider1.setPhoneNumber("4105551212");
        provider1.setPosition("Position");
        provider1.setProviderId(123L);

        PurchaseDescription purchaseDescription1 = new PurchaseDescription();
        purchaseDescription1.setDescription("The characteristics of someone or something");
        purchaseDescription1.setPurchaseId(123);

        Staff staff1 = new Staff();
        staff1.setFirstName("Jane");
        staff1.setLastName("Doe");
        staff1.setPhoneNumber("4105551212");
        staff1.setPosition("Position");
        staff1.setStaffId(123L);

        DeliveryOrder deliveryOrder1 = new DeliveryOrder();
        deliveryOrder1.setDeliveryOrderId(123L);
        deliveryOrder1.setExecutionDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setOrderDescription("Order Description");
        deliveryOrder1.setPlacementDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setProviderId(provider1);
        deliveryOrder1.setPurchaseId(purchaseDescription1);
        deliveryOrder1.setStaffId(staff1);

        String content = mapper.writeValueAsString(deliveryOrder1);
        mockMvc.perform(
                        post("/api/v1/deliveryorders")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Delivery order was added successfully"));
    }


    @Test
    void testReplaceDeliveryOrder() throws Exception {
        Provider provider1 = new Provider();
        provider1.setAddress("42 Main St");
        provider1.setCity("Oxford");
        provider1.setCompanyName("Company Name");
        provider1.setCompanyOfficialName("Company Official Name");
        provider1.setFax("Fax");
        provider1.setPaymentTerm("Payment Term");
        provider1.setPhoneNumber("4105551212");
        provider1.setPosition("Position");
        provider1.setProviderId(123L);

        PurchaseDescription purchaseDescription1 = new PurchaseDescription();
        purchaseDescription1.setDescription("The characteristics of someone or something");
        purchaseDescription1.setPurchaseId(123);

        Staff staff1 = new Staff();
        staff1.setFirstName("Jane");
        staff1.setLastName("Doe");
        staff1.setPhoneNumber("4105551212");
        staff1.setPosition("Position");
        staff1.setStaffId(123L);

        DeliveryOrder deliveryOrder1 = new DeliveryOrder();
        deliveryOrder1.setDeliveryOrderId(123L);
        deliveryOrder1.setExecutionDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setOrderDescription("Order");
        deliveryOrder1.setPlacementDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setProviderId(provider1);
        deliveryOrder1.setPurchaseId(purchaseDescription1);
        deliveryOrder1.setStaffId(staff1);

        String content = mapper.writeValueAsString(deliveryOrder1);
        mockMvc.perform(
                        put("/api/v1/deliveryorders/{id}", 3L)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void testDeleteDeliveryOrder() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/api/v1/deliveryorders/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted delivery order with id = 1"));
    }

    @Test
    void testGetDeliveryOrderById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/deliveryorders/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void testGetDeliveryOrders() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/deliveryorders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}

