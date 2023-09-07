package com.example.digitalmindwebservices.service.impl;

import com.example.digitalmindwebservices.entities.DigitalProfile;
import com.example.digitalmindwebservices.repository.IDigitalProfileRepository;
import com.example.digitalmindwebservices.service.IDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IDatabaseDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IFrameworkDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IProgrammingLanguageDigitalProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class DigitalProfileServiceImpl implements IDigitalProfileService {
    private final IDatabaseDigitalProfileService databaseDigitalProfileService;
    private final IFrameworkDigitalProfileService frameworkDigitalProfileService;
    private final IProgrammingLanguageDigitalProfileService programmingLanguageDigitalProfileService;

    private final IDigitalProfileRepository digitalProfileRepository;

    public DigitalProfileServiceImpl(IDigitalProfileRepository digitalProfileRepository, IDatabaseDigitalProfileService databaseDigitalProfileService, IFrameworkDigitalProfileService frameworkDigitalProfileService, IProgrammingLanguageDigitalProfileService programmingLanguageDigitalProfileService) {
        this.digitalProfileRepository = digitalProfileRepository;
        this.databaseDigitalProfileService = databaseDigitalProfileService;
        this.frameworkDigitalProfileService = frameworkDigitalProfileService;
        this.programmingLanguageDigitalProfileService = programmingLanguageDigitalProfileService;
    }

    @Override
    @Transactional
    public DigitalProfile save(DigitalProfile digitalProfile) throws Exception {
        return digitalProfileRepository.save(digitalProfile);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        digitalProfileRepository.deleteById(id);
    }

    @Override
    public List<DigitalProfile> getAll() throws Exception {
        return digitalProfileRepository.findAll();
    }

    @Override
    public Optional<DigitalProfile> getById(Long id) throws Exception {
        return digitalProfileRepository.findById(id);
    }

    @Override
    public Optional<DigitalProfile> findDigitalProfileByDeveloperId(Long id) throws Exception {
        return digitalProfileRepository.findDigitalProfileByDeveloperId(id);
    }

    @Override
    public List<Long> filterDigitalProfile(String filterDatabase, String filterFramework, String filterProgrammingLanguage) throws Exception {
        List<Long> databaseIds = databaseDigitalProfileService.filterDatabase(filterDatabase);
        List<Long> frameworkIds = frameworkDigitalProfileService.filterFramework(filterFramework);
        List<Long> programmingLanguageIds = programmingLanguageDigitalProfileService.filterProgrammingLanguage(filterProgrammingLanguage);

        Set<Long> intersection = new HashSet<>(databaseIds);

        if (!databaseIds.isEmpty()) {
            intersection.addAll(databaseIds);
        }

        if (!intersection.isEmpty() && !frameworkIds.isEmpty()) {
            intersection.retainAll(frameworkIds);
        } else if (!frameworkIds.isEmpty()) {
            intersection.addAll(frameworkIds);
        }

        if (!intersection.isEmpty() && !programmingLanguageIds.isEmpty()) {
            intersection.retainAll(programmingLanguageIds);
        } else if (!programmingLanguageIds.isEmpty()) {
            intersection.addAll(programmingLanguageIds);
        }

        if (!intersection.isEmpty()) {
            return List.copyOf(intersection);
        }
        return List.of();
    }
}
