package com.webank.databrain.common.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String contact;
    private int certType;
    private String certNo;
    private String externalAccount;

}
