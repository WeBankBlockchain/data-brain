package com.webank.databrain.provider.spi.credential;

/**
 * @author aaronchu
 * @Description
 * @date 2021/11/26
 */
public interface DataFetcher {

    byte[] fetchData() throws Exception;


}
