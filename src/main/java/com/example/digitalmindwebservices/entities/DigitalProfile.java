package com.example.digitalmindwebservices.entities;

import com.example.digitalmindwebservices.entities.cross.DatabaseDigitalProfile;
import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import com.example.digitalmindwebservices.entities.cross.ProgrammingLanguageDigitalProfile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "digital_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DigitalProfile implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Developer developer;

    @OneToMany(mappedBy = "digitalProfile", cascade = CascadeType.ALL)
    private List<DatabaseDigitalProfile> databasesDigitalProfile;

    @OneToMany(mappedBy = "digitalProfile", cascade = CascadeType.ALL)
    private List<ProgrammingLanguageDigitalProfile> programmingLanguagesDigitalProfile;

    @OneToMany(mappedBy = "digitalProfile", cascade = CascadeType.ALL)
    private List<FrameworkDigitalProfile> frameworksDigitalProfile;
}
