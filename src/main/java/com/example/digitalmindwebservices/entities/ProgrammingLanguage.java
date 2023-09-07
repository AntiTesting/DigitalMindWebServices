package com.example.digitalmindwebservices.entities;

import com.example.digitalmindwebservices.entities.cross.ProgrammingLanguageDigitalProfile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "programming_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "iconLink", nullable = false, length = 500)
    private String iconLink;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "programmingLanguage", cascade = CascadeType.ALL)
    private List<ProgrammingLanguageDigitalProfile> programmingLanguageDigitalProfiles;
}
