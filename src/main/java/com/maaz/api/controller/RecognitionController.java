package com.maaz.api.controller;

import com.maaz.api.consts.ApiPath;
import com.maaz.api.consts.ErrorCode;
import com.maaz.api.dto.RecognitionDTO;
import com.maaz.api.response.RecognitionResponseDTO;
import com.maaz.api.service.RecognitionService;
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
public class RecognitionController {
    @Autowired
    RecognitionService service;

    @GetMapping(value = ApiPath.RECOGNITION_GET_ALL)
    public ResponseEntity<RecognitionResponseDTO> getAll() {
        RecognitionResponseDTO response = new RecognitionResponseDTO();
        try {
            List<RecognitionDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success when get all recognition");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when get all recognition:", ex);
            response.setMessage("Error when get all recognition: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @GetMapping(value = ApiPath.RECOGNITION_GET_BY_UUID)
    public ResponseEntity<RecognitionResponseDTO> getByUUid(@RequestBody RecognitionDTO request) {
        RecognitionResponseDTO response = new RecognitionResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            RecognitionDTO resources = service.findByUUid(request.getRecognitionsId());
            response.setData(resources);
            response.setMessage("Success when get recognition by id");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when get recognition by id:", ex);
            response.setMessage("Error when get recognition by id: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = ApiPath.RECOGNITION_CREATE)
    public ResponseEntity<RecognitionResponseDTO> create(@RequestBody RecognitionDTO request) {
        RecognitionResponseDTO response = new RecognitionResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean create = service.create(request);
            if (!create) {
                response.setMessage("Create recognition fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when create recognition");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when create recognition:", ex);
            response.setMessage("Error when create recognition:" + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = ApiPath.RECOGNITION_UPDATE)
    public ResponseEntity<RecognitionResponseDTO> update(@RequestBody RecognitionDTO request) {
        RecognitionResponseDTO response = new RecognitionResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean update = service.update(request);
            if (!update) {
                response.setMessage("Update recognition fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when update recognition");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when update recognition:", ex);
            response.setMessage("Error when update recognition:" + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = ApiPath.RECOGNITION_DELETE)
    public ResponseEntity<RecognitionResponseDTO> delete(@RequestBody RecognitionDTO request) {
        RecognitionResponseDTO response = new RecognitionResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (!StringUtils.isNotBlank(request.getRecognitionsId())) {
                response.setMessage("Input recognition-id");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean delete = service.delete(request.getRecognitionsId());
            if (!delete) {
                response.setMessage("Update recognition fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when delete recognition");
            response.setErrorCode(ErrorCode.SUCCESS);
        } catch (Exception ex) {
            log.error("Error when delete recognition:", ex);
            response.setMessage("Error when delete recognition: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    //end
}
