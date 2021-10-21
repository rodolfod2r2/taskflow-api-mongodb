package org.framework.rodolfo.freire.git.taskflow.controller;


import org.framework.rodolfo.freire.git.taskflow.document.Remark;
import org.framework.rodolfo.freire.git.taskflow.service.RemarkService;
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
public class RemarkController {

    final
    RemarkService remarkService;

    public RemarkController(RemarkService remarkService) {
        this.remarkService = remarkService;
    }

    @GetMapping(value = "/remark")
    public ResponseEntity<List<Remark>> getAllRemark() {
        List<Remark> listRemark = remarkService.findAll();
        return new ResponseEntity<>(listRemark, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/remark/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllRemarkPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Remark> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);
            Page<Remark> pages = remarkService.findAllPage(paging);
            elements = pages.getContent();
            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("remark", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/remark/{id}")
    public ResponseEntity<Remark> getRemarkById(@PathVariable String id) {
        Optional<Remark> remark = remarkService.findById(id);
        return remark.map(remark1 -> new ResponseEntity<>(remark1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/remark")
    public ResponseEntity<Remark> save(@RequestBody Remark user) {
        return new ResponseEntity<>(remarkService.save(user), HttpStatus.CREATED);
    }
}
