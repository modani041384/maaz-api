package com.maaz.api.service.impl;

import com.maaz.api.dto.RecognitionDTO;
import com.maaz.api.entity.Recognitions;
import com.maaz.api.mapper.RecognitionManager;
import com.maaz.api.repository.RecognitionRepository;
import com.maaz.api.service.RecognitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecognitionServiceImpl implements RecognitionService {
    @Autowired
    RecognitionRepository repository;

    @Autowired
    RecognitionManager mapper;

    @Override
    public boolean create(RecognitionDTO dto) {
        try {
            Recognitions entity = mapper.convertDTOToEntity(dto);
            entity.setActive("1");
            repository.save(entity);
            return true;
        } catch (Exception e) {
            log.error("Error when create recognitions:", e);
        }
        return false;
    }

    @Override
    public boolean update(RecognitionDTO dto) {
        try {
            Recognitions entity = repository.findByRecognitionsId(dto.getRecognitionsId());
            if (null != entity && null != entity.getId()) {
                Recognitions newEntity = mapper.convertDTOToEntity(dto);
                newEntity.setId(newEntity.getId());
                repository.save(newEntity);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when update recognitions:", e);
        }
        return false;
    }

    @Override
    public RecognitionDTO findByUUid(String uuid) {
        Recognitions entity = repository.findByRecognitionsId(uuid);
        return entity == null ? null : mapper.convertEntityToDTO(entity);
    }

    @Override
    public List<RecognitionDTO> findAll() {
        List<Recognitions> entities = repository.findAll();
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
