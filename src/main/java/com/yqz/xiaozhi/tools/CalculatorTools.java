package com.yqz.xiaozhi.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * 工具类（函数调用）
 *
 * @author zhaoyq
 * @since 2025/11/29  11:13
 */
@Component
public class CalculatorTools {

    @Tool(name = "sum", value = "将两个参数a和b相加并返回运算结果")
    double sum(
            @ToolMemoryId int memoryId,
            @P(value = "加数1", required = true) double a,
            @P(value = "加数2", required = true) double b) {
        System.out.println("调用加法运算 memoryId " + memoryId);
        return a + b;
    }

    @Tool(name = "squareRoot", value = "计算参数的平方根并返回结果")
    double squareRoot(double x) {
        System.out.println("调用平方根运算");
        return Math.sqrt(x);
    }
}
