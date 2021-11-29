package com.webank.databrain.provider.fetch;

import com.webank.databrain.common.enums.metadata.TransferProtocolEnum;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public interface DataFetcher {

    byte[] fetchData(String url) throws Exception;

    TransferProtocolEnum protocol();
}
