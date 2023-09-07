package com.example.digitalmindwebservices.controller;

import com.example.digitalmindwebservices.entities.Developer;
import com.example.digitalmindwebservices.entities.DigitalProfile;
import com.example.digitalmindwebservices.entities.ProgrammingLanguage;
import com.example.digitalmindwebservices.service.IDeveloperService;
import com.example.digitalmindwebservices.service.IDigitalProfileService;
import com.example.digitalmindwebservices.service.IProgrammingLanguageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/programmingLanguages")
@Api(tags = "Programming Languages", value = "Web Service RESTFul of Programming Languages")

public class ProgrammingLanguageController {
    private final IProgrammingLanguageService programmingLanguageService;
    public ProgrammingLanguageController(IProgrammingLanguageService programmingLanguageService, IDigitalProfileService digitalProfileService, IDeveloperService developerService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all Programming Languages", notes = "Method to list all Programming Languages")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All Programming Languages founds"),
            @ApiResponse(code = 404, message = "Programming Languages Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<ProgrammingLanguage>> findAllProgrammingLanguages(){
        try {
            List<ProgrammingLanguage> programmingLanguages = programmingLanguageService.getAll();
            if(programmingLanguages.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(programmingLanguages, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Programming Language by Id", notes = "Method for find a Programming Language by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Programming Language found by Id"),
            @ApiResponse(code = 404, message = "Programming Language Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ProgrammingLanguage> findProgrammingLanguageById(@PathVariable("id") Long id){
        try {
            Optional<ProgrammingLanguage> programmingLanguage = programmingLanguageService.getById(id);
            return programmingLanguage.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
//    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Create a new Programming Language", notes = "Method for create a new Programming Language")
//    @ApiResponses({
//            @ApiResponse(code = 201, message = "Programming Language created"),
//            @ApiResponse(code = 404, message = "Programming Language Not Found"),
//            @ApiResponse(code = 501, message = "Internal Server Error")
//    })
//    public ResponseEntity<ProgrammingLanguage> createProgrammingLanguage(@PathVariable("id") Long id, @Valid @RequestBody ProgrammingLanguage programmingLanguage){
//        try {
//            Optional<DigitalProfile> digitalProfile = digitalProfileService.getById(id);
//            if(digitalProfile.isPresent()){
//                programmingLanguage.setDigitalProfile(digitalProfile.get());
//                ProgrammingLanguage programmingLanguage1 = programmingLanguageService.save(programmingLanguage);
//                return new ResponseEntity<>(programmingLanguage1, HttpStatus.CREATED);
//            }else{
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Programming Language", notes = "Method for update a Programming Language")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Programming Language updated"),
            @ApiResponse(code = 400, message = "Programming Language Not Updated"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ProgrammingLanguage> updateProgrammingLanguage(@PathVariable("id") Long id, @Valid @RequestBody ProgrammingLanguage programmingLanguage){
        try {
            Optional<ProgrammingLanguage> programmingLanguageUpdate = programmingLanguageService.getById(id);
            if(!programmingLanguageUpdate.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            programmingLanguage.setId(id);
            programmingLanguageService.save(programmingLanguage);
            return new ResponseEntity<>(programmingLanguage, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Programming Language", notes = "Method for delete a Programming Language")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Programming Language deleted"),
            @ApiResponse(code = 400, message = "Programming Language Not Deleted"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<ProgrammingLanguage> deleteProgrammingLanguage(@PathVariable("id") Long id){
        try {
            Optional<ProgrammingLanguage> programmingLanguageDelete = programmingLanguageService.getById(id);
            if(!programmingLanguageDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            programmingLanguageService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}