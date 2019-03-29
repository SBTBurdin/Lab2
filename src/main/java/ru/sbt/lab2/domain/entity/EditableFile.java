package ru.sbt.lab2.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "editable_file", schema = "dbo", catalog = "SBT_lab2")
public class EditableFile {
    private int id;
    private String name;
    // Добавил
    private Set<PlanEdit> planEdits = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Получить все PlanEdit
    @OneToMany(
            targetEntity = ru.sbt.lab2.domain.entity.PlanEdit.class,
//            mappedBy = "plan_edit",
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
        EditableFile that = (EditableFile) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
