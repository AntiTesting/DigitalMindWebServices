package com.example.digitalmindwebservices.repository.cross;

import com.example.digitalmindwebservices.entities.cross.ProgrammingLanguageDigitalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProgrammingLanguageDigitalProfileRepository extends JpaRepository<ProgrammingLanguageDigitalProfile, Long> {
    @Query(value = "SELECT digital_profile_id " +
            "FROM (SELECT DISTINCT digital_profile_id, programming_languages_id FROM programming_languages_digital_profiles) SUBQUERY " +
            "GROUP BY SUBQUERY.digital_profile_id " +
            "HAVING STRING_AGG(CAST(SUBQUERY.programming_languages_id AS TEXT), ',' ORDER BY SUBQUERY.programming_languages_id) = ?1", nativeQuery = true)
    List<Long> filterProgrammingLanguage(String filter);
}

/*

* */