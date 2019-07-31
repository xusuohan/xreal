package com.xreal.controller;

 import com.xreal.entity.Product;
import com.xreal.service.ProductService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InterController {
    @Autowired
    ProductService productService;
    @RequestMapping("/project")
    @ResponseBody
    public List<Product> myProject() {

        List<Product> productArrayList = new ArrayList<Product>();

            productArrayList = productService.SelectAll();

        return productArrayList;
    }
}
