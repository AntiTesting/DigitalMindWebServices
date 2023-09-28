package com.example.digitalmindwebservices.testJunit;


import com.example.digitalmindwebservices.entities.Certificate;
import com.example.digitalmindwebservices.entities.Developer;
import com.example.digitalmindwebservices.entities.DigitalProfile;
import com.example.digitalmindwebservices.entities.Education;
import com.example.digitalmindwebservices.repository.ICertificateRepository;
import com.example.digitalmindwebservices.service.ICertificateService;
import com.example.digitalmindwebservices.service.impl.CertificateServiceImpl;
import com.example.digitalmindwebservices.service.impl.DeveloperServiceImpl;
import com.example.digitalmindwebservices.service.impl.DigitalProfileServiceImpl;
import com.example.digitalmindwebservices.service.impl.EducationServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CertificateServiceIntegrationTest {

    @Autowired
    private ICertificateService certificateService;

    @Autowired
    private EducationServiceImpl educationService;
    @Autowired
    private DigitalProfileServiceImpl digitalProfileService;
    @Autowired
    private DeveloperServiceImpl developerService;


    @Test
    public void testCreateCertificate() throws Exception {
        DigitalProfile digitalProfile = new DigitalProfile();
        Developer developer = new Developer();
        Education education = new Education();

        developer.setFirstName("Nombre");
        developer.setLastName("Apellido");
        developer.setEmail("correo@example.com");
        developer.setPhone("1234567890");
        developer.setPassword("contraseña");
        developer.setRole("developer");
        developer.setDescription("developer1");
        developer.setImage("imagen.png");
        developer.setBannerImage("example.png");
        developerService.save(developer);
        digitalProfile.setName("profile1");
        digitalProfile.setDeveloper(developer);
        digitalProfileService.save(digitalProfile);
        education.setId(1L);
        education.setCareer("Carrera 1");
        education.setDigitalProfile(digitalProfile);
        educationService.save(education);

        // Crear un certificado de prueba y asociarlo a la educación guardada
        Certificate certificate = new Certificate();
        certificate.setTitle("Certificado de Prueba");
        certificate.setDescription("Este es un certificado de prueba");
        certificate.setCertificateurl("https://valid-certificate.com");
        certificate.setObtainedDate(new Date(2023 - 1900, 8, 20));
        certificate.setEducation(education);

        try {
            // Llamar al método para crear un certificado
            Certificate createdCertificate = certificateService.save(certificate);
            // Verificar que el certificado se haya creado correctamente
            assertNotNull(createdCertificate.getId());
            // Verificar la relación entre el certificado y la educación
            assertEquals(education, certificate.getEducation());
            // Comprobar que la URL del certificado es válida
            assertTrue(certificateService.isValidCertificateUrl(createdCertificate.getCertificateurl()), "La URL del certificado no es válida.");
            // Comprobar que la fecha de obtención del certificado no es en el futuro
            Date currentDate = new Date();
            assertFalse(createdCertificate.getObtainedDate().after(currentDate), "La fecha de obtención del certificado no puede ser en el futuro.");

        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

}
