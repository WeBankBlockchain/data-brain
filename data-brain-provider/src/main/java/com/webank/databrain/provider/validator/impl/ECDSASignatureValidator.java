package com.webank.databrain.provider.validator.impl;

import com.webank.databrain.common.enums.crypto.CryptoAlgorithmEnum;
import com.webank.databrain.provider.error.ProviderErrorCode;
import com.webank.databrain.provider.error.ProviderException;
import com.webank.databrain.provider.validator.SignatureValidator;
import com.webank.wedpr.crypto.CryptoResult;
import com.webank.wedpr.crypto.NativeInterface;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.utils.Numeric;

import java.util.Objects;

/**
 * @author aaronchu
 * @Description
 * @date 2021/12/06
 */
public class ECDSASignatureValidator implements SignatureValidator {

    @Override
    public void validateSignature(String utf8Msg, String address, String signature) {
        CryptoKeyPair cryptoKeyPair = new CryptoSuite(CryptoAlgorithmEnum.ECDSA.getCode()).getCryptoKeyPair();
        // 1. Convert to msg hash
        String hexMsg = Numeric.toHexStringNoPrefix(utf8Msg.getBytes());
        CryptoResult cryptoResult = NativeInterface.keccak256Hash(hexMsg);
        if(cryptoResult.wedprErrorMessage != null){
            throw new ProviderException(ProviderErrorCode.SIGNATURE_ERROR, cryptoResult.wedprErrorMessage);
        }
        String hashMsg = cryptoResult.hash;
        // 2. Recover public key
        cryptoResult = NativeInterface.secp256k1RecoverPublicKey(hashMsg, signature);
        if(cryptoResult.wedprErrorMessage != null){
            throw new ProviderException(ProviderErrorCode.SIGNATURE_ERROR, cryptoResult.wedprErrorMessage);
        }
        // 3. Generate address from recovered public key
        String recoveredPubKey = cryptoResult.publicKey;
        String recoveredAddress = cryptoKeyPair.getAddress(recoveredPubKey);
        // 4. Compare address
        if(!Objects.equals(recoveredAddress, address)){
            throw new ProviderException(ProviderErrorCode.SIGNATURE_ERROR);
        }
    }


}
