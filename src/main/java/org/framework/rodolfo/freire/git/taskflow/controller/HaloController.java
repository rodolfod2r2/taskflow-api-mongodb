package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.Halo;
import org.framework.rodolfo.freire.git.taskflow.service.HaloService;
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
public class HaloController {

    final
    HaloService haloService;

    public HaloController(HaloService haloService) {
        this.haloService = haloService;
    }

    @GetMapping(value = "/halo")
    public ResponseEntity<List<Halo>> getAllHalo() {
        List<Halo> listHalo = haloService.findAll();
        return new ResponseEntity<>(listHalo, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/halo/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllHaloPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Halo> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<Halo> pages = haloService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("halo", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/halo/{id}")
    public ResponseEntity<Halo> getHaloById(@PathVariable String id) {
        Optional<Halo> halo = haloService.findById(id);
        return halo.map(halo1 -> new ResponseEntity<>(halo1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/halo")
    public ResponseEntity<Halo> save(@RequestBody Halo halo) {
        return new ResponseEntity<>(haloService.save(halo), HttpStatus.CREATED);
    }
}
