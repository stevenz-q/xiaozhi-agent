package com.yqz.xiaozhi.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 单用户聊天记忆配置类
 *
 * @author zhaoyq
 * @since 2025/11/25  22:02
 */
@Configuration
public class MemoryChatAssistantConfig {
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
