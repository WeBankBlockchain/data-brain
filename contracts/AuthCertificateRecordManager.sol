pragma solidity ^0.4.25;

import "./EnterpriseRegistration.sol";

contract AuthCertificateRecordManager {

    mapping(string => AuthCertificateRecord) private _authCertificateRecordMap;
    mapping(string => Purpose) private _purposeMap;

    EnterpriseRegistration public _enterpriseRegistration;

    uint256 private _authCertificateRecordCount;

    struct AuthCertificateRecord {
        //授权记录ID
        string authRecordId;
        //接收方地址
        string receiverId;
        //提供方地址
        string providerId;
        //用户地址
        string userId;
        //数据
        string schemaId;
        // [0]: authType; [1]: authState; [2]: transferState;
        // authType：0-用户授权
        // authState：0-初始化，1-第一授权完成, 2-第二次授权完成, 3-撤销
        // transferState：0-待发送，1-已发送，2-已接收确认，3-接收数据校验错误
        uint8[3] _intArray;
        //有效期限,时间戳
        uint validPeriod;
        //数据指纹信息
        string dataHash;
        //用途ID
        string purposeId;
         //[0]: createDate; [1]: authDate; [2]: tansferDate;
        uint256[3] private _timeArray;
    }

    struct Purpose {
        //用途ID
        string purposeId;
        //用途名称
        string name;
        //描述
        string abstract;
        //备注
        string note;
        // [0]: useType; [1]: storeEnable;
        uint8[2] _intArray;
    }


    constructor(address enterpriseRegistrationAddr) public {
        _enterpriseRegistration = EnterpriseRegistration(enterpriseRegistrationAddr);
    }

    /**
     * 创建用途
     */
    function createPurpose(string purposeId,string name,string abstract,string note) public {

    }

    /**
     * 用户提交授权记录，并初始化授权状态为1
     */
    function authByUser(string authRecordId, string receiverId, string providerId, string userId,string schemaId,uint256 validPeriod,string purposeId) public {
        //1、用户账户鉴权
        //2、创建授权记录
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
    function authByProvider(string authRecordId) public {
        //1、提供方账户鉴权
        //2、修改授权状态
    }

    /**
     * 提供方传输数据，上传指纹，并修改传输状态为已发送
     */
    function send(string authRecordId, string dataHash) public  {
        //1、提供方账户鉴权
        //2、更新数据指纹
    }

    /**
     * 接收方校验数据,修改传输状态
     */
    function confirm(string authRecordId, uint8 transferState) public  {
        //1、接收方账户鉴权
    }

    /**
     * 查询授权记录
     */
    function getAuthCertificateRecordById(string authRecordId) public view returns(string, string, string, string, string, uint8[3], uint,string, string,uint8[2]) {

    }


    /**
     * 查询用途
     */
    function getPurposeById(string purposeId) public view returns(string, string, string, string, uint8[2]) {

    }
}