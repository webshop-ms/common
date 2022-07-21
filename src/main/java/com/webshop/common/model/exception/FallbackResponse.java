package com.webshop.common.model.exception;

import lombok.Data;

import java.util.Date;

@Data
public abstract class FallbackResponse {

    protected Date timestamp;

    protected int status;

    protected String error;

    protected String message;

    protected String path;

}
