pragma solidity ^0.4.25;

import "./Ownership.sol";


contract EnterpriseRegistration is Ownership{

    //认证信息
    struct  CertificationInfo{
        //认证类型
        uint8 authType;
        //证件类型
        uint8 certType;
        //证件号码
        string certNo;
        //法人姓名
        string representativeName;
        //法人证件类型
        uint8 representativeCertType;
        //法人证件号码
        string representativeCertNo;
        //企业类型
        uint8 type;
    }

    //企业信息
    struct Enterprise{
        //公钥地址
        string keyAddress;
        //企业名称
        string name;
        //手机号
        string phone;
        //联系地址
        string location;
        //邮箱地址
        string email;
        //状态：0-不存在 1-已注册 2-已认证 3-已销户
        uint8 status;
        //操作时间戳
        uint256[] timestamps;
    }

    mapping(address=>Enterprise) private enterprises;
    mapping(address=>CertificationInfo) private certifications;

    function getEnterpriseStatus(string keyAddress) public view returns(uint) {
        return enterprises[keyAddress].status;
    }

    //注册企业数据
    function registerEnterprise(string keyAddress, string name, string phone, string location, string email) public onlyOwner{

    }

    //上传认证数据
    function uploadCertInfos(address keyAddress, uint8 authType, uint8 certType,string certNo,string representativeName,uint8 representativeCertType,string representativeCertNo) public onlyOwner{

    }

    //审核
    function approveEnterpriseCert(address keyAddress) public onlyOwner {

    }

    //取消审核
    function cancelEnterpriseCert(address keyAddress) public onlyOwner {

    }

    //修改企业信息
    function modifyEnterprise(string keyAddress, string name, string phone, string location, string email) public onlyOwner {

    }

    //销户企业
    function removeEnterprise(string keyAddress) public onlyOwner {

    }
}
