package dev.arias.huapaya.redsocial.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.presentation.projection.chat.ChatAllByUserProjection;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

        @Query(nativeQuery = true, value = "SELECT " +
                        "DISTINCT c.* " +
                        "FROM chats c " +
                        "INNER JOIN chat_members cm1 ON cm1.chat_id = c.id AND cm1.user_id = :userOne " +
                        "INNER JOIN chat_members cm2 ON cm2.chat_id = c.id AND cm2.user_id = :userTwo " +
                        "AND c.chat_type = 'PRIVATE'; ")
        Optional<ChatEntity> getChatByUsers(@Param("userOne") Long userOne, @Param("userTwo") Long userTwo);

        @Query("SELECT c AS chat, " +
                        "m AS message " +
                        "FROM ChatEntity c " +
                        "JOIN c.chatMembers cm " +
                        "JOIN MessageEntity m ON m.chat.id = c.id " +
                        "WHERE cm.user.id = :userId " +
                        "AND m.createdAt = (SELECT MAX(m2.createdAt) FROM MessageEntity m2 WHERE m2.chat.id = c.id)")
        List<ChatAllByUserProjection> findChatsByUserId(@Param("userId") Long userId);

        @Query("SELECT c AS chat, " +
                        "m AS message " +
                        "FROM ChatEntity c " +
                        "JOIN c.chatMembers cm " +
                        "JOIN MessageEntity m ON m.chat.id = c.id " +
                        "WHERE cm.user.id = :userId " +
                        "AND c.id = :chatId " +
                        "AND m.createdAt = (SELECT MAX(m2.createdAt) FROM MessageEntity m2 WHERE m2.chat.id = c.id)")
        ChatAllByUserProjection findChatOneByUserId(@Param("chatId") Long chatId, @Param("userId") Long userId);

}
