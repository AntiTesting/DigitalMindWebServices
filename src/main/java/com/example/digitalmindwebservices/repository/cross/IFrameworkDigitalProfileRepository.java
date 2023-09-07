package com.example.digitalmindwebservices.repository.cross;

import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFrameworkDigitalProfileRepository extends JpaRepository<FrameworkDigitalProfile, Long> {
    @Query(value = "SELECT digital_profile_id " +
            "FROM (SELECT DISTINCT digital_profile_id, frameworks_id FROM frameworks_digital_profiles) SUBQUERY " +
            "GROUP BY SUBQUERY.digital_profile_id " +
            "HAVING STRING_AGG(CAST(SUBQUERY.frameworks_id AS TEXT), ',' ORDER BY SUBQUERY.frameworks_id) = ?1", nativeQuery = true)
    List<Long> filterFramework(String filter);
}