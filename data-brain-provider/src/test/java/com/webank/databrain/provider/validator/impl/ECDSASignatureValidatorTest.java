package com.webank.databrain.provider.validator.impl;

import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.crypto.signature.SignatureResult;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public class ECDSASignatureValidatorTest {

    @Test
    public void test() {
        CryptoSuite cryptoSuite = new CryptoSuite(0);
        CryptoKeyPair cryptoKeyPair= new CryptoSuite(0).createKeyPair();
        String message = "Hello World";
        SignatureResult result = cryptoSuite.sign(cryptoSuite.hash(message), cryptoKeyPair);
        String signature = result.convertToString();


        ECDSASignatureValidator validator = new ECDSASignatureValidator();
        validator.validateSignature(message, cryptoKeyPair.getAddress(), signature);
    }

}