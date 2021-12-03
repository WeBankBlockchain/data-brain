package com.webank.databrain.receiver.spi;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/03
 */
public interface SignatureHandler {

    boolean checkSignature(String msg, String address, String signature);

}
