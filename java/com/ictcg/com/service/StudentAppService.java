package com.ictcg.com.service;

import com.ictcg.com.service.dto.StudentAppDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing StudentApp.
 */
public interface StudentAppService {

    /**
     * Save a studentApp.
     *
     * @param studentAppDTO the entity to save
     * @return the persisted entity
     */
    StudentAppDTO save(StudentAppDTO studentAppDTO);

    /**
     * Get all the studentApps.
     *
     * @return the list of entities
     */
    List<StudentAppDTO> findAll();


    /**
     * Get the "id" studentApp.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<StudentAppDTO> findOne(Long id);

    /**
     * Delete the "id" studentApp.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
