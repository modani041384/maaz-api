package com.maaz.api.mapper;

import com.maaz.api.dto.RecognitionDTO;
import com.maaz.api.entity.Recognitions;
import org.springframework.stereotype.Service;

@Service
public class RecognitionManager extends AbstractMapper<Recognitions, RecognitionDTO> {
    public RecognitionManager() {
        super(Recognitions.class, RecognitionDTO.class);
    }
}
