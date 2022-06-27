package com.maaz.api.mapper;

import com.maaz.api.dto.NewsDTO;
import com.maaz.api.entity.News;
import org.springframework.stereotype.Service;

@Service
public class NewsMapper extends AbstractMapper<News, NewsDTO> {
    public NewsMapper() {
        super(News.class, NewsDTO.class);
    }
}
