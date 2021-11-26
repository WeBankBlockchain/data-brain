package com.webank.databrain.common.enums.metadata;

/**
 * 传输协议
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public enum TransferProtocolEnum {

    /**
     * 数据库
     */
    Database(1),

    /**
     * FTP
     */
    Ftp(2),

    /**
     * 本地文件
     */
    File(3);

    private int code;

    TransferProtocolEnum(int code) {
        this.code = code;
    }

}
