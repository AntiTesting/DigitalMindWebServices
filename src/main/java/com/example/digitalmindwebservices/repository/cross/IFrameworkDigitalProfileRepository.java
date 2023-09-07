package com.example.digitalmindwebservices.repository.cross;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFrameworkDigitalProfileRepository {
    @Query(value = """
        SELECT digital_profile_id FROM (
            SELECT DISTINCT digital_profile_id, frameworks_id FROM frameworks_digital_profiles
        ) SUBQUERY
        GROUP BY SUBQUERY.digital_profile_id
        HAVING STRING_AGG(SUBQUERY.frameworks_id::TEXT, ',' ORDER BY SUBQUERY.frameworks_id) = :filter;
    """, nativeQuery = true)
    List<Long> filterFramework(String filter);
}
