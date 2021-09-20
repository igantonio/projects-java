package com.example.school.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class SchoolRequest {

    @NotBlank(message = "Campo name obrigatório")
    public String name;

}
