package com.example.school.service;

import com.example.school.controller.reponse.SchoolResponse;
import com.example.school.controller.request.SchoolRequest;
import com.example.school.exception.AlreadyResourceRegisterException;
import com.example.school.exception.EntityNotFoundException;
import com.example.school.mapper.SchoolMapper;
import com.example.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Transactional
    public Long save(final SchoolRequest schoolRequest) {
        log.info("c={}, m={}, schoolRequest={}", "SchoolService", "save", schoolRequest.toString());
        if(!schoolRepository.existsByName(schoolRequest.name))
            return schoolRepository.save(schoolMapper.toSchoolEntity(schoolRequest)).getId();

        throw new AlreadyResourceRegisterException("Escola já existe com esse nome:" + schoolRequest.getName());
    }

    @Transactional(readOnly = true)
    public List<SchoolResponse> findAll() {
        log.info("c={}, m={}", "SchoolService", "findAll");
        return schoolMapper.toSchoolResponseList(schoolRepository.findAll());
    }


    @Transactional(readOnly = true)
    public SchoolResponse findById(final Long id) {
        log.info("c={}, m={}, id={}", "SchoolService", "findById", id);
        return schoolMapper.toSchoolResponse(
                schoolRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Escola não encontrada com o id:" + id)
                ));
    }

    @Transactional
    public void deleteById(final Long id) {
        log.info("c={}, m={}, schoolRequest={}", "SchoolService", "deleteById", id);
        if(!schoolRepository.existsById(id))
            schoolRepository.deleteById(id);

        throw new EntityNotFoundException("Escola não encontrada com o id:" + id);
    }

}
