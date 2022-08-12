package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id铲鲟用户信息为Map集合
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(Long id);
}
