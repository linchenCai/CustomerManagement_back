package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testUserCrud() {
        // 1. 增 (Create)
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPhone("1234567890");
        user.setPassword("password123");
        int insertResult = userMapper.insert(user);
        assertEquals(1, insertResult, "插入失败");
        assertNotNull(user.getId(), "插入后ID应不为空");

        // 获取插入后带ID的对象，方便后续操作
        Integer insertedUserId = user.getId();

        // 2. 查 (Retrieve)
        User foundUser = userMapper.selectById(insertedUserId);
        assertNotNull(foundUser, "根据ID查询失败");
        assertEquals("testUser", foundUser.getUsername());
        assertEquals("test@example.com", foundUser.getEmail());

        // 3. 改 (Update)
        foundUser.setUsername("updatedUser");
        foundUser.setEmail("updated@example.com");
        int updateResult = userMapper.updateById(foundUser);
        assertEquals(1, updateResult, "更新失败");

        // 再次查询确认更新成功
        User updatedUser = userMapper.selectById(insertedUserId);
        assertNotNull(updatedUser, "更新后查询失败");
        assertEquals("updatedUser", updatedUser.getUsername());
        assertEquals("updated@example.com", updatedUser.getEmail());

    }
}