package com.example.digitalmindwebservices.entities;

import com.example.digitalmindwebservices.entities.cross.DatabaseDigitalProfile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "databases")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "iconLink", nullable = false, length = 500)
    private String iconLink;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "database")
    private List<DatabaseDigitalProfile> databaseDigitalProfiles;
}

