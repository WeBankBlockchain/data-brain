pragma solidity ^0.4.25;

import "BasicAuth.sol";

contract DataDir is BasicAuth {
    bytes32 public _productName;
    string public _schemaID;
    //0-version;1-status;
    // status: 0-closed, 1-open, 2-deprecated
    uint8[2] public _metaInfo;
    // url | format | transfer protocol
    string public _transferInfo;
    // tags & content
    string public _description;
    //0-busi type;1-data level;2-data type
    uint16[3] public _types;
    // 0-createTime; 1-updateTime;
    uint256[2] public _time;

    constructor(
        bytes32 productName,
        string schemaID,
        string transferInfo,
        string description,
        uint16[3] types
    ) {
        _productName = productName;
        _schemaID = schemaID;
        _transferInfo = transferInfo;
        _description = description;
        _types = types;
        _owner = msg.sender;
        _metaInfo[0] = 1;
        _metaInfo[1] = 1;
        _time[0] = now;
    }

    function setProductName(string productName) public onlyOwner {
        _productName = productName;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    function setStatus(uint8 status) public onlyOwner {
        _metaInfo[1] = status;
        _time[1] = now;
    }

    function setTransferInfo(string transferInfo) public onlyOwner {
        _transferInfo = transferInfo;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    function setDescription(string description) public onlyOwner {
        _description = description;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    function setTypes(uint16[3] types) public onlyOwner {
        _types = types;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    function getDataDir()
        public
        view
        returns (
            bytes32,
            string,
            uint8[2],
            string,
            string,
            uint16[3],
            uint256[2]
        )
    {
        return (
            _productName,
            _schemaID,
            _metaInfo,
            _transferInfo,
            _description,
            _types,
            _time
        );
    }
}
