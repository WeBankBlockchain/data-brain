package com.webank.databrain.provider.fetch.impl;

import com.webank.databrain.common.enums.schema.TransferProtocolEnum;
import com.webank.databrain.provider.fetch.DataFetcher;
import org.springframework.stereotype.Component;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Component
public class DbFetcher implements DataFetcher {
    @Override
    public byte[] fetchData(String url) throws Exception {
        return new byte[0];
    }

    @Override
    public TransferProtocolEnum protocol() {
        return TransferProtocolEnum.Database;
    }
}
