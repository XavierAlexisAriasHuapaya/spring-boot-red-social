package dev.arias.huapaya.redsocial.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.redsocial.persistence.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    public List<MessageEntity> findByChatId(Long chatId);

}
