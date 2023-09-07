package com.example.digitalmindwebservices.entities;

import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "frameworks")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "iconLink", nullable = false, length = 500)
    private String iconLink;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "framework", cascade = CascadeType.ALL)
    private List<FrameworkDigitalProfile> frameworkDigitalProfiles;
}
