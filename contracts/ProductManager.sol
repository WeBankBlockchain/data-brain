pragma solidity ^0.4.25;

import "./BasicAuth.sol";

contract ProductManager is BasicAuth {

    event RegisterProduct(address externalAddress, string name);
    event RemoveProduct(address externalAddress);

    struct ProductInfo {
        //产品地址
        address externalAddress;
        //机构地址
        string ownerId;
        //产品名称
        string name;
        uint8 status;
    }

    mapping(address => ProductInfo) private products;

    //注册产品
    function registerProduct(
        address externalAddress,
        string name
    ) public onlyOwner {
        require(products[externalAddress].status == 0, "already registered");
        ProductInfo storage p = products[externalAddress];
        p.externalAddress = externalAddress;
        p.name = name;
        p.status = 1;
        emit RegisterProduct(externalAddress, name);
    }

    //注销产品
    function removeProduct(address externalAddress) public onlyOwner {
        require(products[externalAddress].status == 1, "Not registered");
        ProductInfo storage p = products[externalAddress];
        p.externalAddress = address(0);
        p.name = "";
        p.status = 0;
        emit RemoveProduct(externalAddress);
    }
}
