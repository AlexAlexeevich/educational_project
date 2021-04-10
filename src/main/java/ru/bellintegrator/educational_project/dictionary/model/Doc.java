package ru.bellintegrator.educational_project.dictionary.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doc")
@NoArgsConstructor
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 2)
    private String code;

    public Doc(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Doc(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
