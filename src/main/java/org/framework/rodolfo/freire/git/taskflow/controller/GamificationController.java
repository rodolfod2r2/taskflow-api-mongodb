package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.Gamification;
import org.framework.rodolfo.freire.git.taskflow.service.GamificationService;
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
public class GamificationController {

    final
    GamificationService gamificationService;

    public GamificationController(GamificationService gamificationService) {
        this.gamificationService = gamificationService;
    }

    @GetMapping(value = "/gamification")
    public ResponseEntity<List<Gamification>> getAllGamification() {
        List<Gamification> listGamification = gamificationService.findAll();
        return new ResponseEntity<>(listGamification, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/gamification/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllGamificationPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Gamification> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<Gamification> pages = gamificationService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("gamification", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/gamification/{id}")
    public ResponseEntity<Gamification> getGamificationById(@PathVariable String id) {
        Optional<Gamification> gamification = gamificationService.findById(id);
        return gamification.map(gamification1 -> new ResponseEntity<>(gamification1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/gamification")
    public ResponseEntity<Gamification> save(@RequestBody Gamification gamification) {
        return new ResponseEntity<>(gamificationService.save(gamification), HttpStatus.CREATED);
    }
}
