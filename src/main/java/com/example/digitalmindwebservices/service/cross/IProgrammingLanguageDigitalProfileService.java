package com.example.digitalmindwebservices.service.cross;

import com.example.digitalmindwebservices.entities.cross.ProgrammingLanguageDigitalProfile;
import com.example.digitalmindwebservices.service.CrudService;

import java.util.List;

public interface IProgrammingLanguageDigitalProfileService extends CrudService<ProgrammingLanguageDigitalProfile> {
    List<Long> filterProgrammingLanguage(String filter) throws Exception;
}
