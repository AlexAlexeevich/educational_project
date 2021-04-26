package ru.bellintegrator.educational_project.office;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
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
        List<OfficeDtoForListResponse> expected = new ArrayList<>();
        expected.add(office);

        OfficeDtoForListRequest officeDtoForListRequest = new OfficeDtoForListRequest(1, null, null, true);

        this.mockMvc.perform(post("/api/office/list")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(officeDtoForListRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(1)))
                .andExpect(jsonPath("$.data[0].id").value(expected.get(0).getId()))
                .andExpect(jsonPath("$.data[0].name").value(expected.get(0).getName()))
                .andExpect(jsonPath("$.data[0].isActive").value(expected.get(0).getIsActive()));
    }

    @Test
    public void getOfficeByIdTest() throws Exception {
        OfficeDtoForSaveResponse expected = new OfficeDtoForSaveResponse(2, "Лето на Снежной", "ул. Снежная, 25",
                "+79097778855", true);

        ResultDto resultDto = new ResultDto();
        resultDto.setData(expected);
        this.mockMvc.perform(get("/api/office/2"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(expected.getId()))
                .andExpect(jsonPath("$.data.name").value(expected.getName()))
                .andExpect(jsonPath("$.data.address").value(expected.getAddress()))
                .andExpect(jsonPath("$.data.phone").value(expected.getPhone()))
                .andExpect(jsonPath("$.data.isActive").value(expected.getIsActive()));
    }

    @Test
    public void getOfficeByIdTest_failNotFound() throws Exception {
        mockMvc.perform(get("/api/office/222"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getOfficeByIdTest_failBadRequest() throws Exception {
        mockMvc.perform(get("/api/office/zzz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateOfficeTest() throws Exception {
        OfficeDtoForUpdate expected = new OfficeDtoForUpdate(1, "test name", "test address", "", false);

        ResultDtoForVoid resultDtoForVoid = new ResultDtoForVoid();
        resultDtoForVoid.setResult("success");

        this.mockMvc.perform(post("/api/office/update")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(expected)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(resultDtoForVoid.getResult()));

        this.mockMvc.perform(get("/api/office/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(expected.getId()))
                .andExpect(jsonPath("$.data.name").value(expected.getName()))
                .andExpect(jsonPath("$.data.address").value(expected.getAddress()))
                .andExpect(jsonPath("$.data.phone").value(expected.getPhone()))
                .andExpect(jsonPath("$.data.isActive").value(expected.getIsActive()));
    }

    @Test
    public void addOfficeTest() throws Exception {
        OfficeDtoForSaveRequest expected = new OfficeDtoForSaveRequest(2, "test name", "test address",
                "test phone", true);

        ResultDtoForVoid resultDtoForVoid = new ResultDtoForVoid();
        resultDtoForVoid.setResult("success");

        mockMvc.perform(post("/api/office/save")
                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(expected)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(resultDtoForVoid.getResult()));

        this.mockMvc.perform(get("/api/office/3"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(expected.getName()))
                .andExpect(jsonPath("$.data.address").value(expected.getAddress()))
                .andExpect(jsonPath("$.data.phone").value(expected.getPhone()))
                .andExpect(jsonPath("$.data.isActive").value(expected.getIsActive()));
    }
}
