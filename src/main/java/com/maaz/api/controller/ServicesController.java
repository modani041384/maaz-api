package com.maaz.api.controller;

import com.maaz.api.consts.ApiPath;
import com.maaz.api.consts.ErrorCode;
import com.maaz.api.dto.ServicesDTO;
import com.maaz.api.mapper.ServicesMapper;
import com.maaz.api.response.ServicesResponseDTO;
import com.maaz.api.service.ServicesArticle;
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
public class ServicesController {
    @Autowired
    ServicesArticle service;

    @GetMapping(value = ApiPath.SERVICE_GET_ALL)
    public ResponseEntity<ServicesResponseDTO> getAll() {
        ServicesResponseDTO response = new ServicesResponseDTO();
        try {
            List<ServicesDTO> list = service.findAll();
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

    @GetMapping(value = ApiPath.SERVICE_GET_BY_UUID)
    public ResponseEntity<ServicesResponseDTO> getByUUid(@RequestBody ServicesDTO request) {
        ServicesResponseDTO response = new ServicesResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            ServicesDTO services = service.findByUUid(request.getServiceId());
            response.setData(services);
            response.setMessage("Success when get services by id");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when get services by id:", ex);
            response.setMessage("Error when get services by id: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = ApiPath.SERVICE_CREATE)
    public ResponseEntity<ServicesResponseDTO> create(@RequestBody ServicesDTO request) {
        ServicesResponseDTO response = new ServicesResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean create = service.create(request);
            if (!create) {
                response.setMessage("Create services fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when create services");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when create services:", ex);
            response.setMessage("Error when create services: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = ApiPath.SERVICE_UPDATE)
    public ResponseEntity<ServicesResponseDTO> update(@RequestBody ServicesDTO request) {
        ServicesResponseDTO response = new ServicesResponseDTO();
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
            response.setMessage("Success when update services");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when update services:", ex);
            response.setMessage("Error when update services: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = ApiPath.SERVICE_DELETE)
    public ResponseEntity<ServicesResponseDTO> delete(@RequestBody ServicesDTO request) {
        ServicesResponseDTO response = new ServicesResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (!StringUtils.isNotBlank(request.getServiceId())) {
                response.setMessage("Input services-id");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean delete = service.delete(request.getServiceId());
            if (!delete) {
                response.setMessage("Update services fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when delete services");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when delete services:", ex);
            response.setMessage("Error when delete services: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    //end
}
