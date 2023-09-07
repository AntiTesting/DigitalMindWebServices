package com.example.digitalmindwebservices.service.cross;

import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import com.example.digitalmindwebservices.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public interface IFrameworkDigitalProfileService extends CrudService<FrameworkDigitalProfile> {
    List<Long> filterFramework(String filter) throws Exception;
}
