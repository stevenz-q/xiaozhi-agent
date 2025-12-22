package com.yqz.xiaozhi;

import com.yqz.xiaozhi.assistant.Assistant;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoyq
 * @since 2025/11/25  21:09
 */
@SpringBootTest
public class AIServiceTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        String answer = assistant.chat("你是谁");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;

    @Test
    public void testAssistant() {
        String answer = assistant.chat("你是什么模型");
        System.out.println(answer);
    }
}
