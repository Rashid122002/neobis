package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.entity.Price;
import kg.neobis.cardealership.model.CarModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getCars() throws Exception {
        mockMvc.perform(get("/api/v1/cars"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCarById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/cars/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewCar() throws Exception {
        Price price = new Price(1, 324);
        Car car = new Car(1L, "Car Brand", "43535", LocalDate.of(2002, 1, 1),
                "2.0", "black", price, "");
        String content = mapper.writeValueAsString(car);
        mockMvc.perform(
                        post("/api/v1/cars")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Car was added successfully"));
    }

    @Test
    void replaceCar() throws Exception {
        Price price = new Price(1, 324);
        CarModel carModel = new CarModel(3L, "Car Brand", "43535", LocalDate.of(2002, 1, 1),
                "2.0", "white", price, "Notes");
        String content = mapper.writeValueAsString(carModel);
        mockMvc.perform(
                        put("/api/v1/cars/{id}", 3L)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCar() throws Exception {
        mockMvc.perform(delete("/api/v1/cars/{id}", 3L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted car with id = 3"));
    }
}