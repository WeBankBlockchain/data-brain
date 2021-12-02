package com.webank.databrain.provider.error;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public enum  ProviderErrorCode {

    ID_NOT_AUTHENTICATED(10001, "User credential not authenticated"),
    INVALID_CREDENTIAL_MODE(10002, "Invalid credential mode"),
    AUTH_RECORD_NOT_FOUND(20001, "AuthRecord not found"),
    USER_NOT_AUTH(20002, "User not authorize this data"),
    PROVIDER_NOT_AUTH(20003, "auth record id not authed by provider"),
    SCHEMA_ID_NULL(30001,"schema id is null"),
    SCHEMA_NOT_FOUND(30002,"schema not found in auth record"),
    TRANSFER_PROTOCOL_NOT_SUPPORT(40001,"transfer protocol not support"),
    TRANSFER_ERROR(40002,"transfer error"),
    INNER_ERROR(-1,"Inner Exception");

    private long code;
    private String msg;

    ProviderErrorCode(long code, String msg){
        this.msg = msg;
    }

    public String format(String extra){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Error code:");
        strBuilder.append(this.code);
        strBuilder.append(".Msg info:");
        strBuilder.append(this.msg);
        strBuilder.append(". Parameter info:");
        strBuilder.append(":");
        strBuilder.append(extra);
        return strBuilder.toString();
    }
}
