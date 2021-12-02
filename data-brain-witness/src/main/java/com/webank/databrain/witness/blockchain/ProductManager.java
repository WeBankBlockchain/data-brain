package com.webank.databrain.witness.blockchain;

import com.webank.databrain.common.model.Product;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductManager {

    public TransactionResponse register(Product product) {
        return null;
    }

    public TransactionResponse unregister(String productId) {
        return null;
    }
}
