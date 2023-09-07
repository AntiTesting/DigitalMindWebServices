package com.example.digitalmindwebservices.entities.cross;

import com.example.digitalmindwebservices.entities.Database;
import com.example.digitalmindwebservices.entities.DigitalProfile;
import com.example.digitalmindwebservices.entities.Framework;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "frameworks_digital_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrameworkDigitalProfile {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "digital_profile_id", nullable = false)
    private DigitalProfile digitalProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frameworks_id", nullable = false)
    private Framework framework;
}
