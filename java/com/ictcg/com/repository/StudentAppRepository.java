package com.ictcg.com.repository;

import com.ictcg.com.domain.StudentApp;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the StudentApp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StudentAppRepository extends JpaRepository<StudentApp, Long> {

}
