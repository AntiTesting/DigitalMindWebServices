package com.example.digitalmindwebservices.service.cross;

import com.example.digitalmindwebservices.entities.cross.DatabaseDigitalProfile;
import com.example.digitalmindwebservices.service.CrudService;

import java.util.List;

public interface IDatabaseDigitalProfileService extends CrudService<DatabaseDigitalProfile> {
    List<Long> filterDatabase(String filter) throws Exception;
}
