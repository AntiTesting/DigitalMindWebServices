package com.example.digitalmindwebservices.repository.cross;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProgrammingLanguageDigitalProfileRepository {
    @Query(value = """
        SELECT digital_profile_id
        FROM (
            SELECT DISTINCT digital_profile_id, programming_languages_id FROM programming_languages_digital_profiles
        ) SUBQUERY
        GROUP BY SUBQUERY.digital_profile_id
        HAVING STRING_AGG(SUBQUERY.programming_languages_id::TEXT, ',' ORDER BY SUBQUERY.programming_languages_id) = :filter;
    """, nativeQuery = true)
    List<Long> filterProgrammingLanguage(String filter);
}
