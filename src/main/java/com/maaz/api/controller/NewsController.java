package com.maaz.api.controller;

import com.maaz.api.consts.ApiPath;
import com.maaz.api.consts.ErrorCode;
import com.maaz.api.dto.NewsDTO;
import com.maaz.api.response.NewsResponseDTO;
import com.maaz.api.service.NewsService;
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
public class NewsController {
    @Autowired
    NewsService service;

    @GetMapping(value = ApiPath.NEWS_GET_ALL)
    public ResponseEntity<NewsResponseDTO> getAll() {
        NewsResponseDTO response = new NewsResponseDTO();
        try {
            List<NewsDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success when get all news");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get all news:", ex);
            response.setMessage("Error when get all news: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.NEWS_GET_BY_UUID)
    public ResponseEntity<NewsResponseDTO> getByUUid(@RequestBody NewsDTO request) {
        NewsResponseDTO response = new NewsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            NewsDTO resources = service.findByUUid(request.getNewsId());
            response.setData(resources);
            response.setMessage("Success when get news by id");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get news by id:", ex);
            response.setMessage("Error when get news by id: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.NEWS_CREATE)
    public ResponseEntity<NewsResponseDTO> create(@RequestBody NewsDTO request) {
        NewsResponseDTO response = new NewsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean create = service.create(request);
            if (!create) {
                response.setMessage("Create news fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when create news");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when create news:", ex);
            response.setMessage("Error when create news: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.NEWS_UPDATE)
    public ResponseEntity<NewsResponseDTO> update(@RequestBody NewsDTO request) {
        NewsResponseDTO response = new NewsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean update = service.update(request);
            if (!update) {
                response.setMessage("Update news fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when update news");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when update news:", ex);
            response.setMessage("Error when update news: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.NEWS_DELETE)
    public ResponseEntity<NewsResponseDTO> delete(@RequestBody NewsDTO request) {
        NewsResponseDTO response = new NewsResponseDTO();
        try {
            if (null == request) {
                response.setMessage("Input body");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if (!StringUtils.isNotBlank(request.getNewsId())) {
                response.setMessage("Input news-id");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            boolean delete = service.delete(request.getNewsId());
            if (!delete) {
                response.setMessage("Update news fail!!!!");
                return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            response.setMessage("Success when delete news");
            response.setErrorCode(ErrorCode.SUCCESS);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when delete news:", ex);
            response.setMessage("Error when delete news: " + ex.getMessage());
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //end
}
