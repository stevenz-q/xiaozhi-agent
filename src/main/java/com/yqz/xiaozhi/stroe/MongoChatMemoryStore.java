package com.yqz.xiaozhi.stroe;

import com.yqz.xiaozhi.bean.ChatMessages;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author zhaoyq
 * @since 2025/11/26  15:11
 */
@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        ChatMessages chatMessages = mongoTemplate.findOne(Query.query(Criteria.where("memoryId").is(memoryId)), ChatMessages.class);
        if (chatMessages != null) {
            return ChatMessageDeserializer.messagesFromJson(chatMessages.getContent());
        }
        return Collections.emptyList();
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        Criteria criteria = Criteria.where("memoryId").is(memoryId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", ChatMessageSerializer.messagesToJson(messages));
        // 更新或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        mongoTemplate.remove(Query.query(Criteria.where("memoryId").is(memoryId)), ChatMessages.class);
    }
}

//ChatMemory chatMemory = MessageWindowChatMemory.builder()
//        .id("12345")
//        .maxMessages(10)
//        .chatMemoryStore(new PersistentChatMemoryStore())
//        .build();