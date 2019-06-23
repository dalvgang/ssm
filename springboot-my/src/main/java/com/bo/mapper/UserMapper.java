package com.bo.mapper;

import com.bo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
