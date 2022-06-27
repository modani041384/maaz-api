package com.maaz.api.service.impl;

import com.maaz.api.dto.PartnerDTO;
import com.maaz.api.entity.Partner;
import com.maaz.api.mapper.PartnerMapper;
import com.maaz.api.repository.PartnerRepository;
import com.maaz.api.service.PartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    PartnerRepository repository;

    @Autowired
    PartnerMapper mapper;

    @Override
    public boolean create(PartnerDTO dto) {
        try {
            Partner entity = mapper.convertDTOToEntity(dto);
            entity.setActive("1");
            repository.save(entity);
            return true;
        } catch (Exception e) {
            log.error("Error when create partner:", e);
        }
        return false;
    }

    @Override
    public boolean update(PartnerDTO dto) {
        try {
            Partner entity = repository.findByPartnerId(dto.getPartnerId());
            if (null != entity && null != entity.getId()) {
                Partner newEntity = mapper.convertDTOToEntity(dto);
                newEntity.setId(newEntity.getId());
                repository.save(newEntity);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when update partner:", e);
        }
        return false;
    }

    @Override
    public PartnerDTO findByUUid(String uuid) {
        Partner entity = repository.findByPartnerId(uuid);
        return entity == null ? null : mapper.convertEntityToDTO(entity);
    }

    @Override
    public List<PartnerDTO> findAll() {
        List<Partner> entities = repository.findAll();
        return entities == null || entities.size() == 0 ? new ArrayList<>() :
                entities.stream().map(obj ->  mapper.convertEntityToDTO(obj)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }

    //end
}
