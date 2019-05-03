package com.ictcg.com.service.mapper;

import com.ictcg.com.domain.*;
import com.ictcg.com.service.dto.StudentAppDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity StudentApp and its DTO StudentAppDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StudentAppMapper extends EntityMapper<StudentAppDTO, StudentApp> {



    default StudentApp fromId(Long id) {
        if (id == null) {
            return null;
        }
        StudentApp studentApp = new StudentApp();
        studentApp.setId(id);
        return studentApp;
    }
}
