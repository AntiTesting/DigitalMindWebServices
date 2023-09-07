package com.example.digitalmindwebservices.entities.cross;

import com.example.digitalmindwebservices.entities.Database;
import com.example.digitalmindwebservices.entities.DigitalProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "databases_digital_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseDigitalProfile {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "digital_profile_id", nullable = false)
    private DigitalProfile digitalProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "databases_id", nullable = false)
    private Database database;
}
