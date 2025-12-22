package com.yqz.xiaozhi;

import com.yqz.xiaozhi.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


/**
 * @author zhaoyq
 * @since 2025/11/26  12:55
 */
@SpringBootTest
public class MongoCrudTest {
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 插入测试
     */
    @Test
    public void testInsert() {
        //mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }

    /**
     * 查询测试
     */
    @Test
    public void testFindById() {
        ChatMessages messages = mongoTemplate.findById("692689a9eeda330b62ac36c0", ChatMessages.class);
        System.out.println(messages);
    }

    /**
     * 修改测试
     */
    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("692689a9eeda330b62ac36c0");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录列表");
        // 更新或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }
    /**
     * 删除测试
     */
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("692689a9eeda330b62ac36c0");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
