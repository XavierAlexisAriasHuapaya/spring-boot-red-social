package dev.arias.huapaya.redsocial.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.redsocial.persistence.entity.OperationEntity;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

    @Query("SELECT o FROM OperationEntity o WHERE o.permitAll = true")
    public List<OperationEntity> findByPublicAccess();

}
