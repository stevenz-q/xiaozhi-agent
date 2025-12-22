package com.yqz.xiaozhi;

import com.yqz.xiaozhi.assistant.Assistant;
import com.yqz.xiaozhi.assistant.MemoryChatAssistant;
import com.yqz.xiaozhi.assistant.SeparateAssistant;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoyq
 * @since 2025/11/25  21:42
 */
@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void test2() {
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(openAiChatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
        String answer = assistant.chat("我是环环");
        System.out.println(answer);
        String answer2 = assistant.chat("我是谁？");
        System.out.println(answer2);
    }

    @Autowired
    private MemoryChatAssistant assistant;

    @Test
    public void test4() {
        String answer = assistant.chat("我是环环");
        System.out.println(answer);
        String answer2 = assistant.chat("我是谁？");
        System.out.println(answer2);
    }

    @Autowired
    private SeparateAssistant separateAssistant;

    @Test
    public void test5() {
        String answer = separateAssistant.chat(1, "我是环环");
        System.out.println(answer);
        String answer3 = separateAssistant.chat(2, "我是谁？");
        System.out.println(answer3);
        String answer2 = separateAssistant.chat(1, "我是谁？");
        System.out.println(answer2);
    }
}
