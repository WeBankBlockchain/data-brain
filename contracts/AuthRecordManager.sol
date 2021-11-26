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
        // [0]: authState; [1]: transferState;
        // authState：0-初始化，1-组织方已认证, 2-提供方已认证, 3-撤销
        // transferState：0-待发送，1-已发送，2-已接收 3-接收方数据校验错误
        uint8[2] intArray;
        //数据指纹信息
        string dataHash;
        //用途ID
        string purposeId;
        //[0]: createDate; [1]: authDate; [2]: tansferDate;
        uint256[3] timeArray;
    }

    event CreateAuthRecordSuccessEvent(uint256 authRecordId,address receiverId, address providerId, address userId,string schemaId, string purposeId);
    event RevokeSuccessEvent(uint256 authRecordId);
    event ChangeAuthStateToFinishSuccessEvent(uint256 authRecordId);
    event UploadEvidenceSuccessEvent(uint256 authRecordId, string dataHash);
    event ChangeTransferStateSuccessEvent(uint256 authRecordId, uint8 transferState);

    constructor() public {
        _authRecordCount = 1;
    }



    /**
     * 用户提交授权记录，并初始化授权状态为1
     */
    function createAuthRecord(address receiverId, address providerId, address userId,string schemaId, string purposeId) public returns(uint256) {
        uint256 authRecordId = _authRecordCount;
        _authRecordCount = _authRecordCount + 1;
        _authRecordMap[authRecordId] = AuthRecord(authRecordId, receiverId, providerId, userId, schemaId, [1,0],"", purposeId, [now,0,0]);
        emit CreateAuthRecordSuccessEvent(authRecordId,receiverId,providerId,userId,schemaId,purposeId);
        return (authRecordId);
    }

    /**
     * 取消授权记录，修改授权状态为已取消
     */
    function revoke(uint256 authRecordId) public {
        AuthRecord storage authRecord = _authRecordMap[authRecordId];
        require(msg.sender == authRecord.userId, "AuthRecordManager : account must be userID");
        authRecord.intArray[0] = 3;
        authRecord.timeArray[1] = now;
        emit RevokeSuccessEvent(authRecordId);
    }

    /**
     * 提供方授权完成，上链修改授权状态为完成态
     */
    function changeAuthStateToFinish(uint256 authRecordId) public {
        _authRecordMap[authRecordId].intArray[0] = 2;
        emit ChangeAuthStateToFinishSuccessEvent(authRecordId);
    }

    /**
     * 提供方传输数据，上传指纹，并修改传输状态为已发送
     */
    function uploadEvidence(uint256 authRecordId, string dataHash) public  {
        AuthRecord storage authRecord = _authRecordMap[authRecordId];
        authRecord.intArray[1] = 1;
        authRecord.timeArray[2] = now;
        emit UploadEvidenceSuccessEvent(authRecordId,dataHash);
    }

    /**
     * 接收方校验数据,修改传输状态
     */
    function changeTransferState(uint256 authRecordId, uint8 transferState) public  {
        _authRecordMap[authRecordId].intArray[1] = transferState;
        emit ChangeTransferStateSuccessEvent(authRecordId,transferState);
    }

    /**
     * 查询授权记录
     */
    function getAuthRecordById(uint256 authRecordId) public view returns(uint256, address, address, address, string, uint8[2], string, string,uint256[3]) {
         AuthRecord storage authRecord = _authRecordMap[authRecordId];
         return (authRecord.authRecordId,authRecord.receiverId,authRecord.providerId,authRecord.userId,authRecord.schemaId,authRecord.intArray,authRecord.dataHash,authRecord.purposeId,authRecord.timeArray);
    }
}