package com.maaz.api.controller;

import com.maaz.api.consts.ApiPath;
import com.maaz.api.consts.ErrorCode;
import com.maaz.api.dto.CompanyDTO;
import com.maaz.api.response.CompanyResponseDTO;
import com.maaz.api.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CompanyController {
    @Autowired
    CompanyService service;

    @GetMapping(value = ApiPath.COMPANY_GET_ALL)
    public ResponseEntity<CompanyResponseDTO> getAll() {
        CompanyResponseDTO response = new CompanyResponseDTO();
        try {
            List<CompanyDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success when get all services");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when get all services:", ex);
            response.setMessage("Error when get all services: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @GetMapping(value = ApiPath.COMPANY_GET_UUID)
    public ResponseEntity<CompanyResponseDTO> getByUUid(@RequestBody CompanyDTO request) {
        CompanyResponseDTO response = new CompanyResponseDTO();
        try {
            if (null == request || request.getId() == null) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            CompanyDTO services = service.findByUUid(request.getCompanyId());
            response.setData(services);
            response.setMessage("Success when get company by id");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get company by id:", ex);
            response.setMessage("Error when get company by id: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.COMPANY_CREATE)
    public ResponseEntity<CompanyResponseDTO> create(@RequestBody CompanyDTO request) {
        CompanyResponseDTO response = new CompanyResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean create = service.create(request);
            if (!create) {
                response.setMessage("Create company fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when create company");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when create company:", ex);
            response.setMessage("Error when create company: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.COMPANY_UPDATE)
    public ResponseEntity<CompanyResponseDTO> update(@RequestBody CompanyDTO request) {
        CompanyResponseDTO response = new CompanyResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean update = service.update(request);
            if (!update) {
                response.setMessage("Update services fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when update company");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when update company:", ex);
            response.setMessage("Error when update company: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.COMPANY_DELETE)
    public ResponseEntity<CompanyResponseDTO> delete(@RequestBody CompanyDTO request) {
        CompanyResponseDTO response = new CompanyResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (!StringUtils.isNotBlank(request.getCompanyId())) {
                response.setMessage("Input company-id");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean delete = service.delete(request.getCompanyId());
            if (!delete) {
                response.setMessage("Update company fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when delete company");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when delete company:", ex);
            response.setMessage("Error when delete company: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //end
}
