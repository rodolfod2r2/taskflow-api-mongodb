package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.Family;
import org.framework.rodolfo.freire.git.taskflow.service.FamilyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class FamilyController {

    final
    FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping(value = "/family")
    public ResponseEntity<List<Family>> getAllFamily() {
        List<Family> listFamily = familyService.findAll();
        return new ResponseEntity<>(listFamily, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/family/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllFamilyPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Family> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<Family> pages = familyService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("family", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/family/{id}")
    public ResponseEntity<Family> getFamilyById(@PathVariable String id) {
        Optional<Family> family = familyService.findById(id);
        return family.map(family1 -> new ResponseEntity<>(family1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/family")
    public ResponseEntity<Family> save(@RequestBody Family family) {
        return new ResponseEntity<>(familyService.save(family), HttpStatus.CREATED);
    }
}
