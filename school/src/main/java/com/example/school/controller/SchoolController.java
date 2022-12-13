package com.example.school.controller;

import com.example.school.controller.reponse.SchoolResponse;
import com.example.school.controller.request.SchoolRequest;
import com.example.school.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
@Slf4j
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ApiOperation(value = "Adicionar escola")
    public ResponseEntity<Long> save(@Valid @RequestBody SchoolRequest schoolRequest) {
        log.info("c={}, m={}, schoolRequest={}", "SchoolController", "save", schoolRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.save(schoolRequest));
    }

    @GetMapping
    @ApiOperation(value = "Buscar todas as escolas")
    public ResponseEntity<List<SchoolResponse>> findAll() {
        log.info("c={}, m={}", "SchoolController", "findAll");
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar escola por id")
    public ResponseEntity<SchoolResponse> findById(@PathVariable Long id) {
        log.info("c={}, m={}, id={}", "SchoolController", "findById", id);
        return ResponseEntity.ok(schoolService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar escola por id")
    public ResponseEntity deleteById(@PathVariable Long id) {
        schoolService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
