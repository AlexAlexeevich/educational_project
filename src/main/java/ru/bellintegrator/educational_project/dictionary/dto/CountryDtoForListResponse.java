package ru.bellintegrator.educational_project.dictionary.dto;

import lombok.Data;

@Data
public class CountryDtoForListResponse {
    private String name;

    private String code;

    public CountryDtoForListResponse(String name, String code) {
        this.name = name;
        this.code = code;
    }
}