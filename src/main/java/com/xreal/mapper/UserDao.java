package com.xreal.mapper;


import com.xreal.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from user where id=#{id}")
    public User getNameById(@Param("id") long id);

    @Options(useGeneratedKeys = true, keyProperty = "iid")
    @Insert("insert into user(name) values(#{name})")
    public int insert(User user);
}
