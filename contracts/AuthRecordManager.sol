pragma solidity ^0.4.25;

contract AuthRecordManager {

    mapping(uint256 => AuthRecord) private _authRecordMap;

    uint256 private _authRecordCount;

    struct AuthRecord {
        //授权记录ID
        uint256 authRecordId;
        //接收方地址
        address receiverId;
        //提供方地址
        address providerId;
        //用户地址
        address userId;
        //数据目录id
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
        uint256[3] timeArray;
    }

    constructor() public {
        _authRecordCount = 1;
    }

    /**
     * 用户提交授权记录，并初始化授权状态为1
     */
    function createAuthRecord(address receiverId, address providerId, address userId,string schemaId, string purposeId) public returns(uint256) {
        uint256 authRecordId = _authRecordCount;
        _authRecordCount = _authRecordCount + 1;
        _authRecordMap[authRecordId] = _authRecordMap(authRecordId, receiverId, providerId, userId, schemaId, [1,0],"", purposeId,[now,0,0]);
        return (authRecordId);
    }

    /**
     * 取消授权记录，修改授权状态为已取消
     */
    function revoke(string authRecordId) public {
        AuthRecord storage authRecord = _authRecordMap[authRecordId];
        require(msg.sender == authRecord.userId, "AuthRecordManager : account must be userID");
        authRecord.authState = 3;
        authRecord.timeArray[1] = now;
    }

    /**
     * 提供方授权完成，上链修改授权状态为完成态
     */
    function changeAuthState(string authRecordId) public {
        _authRecordMap[authRecordId].authState = 2;
    }

    /**
     * 提供方传输数据，上传指纹，并修改传输状态为已发送
     */
    function uploadEvidence(string authRecordId, string dataHash) public  {
        AuthRecord storage authRecord = _authRecordMap[authRecordId];
        authRecord.transferState = 1;
        authRecord.timeArray[2] = now;
    }

    /**
     * 接收方校验数据,修改传输状态
     */
    function changeTransferState(string authRecordId, uint8 transferState) public  {
        _authRecordMap[authRecordId].transferState = transferState;
    }

    /**
     * 查询授权记录
     */
    function getAuthRecordById(string authRecordId) public view returns(string, address, address, address, string, uint8[2], string, string,uint8[2]) {
         AuthRecord storage authRecord = _authRecordMap[authRecordId];
         return (authRecord);
    }
}