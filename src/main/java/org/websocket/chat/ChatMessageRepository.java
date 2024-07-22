package org.websocket.chat;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author prabhakar, @Date 19-07-2024
 */
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    List<ChatMessage> findByChatId(String chatId);
}
