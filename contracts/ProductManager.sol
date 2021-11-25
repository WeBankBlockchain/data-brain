pragma solidity ^0.4.25;

import "./BasicAuth.sol";
import "./EnterpriseManager.sol";

contract ProductManager is BasicAuth {

    struct Product {
        //产品地址
        address externalAddress;
        //机构地址
        string ownerId;
        //产品名称
        string name;
    }

    mapping(address => Product) private products;

    //注册产品
    function registerProduct(
        string externalAddress,
        string name
    ) public onlyOwner {}

    //注销产品
    function removeProduct(string productAddress) public onlyOwner {}
}
