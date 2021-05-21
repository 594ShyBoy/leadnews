# 头条-平台管理API文档


**简介**:头条-平台管理API文档


**HOST**:localhost:9001


**联系人**:羞涩男孩


**Version**:1.0.0


**接口路径**:/v2/api-docs


[TOC]






# 频道管理


## 频道删除


**接口地址**:`/api/v1/channel/del/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResponseResult|
|204|No Content||
|401|Unauthorized||
|403|Forbidden||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||object||
|errorMessage||string||
|host||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"errorMessage": "",
	"host": ""
}
```


## 根据名称分页查询频道列表


**接口地址**:`/api/v1/channel/list`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"name": "",
	"page": 0,
	"size": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dto|dto|body|true|ChannelDto|ChannelDto|
|&emsp;&emsp;name|频道名称||false|string||
|&emsp;&emsp;page|当前页||true|integer(int32)||
|&emsp;&emsp;size|每页显示条数||true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResponseResult|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||object||
|errorMessage||string||
|host||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"errorMessage": "",
	"host": ""
}
```


## 频道保存


**接口地址**:`/api/v1/channel/save`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"createdTime": "",
	"description": "",
	"id": 0,
	"isDefault": true,
	"name": "",
	"ord": 0,
	"status": true
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|adChannel|adChannel|body|true|AdChannel|AdChannel|
|&emsp;&emsp;createdTime|||false|string(date-time)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|integer(int32)||
|&emsp;&emsp;isDefault|||false|boolean||
|&emsp;&emsp;name|||true|string||
|&emsp;&emsp;ord|||false|integer(int32)||
|&emsp;&emsp;status|||false|boolean||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResponseResult|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||object||
|errorMessage||string||
|host||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"errorMessage": "",
	"host": ""
}
```


## 频道修改


**接口地址**:`/api/v1/channel/update`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"createdTime": "",
	"description": "",
	"id": 0,
	"isDefault": true,
	"name": "",
	"ord": 0,
	"status": true
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|adChannel|adChannel|body|true|AdChannel|AdChannel|
|&emsp;&emsp;createdTime|||false|string(date-time)||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|integer(int32)||
|&emsp;&emsp;isDefault|||false|boolean||
|&emsp;&emsp;name|||true|string||
|&emsp;&emsp;ord|||false|integer(int32)||
|&emsp;&emsp;status|||false|boolean||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResponseResult|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code||integer(int32)|integer(int32)|
|data||object||
|errorMessage||string||
|host||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {},
	"errorMessage": "",
	"host": ""
}
```