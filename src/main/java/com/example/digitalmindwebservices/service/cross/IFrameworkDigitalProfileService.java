package com.example.digitalmindwebservices.service.cross;

import com.example.digitalmindwebservices.entities.cross.FrameworkDigitalProfile;
import com.example.digitalmindwebservices.service.CrudService;

import java.util.List;

public interface IFrameworkDigitalProfileService extends CrudService<FrameworkDigitalProfile> {
    List<Long> filterFramework(String filter) throws Exception;
}
