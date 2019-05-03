package com.ictcg.com.web.rest;
import com.ictcg.com.service.SchoolService;
import com.ictcg.com.web.rest.errors.BadRequestAlertException;
import com.ictcg.com.web.rest.util.HeaderUtil;
import com.ictcg.com.service.dto.SchoolDTO;
import com.ictcg.com.service.dto.SchoolCriteria;
import com.ictcg.com.service.SchoolQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing School.
 */
@RestController
@RequestMapping("/api")
public class SchoolResource {

    private final Logger log = LoggerFactory.getLogger(SchoolResource.class);

    private static final String ENTITY_NAME = "school";

    private final SchoolService schoolService;

    private final SchoolQueryService schoolQueryService;

    public SchoolResource(SchoolService schoolService, SchoolQueryService schoolQueryService) {
        this.schoolService = schoolService;
        this.schoolQueryService = schoolQueryService;
    }

    /**
     * POST  /schools : Create a new school.
     *
     * @param schoolDTO the schoolDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new schoolDTO, or with status 400 (Bad Request) if the school has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/schools")
    public ResponseEntity<SchoolDTO> createSchool(@RequestBody SchoolDTO schoolDTO) throws URISyntaxException {
        log.debug("REST request to save School : {}", schoolDTO);
        if (schoolDTO.getId() != null) {
            throw new BadRequestAlertException("A new school cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SchoolDTO result = schoolService.save(schoolDTO);
        return ResponseEntity.created(new URI("/api/schools/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /schools : Updates an existing school.
     *
     * @param schoolDTO the schoolDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated schoolDTO,
     * or with status 400 (Bad Request) if the schoolDTO is not valid,
     * or with status 500 (Internal Server Error) if the schoolDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/schools")
    public ResponseEntity<SchoolDTO> updateSchool(@RequestBody SchoolDTO schoolDTO) throws URISyntaxException {
        log.debug("REST request to update School : {}", schoolDTO);
        if (schoolDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SchoolDTO result = schoolService.save(schoolDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, schoolDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /schools : get all the schools.
     *
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of schools in body
     */
    @GetMapping("/schools")
    public ResponseEntity<List<SchoolDTO>> getAllSchools(SchoolCriteria criteria) {
        log.debug("REST request to get Schools by criteria: {}", criteria);
        List<SchoolDTO> entityList = schoolQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
    * GET  /schools/count : count all the schools.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/schools/count")
    public ResponseEntity<Long> countSchools(SchoolCriteria criteria) {
        log.debug("REST request to count Schools by criteria: {}", criteria);
        return ResponseEntity.ok().body(schoolQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /schools/:id : get the "id" school.
     *
     * @param id the id of the schoolDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the schoolDTO, or with status 404 (Not Found)
     */
    @GetMapping("/schools/{id}")
    public ResponseEntity<SchoolDTO> getSchool(@PathVariable Long id) {
        log.debug("REST request to get School : {}", id);
        Optional<SchoolDTO> schoolDTO = schoolService.findOne(id);
        return ResponseUtil.wrapOrNotFound(schoolDTO);
    }

    /**
     * DELETE  /schools/:id : delete the "id" school.
     *
     * @param id the id of the schoolDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/schools/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        log.debug("REST request to delete School : {}", id);
        schoolService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
