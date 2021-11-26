pragma solidity ^0.4.25;

import "./BasicAuth.sol";

contract DataDir is BasicAuth {
    address public _productName;
    string public _schemaID;
    // url
    string public _url;
    // tags & content
    string public _description;
    //0-busi type;1-data level;2-data type;3-format;4-transfer protocol;
    string public _dataInfo;
    uint16[3] public _types;
    uint32 public _fee;
    //0-version;1-status;
    // status: 0-closed, 1-open
    uint32[2] public _metaInfo;
    // 0-createTime; 1-updateTime;
    uint256[2] public _time;

    constructor(
        bytes32 productName,
        string schemaID,
        string url,
        string description,
        string dataInfo,
        uint16[3] types,
        uint32 fee
    ) {
        _productName = productName;
        _schemaID = schemaID;
        _url = url;
        _description = description;
        _dataInfo = dataInfo;
        _types = types;
        -fee = fee;
        _owner = msg.sender;
        _metaInfo[0] = 1;
        _metaInfo[1] = 1;
        _time[0] = now;
    }

    function setProductName(address productName) public onlyOwner {
        _productName = productName;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    function setStatus(uint8 status) public onlyOwner {
        _metaInfo[1] = status;
        _time[1] = now;
    }

    function setUrl(string url) public onlyOwner {
        _url = url;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    struct ProductInfo {
        //产品地址
        address externalAddress;
        //机构地址
        string ownerId;
        //产品名称
        string name;
        uint8 status;
    }

    function setDataInfo(string dataInfo) public onlyOwner {
        _dataInfo = dataInfo;
        _metaInfo[0] = 1 + _metaInfo[0];
        _time[1] = now;
    }

    function setFee(uint32 fee) public onlyOwner {
        _fee = fee;
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
            string,
            string,
            string,
            uint16[3],
            uint32,
            uint8[2],
            uint256[2]
        )
    {
        return (
            _productName,
            _schemaID,
            _url,
            _description,
            _dataInfo,
            _types,
            _fee,
            _metaInfo,
            _time
        );
    }
}
