package com.ictcg.com.service.impl;

import com.ictcg.com.service.StudentAppService;
import com.ictcg.com.domain.StudentApp;
import com.ictcg.com.repository.StudentAppRepository;
import com.ictcg.com.service.dto.StudentAppDTO;
import com.ictcg.com.service.mapper.StudentAppMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing StudentApp.
 */
@Service
@Transactional
public class StudentAppServiceImpl implements StudentAppService {

    private final Logger log = LoggerFactory.getLogger(StudentAppServiceImpl.class);

    private final StudentAppRepository studentAppRepository;

    private final StudentAppMapper studentAppMapper;

    public StudentAppServiceImpl(StudentAppRepository studentAppRepository, StudentAppMapper studentAppMapper) {
        this.studentAppRepository = studentAppRepository;
        this.studentAppMapper = studentAppMapper;
    }

    /**
     * Save a studentApp.
     *
     * @param studentAppDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public StudentAppDTO save(StudentAppDTO studentAppDTO) {
        log.debug("Request to save StudentApp : {}", studentAppDTO);
        StudentApp studentApp = studentAppMapper.toEntity(studentAppDTO);
        studentApp = studentAppRepository.save(studentApp);
        return studentAppMapper.toDto(studentApp);
    }

    /**
     * Get all the studentApps.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<StudentAppDTO> findAll() {
        log.debug("Request to get all StudentApps");
        return studentAppRepository.findAll().stream()
            .map(studentAppMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one studentApp by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StudentAppDTO> findOne(Long id) {
        log.debug("Request to get StudentApp : {}", id);
        return studentAppRepository.findById(id)
            .map(studentAppMapper::toDto);
    }

    /**
     * Delete the studentApp by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StudentApp : {}", id);
        studentAppRepository.deleteById(id);
    }
}
