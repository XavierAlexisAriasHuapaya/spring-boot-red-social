package dev.arias.huapaya.redsocial.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "DISTINCT c.* " +
            "FROM chats c " +
            "INNER JOIN chat_members cm1 ON cm1.chat_id = c.id AND cm1.user_id = :userOne " +
            "INNER JOIN chat_members cm2 ON cm2.chat_id = c.id AND cm2.user_id = :userTwo " +
            "AND c.chat_type = 'PRIVATE'; ")
    Optional<ChatEntity> getChatByUsers(@Param("userOne") Long userOne, @Param("userTwo") Long userTwo);

}
