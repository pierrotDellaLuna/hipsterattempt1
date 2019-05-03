package com.ictcg.com.web.rest;
import com.ictcg.com.service.StudentAppService;
import com.ictcg.com.web.rest.errors.BadRequestAlertException;
import com.ictcg.com.web.rest.util.HeaderUtil;
import com.ictcg.com.service.dto.StudentAppDTO;
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
 * REST controller for managing StudentApp.
 */
@RestController
@RequestMapping("/api")
public class StudentAppResource {

    private final Logger log = LoggerFactory.getLogger(StudentAppResource.class);

    private static final String ENTITY_NAME = "studentApp";

    private final StudentAppService studentAppService;

    public StudentAppResource(StudentAppService studentAppService) {
        this.studentAppService = studentAppService;
    }

    /**
     * POST  /student-apps : Create a new studentApp.
     *
     * @param studentAppDTO the studentAppDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new studentAppDTO, or with status 400 (Bad Request) if the studentApp has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/student-apps")
    public ResponseEntity<StudentAppDTO> createStudentApp(@RequestBody StudentAppDTO studentAppDTO) throws URISyntaxException {
        log.debug("REST request to save StudentApp : {}", studentAppDTO);
        if (studentAppDTO.getId() != null) {
            throw new BadRequestAlertException("A new studentApp cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StudentAppDTO result = studentAppService.save(studentAppDTO);
        return ResponseEntity.created(new URI("/api/student-apps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /student-apps : Updates an existing studentApp.
     *
     * @param studentAppDTO the studentAppDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated studentAppDTO,
     * or with status 400 (Bad Request) if the studentAppDTO is not valid,
     * or with status 500 (Internal Server Error) if the studentAppDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/student-apps")
    public ResponseEntity<StudentAppDTO> updateStudentApp(@RequestBody StudentAppDTO studentAppDTO) throws URISyntaxException {
        log.debug("REST request to update StudentApp : {}", studentAppDTO);
        if (studentAppDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StudentAppDTO result = studentAppService.save(studentAppDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, studentAppDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /student-apps : get all the studentApps.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of studentApps in body
     */
    @GetMapping("/student-apps")
    public List<StudentAppDTO> getAllStudentApps() {
        log.debug("REST request to get all StudentApps");
        return studentAppService.findAll();
    }

    /**
     * GET  /student-apps/:id : get the "id" studentApp.
     *
     * @param id the id of the studentAppDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the studentAppDTO, or with status 404 (Not Found)
     */
    @GetMapping("/student-apps/{id}")
    public ResponseEntity<StudentAppDTO> getStudentApp(@PathVariable Long id) {
        log.debug("REST request to get StudentApp : {}", id);
        Optional<StudentAppDTO> studentAppDTO = studentAppService.findOne(id);
        return ResponseUtil.wrapOrNotFound(studentAppDTO);
    }

    /**
     * DELETE  /student-apps/:id : delete the "id" studentApp.
     *
     * @param id the id of the studentAppDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/student-apps/{id}")
    public ResponseEntity<Void> deleteStudentApp(@PathVariable Long id) {
        log.debug("REST request to delete StudentApp : {}", id);
        studentAppService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
