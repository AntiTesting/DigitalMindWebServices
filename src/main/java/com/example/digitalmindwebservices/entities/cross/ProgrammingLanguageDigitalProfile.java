package com.example.digitalmindwebservices.entities.cross;

import com.example.digitalmindwebservices.entities.Database;
import com.example.digitalmindwebservices.entities.DigitalProfile;
import com.example.digitalmindwebservices.entities.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "programming_languages_digital_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingLanguageDigitalProfile {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "digital_profile_id", nullable = false)
    private DigitalProfile digitalProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programming_languages_id", nullable = false)
    private ProgrammingLanguage programmingLanguage;
}
