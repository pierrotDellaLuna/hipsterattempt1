package com.ictcg.com.service.dto;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the StudentApp entity.
 */
public class StudentAppDTO implements Serializable {

    private Long id;

    private Long studentId;

    private String studentName;

    private LocalDate inscriptionDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(LocalDate inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StudentAppDTO studentAppDTO = (StudentAppDTO) o;
        if (studentAppDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), studentAppDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StudentAppDTO{" +
            "id=" + getId() +
            ", studentId=" + getStudentId() +
            ", studentName='" + getStudentName() + "'" +
            ", inscriptionDate='" + getInscriptionDate() + "'" +
            "}";
    }
}
