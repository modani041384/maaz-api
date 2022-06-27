package com.maaz.api.service.impl;

import com.maaz.api.dto.NewsDTO;
import com.maaz.api.entity.News;
import com.maaz.api.mapper.NewsMapper;
import com.maaz.api.repository.NewsRepository;
import com.maaz.api.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository repository;

    @Autowired
    NewsMapper mapper;

    @Override
    public boolean create(NewsDTO dto) {
        try {
            News entity = mapper.convertDTOToEntity(dto);
            entity.setActive("1");
            repository.save(entity);
            return true;
        } catch (Exception e) {
            log.error("Error when create news:", e);
        }
        return false;
    }

    @Override
    public boolean update(NewsDTO dto) {
        try {
            News entity = repository.findByNewsId(dto.getNewsId());
            if (null != entity && null != entity.getId()) {
                News newEntity = mapper.convertDTOToEntity(dto);
                newEntity.setId(newEntity.getId());
                repository.save(newEntity);
                return true;
            }
        } catch (Exception e) {
            log.error("Error when update news:", e);
        }
        return false;
    }

    @Override
    public NewsDTO findByUUid(String uuid) {
        News entity = repository.findByNewsId(uuid);
        return entity == null ? null : mapper.convertEntityToDTO(entity);
    }

    @Override
    public List<NewsDTO> findAll() {
        List<News> entities = repository.findAll();
        return entities == null || entities.size() == 0 ? new ArrayList<>() :
                entities.stream().map(obj ->  mapper.convertEntityToDTO(obj)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String uuid) {
        //TODO
        return false;
    }
}
