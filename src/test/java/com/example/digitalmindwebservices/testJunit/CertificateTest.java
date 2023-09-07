package com.example.digitalmindwebservices.testJunit;

import com.example.digitalmindwebservices.entities.Certificate;
import com.example.digitalmindwebservices.repository.ICertificateRepository;
import com.example.digitalmindwebservices.service.ICertificateService;
import com.example.digitalmindwebservices.service.impl.CertificateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CertificateServiceTest {
    @Mock
    private ICertificateRepository certificateRepository;

    private ICertificateService certificateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        certificateService = new CertificateServiceImpl(certificateRepository);
    }


    @Test
    void testFindByEducationIdWithValidCertificates() throws Exception {
        List<Certificate> certificates = Arrays.asList(
                new Certificate(1L, "Certificado 1", "Descripción 1", "https://valid-certificate.com", new Date(), null),
                new Certificate(2L, "Certificado 2", "Descripción 2", "https://valid-certificate.com", new Date(), null)
        );
        when(certificateRepository.findByEducationId(1L)).thenReturn(certificates);

        List<Certificate> result = certificateService.findByEducationId(1L);

        assertEquals(certificates.size(), result.size());
        assertTrue(result.containsAll(certificates));

        verify(certificateRepository, times(1)).findByEducationId(1L);
    }
}
