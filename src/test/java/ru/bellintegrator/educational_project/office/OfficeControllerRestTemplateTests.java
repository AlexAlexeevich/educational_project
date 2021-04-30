package ru.bellintegrator.educational_project.office;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.bellintegrator.educational_project.aop.dto.ResultDto;
import ru.bellintegrator.educational_project.aop.dto.ResultDtoForVoid;
import ru.bellintegrator.educational_project.office.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfficeControllerRestTemplateTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getOfficesTest() throws Exception {
        OfficeDtoForListResponse office = new OfficeDtoForListResponse(1, "Зима на Лесной", true);
        List<OfficeDtoForListResponse> list = new ArrayList<>();
        list.add(office);

        OfficeDtoForListRequest officeDtoForListRequest = new OfficeDtoForListRequest(1, null, null, true);

        ResponseEntity<ResultDto> result = this.restTemplate
                .postForEntity("/api/office/list", officeDtoForListRequest, ResultDto.class);

        String extended = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()).getData());
        String actual = new ObjectMapper().writeValueAsString(list);

        assertEquals(extended, actual);
    }

    @Test
    public void getOfficeByIdTest() throws Exception {
        OfficeDtoForSaveResponse officeDtoForSaveResponse = new OfficeDtoForSaveResponse(2, "Лето на Снежной", "ул. Снежная, 25",
                "+79097778855", true);

        ResponseEntity<ResultDto> result = this.restTemplate.getForEntity("/api/office/2", ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()).getData());
        String actual = new ObjectMapper().writeValueAsString(officeDtoForSaveResponse);

        assertEquals(expected, actual);
    }

    @Test
    public void updateOfficeTest() throws Exception {
        OfficeDtoForUpdate officeDtoForUpdate = new OfficeDtoForUpdate(1, "test name", "test address", "", false);

        ResultDto resultDto = new ResultDto(new ResultDtoForVoid("success"));

        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity("/api/office/update", officeDtoForUpdate, ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()));
        String actual = new ObjectMapper().writeValueAsString(resultDto);
        assertEquals(expected, actual);

        ResponseEntity<ResultDto> resultFromRepository = this.restTemplate.getForEntity("/api/office/1", ResultDto.class);

        String expected1 = new ObjectMapper().writeValueAsString(Objects.requireNonNull(resultFromRepository.getBody()).getData());
        String actual1 = new ObjectMapper().writeValueAsString(officeDtoForUpdate);
        assertEquals(expected1, actual1);
    }

    @Test
    public void addOfficeTest() throws Exception {
        OfficeDtoForSaveRequest officeDtoForSaveRequest = new OfficeDtoForSaveRequest(2, "test name", "test address",
                "test phone", true);

        ResultDto resultDto = new ResultDto(new ResultDtoForVoid("success"));
        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity("/api/office/save", officeDtoForSaveRequest, ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()));
        String actual = new ObjectMapper().writeValueAsString(resultDto);
        assertEquals(expected, actual);

        OfficeDtoForSaveResponse officeDtoForSaveResponse = new OfficeDtoForSaveResponse(3, "test name", "test address",
                "test phone", true);
        ResponseEntity<ResultDto> resultFromRepository = this.restTemplate.getForEntity("/api/office/3", ResultDto.class);

        String expected1 = new ObjectMapper().writeValueAsString(Objects.requireNonNull(resultFromRepository.getBody()).getData());
        String actual1 = new ObjectMapper().writeValueAsString(officeDtoForSaveResponse);

        assertEquals(expected1, actual1);
    }
}
