package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Service.ProductService;
import com.example.Service.UserService;
import com.example.domain.User;
import com.example.enums.SexEnum;
import com.example.mapper.UserMapper;
import org.apache.ibatis.logging.stdout.StdOutImpl;
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

    @Test
    public void testPage(){
        Page<User> page=new Page<>(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage);
    }
    @Test
    public void version01(){
        User user=userMapper.selectById(1L);
        System.out.println("一号"+user.getAge());
        User user2=userMapper.selectById(1L);
        System.out.println("一号"+user2.getAge());
        user.setAge(user.getAge()+1);
        userMapper.updateById(user);
        user2.setAge(user2.getAge()+2);
        userMapper.updateById(user2);


        System.out.println(userMapper.selectById(1L).getAge());


    }

    @Test
    public void Enumdemo(){
        User user=new User();
        user.setName("admin");
        user.setAge(18);
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }
    @Autowired
    private ProductService productService;
    @Test
    public void dynamictest(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }

}
