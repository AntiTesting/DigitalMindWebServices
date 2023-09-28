package com.example.digitalmindwebservices.service.cross.impl;

import com.example.digitalmindwebservices.entities.cross.ProgrammingLanguageDigitalProfile;
import com.example.digitalmindwebservices.repository.cross.IProgrammingLanguageDigitalProfileRepository;
import com.example.digitalmindwebservices.service.cross.IProgrammingLanguageDigitalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProgrammingLanguageDigitalProfileImpl implements IProgrammingLanguageDigitalProfileService {
    private final IProgrammingLanguageDigitalProfileRepository programmingLanguageDigitalProfileRepository;

    public ProgrammingLanguageDigitalProfileImpl(IProgrammingLanguageDigitalProfileRepository programmingLanguageDigitalProfileRepository) {
        this.programmingLanguageDigitalProfileRepository = programmingLanguageDigitalProfileRepository;
    }

    @Override
    @Transactional
    public ProgrammingLanguageDigitalProfile save(ProgrammingLanguageDigitalProfile programmingLanguageDigitalProfile) throws Exception {
        return programmingLanguageDigitalProfileRepository.save(programmingLanguageDigitalProfile);
    }

    @Override
    public void delete(Long id) throws Exception {
        programmingLanguageDigitalProfileRepository.deleteById(id);
    }

    @Override
    public List<ProgrammingLanguageDigitalProfile> getAll() throws Exception {
        return programmingLanguageDigitalProfileRepository.findAll();
    }

    @Override
    public Optional<ProgrammingLanguageDigitalProfile> getById(Long id) throws Exception {
        return programmingLanguageDigitalProfileRepository.findById(id);
    }

    @Override
    public List<Long> filterProgrammingLanguage(String filter) throws Exception {
        return programmingLanguageDigitalProfileRepository.filterProgrammingLanguage(filter);
    }
}
