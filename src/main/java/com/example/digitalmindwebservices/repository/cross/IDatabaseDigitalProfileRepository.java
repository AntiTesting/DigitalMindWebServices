package com.example.digitalmindwebservices.repository.cross;

import com.example.digitalmindwebservices.entities.cross.DatabaseDigitalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDatabaseDigitalProfileRepository extends JpaRepository<DatabaseDigitalProfile, Long> {
    @Query(value = "SELECT digital_profile_id " +
            "FROM (SELECT DISTINCT digital_profile_id, databases_id FROM databases_digital_profiles) SUBQUERY " +
            "GROUP BY SUBQUERY.digital_profile_id " +
            "HAVING STRING_AGG(CAST(SUBQUERY.databases_id AS TEXT), ',' ORDER BY SUBQUERY.databases_id) = ?1", nativeQuery = true)
    List<Long> filterDatabase(String filter);
}
