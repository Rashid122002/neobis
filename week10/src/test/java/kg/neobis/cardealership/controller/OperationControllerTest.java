package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OperationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getOperations() throws Exception {
        mockMvc.perform(get("/api/v1/operations"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getOperationById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/operations/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewOperation() throws Exception {
        Price price = new Price(1, 324);
        Car car = new Car(4L, "Car Brand", "43535", LocalDate.of(2002, 1, 1),
                "2.0", "black", price, "");
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
        deliveryOrder1.setDeliveryOrderId(2L);
        deliveryOrder1.setExecutionDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setOrderDescription("Order Description");
        deliveryOrder1.setPlacementDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setProviderId(provider1);
        deliveryOrder1.setPurchaseId(purchaseDescription1);
        deliveryOrder1.setStaffId(staff1);

        Operation operation = new Operation(123L, LocalDate.of(2000, 1,1), car,
                deliveryOrder1, "aaaa", 1111, 2222, 3333);
        String content = mapper.writeValueAsString(operation);
        mockMvc.perform(
                        post("/api/v1/operations")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Operation was added successfully"));
    }

    @Test
    void replaceOperation() throws Exception {
        Price price = new Price(1, 324);
        Car car = new Car(4L, "Car Brand", "43535", LocalDate.of(2002, 1, 1),
                "2.0", "black", price, "");
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
        deliveryOrder1.setDeliveryOrderId(2L);
        deliveryOrder1.setExecutionDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setOrderDescription("Order Description");
        deliveryOrder1.setPlacementDate(LocalDate.ofEpochDay(1L));
        deliveryOrder1.setProviderId(provider1);
        deliveryOrder1.setPurchaseId(purchaseDescription1);
        deliveryOrder1.setStaffId(staff1);

        Operation operation = new Operation(3L, LocalDate.of(2000, 1,1), car,
                deliveryOrder1, "bbbb", 1111, 2222, 3333);

        String content = mapper.writeValueAsString(operation);
        mockMvc.perform(
                        put("/api/v1/operations/{id}", 3L)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteOperation() throws Exception {
        mockMvc.perform(delete("/api/v1/operations/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted car with id = 1"));
    }
}