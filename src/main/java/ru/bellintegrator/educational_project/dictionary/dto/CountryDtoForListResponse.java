package ru.bellintegrator.educational_project.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDtoForListResponse {
    private String name;

    private String code;

}
