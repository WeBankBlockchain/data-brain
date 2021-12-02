package com.webank.databrain.provider.model;

import com.webank.databrain.provider.model.fetch.ProcessHint;
import lombok.Data;

import java.util.List;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/02
 */
@Data
public class FetchRequestVO {

    /**
     * Token
     */
    private String token;

    /**
     * 数据处理方法，例如列表为 [Compression, Encryption]，那就是先压缩再加密，以此类推
     */
    private List<ProcessHint> processHints;

}
