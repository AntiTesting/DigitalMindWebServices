package com.example.digitalmindwebservices.service;

import com.example.digitalmindwebservices.entities.Company;
import com.example.digitalmindwebservices.entities.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICompanyService extends CrudService<Company> {
    List<Developer> getFilteredDevelopers(int experience, String programmingLanguages, String frameworks, String databases) throws Exception;
}

