package ru.bellintegrator.educational_project.dictionary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bellintegrator.educational_project.aop.dto.ResultDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocControllerTestRestTemplate {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getDocsTest() {

        ResponseEntity<ResultDto> result = this.restTemplate
                .postForEntity("/api/docs", null, ResultDto.class);

        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(result);
    }
}
