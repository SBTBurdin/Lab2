package ru.sbt.lab2.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "app_user", schema = "dbo", catalog = "SBT_lab2")
public class User {
    private int id;
    private String login;
    private String password;
    // Добавил
    private Set<PlanEdit> planEdits = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int identity", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Получение всех PlanEdit пользователя
    @OneToMany(
            targetEntity = ru.sbt.lab2.domain.entity.PlanEdit.class,
//            mappedBy = "planEdit",
            cascade = CascadeType.MERGE
    )
    public Set<PlanEdit> getPlanEdits() {
        return planEdits;
    }

    public void setPlanEdits(Set<PlanEdit> planEdits) {
        this.planEdits = planEdits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
