package ru.bellintegrator.educational_project.organization.model;

import lombok.*;
import ru.bellintegrator.educational_project.office.model.Office;

import javax.persistence.*;
import java.util.List;

/**
 * Entity-класс для организации
 */
@Data
@Entity
@Table(name = "Organization")
@NoArgsConstructor
public class Organization {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    /**
     * Служебное поле version (для Hibernate).
     */
    @Version
    private Integer version;

    /**
     * Поле название
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * Поле полное название
     */
    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    /**
     * Поле ИНН
     */
    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    /**
     * Поле КПП
     */
    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    /**
     * Поле адрес
     */
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    /**
     * Поле телефон
     */
    @Column(name = "phone", length = 25)
    private String phone;

    /**
     * Поле активна ли организация
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Поле список офисов
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "org_id")
    private List<Office> offices;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - id
     * @param name - название
     * @param isActive - активна ли организация
     */
    public Organization(int id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - id
     * @param name - название
     * @param fullName - полное название
     * @param inn - ИНН
     * @param kpp - КПП
     * @param address - адрес
     * @param phone - телефон
     * @param isActive - активна ли организация
     */
    public Organization(int id, String name, String fullName, String inn, String kpp, String address, String phone,
                        boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    /**
     * Вернуть значение поля isActive
     * @return возвращает значение поля isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Задать значение поля isActive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
