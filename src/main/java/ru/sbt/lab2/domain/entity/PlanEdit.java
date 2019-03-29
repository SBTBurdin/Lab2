package ru.sbt.lab2.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "plan_edit", schema = "dbo", catalog = "SBT_lab2")
public class PlanEdit {
    private int id;
    private Timestamp startDate;
    private Timestamp endDate;
    private boolean actual;
    // Я добавил
    private EditableFile editableFile;
    private User user;

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
    @Column(name = "start_date", nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "actual", nullable = false)
    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    @ManyToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", nullable = false)
    public EditableFile getEditableFile() {
        return editableFile;
    }

    public void setEditableFile(EditableFile editableFileByFileId) {
        this.editableFile = editableFileByFileId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanEdit planEdit = (PlanEdit) o;
        return id == planEdit.id &&
                actual == planEdit.actual &&
                Objects.equals(startDate, planEdit.startDate) &&
                Objects.equals(endDate, planEdit.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, actual);
    }
}
