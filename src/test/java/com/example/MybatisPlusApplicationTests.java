package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Service.UserService;
import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
//
//    @Test
//    public void contextLoads() {
////        List<User> mybatis_pluses=userMapper.selectList(null);
////        for (User mp:mybatis_pluses
////             ) {
////            System.out.println(mp);
////        }
//
////        System.out.println(userMapper.selectById(1L));
//
////        User user=new User();
////        user.setAge(8);
////        user.setEmail("aaaaaas@qq.com");
////        user.setName("Amazon");
////        int result=userMapper.insert(user);
////        System.out.println(result);
////        System.out.println(user.getId());
//
//        Map<String,Object> map=userMapper.selectMapById(1L);
//        System.out.println(map);
//
//    }

    @Autowired
    private UserService userService;

    @Test
    public void selectcount(){
        long x=userService.count();
        System.out.println(x);

    }

    @Test
    public void querydemo(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
    }

}
