pragma solidity ^0.4.25;

import "./BasicAuth.sol";

contract EnterpriseManager is BasicAuth{

    uint8 public constant STATUS_NOT_EXIST = 0;
    uint8 public constant STATUS_REGISTERED = 1;
    uint8 public constant STATUS_AUTHENTICATED = 2;
    uint8 public constant STATUS_REMOVED = 3;

    event RegisterEnterprise(string id, string name, string contact, string location, string email);
    event AuthenticateEnterprise(string id, bytes32 certHash);
    event ModifyEnterprise(string id, string name, string contact, string location, string email);
    event RemoveEnterprise(string id);

    //企业信息
    struct EnterpriseInfo{
        string id;
        //企业名称
        string name;
        //手机号
        string contact;
        //联系地址
        string location;
        //邮箱地址
        string email;
        //状态：0-不存在 1-已注册 2-已认证 3-已销户
        uint8 status;
        //认证数据哈希
        bytes32 certHash;
        //时间戳 0-注册时间戳 1-认证时间戳 2-销户时间戳 3-更新时间戳
        uint256[] timestamps;
    }

    mapping(string=>EnterpriseInfo) private enterprises;

    function getEnterpriseStatus(string id) public view returns(uint) {
        return enterprises[id].status;
    }

    //注册企业数据
    function registerEnterprise(string id, string name, string contact, string location, string email) public onlyOwner{
        require(enterprises[id].status == STATUS_NOT_EXIST, "Enterprise already existed");
        EnterpriseInfo storage enterprise = enterprises[id];
        enterprise.name = name;
        enterprise.contact = contact;
        enterprise.location = location;
        enterprise.email = email;
        enterprise.status = STATUS_REGISTERED;
        emit RegisterEnterprise(id, name, contact, location, email);
    }

    //认证
    function authenticateEnterpriseCert(string id, bytes32 certHash) public onlyOwner {
        require(enterprises[id].status == STATUS_REGISTERED, "Enterprise not registered");
        EnterpriseInfo storage enterprise = enterprises[id];
        enterprise.certHash = certHash;
        enterprise.status = STATUS_AUTHENTICATED;
        emit AuthenticateEnterprise(id, certHash);
    }

    //修改企业信息
    function modifyEnterprise(string id, string name, string contact, string location, string email) public onlyOwner {
        require(enterprises[id].status == STATUS_REGISTERED  || enterprises[id].status == STATUS_AUTHENTICATED , "Enterprise must register");
        EnterpriseInfo storage enterprise = enterprises[id];
        enterprise.name = name;
        enterprise.contact = contact;
        enterprise.location = location;
        enterprise.email = email;
        emit ModifyEnterprise(id, name, contact, location, email);
    }

    //销户企业
    function removeEnterprise(string id) public onlyOwner {
        require(enterprises[id].status == STATUS_REGISTERED  || enterprises[id].status == STATUS_AUTHENTICATED , "Enterprise must register");
        EnterpriseInfo storage enterprise = enterprises[id];
        enterprise.status = STATUS_REMOVED;
        emit RemoveEnterprise(id);
    }
}
