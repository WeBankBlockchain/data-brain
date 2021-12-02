package com.webank.databrain.common.model;

import lombok.Data;

/**
 * @author wesleywang
 * @Description:
 * @date 2021/11/25
 */
@Data
public class AuthRecord {

    private String authRecordId;

    private String receiverId;

    private String providerId;

    private String userId;

    private String schemaId;

    private int authState;

    private int transferState;

    private String purposeId;

    private long createDate;

    private long authDate;

    private long transferDate;
}
