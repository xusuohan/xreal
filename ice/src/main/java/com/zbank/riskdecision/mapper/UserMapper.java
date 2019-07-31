package com.zbank.riskdecision.mapper;


import com.zbank.riskdecision.entity.User;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;

@Mapper
//@Repository
public interface UserMapper {
    //@Select("select * from t_user where user_id=#{id}")
    public User getById(@Param("id") int id);
    
    public List<Map<Integer, Object>> getAll();
    
    public List<Map<Integer, Object>> getCount();

}

