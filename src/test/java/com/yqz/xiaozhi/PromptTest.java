package com.yqz.xiaozhi;

import com.yqz.xiaozhi.assistant.MemoryChatAssistant;
import com.yqz.xiaozhi.assistant.SeparateAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoyq
 * @since 2025/11/26  15:55
 */
@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateAssistant separateAssistant;

    @Test
    public void testPrompt() {
        String answer = separateAssistant.chat(5, "我是谁？");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void userMessage() {
        String answer = memoryChatAssistant.chat("我是谁？");
        System.out.println(answer);
    }

    @Test
    public void testPrompt2() {
        String answer = separateAssistant.chat2(10, "我是谁？");
        System.out.println(answer);
    }

    @Test
    public void testUserInfo() {
        // 从数据库中获取用户信息
        String answer = separateAssistant.chat3(9, "我是谁？", "张三", 18);
        System.out.println(answer);
    }
}
