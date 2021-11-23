pragma solidity ^0.4.25;

import "./Ownership.sol";


contract ProductRegistration is Ownership{

    struct Product{
        //公钥地址
        string id;
        //企业名称
        string name;
        //手机号
        string phone;
        //联系地址
        string location;
        //邮箱地址
        string email;
        //状态：0-已注册 1-已认证 2-已销户
        uint8 status;
    }

    mapping(address=>Enterprise) private enterprises;

    //注册企业数据
    function registerEnterprise(string externalAddress, string name, string phone, string location, string email) public onlyOwner{

    }

    //认证企业数据
    function validateEnterprise(address externalAddress) public onlyOwner {

    }

    //取消认证
    function invalidateEnterprise(address externalAddress) public onlyOwner {

    }

    //修改企业信息
    function modifyEnterprise(string externalAddress, string name, string phone, string location, string email) public onlyOwner {

    }

    //销户企业
    function removeEnterprise(string externalAddress) public onlyOwner {

    }
}
