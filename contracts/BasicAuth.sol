pragma solidity ^0.4.25;

contract BasicAuth {
    address public _owner;

    event TransferOwnership(address previous, address now);

    constructor() public {
        _owner = msg.sender;
    }

    modifier onlyOwner() {
        require(auth(msg.sender), "Only owner!");
        _;
    }

    function setOwner(address owner) public onlyOwner {
        _owner = owner;
    }

    function auth(address src) public view returns (bool) {
        if (src == address(this)) {
            return true;
        } else if (src == _owner) {
            return true;
        } else {
            return false;
        }
    }

    function transferOwnership(address newOwner) public onlyOwner {
        require(newOwner != address(0), "Invalid new owner");
        address previous = owner;
        _owner = newOwner;
        emit TransferOwnership(previous, _owner);
    }
}
