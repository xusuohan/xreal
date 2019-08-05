package com.xreal.service;

import com.xreal.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> SelectAll();
}
