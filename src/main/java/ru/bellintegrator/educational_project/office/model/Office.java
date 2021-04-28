package ru.bellintegrator.educational_project.office.model;

import lombok.*;
import ru.bellintegrator.educational_project.user.model.User;

import javax.persistence.*;
import java.util.List;

/**
 * Entity-класс для офиса
 */
@Data
@Entity
@Table(name = "Office")
@NoArgsConstructor
public class Office {

    /**
     * Поле id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

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
     * Поле id организации
     */
    @Column(name = "org_id", nullable = false)
    private Integer orgId;

    /**
     * Поле список работников
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "office_id")
    private List<User> users;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - id
     * @param name - название
     * @param isActive - активен ли офис
     */
    public Office(Integer id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param orgId - id организации
     * @param name - имя
     * @param address - адрес
     * @param phone - телефон
     * @param isActive - активен ли офис
     */
    public Office(Integer orgId, String name, String address, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    /**
     * Вернуть значение поля isActive
     * @return возвращает значение поля isActive
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Задать значение поля isActive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


}
