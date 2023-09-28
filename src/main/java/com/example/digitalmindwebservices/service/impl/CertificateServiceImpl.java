package com.example.digitalmindwebservices.service.impl;

import com.example.digitalmindwebservices.entities.Certificate;
import com.example.digitalmindwebservices.repository.ICertificateRepository;
import com.example.digitalmindwebservices.service.ICertificateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CertificateServiceImpl implements ICertificateService {

    private final ICertificateRepository certificateRepository;

    public CertificateServiceImpl(ICertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    @Transactional
    public Certificate save(Certificate certificate) throws Exception {
        return certificateRepository.save(certificate);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        certificateRepository.deleteById(id);
    }

    @Override
    public List<Certificate> getAll() throws Exception {
        return  certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> getById(Long id) throws Exception {
        return certificateRepository.findById(id);
    }


    @Override
    public List<Certificate> findByEducationId(Long id) throws Exception {
        //return certificateRepository.findByEducationId(id);

        List<Certificate> certificates = certificateRepository.findByEducationId(id);

        List<Certificate> validCertificates = new ArrayList<>();
        for (Certificate certificate : certificates) {
            if (isValidCertificateUrl(certificate.getCertificateurl())) {
                validCertificates.add(certificate);
            } else {
                throw new Exception("Certificado inválido para ID: " + certificate.getId());
            }
        }

        return validCertificates;
    }

    public boolean isValidCertificateUrl(String certificateUrl) {
        return certificateUrl != null && !certificateUrl.isEmpty();
    }



}

