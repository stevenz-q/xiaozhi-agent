package com.yqz.xiaozhi.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 聊天记忆的AiService
 *
 * @author zhaoyq
 * @since 2025/11/25  22:01
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "openAiChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {
    //@UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。{{it}}")
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。{{message}}")
    String chat(@V("message") String userMessage);
}
