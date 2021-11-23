pragma solidity ^0.6.10;


contract Ownership{

    address owner;

    event TransferOwnership(address previous, address now);

    modifier onlyOwner{
        require(msg.sender == owner, "Not owner");
        _;
    }

    constructor() public {
        owner = msg.sender;
        emit TransferOwnership(address(0), owner);
    }

    function transferOwnership(address newOwner) public onlyOwner{
        require(newOwner != address(0), "Invalid new owner");
        address previous = owner;
        address owner = newOwner;
        emit TransferOwnership(previous, owner);
    }
}