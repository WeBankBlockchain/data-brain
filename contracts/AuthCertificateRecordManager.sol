pragma solidity ^0.4.25;

import "./ProductRegistration.sol";

contract AuthRecordManager {

    mapping(string => AuthCertificateRecord) private _authCertificateRecordMap;
    mapping(string => Purpose) private _purposeMap;

    uint256 private _authCertificateRecordCount;

    struct AuthRecord {
        //授权记录ID
        string authRecordId;
        //接收方地址
        address receiverId;
        //提供方地址
        address providerId;
        //用户地址
        address userId;
        //数据
        string schemaId;
        // [1]: authState; [2]: transferState;
        // authState：0-初始化，1-组织方已认证, 2-提供方已认证, 3-撤销
        // transferState：0-待发送，1-已发送，2-已接收 3-接收方数据校验错误
        uint8[2] _intArray;
        //数据指纹信息
        string dataHash;
        //用途ID
        string purposeId;
         //[0]: createDate; [1]: authDate; [2]: tansferDate;
        uint256[3] private _timeArray;
    }

    constructor(address productRegistrationAddr) public {

    }

    /**
     * 用户提交授权记录，并初始化授权状态为1
     */
    function createAuthRecord(string authRecordId, address receiverId, address providerId, address userId,string schemaId,uint256 validPeriod,string purposeId) public {
        //1、授权记录ID在链上递增，创建授权记录
    }

    /**
     * 取消授权记录，修改授权状态为已取消
     */
    function revoke(string authRecordId) public  {
        //1、用户账户鉴权
    }

    /**
     * 提供方授权完成，上链修改授权状态为完成态
     */
    function changeAuthState(string authRecordId) public {
        //修改授权状态
    }

    /**
     * 提供方传输数据，上传指纹，并修改传输状态为已发送
     */
    function uploadEvidence(string authRecordId, string dataHash) public  {
        //更新数据指纹
    }

    /**
     * 接收方校验数据,修改传输状态
     */
    function changeTransferState(string authRecordId, uint8 transferState) public  {
        //1、接收方账户鉴权
    }

    /**
     * 查询授权记录
     */
    function getAuthCertificateRecordById(string authRecordId) public view returns(string, address, address, address, string, uint8[2], string, string,uint8[2]) {

    }
}