package com.webank.databrain.common.model;

import com.webank.databrain.common.enums.metadata.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@NoArgsConstructor
@Data
public class MetaData {
    /**
     * 产品名称
     */
    private String productName;

    /**
     * SchemaId
     */
    private String schemaId;

    /**
     * 归属业务类型
     */
    private BusinessTypeEnum bizType;

    /**
     * 数据等级
     */
    private DataLevelEnum dataLevel;

    /**
     * 数据描述
     */
    private String description;

    /**
     * 数据类型
     */
    private DataTypeEnum dataType;

    /**
     * 状态
     */
    private DataStatusEnum dataStatus;

    /**
     * 标签
     */
    private String[] tags;

    /**
     * 版本
     */
    private String version;

    /**
     * 数据内容
     */
    private  String dataInfo;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 数据格式
     */
    private DataFormatEnum format;

    /**
     * 传输协议
     */
    private TransferProtocolEnum transferProtocol;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
