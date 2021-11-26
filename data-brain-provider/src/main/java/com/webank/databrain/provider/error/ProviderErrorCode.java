package com.webank.databrain.provider.error;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public enum  ProviderErrorCode {

    ID_NOT_AUTHENTICATED(1, "User credential not authenticated"),
    AUTH_RECORD_NOT_FOUND(2, "AuthRecord not found"),
    USER_NOT_AUTH(3, "User not authorize this data"),
    PROVIDER_NOT_AUTH(4, "auth record id not authed by provider"),
    SCHEMA_ID_NULL(5,"schema id is null"),
    SCHEMA_NOT_FOUND(6,"schema not found in auth record"),
    TRANSFER_PROTOCOL_NOT_SUPPORT(7,"transfer protocol not support"),
    TRANSFER_ERROR(8,"transfer error"),
    INNER_ERROR(-1,"Inner Exceptoin");

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
