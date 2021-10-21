package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.History;
import org.framework.rodolfo.freire.git.taskflow.service.HistoryService;
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
public class HistoryController {

    final
    HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(value = "/history")
    public ResponseEntity<List<History>> getAllHistory() {
        List<History> listHistory = historyService.findAll();
        return new ResponseEntity<>(listHistory, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/history/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllHistoryPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<History> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<History> pages = historyService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("history", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/history/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable String id) {
        Optional<History> history = historyService.findById(id);
        return history.map(history1 -> new ResponseEntity<>(history1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/history")
    public ResponseEntity<History> save(@RequestBody History history) {
        return new ResponseEntity<>(historyService.save(history), HttpStatus.CREATED);
    }
}
