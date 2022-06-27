package com.maaz.api.mapper;

import com.maaz.api.dto.ServicesDTO;
import com.maaz.api.entity.Services;
import org.springframework.stereotype.Service;

@Service
public class ServicesMapper extends AbstractMapper<Services, ServicesDTO> {
    public ServicesMapper() {
        super(Services.class, ServicesDTO.class);
    }
}
