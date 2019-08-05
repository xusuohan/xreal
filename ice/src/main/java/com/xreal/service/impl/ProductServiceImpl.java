package com.xreal.service.impl;


import com.xreal.dao.ProductMapper;
import com.xreal.entity.Product;
import com.xreal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> SelectAll() {
        List<Product> list = productMapper.SelectAll();
        return list;
    }
}
