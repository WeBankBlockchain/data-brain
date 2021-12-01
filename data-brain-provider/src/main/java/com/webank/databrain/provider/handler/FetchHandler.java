package com.webank.databrain.provider.handler;

import com.webank.databrain.common.enums.metadata.TransferProtocolEnum;
import com.webank.databrain.common.model.Schema;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.fetch.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
@Component
public class FetchHandler {

    private Map<TransferProtocolEnum, DataFetcher> fetcherMap;

    public FetchHandler(List<DataFetcher> fetchers){
        this.fetcherMap = new HashMap<>();
        for(DataFetcher fetcher: fetchers){
            fetcherMap.put(fetcher.protocol(), fetcher);
        }
    }

    public byte[] fetch(Schema schema){
        TransferProtocolEnum transferProtocol = schema.getTransferProtocol();
        DataFetcher dataFetcher = fetcherMap.get(transferProtocol);
        if(dataFetcher == null){
            throw new ProviderException(ProviderErrorCode.TRANSFER_PROTOCOL_NOT_SUPPORT, transferProtocol);
        }
        try{
            return dataFetcher.fetchData(schema.getUrl());
        }
        catch (Exception ex){
            throw new ProviderException(ex, ProviderErrorCode.TRANSFER_ERROR);
        }
    }

}
