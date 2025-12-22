package com.yqz.xiaozhi.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author zhaoyq
 * @since 2025/11/25  21:09
 */
@AiService(wiringMode = EXPLICIT, chatModel = "openAiChatModel")
public interface Assistant {
    String chat(String userMessage);
}
