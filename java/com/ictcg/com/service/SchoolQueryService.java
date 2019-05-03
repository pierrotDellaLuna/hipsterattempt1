package com.ictcg.com.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.ictcg.com.domain.School;
import com.ictcg.com.domain.*; // for static metamodels
import com.ictcg.com.repository.SchoolRepository;
import com.ictcg.com.service.dto.SchoolCriteria;
import com.ictcg.com.service.dto.SchoolDTO;
import com.ictcg.com.service.mapper.SchoolMapper;

/**
 * Service for executing complex queries for School entities in the database.
 * The main input is a {@link SchoolCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SchoolDTO} or a {@link Page} of {@link SchoolDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SchoolQueryService extends QueryService<School> {

    private final Logger log = LoggerFactory.getLogger(SchoolQueryService.class);

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolQueryService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    /**
     * Return a {@link List} of {@link SchoolDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SchoolDTO> findByCriteria(SchoolCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<School> specification = createSpecification(criteria);
        return schoolMapper.toDto(schoolRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link SchoolDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SchoolDTO> findByCriteria(SchoolCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<School> specification = createSpecification(criteria);
        return schoolRepository.findAll(specification, page)
            .map(schoolMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SchoolCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<School> specification = createSpecification(criteria);
        return schoolRepository.count(specification);
    }

    /**
     * Function to convert SchoolCriteria to a {@link Specification}
     */
    private Specification<School> createSpecification(SchoolCriteria criteria) {
        Specification<School> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), School_.id));
            }
            if (criteria.getSchoolName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSchoolName(), School_.schoolName));
            }
            if (criteria.getCode() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCode(), School_.code));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), School_.description));
            }
            if (criteria.getTostudentId() != null) {
                specification = specification.and(buildSpecification(criteria.getTostudentId(),
                    root -> root.join(School_.tostudents, JoinType.LEFT).get(StudentApp_.id)));
            }
        }
        return specification;
    }
}
