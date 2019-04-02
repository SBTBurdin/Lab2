package ru.sbt.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.lab2.service.RestService;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/rest")
public class RestServiceController {
    private final RestService restService;

    @Autowired
    public RestServiceController(RestService restService) {
        this.restService = restService;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(
            @RequestParam(value = "id", required = false) Integer id
    ) {
        return ResponseEntity.ok(restService.getUserInfo(id));
    }
}
