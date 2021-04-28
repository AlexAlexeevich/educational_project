package ru.bellintegrator.educational_project.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.educational_project.dictionary.model.Country;

import javax.persistence.*;

/**
 * Entity-класс для работника
 */
@Data
@Entity
@Table(name = "User")
@NoArgsConstructor
public class User {

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
     * Поле имя
     */
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    /**
     * Поле фамилия
     */
    @Column(name = "second_name", length = 100, nullable = false)
    private String secondName;

    /**
     * Поле отчество
     */
    @Column(name = "middle_name", length = 100, nullable = false)
    private String middleName;

    /**
     * Поле телефон
     */
    @Column(name = "phone", length = 25)
    private String phone;

    /**
     * Поле должность
     */
    @Column(name = "position", length = 50, nullable = false)
    private String position;

    /**
     * Поле идентифицирован ли работник
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Поле id офиса
     */
    @Column(name = "office_id", nullable = false)
    private Integer officeId;

    /**
     * Поле страна гражданства
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Country country;

    /**
     * Поле документ
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserDoc userDoc;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - id
     * @param firstName - имя
     * @param secondName - фамилия
     * @param middleName - отчество
     * @param position - должность
     */
    public User(Integer id, String firstName, String secondName, String middleName, String position)
    {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - id
     * @param firstName - имя
     * @param secondName - фамилия
     * @param middleName - отчество
     * @param position - должность
     * @param isIdentified - идентифицирован ли работник
     * @param userDoc - личный документ работника
     * @param country - страна
     */
    public User(Integer id, String firstName, String secondName, String middleName, String position, Boolean isIdentified,
                UserDoc userDoc, Country country) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.isIdentified = isIdentified;
        this.country = country;
        this.userDoc = userDoc;
    }

    /**
     * Вернуть значение поля isIdentified
     * @return возвращает значение поля isIdentified
     */
    public Boolean getIsIdentified() {
        return isIdentified;
    }

    /**
     * Задать значение поля isIdentified
     */
    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
