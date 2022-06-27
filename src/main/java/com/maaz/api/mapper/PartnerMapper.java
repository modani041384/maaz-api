package com.maaz.api.mapper;

import com.maaz.api.dto.PartnerDTO;
import com.maaz.api.entity.Partner;
import org.springframework.stereotype.Service;

@Service
public class PartnerMapper extends AbstractMapper<Partner, PartnerDTO> {
    public PartnerMapper() {
        super(Partner.class, PartnerDTO.class);
    }
}
