package com.webank.databrain.provider.error;

import lombok.Getter;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Getter
public class ProviderException extends RuntimeException {

    private ProviderErrorCode errorCode;
    private Object param;

    public ProviderException(ProviderErrorCode errorCode){
        super(errorCode.format(null));
        this.errorCode = errorCode;
    }

    public ProviderException(ProviderErrorCode errorCode, Object param){
        super(errorCode.format(param.toString()));
        this.errorCode = errorCode;
        this.param = param;
    }

    public ProviderException(Throwable cause, ProviderErrorCode errorCode){
        super(cause);
        this.errorCode = errorCode;
    }
}
