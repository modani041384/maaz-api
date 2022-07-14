package com.maaz.api.controller;

import com.maaz.api.consts.ApiPath;
import com.maaz.api.consts.ErrorCode;
import com.maaz.api.dto.ProductsDTO;
import com.maaz.api.mapper.ProductsMapper;
import com.maaz.api.response.ProductsResponseDTO;
import com.maaz.api.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductsController {
    @Autowired
    ProductsService service;

    @GetMapping(value = ApiPath.PRODUCT_GET_ALL)
    public ResponseEntity<ProductsResponseDTO> getAll() {
        ProductsResponseDTO response = new ProductsResponseDTO();
        try {
            List<ProductsDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success when get all products");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get all products:", ex);
            response.setMessage("Error when get all products: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.PRODUCT_GET_BY_UUID)
    public ResponseEntity<ProductsResponseDTO> getByUUid(@RequestBody ProductsDTO request) {
        ProductsResponseDTO response = new ProductsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            ProductsDTO products = service.findByUUid(request.getProductId());
            response.setData(products);
            response.setMessage("Success when get product by id");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception ex) {
            log.error("Error when get product by id:", ex);
            response.setMessage("Error when get product by id: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.PRODUCT_CREATE)
    public ResponseEntity<ProductsResponseDTO> create(@RequestBody ProductsDTO request) {
        ProductsResponseDTO response = new ProductsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean create = service.create(request);
            if (!create) {
                response.setMessage("Create product fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when create product");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when create product:", ex);
            response.setMessage("Error when create product: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.PRODUCT_UPDATE)
    public ResponseEntity<ProductsResponseDTO> update(@RequestBody ProductsDTO request) {
        ProductsResponseDTO response = new ProductsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean update = service.update(request);
            if (!update) {
                response.setMessage("Update product fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when update product");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when update product:", ex);
            response.setMessage("Error when update product: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.PRODUCT_DELETE)
    public ResponseEntity<ProductsResponseDTO> delete(@RequestBody ProductsDTO request) {
        ProductsResponseDTO response = new ProductsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (!StringUtils.isNotBlank(request.getProductId())) {
                response.setMessage("Input product-id");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean delete = service.delete(request.getProductId());
            if (!delete) {
                response.setMessage("Update product fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when delete product");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when delete product:", ex);
            response.setMessage("Error when delete product: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //end
}
