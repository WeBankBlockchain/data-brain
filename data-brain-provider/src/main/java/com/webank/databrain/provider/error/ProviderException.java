package com.webank.databrain.provider.error;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public class ProviderException extends RuntimeException {

    public ProviderException(ProviderErrorCode errorCode){
        super(errorCode.format(null));
    }

    public ProviderException(ProviderErrorCode errorCode, Object param){
        super(errorCode.format(param.toString()));
    }
}
