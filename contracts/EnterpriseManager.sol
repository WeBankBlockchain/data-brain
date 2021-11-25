pragma solidity ^0.4.25;

import "./BasicAuth.sol";


contract EnterpriseManager is BasicAuth{
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
        //时间戳 0-注册时间戳 1-认证时间戳 2-销户时间戳 3-更新时间戳
        uint256[] timestamps;
    }

    mapping(string=>Enterprise) private enterprises;
    mapping(string=>CertificationInfo) private certifications;

    function getEnterpriseStatus(string id) public view returns(uint) {
        return enterprises[id].status;
    }

    //注册企业数据
    function registerEnterprise(string id, string name, string phone, string location, string email) public onlyOwner{

    }

    //认证
    function approveEnterpriseCert(string id, bytes32 certHash) public onlyOwner {

    }

    //修改企业信息
    function modifyEnterprise(string id, string name, string phone, string location, string email) public onlyOwner {

    }

    //销户企业
    function removeEnterprise(string id) public onlyOwner {

    }
}
