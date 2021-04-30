package ru.bellintegrator.educational_project.office;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.bellintegrator.educational_project.aop.dto.ResultDto;
import ru.bellintegrator.educational_project.aop.dto.ResultDtoForVoid;
import ru.bellintegrator.educational_project.office.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OfficeControllerMockMvcIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOfficesTest() throws Exception {
        OfficeDtoForListResponse office = new OfficeDtoForListResponse(1, "Зима на Лесной", true);
        List<OfficeDtoForListResponse> list = new ArrayList<>();
        list.add(office);
        ResultDto expected = new ResultDto();
        expected.setData(list);

        OfficeDtoForListRequest officeDtoForListRequest = new OfficeDtoForListRequest(1, null, null, true);

        this.mockMvc.perform(post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(officeDtoForListRequest)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expected)));
    }

    @Test
    public void getOfficeByIdTest() throws Exception {
        OfficeDtoForSaveResponse officeDtoForSaveResponse = new OfficeDtoForSaveResponse(2, "Лето на Снежной", "ул. Снежная, 25",
                "+79097778855", true);

        ResultDto expected = new ResultDto();
        expected.setData(officeDtoForSaveResponse);
        this.mockMvc.perform(get("/api/office/2"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(officeDtoForSaveResponse.getId()))
                .andExpect(jsonPath("$.data.name").value(officeDtoForSaveResponse.getName()))
                .andExpect(jsonPath("$.data.address").value(officeDtoForSaveResponse.getAddress()))
                .andExpect(jsonPath("$.data.phone").value(officeDtoForSaveResponse.getPhone()))
                .andExpect(jsonPath("$.data.isActive").value(officeDtoForSaveResponse.getIsActive()));
    }

    @Test
    public void getOfficeByIdTest_failNotFound() throws Exception {
        this.mockMvc.perform(get("/api/office/222"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getOfficeByIdTest_failBadRequest() throws Exception {
        this.mockMvc.perform(get("/api/office/zzz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfficeTest() throws Exception {
        OfficeDtoForUpdate officeDtoForUpdate = new OfficeDtoForUpdate(1, "test name", "test address", "", false);

        ResultDto expected = new ResultDto(new ResultDtoForVoid("success"));

        this.mockMvc.perform(post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(officeDtoForUpdate)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expected)));


        this.mockMvc.perform(get("/api/office/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(officeDtoForUpdate.getId()))
                .andExpect(jsonPath("$.data.name").value(officeDtoForUpdate.getName()))
                .andExpect(jsonPath("$.data.address").value(officeDtoForUpdate.getAddress()))
                .andExpect(jsonPath("$.data.phone").value(officeDtoForUpdate.getPhone()))
                .andExpect(jsonPath("$.data.isActive").value(officeDtoForUpdate.getIsActive()));
    }

    @Test
    public void addOfficeTest() throws Exception {
        OfficeDtoForSaveRequest officeDtoForSaveRequest = new OfficeDtoForSaveRequest(2, "test name", "test address",
                "test phone", true);

        ResultDto expected = new ResultDto(new ResultDtoForVoid("success"));

        this.mockMvc.perform(post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(officeDtoForSaveRequest)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expected)));

        this.mockMvc.perform(get("/api/office/3"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(officeDtoForSaveRequest.getName()))
                .andExpect(jsonPath("$.data.address").value(officeDtoForSaveRequest.getAddress()))
                .andExpect(jsonPath("$.data.phone").value(officeDtoForSaveRequest.getPhone()))
                .andExpect(jsonPath("$.data.isActive").value(officeDtoForSaveRequest.getIsActive()));
    }
}
