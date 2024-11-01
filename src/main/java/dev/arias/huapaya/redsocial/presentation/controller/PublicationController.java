package dev.arias.huapaya.redsocial.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.redsocial.persistence.entity.PublicationEntity;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationUpdateDto;
import dev.arias.huapaya.redsocial.service.interfaces.PublicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(path = "publication")
@RestController
public class PublicationController {

    private final PublicationService publicationService;
    
    @PreAuthorize("hasAuthority('PUBLICATION_CREATE')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PublicationCreateDto publication) {
        Map<String, Object> response = new HashMap<>();
        PublicationEntity publicationCreate = this.publicationService.create(publication);
        response.put("data", publicationCreate);
        response.put("message", "Successfully created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('PUBLICATION_UPDATE')")
    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody PublicationUpdateDto publication, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        PublicationEntity publicationUpdate = this.publicationService.update(publication, id);
        response.put("data", publicationUpdate);
        response.put("message", "Successfully updated");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('PUBLICATION_ALL')")
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PublicationAllDto> publicationAll = this.publicationService.findAll();
        return new ResponseEntity<>(publicationAll, HttpStatus.OK);
    }

}
