package com.example.school.mapper;

import com.example.school.controller.request.SchoolRequest;
import com.example.school.entity.SchoolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface SchoolMapper {

    @Mapping(
            source = "schoolRequest.name", target = "name"
    )
    SchoolEntity toSchoolEntity(SchoolRequest schoolRequest);

    SchoolRequest toSchoolRequest(SchoolEntity schoolEntity);

}
