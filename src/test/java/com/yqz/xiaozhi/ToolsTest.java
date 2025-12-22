package com.yqz.xiaozhi;

import com.yqz.xiaozhi.assistant.SeparateAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoyq
 * @since 2025/11/29  11:09
 */
@SpringBootTest
public class ToolsTest {
    @Autowired
    private SeparateAssistant separateAssistant;

    @Test
    public void testCalculatorTools() {
        String answer = separateAssistant.chat(25, "1+2等于几,445555的平凡根等于几");
        System.out.println(answer);
    }
}
