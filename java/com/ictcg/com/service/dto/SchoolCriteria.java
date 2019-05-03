package com.ictcg.com.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the School entity. This class is used in SchoolResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /schools?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SchoolCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter schoolName;

    private IntegerFilter code;

    private StringFilter description;

    private LongFilter tostudentId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(StringFilter schoolName) {
        this.schoolName = schoolName;
    }

    public IntegerFilter getCode() {
        return code;
    }

    public void setCode(IntegerFilter code) {
        this.code = code;
    }

    public StringFilter getDescription() {
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public LongFilter getTostudentId() {
        return tostudentId;
    }

    public void setTostudentId(LongFilter tostudentId) {
        this.tostudentId = tostudentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SchoolCriteria that = (SchoolCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(schoolName, that.schoolName) &&
            Objects.equals(code, that.code) &&
            Objects.equals(description, that.description) &&
            Objects.equals(tostudentId, that.tostudentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        schoolName,
        code,
        description,
        tostudentId
        );
    }

    @Override
    public String toString() {
        return "SchoolCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (schoolName != null ? "schoolName=" + schoolName + ", " : "") +
                (code != null ? "code=" + code + ", " : "") +
                (description != null ? "description=" + description + ", " : "") +
                (tostudentId != null ? "tostudentId=" + tostudentId + ", " : "") +
            "}";
    }

}
