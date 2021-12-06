package com.webank.databrain.common.enums.crypto;

import lombok.Getter;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
@Getter
public enum CryptoAlgorithmEnum {

    ECDSA(0),

    SM2(1),

    RSA(2);

    private int code;

    CryptoAlgorithmEnum(int code) {
        this.code = code;
    }

}
