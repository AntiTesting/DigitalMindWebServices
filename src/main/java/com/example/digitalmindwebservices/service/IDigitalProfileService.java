package com.example.digitalmindwebservices.service;

import com.example.digitalmindwebservices.entities.Developer;
import com.example.digitalmindwebservices.entities.DigitalProfile;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IDigitalProfileService extends CrudService<DigitalProfile> {

    Optional<DigitalProfile> findDigitalProfileByDeveloperId(Long id) throws Exception;
    List<Long> filterDigitalProfile(String filterDatabase, String filterFramework, String filterProgrammingLanguage) throws Exception;
    Optional<Developer> getDeveloperByDigitalProfileId(Long id) throws Exception;
}
