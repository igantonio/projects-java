package com.example.school.mapper;

import com.example.school.controller.reponse.SchoolResponse;
import com.example.school.controller.request.SchoolRequest;
import com.example.school.entity.SchoolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface SchoolMapper {

    @Mapping(
            source = "schoolRequest.name", target = "name"
    )
    SchoolEntity toSchoolEntity(SchoolRequest schoolRequest);

    SchoolRequest toSchoolRequest(SchoolEntity schoolEntity);

    SchoolResponse toSchoolResponse(SchoolEntity schoolEntity);

    List<SchoolResponse> toSchoolResponseList(List<SchoolEntity> schoolEntities);

}
