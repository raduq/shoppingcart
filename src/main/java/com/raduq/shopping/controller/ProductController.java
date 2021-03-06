package com.raduq.shopping.controller;

import com.raduq.shopping.dto.ProductDto;
import com.raduq.shopping.dto.ProductsDto;
import com.raduq.shopping.model.Product;
import com.raduq.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Raduq on 04/07/2016.
 */
@RestController
@RequestMapping(value = "/store")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ProductsDto> products() {
        return ResponseEntity.ok(new ProductsDto(productService.getProducts()));
    }

    @RequestMapping(value = "/products/new", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ProductDto> newProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.newProduct(productDto.getName(), productDto.getImage(),Long.valueOf(productDto.getPrice())));
    }

}
