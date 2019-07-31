package com.zbank.riskdecision.service.impl;

import com.zbank.riskdecision.entity.User;
import com.zbank.riskdecision.mapper.UserMapper;
import com.zbank.riskdecision.service.UserService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User getById(int id) {
        return userMapper.getById(id);
    }

	@Override
	public List<Map<Integer,Object>> getAllData() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}

	@Override
	public List<Map<Integer, Object>> getCount() {
		// TODO Auto-generated method stub
		return userMapper.getCount();
	}

}