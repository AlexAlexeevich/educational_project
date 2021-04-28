package ru.bellintegrator.educational_project.dictionary.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity-класс для документа
 */
@Data
@Entity
@Table(name = "doc")
@NoArgsConstructor
public class Doc {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Поле название
     */
    @Column(name = "name", length = 100)
    private String name;

    /**
     * Поле код
     */
    @Column(name = "code", length = 2)
    private String code;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name - название
     * @param code - код
     */
    public Doc(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - id
     * @param name - название
     * @param code - код
     */
    public Doc(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
