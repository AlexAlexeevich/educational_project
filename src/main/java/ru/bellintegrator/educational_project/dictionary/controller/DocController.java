package ru.bellintegrator.educational_project.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.educational_project.dictionary.dto.DocDtoForListResponse;
import ru.bellintegrator.educational_project.dictionary.service.DocService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocController {

    private final DocService docService;

    @Autowired
    public DocController(DocService docService) {
        this.docService = docService;
    }

    @PostMapping("")
    public ResponseEntity<List<DocDtoForListResponse>> getDocs() {
        return new ResponseEntity<>(docService.getDocs(), HttpStatus.OK);
    }
}
