package dev.arias.huapaya.redsocial.service.interfaces;

import java.util.List;

import dev.arias.huapaya.redsocial.persistence.entity.PublicationEntity;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.publication.PublicationUpdateDto;

public interface PublicationService {

    public PublicationEntity create(PublicationCreateDto publication);

    public PublicationEntity update(PublicationUpdateDto publication, Long id);

    public List<PublicationAllDto> findAll();

}
