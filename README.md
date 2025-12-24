# 小智医疗

基于 langchain4j 实现的 ai-agent 智能体，提供医疗领域的智能问答，以及智能预约。

## 技术栈

- 后端：Java 17 + SpringBoot 3 + LangChain4j + MySQL + MongoDB + Pinecone（向量数据库）
- 前端：Vue 3 + Vite + Element Plus
## 项目功能

1. AI智能对话
   - 提供基于多种大语言模型的对话功能（阿里通义千问（默认）、OpenAI、Ollama）
   - 支持流式响应
2. 记忆化对话
   - 支持会话记忆功能，能够维持上下文连续性
   - 使用MongoDB存储对话历史和记忆
3. 工具调用
   - 集成预约工具，提供了查询预约，并将预约记录持久化到MySQL
4. RAG
   - 将知识存储到向量库
   - 通过向量检索增强AI回答能力，专门针对医疗场景优化，支持医院科室信息检索与咨询服务