package dev.arias.huapaya.redsocial.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.redsocial.persistence.entity.PublicationEntity;
import dev.arias.huapaya.redsocial.persistence.repository.PublicationRepository;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationUpdateDto;
import dev.arias.huapaya.redsocial.service.interfaces.PublicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PublicationServiceImplementation implements PublicationService {

    private final PublicationRepository publicationRepository;

    @Transactional(readOnly = false)
    @Override
    public PublicationEntity create(PublicationCreateDto publication) {
        PublicationEntity publicationCreate = PublicationEntity.builder()
                .user(publication.getUser())
                .content(publication.getContent())
                .build();
        return this.publicationRepository.save(publicationCreate);
    }

    @Transactional(readOnly = false)
    @Override
    public PublicationEntity update(PublicationUpdateDto publication, Long id) {
        PublicationEntity publicationFind = this.publicationRepository.findById(id).get();
        PublicationEntity publicationUpdate = PublicationEntity.builder()
                .id(id)
                .user(publicationFind.getUser())
                .content(publication.getContent())
                .createdAt(publicationFind.getCreatedAt())
                .updatedAt(publicationFind.getUpdatedAt())
                .status(publicationFind.getStatus())
                .build();
        return this.publicationRepository.save(publicationUpdate);

    }

    @Transactional(readOnly = true)
    @Override
    public List<PublicationAllDto> findAll() {
        List<PublicationEntity> findAll = this.publicationRepository.findAll();
        return findAll.stream()
                .map(this::convertAll)
                .collect(Collectors.toList());
    }

    private PublicationAllDto convertAll(PublicationEntity publication) {
        PublicationAllDto publicationAllDto = PublicationAllDto.builder()
                .id(publication.getId())
                .user(publication.getUser())
                .content(publication.getContent())
                .createdAt(publication.getCreatedAt())
                .build();
        return publicationAllDto;
    }

}
