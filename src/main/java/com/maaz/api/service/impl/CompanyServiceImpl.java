package com.maaz.api.service.impl;

import com.maaz.api.dto.CompanyDTO;
import com.maaz.api.entity.Company;
import com.maaz.api.mapper.CompanyMapper;
import com.maaz.api.repository.CompanyRepository;
import com.maaz.api.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository repository;

    @Autowired
    CompanyMapper mapper;

    @Override
    public boolean create(CompanyDTO dto) {
        try {
            Company entity = mapper.convertDTOToEntity(dto);
            entity.setActive("1");
            repository.save(entity);
            return true;
        } catch (Exception e) {
            log.error("Error when create company:", e);
        }
        return false;
    }

    @Override
    public boolean update(CompanyDTO dto) {
        try {
            Company entity = repository.findByCompanyId(dto.getCompanyId());
            if (null != entity && null != entity.getId()) {
                Company newEntity = mapper.convertDTOToEntity(dto);
                newEntity.setId(newEntity.getId());
                repository.save(newEntity);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when update company:", e);
        }
        return false;
    }

    @Override
    public CompanyDTO findByUUid(String uuid) {
        Company entity = repository.findByCompanyId(uuid);
        return entity == null ? null : mapper.convertEntityToDTO(entity);
    }

    @Override
    public List<CompanyDTO> findAll() {
        List<Company> entities = repository.findAll();
        return entities == null || entities.size() == 0 ? new ArrayList<>() :
                entities.stream().map(obj ->  mapper.convertEntityToDTO(obj)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String uuid) {
        return false;
    }
}
