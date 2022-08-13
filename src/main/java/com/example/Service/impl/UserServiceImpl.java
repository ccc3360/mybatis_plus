package com.example.Service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.Service.UserService;
import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;
@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
