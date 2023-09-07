package com.example.digitalmindwebservices.repository.cross;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDatabaseDigitalProfileRepository {
    @Query(value = """
        SELECT digital_profile_id FROM (
            SELECT DISTINCT digital_profile_id, databases_id FROM databases_digital_profiles
        ) SUBQUERY
        GROUP BY SUBQUERY.digital_profile_id
        HAVING STRING_AGG(SUBQUERY.databases_id::TEXT, ',' ORDER BY SUBQUERY.databases_id) = :filter;
    """, nativeQuery = true)
    List<Long> filterDatabase(String filter);
}
