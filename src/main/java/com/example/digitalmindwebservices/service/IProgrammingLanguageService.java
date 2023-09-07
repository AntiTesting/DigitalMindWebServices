package com.example.digitalmindwebservices.service;

import com.example.digitalmindwebservices.entities.ProgrammingLanguage;

import java.util.List;

public interface IProgrammingLanguageService extends CrudService<ProgrammingLanguage> {
    List<ProgrammingLanguage> findByName(String name) throws Exception;
}
