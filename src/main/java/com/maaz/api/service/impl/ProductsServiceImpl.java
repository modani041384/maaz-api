package com.maaz.api.service.impl;

import com.maaz.api.dto.ProductsDTO;
import com.maaz.api.entity.Products;
import com.maaz.api.mapper.ProductsMapper;
import com.maaz.api.repository.ProductsRepository;
import com.maaz.api.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsRepository repository;

    @Autowired
    ProductsMapper mapper;

    @Override
    public boolean create(ProductsDTO dto) {
        try {
            Products entity = mapper.convertDTOToEntity(dto);
            entity.setActive("1");
            repository.save(entity);
            return true;
        } catch (Exception e) {
            log.error("Error when create products:", e);
        }
        return false;
    }

    @Override
    public boolean update(ProductsDTO dto) {
        try {
            Products entity = repository.findByProductId(dto.getProductId());
            if (null != entity && null != entity.getId()) {
                Products newEntity = mapper.convertDTOToEntity(dto);
                newEntity.setId(newEntity.getId());
                repository.save(newEntity);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when update products:", e);
        }
        return false;
    }

    @Override
    public ProductsDTO findByUUid(String uuid) {
        Products entity = repository.findByProductId(uuid);
        return entity == null ? null : mapper.convertEntityToDTO(entity);
    }

    @Override
    public List<ProductsDTO> findAll() {
        List<Products> entities = repository.findAll();
        return entities == null || entities.size() == 0 ? new ArrayList<>() :
                entities.stream().map(obj ->  mapper.convertEntityToDTO(obj)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String uuid) {
        //TODO
        try {
            Products products = repository.findByProductId(uuid);
            if (products != null && products.getId() != null) {
                repository.delete(products);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when delete:", e);
        }
        return false;
    }

    //end
}
