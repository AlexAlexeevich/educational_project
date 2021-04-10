package ru.bellintegrator.educational_project.dictionary.dto;

import lombok.Data;

@Data
public class DocDtoForListResponse {

    private String name;

    private String code;

    public DocDtoForListResponse(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
