package ru.bellintegrator.educational_project.dictionary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.bellintegrator.educational_project.aop.dto.ResultDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryControllerRestTemplateTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCountriesTest() {

        ResponseEntity<ResultDto> result = this.restTemplate
                .postForEntity("/api/countries", null, ResultDto.class);

        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertNotNull(result);
    }
}
