package com.maaz.api.mapper;

import com.maaz.api.dto.ProductsDTO;
import com.maaz.api.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper extends AbstractMapper<Products, ProductsDTO> {
    public ProductsMapper() {
        super(Products.class, ProductsDTO.class);
    }
}
