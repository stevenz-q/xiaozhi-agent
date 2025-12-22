package com.yqz.xiaozhi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 聊天对话记录
 *
 * @author zhaoyq
 * @since 2025/11/26  12:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {
    @Id//唯一标识，映射到MongoDB文档的——id字段
    private ObjectId messageId;
    private String memoryId;
    private String content;

    public ChatMessages(String content, String memoryId) {
        this.content = content;
        this.memoryId = memoryId;
    }
}
