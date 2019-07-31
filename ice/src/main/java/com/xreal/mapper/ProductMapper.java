package com.xreal.mapper;
import com.xreal.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;



@Mapper
@Repository
public interface ProductMapper {
   @Select("select * from product")
   public List<Product> SelectAll();
}