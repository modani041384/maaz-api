package com.maaz.api.controller;

import com.maaz.api.consts.ApiPath;
import com.maaz.api.consts.ErrorCode;
import com.maaz.api.dto.PartnerDTO;
import com.maaz.api.response.PartnerResponseDTO;
import com.maaz.api.service.PartnerService;
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
public class PartnerController {
    @Autowired
    PartnerService service;

    @GetMapping(value = ApiPath.PARTNER_GET_ALL)
    public ResponseEntity<PartnerResponseDTO> getAll() {
        PartnerResponseDTO response = new PartnerResponseDTO();
        try {
            List<PartnerDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success when get all partner");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get all partner:", ex);
            response.setMessage("Error when get all partner: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.PARTNER_GET_BY_UUID)
    public ResponseEntity<PartnerResponseDTO> getByUUid(@RequestBody PartnerDTO request) {
        PartnerResponseDTO response = new PartnerResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            PartnerDTO resources = service.findByUUid(request.getPartnerId());
            response.setData(resources);
            response.setMessage("Success when get partner by id");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get partner by id:", ex);
            response.setMessage("Error when get partner by id: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.PARTNER_CREATE)
    public ResponseEntity<PartnerResponseDTO> create(@RequestBody PartnerDTO request) {
        PartnerResponseDTO response = new PartnerResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean create = service.create(request);
            if (!create) {
                response.setMessage("Create partner fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when create partner");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when create partner:", ex);
            response.setMessage("Error when create partner: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.PARTNER_UPDATE)
    public ResponseEntity<PartnerResponseDTO> update(@RequestBody PartnerDTO request) {
        PartnerResponseDTO response = new PartnerResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean update = service.update(request);
            if (!update) {
                response.setMessage("Update partner fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when update partner");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when update partner:", ex);
            response.setMessage("Error when update partner: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.PARTNER_DELETE)
    public ResponseEntity<PartnerResponseDTO> delete(@RequestBody PartnerDTO request) {
        PartnerResponseDTO response = new PartnerResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (!StringUtils.isNotBlank(request.getPartnerId())) {
                response.setMessage("Input partner-id");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean delete = service.delete(request.getPartnerId());
            if (!delete) {
                response.setMessage("Update partner fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when delete partner");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when delete partner:", ex);
            response.setMessage("Error when delete partner: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //end
}
