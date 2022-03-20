package kg.neobis.cardealership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.neobis.cardealership.entity.Staff;
import kg.neobis.cardealership.model.StaffModel;
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
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getStaff() throws Exception {
        mockMvc.perform(get("/api/v1/staff"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getStaffById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/v1/staff/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewStaff() throws Exception {
        Staff staff = new Staff(123L, "John", "Wick", "manager", "79743");
        String content = mapper.writeValueAsString(staff);
        mockMvc.perform(
                        post("/api/v1/staff")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Staff was added successfully"));
    }

    @Test
    void replaceStaff() throws Exception {
        StaffModel staff = new StaffModel(123L, "Bred", "Wick", "manager", "79743");
        String content = mapper.writeValueAsString(staff);
        mockMvc.perform(
                        put("/api/v1/staff/{id}", 123L)
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteStaff() throws Exception {
        mockMvc.perform(delete("/api/v1/staff/{id}", 123L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted staff with id = 123"));
    }
}