package dev.arias.huapaya.redsocial.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.redsocial.persistence.entity.RolEntity;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {

    public RolEntity findByDescription(String description);

}
