package com.yqz.xiaozhi.config;

import com.yqz.xiaozhi.stroe.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多用户聊天记忆配置类
 *
 * @author zhaoyq
 * @since 2025/11/26  09:04
 */
@Configuration
public class SeparateAssistantConfig {
    /**
     * 方案一
     * 独立的Store
     * @param inMemoryChatMemoryStore
     * @return
     */
/*    @Bean
    public ChatMemoryProvider chatMemoryProvider(InMemoryChatMemoryStore inMemoryChatMemoryStore) {
        return memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(10).build();
        //return new ChatMemoryProvider() {
        //    @Override
        //    public ChatMemory get(Object memoryId) {
        //        return new MessageWindowChatMemory.Builder().id(memoryId).maxMessages(10).build();
        //    }
        //};
    }*/

    /**
     * 方案二
     * 共享Store，单例InMemoryChatMemoryStore
     */
/*    @Bean
    public InMemoryChatMemoryStore inMemoryChatMemoryStore() {
        return new InMemoryChatMemoryStore();
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider(InMemoryChatMemoryStore inMemoryChatMemoryStore) {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(inMemoryChatMemoryStore)
                .build();
    }*/
    @Bean
    public ChatMemoryProvider chatMemoryProvider(MongoChatMemoryStore mongoChatMemoryStore) {
        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }

}
