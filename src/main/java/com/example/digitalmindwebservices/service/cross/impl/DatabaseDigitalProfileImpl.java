package com.example.digitalmindwebservices.service.cross.impl;

import com.example.digitalmindwebservices.entities.cross.DatabaseDigitalProfile;
import com.example.digitalmindwebservices.repository.cross.IDatabaseDigitalProfileRepository;
import com.example.digitalmindwebservices.service.cross.IDatabaseDigitalProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DatabaseDigitalProfileImpl implements IDatabaseDigitalProfileService {

    private final IDatabaseDigitalProfileRepository databaseDigitalProfileRepository;

    public DatabaseDigitalProfileImpl(IDatabaseDigitalProfileRepository databaseDigitalProfileRepository) {
        this.databaseDigitalProfileRepository = databaseDigitalProfileRepository;
    }

    @Override
    @Transactional
    public DatabaseDigitalProfile save(DatabaseDigitalProfile databaseDigitalProfile) throws Exception {
        return databaseDigitalProfileRepository.save(databaseDigitalProfile);
    }

    @Override
    public void delete(Long id) throws Exception {
        databaseDigitalProfileRepository.deleteById(id);
    }

    @Override
    public List<DatabaseDigitalProfile> getAll() throws Exception {
        return databaseDigitalProfileRepository.findAll();
    }

    @Override
    public Optional<DatabaseDigitalProfile> getById(Long id) throws Exception {
        return databaseDigitalProfileRepository.findById(id);
    }

    @Override
    public List<Long> filterDatabase(String filter) throws Exception {
        return databaseDigitalProfileRepository.filterDatabase(filter);
    }
}
