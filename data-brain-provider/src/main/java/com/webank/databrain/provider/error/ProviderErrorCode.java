package com.webank.databrain.provider.error;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public enum  ProviderErrorCode {

    ID_NOT_AUTHENTICATED("User credential not authenticated"),

    INNER_ERROR("Inner Exceptoin");

    private String msg;

    ProviderErrorCode(String msg){
        this.msg = msg;
    }

    public String format(String extra){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(this.msg);
        strBuilder.append(":");
        strBuilder.append(extra);
        return strBuilder.toString();
    }
}
