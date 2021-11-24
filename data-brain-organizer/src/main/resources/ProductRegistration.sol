pragma solidity ^0.4.25;

import "./Ownership.sol";
import "./EnterpriseRegistration.sol";

contract ProductRegistration is Ownership{

    EnterpriseRegistration public enterpriseRegistration;

    struct Product{
        //产品地址
        address productAddress;
        //机构地址
        address owner;
        //产品名称
        string name;
        //产品描述
        string description;
        //产品类别
        uint256 category;
        //负责人联系方式
        string contact;
    }

    mapping(address=>Product) private enterprises;

    function setEnterpriseRegistration(EnterpriseRegistration _enterpriseRegistration) public onlyOwner{
        enterpriseRegistration = _enterpriseRegistration;
    }

    //注册产品
    function registerProduct(string productAddress, string name, string description, uint256 category, string contact) public onlyOwner{

    }

    //销户企业
    function removeProduct(string productAddress) public onlyOwner {

    }
}
