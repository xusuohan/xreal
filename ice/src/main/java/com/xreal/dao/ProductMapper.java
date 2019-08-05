package com.xreal.dao;

 import com.xreal.entity.Product;
 import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
   public List<Product> SelectAll();
}
