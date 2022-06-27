package com.maaz.api.service.impl;

import com.maaz.api.dto.ServicesDTO;
import com.maaz.api.entity.Services;
import com.maaz.api.mapper.ServicesMapper;
import com.maaz.api.repository.ServicesRepository;
import com.maaz.api.service.ServicesArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServicesImpl implements ServicesArticle {
    @Autowired
    ServicesRepository repository;

    @Autowired
    ServicesMapper mapper;

    @Override
    public boolean create(ServicesDTO dto) {
        try {
            Services entity = mapper.convertDTOToEntity(dto);
            entity.setActive("1");
            repository.save(entity);
            return true;
        } catch (Exception e) {
            log.error("Error when create services:", e);
        }
        return false;
    }

    @Override
    public boolean update(ServicesDTO dto) {
        try {
            Services entity = repository.findByServiceId(dto.getServiceId());
            if (null != entity && null != entity.getId()) {
                Services newEntity = mapper.convertDTOToEntity(dto);
                newEntity.setId(newEntity.getId());
                repository.save(newEntity);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when update services:", e);
        }
        return false;
    }

    @Override
    public ServicesDTO findByUUid(String uuid) {
        Services entity = repository.findByServiceId(uuid);
        return entity == null ? null : mapper.convertEntityToDTO(entity);
    }

    @Override
    public List<ServicesDTO> findAll() {
        List<Services> entities = repository.findAll();
        return entities == null || entities.size() == 0 ? new ArrayList<>() :
                entities.stream().map(obj ->  mapper.convertEntityToDTO(obj)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String uuid) {
        //TODO
        return false;
    }

    //end
}
