package com.example.school.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StandardError {

    private String timestamp;
    private Integer status;
    private String errorTitle;
    private String message;
    private String path;

}
