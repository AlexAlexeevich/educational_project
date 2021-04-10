package ru.bellintegrator.educational_project.office.model;

import lombok.*;
import ru.bellintegrator.educational_project.user.model.User;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Office")
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "phone", length = 25)
    private String phone;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "org_id", nullable = false)
    private Integer orgId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "office_id")
    private List<User> users;

    public Office(Integer id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Office(Integer orgId, String name, String address, String phone, boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


}
