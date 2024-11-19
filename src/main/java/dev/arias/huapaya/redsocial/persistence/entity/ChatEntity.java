package dev.arias.huapaya.redsocial.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import dev.arias.huapaya.redsocial.persistence.entity.enums.ChatTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chats")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uniqueCode;

    private String name;

    @Enumerated(EnumType.STRING)
    private ChatTypeEnum chatType;

    @JoinColumn(name = "senderId")
    private UserEntity sender;

    @JoinColumn(name = "receiverId")
    private UserEntity receiver;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean status;

    @PrePersist
    private void PrePersist() {
        if (sender != null && receiver != null) {
            this.uniqueCode = generateChatCode();
        }
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = true;
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.status = true;
    }

    private String generateChatCode() {
        Long senderId = this.sender.getId();
        Long receiverId = this.receiver.getId();
        return senderId > receiverId ? (senderId + "-" + receiverId) : (receiverId + "-" + senderId);
    }

}
