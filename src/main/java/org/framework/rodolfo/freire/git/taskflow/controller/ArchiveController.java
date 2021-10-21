package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.Archive;
import org.framework.rodolfo.freire.git.taskflow.service.ArchiveService;
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
public class ArchiveController {

    final
    ArchiveService archiveService;

    public ArchiveController(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }


    @GetMapping(value = "/archive", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Archive>> getAllArchive() {
        List<Archive> listArchive = archiveService.findAll();
        return new ResponseEntity<>(listArchive, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/archive/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllArchivePages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Archive> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<Archive> pages = archiveService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("archive", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/archive/{id}")
    public ResponseEntity<Archive> getArchiveById(@PathVariable String id) {
        Optional<Archive> archive = archiveService.findById(id);
        return archive.map(archive1 -> new ResponseEntity<>(archive1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/archive")
    public ResponseEntity<Archive> save(@RequestBody Archive archive) {
        return new ResponseEntity<>(archiveService.save(archive), HttpStatus.CREATED);
    }
}
