package ru.bellintegrator.educational_project.user;

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
import ru.bellintegrator.educational_project.user.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerRestTemplateTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUsersTest() throws Exception {
        UserDtoForListResponse user = new UserDtoForListResponse(3, "Петров", "Петр", "Петрович", "manager");
        List<UserDtoForListResponse> list = new ArrayList<>();
        list.add(user);

        UserDtoForListRequest userDtoForListRequest = new UserDtoForListRequest(2, "Петров", "Петр", "Петрович", null, "03", "112");

        ResponseEntity<ResultDto> result = this.restTemplate
                .postForEntity("/api/user/list", userDtoForListRequest, ResultDto.class);

        String extended = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()).getData());
        String actual = new ObjectMapper().writeValueAsString(list);

        assertEquals(extended, actual);
    }

    @Test
    public void getUserByIdTest() throws Exception {
        UserDtoForSaveResponse userDtoForSaveResponse = new UserDtoForSaveResponse(1, "Иван", "Иванов", "Иванович",
                "manager", "+79990003322", "Свидетельство о рождении", "8888 123456",
                "2000-12-05", "Российская Федерация", "643", true);

        ResponseEntity<ResultDto> result = this.restTemplate.getForEntity("/api/user/1", ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()).getData());
        String actual = new ObjectMapper().writeValueAsString(userDtoForSaveResponse);

        assertEquals(expected, actual);
    }

    @Test
    public void updateUserTest() throws Exception {
        UserDtoForUpdate userDtoForUpdate = new UserDtoForUpdate(2, 2, "test first name", "test second name", "test middle name",
                "test position", "test phone", "Паспорт гражданина РФ", "0000", null, "643", false);

        ResultDto resultDto = new ResultDto(new ResultDtoForVoid("success"));

        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity("/api/user/update", userDtoForUpdate, ResultDto.class);

        System.out.println(result);
        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()));
        String actual = new ObjectMapper().writeValueAsString(resultDto);
        assertEquals(expected, actual);

        UserDtoForSaveResponse userDtoForSaveResponse = new UserDtoForSaveResponse(2, "test first name", "test second name", "test middle name",
                "test position", "test phone", "Паспорт гражданина РФ", "0000", null, "Российская Федерация", "643", false);
        ResponseEntity<ResultDto> resultFromRepository = this.restTemplate.getForEntity("/api/user/2", ResultDto.class);

        String expected1 = new ObjectMapper().writeValueAsString(Objects.requireNonNull(resultFromRepository.getBody()).getData());
        String actual1 = new ObjectMapper().writeValueAsString(userDtoForSaveResponse);
        assertEquals(expected1, actual1);
    }

    @Test
    public void addUserTest() throws Exception {
        UserDtoForSaveRequest userDtoForSave = new UserDtoForSaveRequest(1, "test first name", "test second name", "test middle name",
                "test position", "test phone", "21", "Паспорт гражданина РФ", "9999", null, "643", false);

        ResultDto resultDto = new ResultDto(new ResultDtoForVoid("success"));

        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity("/api/user/save", userDtoForSave, ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()));
        String actual = new ObjectMapper().writeValueAsString(resultDto);
        assertEquals(expected, actual);

        UserDtoForSaveResponse userDtoForSaveResponse = new UserDtoForSaveResponse(5, "test first name", "test second name", "test middle name",
                "test position", "test phone", "Паспорт гражданина РФ", "9999", null, "Российская Федерация", "643", false);
        ResponseEntity<ResultDto> resultFromRepository = this.restTemplate.getForEntity("/api/user/5", ResultDto.class);

        String expected1 = new ObjectMapper().writeValueAsString(Objects.requireNonNull(resultFromRepository.getBody()).getData());
        String actual1 = new ObjectMapper().writeValueAsString(userDtoForSaveResponse);

        assertEquals(expected1, actual1);
    }
}
