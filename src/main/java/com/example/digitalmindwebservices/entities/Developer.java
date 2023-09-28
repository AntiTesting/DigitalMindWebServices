package com.example.digitalmindwebservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "developers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Developer extends User {
    private Integer experience;
    public Developer(Long id, String firstName, String lastName, String email, String phone, String password, String role, String description, String image, String bannerImage, Integer experience) {
        super(id, firstName, lastName, email, phone, password, role, description, image, bannerImage);
        this.experience = experience;
    }
}
