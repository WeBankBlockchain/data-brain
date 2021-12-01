package com.webank.databrain.organizer.service;

import com.webank.databrain.common.model.CommonResponse;
import com.webank.databrain.common.model.Enterprise;
import com.webank.databrain.common.model.Product;
import com.webank.databrain.organizer.api.EnterpriseAuthApi;
import com.webank.databrain.organizer.blockchain.EnterpriseManager;
import com.webank.databrain.organizer.blockchain.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;

public class EnterpriseService {
    @Autowired
    private EnterpriseAuthApi enterpriseAuthApi;
    @Autowired
    private EnterpriseManager enterpriseManager;
    @Autowired
    private ProductManager productManager;

    public CommonResponse register(Enterprise enterprise, String password) {
        enterpriseManager.register(enterprise);
        return new CommonResponse();
    }

    public CommonResponse modify(Enterprise enterprise) {
        enterpriseManager.modify(enterprise);
        return new CommonResponse();
    }

    public CommonResponse forgetPassword(Enterprise enterprise, String newPassword) {
        return new CommonResponse();
    }

    public CommonResponse unregister(String enterpriseId, String password) {
        enterpriseManager.remove(enterpriseId);
        return new CommonResponse();
    }

    public CommonResponse authentication(Enterprise enterprise) {
        enterpriseManager.authenticateEnterpriseCert(enterprise.getId(), enterprise.getCertHash());
        return enterpriseAuthApi.authentication(enterprise);
    }

    public CommonResponse login(String loginName, String password) {
        return new CommonResponse();
    }

    public CommonResponse registerProduct(Product product) {
        productManager.register(product);
        return new CommonResponse();
    }

    public CommonResponse unregisterProduct(String productId) {
        productManager.unregister(productId);
        return new CommonResponse();
    }
}
