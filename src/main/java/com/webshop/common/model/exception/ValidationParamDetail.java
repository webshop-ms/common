package com.webshop.common.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationParamDetail {

    private String path;

    private String value;

    private String message;
}
