package com.maaz.api.mapper;

import com.maaz.api.dto.CompanyDTO;
import com.maaz.api.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper extends AbstractMapper<Company, CompanyDTO> {
    public CompanyMapper() {
        super(Company.class, CompanyDTO.class);
    }
}