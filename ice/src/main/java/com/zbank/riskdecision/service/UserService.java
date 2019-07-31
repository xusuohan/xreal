package com.zbank.riskdecision.service;

import com.zbank.riskdecision.entity.User;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    @Autowired

    public User getById(int id);
    
    public List<Map<Integer,Object>> getAllData();
    
    public List<Map<Integer,Object>> getCount();
    
}