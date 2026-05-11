package br.com.tudocarros.api.controller;

import br.com.tudocarros.api.dto.SpecRequestDTO;
import br.com.tudocarros.api.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/specifications")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @PostMapping("/search")
    public ResponseEntity<Map<String, Object>> searchSpecs(@RequestBody SpecRequestDTO request) {
        
        // A regra de negócio fica blindada no Service (Cumprindo requisito de SOA)
        Map<String, Object> response = specificationService.generateStandardSpecs(request);
        
        return ResponseEntity.ok(response);
    }
}