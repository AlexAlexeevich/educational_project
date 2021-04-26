package ru.bellintegrator.educational_project.organization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.educational_project.aop.dto.ResultDto;
import ru.bellintegrator.educational_project.aop.dto.ResultDtoForVoid;
import ru.bellintegrator.educational_project.organization.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganizationControllerTestRestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getOrganizationsTest() throws Exception {
        OrganizationDtoForListResponse organization1 = new OrganizationDtoForListResponse(1, "ООО Зима", true);
        List<OrganizationDtoForListResponse> list = new ArrayList<>();
        list.add(organization1);

        OrganizationDtoForListRequest organizationDtoForListRequest = new OrganizationDtoForListRequest("ООО Зима", null, true);

        ResponseEntity<ResultDto> result = this.restTemplate
                .postForEntity("/api/organization/list", organizationDtoForListRequest, ResultDto.class);

        String extended = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()).getData());
        String actual = new ObjectMapper().writeValueAsString(list);

        Assert.assertEquals(extended, actual);
    }

    @Test
    public void getOrganizationByIdTest() throws Exception {
        OrganizationDtoForSaveResponse organizationDtoForSaveResponse = new OrganizationDtoForSaveResponse(1, "ООО Зима",
                "Общество с ограниченной ответственностью Зима", "123456789012", "123456789",
                "ул. Цветочная, 10", "+79995553333", true);

        ResponseEntity<ResultDto> result = this.restTemplate.getForEntity("/api/organization/1", ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()).getData());
        String actual = new ObjectMapper().writeValueAsString(organizationDtoForSaveResponse);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateOrganizationTest() throws Exception {
        OrganizationDtoForUpdate organizationDtoForUpdate = new OrganizationDtoForUpdate(2, "test name", "test full name",
                "test inn", "test kpp", "test address", "", false);

        ResultDto resultDto = new ResultDto(new ResultDtoForVoid("success"));

        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity("/api/organization/update", organizationDtoForUpdate, ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()));
        String actual = new ObjectMapper().writeValueAsString(resultDto);
        Assert.assertEquals(expected, actual);

        ResponseEntity<ResultDto> resultFromRepository = this.restTemplate.getForEntity("/api/organization/2", ResultDto.class);

        String expected1 = new ObjectMapper().writeValueAsString(Objects.requireNonNull(resultFromRepository.getBody()).getData());
        String actual1 = new ObjectMapper().writeValueAsString(organizationDtoForUpdate);
        Assert.assertEquals(expected1, actual1);
    }

    @Test
    public void addOrganizationTest() throws Exception {
        OrganizationDtoForSaveRequest organizationDtoForSave = new OrganizationDtoForSaveRequest("test name", "test full name",
                "test inn", "test kpp", "test address", "test phone", false);

        ResultDto resultDto = new ResultDto(new ResultDtoForVoid("success"));
        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity("/api/organization/save", organizationDtoForSave, ResultDto.class);

        String expected = new ObjectMapper().writeValueAsString(Objects.requireNonNull(result.getBody()));
        String actual = new ObjectMapper().writeValueAsString(resultDto);
        Assert.assertEquals(expected, actual);


        OrganizationDtoForSaveResponse organizationDtoForSaveResponse = new OrganizationDtoForSaveResponse(3, "test name", "test full name",
                "test inn", "test kpp", "test address", "test phone", false);
        ResponseEntity<ResultDto> resultFromRepository = this.restTemplate.getForEntity("/api/organization/3", ResultDto.class);

        String expected1 = new ObjectMapper().writeValueAsString(Objects.requireNonNull(resultFromRepository.getBody()).getData());
        String actual1 = new ObjectMapper().writeValueAsString(organizationDtoForSaveResponse);

        Assert.assertEquals(expected1, actual1);
    }
}
