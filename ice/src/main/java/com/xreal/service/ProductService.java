package com.xreal.service;


import com.xreal.entity.Product;
import com.xreal.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public List<Product> SelectAll()
    {
        return productMapper.SelectAll();
    }

}
