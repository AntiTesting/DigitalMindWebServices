package com.example.digitalmindwebservices.service.cross.impl;

import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import com.example.digitalmindwebservices.repository.cross.IFrameworkDigitalProfileRepository;
import com.example.digitalmindwebservices.service.cross.IFrameworkDigitalProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FrameworkDigitalProfileImpl implements IFrameworkDigitalProfileService {
    private final IFrameworkDigitalProfileRepository frameworkDigitalProfileRepository;

    public FrameworkDigitalProfileImpl(IFrameworkDigitalProfileRepository frameworkDigitalProfileRepository) {
        this.frameworkDigitalProfileRepository = frameworkDigitalProfileRepository;
    }

    @Override
    @Transactional
    public FrameworkDigitalProfile save(FrameworkDigitalProfile frameworkDigitalProfile) throws Exception {
        return frameworkDigitalProfileRepository.save(frameworkDigitalProfile);
    }

    @Override
    public void delete(Long id) throws Exception {
        frameworkDigitalProfileRepository.deleteById(id);
    }

    @Override
    public List<FrameworkDigitalProfile> getAll() throws Exception {
        return frameworkDigitalProfileRepository.findAll();
    }

    @Override
    public Optional<FrameworkDigitalProfile> getById(Long id) throws Exception {
        return frameworkDigitalProfileRepository.findById(id);
    }

    @Override
    public List<Long> filterFramework(String filter) throws Exception {
        return frameworkDigitalProfileRepository.filterFramework(filter);
    }
}
