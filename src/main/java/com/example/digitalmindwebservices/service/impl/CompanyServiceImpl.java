package com.example.digitalmindwebservices.service.impl;

import com.example.digitalmindwebservices.entities.Company;
import com.example.digitalmindwebservices.entities.Developer;
import com.example.digitalmindwebservices.repository.ICompanyRepository;
import com.example.digitalmindwebservices.service.ICompanyService;
import com.example.digitalmindwebservices.service.IDigitalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements ICompanyService {

    private final ICompanyRepository _companyRepository;
    private final IDigitalProfileService digitalProfileService;
    public CompanyServiceImpl(IDigitalProfileService digitalProfileService, ICompanyRepository _companyRepository) {

        this.digitalProfileService = digitalProfileService;
        this._companyRepository = _companyRepository;
    }

    @Override
    @Transactional
    public Company save(Company company) throws Exception {
        return _companyRepository.save(company);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        _companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAll() throws Exception {
        return _companyRepository.findAll();
    }

    @Override
    public Optional<Company> getById(Long id) throws Exception {
        return _companyRepository.findById(id);
    }

    @Override
    public List<Developer> getFilteredDevelopers(int experience, String programmingLanguages, String frameworks, String databases) throws Exception {
        List<Long> profiles = digitalProfileService.filterDigitalProfile(programmingLanguages, frameworks, databases);
        if (profiles.isEmpty()) {
            System.out.println("No developers found");
            return null;
        }
        List<Developer> developerList = new ArrayList<>();
        for (Long profile : profiles) {
            Optional<Developer> developer = digitalProfileService.getDeveloperByDigitalProfileId(profile);
            if (developer.isPresent()) {
                if (developer.get().getExperience() >= experience) {
                    developerList.add(developer.get());
                }
            }
        }
        if (developerList.isEmpty()) {
            System.out.println("No developers with the specified experience found");
            return null;
        }
        return developerList;
    }
}
