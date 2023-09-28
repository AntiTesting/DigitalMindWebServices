package com.example.digitalmindwebservices.service;

import com.example.digitalmindwebservices.entities.*;
import com.example.digitalmindwebservices.entities.cross.DatabaseDigitalProfile;
import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import com.example.digitalmindwebservices.entities.cross.ProgrammingLanguageDigitalProfile;
import com.example.digitalmindwebservices.service.cross.IDatabaseDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IFrameworkDigitalProfileService;
import com.example.digitalmindwebservices.service.cross.IProgrammingLanguageDigitalProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ICompanyServiceIntegralTest {
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IDatabaseService databaseService;
    @Autowired
    private IFrameworkService frameworkService;
    @Autowired
    private IProgrammingLanguageService programmingLanguageService;
    @Autowired
    private IDeveloperService developerService;
    @Autowired
    private IDigitalProfileService digitalProfileService;
    @Autowired
    private IProgrammingLanguageDigitalProfileService programmingLanguageDigitalProfileService;
    @Autowired
    private IDatabaseDigitalProfileService databaseDigitalProfileService;
    @Autowired
    private IFrameworkDigitalProfileService frameworkDigitalProfileService;

    @BeforeEach
    void setUp() throws Exception {
        Database mysql = new Database(1L, "MySQL", "https://www.mysql.com/common/logos/logo-mysql-170x115.png", "MySQL is an open-source relational database management system.", null);
        Database postgresql = new Database(2L, "PostgreSQL", "https://www.postgresql.org/media/img/about/press/elephant.png", "PostgreSQL is a free and open-source relational database management system.", null);
        Database mongodb = new Database(3L, "MongoDB", "https://webassets.mongodb.com/_com_assets/cms/mongodb_logo1-76twgcu2dm.png", "MongoDB is a source-available cross-platform document-oriented database program.", null);
        databaseService.save(mysql);
        databaseService.save(postgresql);
        databaseService.save(mongodb);

        Framework spring = new Framework(1L, "Spring", "https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg", "Spring is a lightweight framework.", null);
        Framework angular = new Framework(2L, "Angular", "https://angular.io/assets/images/logos/angular/angular.svg", "Angular is a TypeScript-based open-source web application framework.", null);
        Framework react = new Framework(3L, "React", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1280px-React-icon.svg.png", "React is an open-source front-end JavaScript library for building user interfaces or UI components.", null);
        frameworkService.save(spring);
        frameworkService.save(angular);
        frameworkService.save(react);

        ProgrammingLanguage java = new ProgrammingLanguage(1L, "Java", "https://www.oracle.com/a/ocom/img/cb71-java-logo.png", "Java is a class-based, object-oriented programming language.", null);
        ProgrammingLanguage python = new ProgrammingLanguage(2L, "Python", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1200px-Python-logo-notext.svg.png", "Python is an interpreted, high-level and general-purpose programming language.", null);
        ProgrammingLanguage javascript = new ProgrammingLanguage(3L, "JavaScript", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1280px-Unofficial_JavaScript_logo_2.svg.png", "JavaScript is a programming language that conforms to the ECMAScript specification.", null);
        programmingLanguageService.save(java);
        programmingLanguageService.save(python);
        programmingLanguageService.save(javascript);

        Developer juan = new Developer(1L, "Juan", "Jimenez", "correo01@gmail.com", "963254789", "pass123", "dev", "Im a developer", "string", "string", 5);
        Developer pedro = new Developer(2L, "Pedro", "Perez", "correo02@gmail.com", "986542359", "pass124", "dev", "Im a developer", "string", "string", 2);
        Developer maria = new Developer(3L, "Maria", "Gomez", "correo03@gmail.com", "985247963", "pass125", "dev", "Im a developer", "string", "string", 3);
        developerService.save(juan);
        developerService.save(pedro);
        developerService.save(maria);

        digitalProfileService.save(new DigitalProfile(0L, "Juan's Digital Profile", juan, null, null, null));
        digitalProfileService.save(new DigitalProfile(0L, "Pedro's Digital Profile", pedro, null, null, null));
        digitalProfileService.save(new DigitalProfile(0L, "Maria's Digital Profile", maria, null, null, null));

        programmingLanguageDigitalProfileService.save(new ProgrammingLanguageDigitalProfile(0L, digitalProfileService.getById(1L).get(), java));
        programmingLanguageDigitalProfileService.save(new ProgrammingLanguageDigitalProfile(0L, digitalProfileService.getById(1L).get(), python));
        programmingLanguageDigitalProfileService.save(new ProgrammingLanguageDigitalProfile(0L, digitalProfileService.getById(1L).get(), javascript));
        programmingLanguageDigitalProfileService.save(new ProgrammingLanguageDigitalProfile(0L, digitalProfileService.getById(2L).get(), javascript));
        programmingLanguageDigitalProfileService.save(new ProgrammingLanguageDigitalProfile(0L, digitalProfileService.getById(3L).get(), python));
        programmingLanguageDigitalProfileService.save(new ProgrammingLanguageDigitalProfile(0L, digitalProfileService.getById(3L).get(), java));

        databaseDigitalProfileService.save(new DatabaseDigitalProfile(0L, digitalProfileService.getById(1L).get(), postgresql));
        databaseDigitalProfileService.save(new DatabaseDigitalProfile(0L, digitalProfileService.getById(2L).get(), postgresql));
        databaseDigitalProfileService.save(new DatabaseDigitalProfile(0L, digitalProfileService.getById(3L).get(), mongodb));
        databaseDigitalProfileService.save(new DatabaseDigitalProfile(0L, digitalProfileService.getById(1L).get(), mysql));

        frameworkDigitalProfileService.save(new FrameworkDigitalProfile(0L, digitalProfileService.getById(1L).get(), angular));
        frameworkDigitalProfileService.save(new FrameworkDigitalProfile(0L, digitalProfileService.getById(2L).get(), react));
        frameworkDigitalProfileService.save(new FrameworkDigitalProfile(0L, digitalProfileService.getById(3L).get(), spring));
        frameworkDigitalProfileService.save(new FrameworkDigitalProfile(0L, digitalProfileService.getById(1L).get(), spring));

    }

    @Test
    void getFilteredDevelopers() throws Exception {
        List<Developer> developerList = companyService.getFilteredDevelopers(5, "1,2,3", "1,2", "1");
        assertEquals(developerList.get(0).getFirstName(), "Juan");
    }
}