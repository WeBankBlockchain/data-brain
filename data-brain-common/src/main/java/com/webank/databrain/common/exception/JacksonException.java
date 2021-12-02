package com.webank.databrain.common.exception;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
public class JacksonException extends RuntimeException {

    public JacksonException(Exception ex){
        super(ex);
    }
}
